import javax.swing.JOptionPane;
import org.bson.Document;
import com.mongodb.ConnectionString;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.result.*;

public class Container {
    private int numberofboxes;
    private int size;
    private int regno;
    private int license;
    
    public Container(int numberofboxes, int size, int regno, int license) {
        this.numberofboxes = numberofboxes;
        this.size = size;
        this.regno = regno;
        this.license = license;
    }

     public static void add(Document document){

        String mongoURI = "mongodb://localhost:27017";
        ConnectionString connectionString = new ConnectionString(mongoURI);
        MongoClientSettings settings = MongoClientSettings.builder()
            .applyConnectionString(connectionString)
            .build();

       com.mongodb.client.MongoClient client=MongoClients.create(settings);
        MongoDatabase database = client.getDatabase("ShippingCompany");
        MongoCollection<Document> Collection = database.getCollection("Container");

        try {
            Collection.insertOne(document);
            System.out.println("Document added successfully.");
        } catch (Exception e) {
            System.out.println("Error adding document: " + e.getMessage());
        }

        client.close();

    }

    public static void delete(Document filter){
        ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017");

        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();

        MongoClient mongoClient = MongoClients.create(settings);
        MongoDatabase database = mongoClient.getDatabase("ShippingCompany");
        MongoCollection<Document> Collection = database.getCollection("Container");
        
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
        MongoCollection<Document> collection = database.getCollection("Container");
        
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
        MongoCollection<Document> collection = database.getCollection("Container");

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

    
    public int getNumberofboxes() {
        return numberofboxes;
    }

    public void setNumberofboxes(int numberofboxes) {
        this.numberofboxes = numberofboxes;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getRegno() {
        return regno;
    }

    public void setRegno(int regno) {
        this.regno = regno;
    }

    public int getLicense() {
        return license;
    }

    public void setLicense(int license) {
        this.license = license;
    }
    
}
