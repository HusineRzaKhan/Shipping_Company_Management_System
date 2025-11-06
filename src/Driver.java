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
import com.mongodb.client.result.UpdateResult;


public class Driver {
    private int CNIC;
    private String name;
    private int age;
    private int contact;
    private int id;
    private int salary;
    private int designation;
    private int licensenumber;

    public Driver(int cNIC, String name, int age, int contact, int id, int salary, int designation, int licensenumber) {
        CNIC = cNIC;
        this.name = name;
        this.age = age;
        this.contact = contact;
        this.id = id;
        this.salary = salary;
        this.designation = designation;
        this.licensenumber = licensenumber;
    }

    public static void add(Document document){
        ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017");

        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();

        com.mongodb.client.MongoClient mongoClient = MongoClients.create(settings);
        MongoDatabase database = mongoClient.getDatabase("ShippingCompany");
        MongoCollection<Document> accountCollection = database.getCollection("Driver");

        accountCollection.insertOne(document);

        mongoClient.close();

    }

    public static void delete(Document filter){
        ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017");

        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();

        com.mongodb.client.MongoClient mongoClient = MongoClients.create(settings);
        MongoDatabase database = mongoClient.getDatabase("ShippingCompany");
        MongoCollection<Document> accountCollection = database.getCollection("Driver");
        
        // Delete a document matching a specific condition
        accountCollection.deleteOne(filter);
        
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
        MongoCollection<Document> collection = database.getCollection("Driver");
        
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
        MongoCollection<Document> collection = database.getCollection("Driver");

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


    public void update(){
        
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



    public int getId() {
        return id;
    }



    public void setId(int id) {
        this.id = id;
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



    public int getLicensenumber() {
        return licensenumber;
    }



    public void setLicensenumber(int licensenumber) {
        this.licensenumber = licensenumber;
    }

    

    
}
