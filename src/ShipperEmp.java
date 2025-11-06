import javax.swing.JOptionPane;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import org.bson.Document;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

public class ShipperEmp {
    private int CNIC;
    private String name;
    private int age;
    private int contact;
    private int eid;
    private int salary;
    private int designation;
    private int totaldeliveries;
    private int remaining;
    private int shipperid;

    
    
    public ShipperEmp(int cNIC, String name, int age, int contact, int eid, int salary, int designation,
            int totaldeliveries, int remaining, int shipperid) {
        CNIC = cNIC;
        this.name = name;
        this.age = age;
        this.contact = contact;
        this.eid = eid;
        this.salary = salary;
        this.designation = designation;
        this.totaldeliveries = totaldeliveries;
        this.remaining = remaining;
        this.shipperid = shipperid;
    }

    public static void add(Document document){
        ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017");

        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();

        com.mongodb.client.MongoClient mongoClient = MongoClients.create(settings);
        MongoDatabase database = mongoClient.getDatabase("ShippingCompany");
        MongoCollection<Document> Collection = database.getCollection("ShipperEmp");

        try {
            Collection.insertOne(document);
            System.out.println("Document added successfully.");
        } catch (Exception e) {
            System.out.println("Error adding document: " + e.getMessage());
        }

        mongoClient.close();

    }

    public static void delete(Document filter){
        ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017");

        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();

        com.mongodb.client.MongoClient mongoClient = MongoClients.create(settings);
        MongoDatabase database = mongoClient.getDatabase("ShippingCompany");
        MongoCollection<Document> Collection = database.getCollection("ShipperEmp");
        
        // Delete a document matching a specific condition
        DeleteResult deleteResult = Collection.deleteOne(filter);
        
        long matchedCount = deleteResult.getDeletedCount();

        if (matchedCount > 0) {
            System.out.println("Delete operation completed successfully.");
            System.out.println("Deleted documents: " + matchedCount);
        } else {
            System.out.println("No documents matched the filter criteria.");
        }

        // Close the connection
        mongoClient.close();
    }
    public static void update(Document filter, Document update){
        ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017");

        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();

        MongoClient mongoClient = MongoClients.create(settings);
        MongoDatabase database = mongoClient.getDatabase("ShippingCompany");
        MongoCollection<Document> collection = database.getCollection("ShipperEmp");
        
        // Delete a document matching a specific condition
        UpdateOptions options = new UpdateOptions().upsert(true);
        UpdateResult updateResult = collection.updateOne(filter, update, options);
        
        long matchedCount = updateResult.getMatchedCount();
        long modifiedCount = updateResult.getModifiedCount();

        if (matchedCount > 0) {
            JOptionPane.showMessageDialog(null,"Update operation completed successfully.");
            JOptionPane.showMessageDialog(null,"Matched documents: " + matchedCount);
            JOptionPane.showMessageDialog(null,"Modified documents: " + modifiedCount);
        } else {
            System.out.println("No documents matched the filter criteria.");
        }

        // Close the connection
        mongoClient.close();
    }

    public static void view(Document filter){
        ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017");

        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();

        MongoClient mongoClient = MongoClients.create(settings);
        MongoDatabase database = mongoClient.getDatabase("ShippingCompany");
        MongoCollection<Document> collection = database.getCollection("ShipperEmp");

        FindIterable<Document> documents = collection.find(filter);

        MongoCursor<Document> cursor = documents.iterator();
        boolean isPresent = cursor.hasNext();

        

        if(!isPresent){
            JOptionPane.showMessageDialog(null, "Record not Found");
        }
        else{
            StringBuilder sb = new StringBuilder();
            while(cursor.hasNext()){
                Document document = cursor.next();
                sb.append(document.toJson()).append("\n");
            }
            JOptionPane.showMessageDialog(null, sb.toString());
        }
    }


    public int getCNIC() {
        return CNIC;
    }

    public void setCNIC(int cNIC) {
        CNIC = cNIC;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int id) {
        this.eid = id;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getDesignation() {
        return designation;
    }

    public void setDesignation(int designation) {
        this.designation = designation;
    }

    public int getTotaldeliveries() {
        return totaldeliveries;
    }

    public void setTotaldeliveries(int totaldeliveries) {
        this.totaldeliveries = totaldeliveries;
    }

    public int getRemaining() {
        return remaining;
    }

    public void setRemaining(int remaining) {
        this.remaining = remaining;
    }

    public int getShipperid() {
        return shipperid;
    }

    public void setShipperid(int shipperid) {
        this.shipperid = shipperid;
    }
    
    
}
