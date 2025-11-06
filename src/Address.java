import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import javax.swing.*;

public class Address {
    private int houseno;
    private int street;
    private int city;
    private int destrict;

    public Address(int houseno, int street, int city, int destrict) {
        this.houseno = houseno;
        this.street = street;
        this.city = city;
        this.destrict = destrict;
    }

    public int getHouseno() {
        return houseno;
    }
    public void setHouseno(int houseno) {
        this.houseno = houseno;
    }
    public int getStreet() {
        return street;
    }
    public void setStreet(int street) {
        this.street = street;
    }
    public int getCity() {
        return city;
    }
    public void setCity(int city) {
        this.city = city;
    }
    public int getDestrict() {
        return destrict;
    }
    public void setDestrict(int destrict) {
        this.destrict = destrict;
    }

      public static void add(Document document){

          ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017");

          MongoClientSettings settings = MongoClientSettings.builder()
                  .applyConnectionString(connectionString)
                  .build();

          MongoClient mongoClient = MongoClients.create(settings);
          MongoDatabase database = mongoClient.getDatabase("ShippingCompany");
         MongoCollection<Document> Collection = database.getCollection("Address");

         try {
             Collection.insertOne(document);
             System.out.println("Document added successfully.");
         } catch (Exception e) {
             System.out.println("Error adding document: " + e.getMessage());
         }

         mongoClient.close();

     }

     public static void delete(String field, Object value){
         ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017");

         MongoClientSettings settings = MongoClientSettings.builder()
                 .applyConnectionString(connectionString)
                 .build();

         MongoClient mongoClient = MongoClients.create(settings);
         MongoDatabase database = mongoClient.getDatabase("ShippingCompany");
         MongoCollection<Document> Collection = database.getCollection("Address");
        
         // Delete a document matching a specific condition
         DeleteResult deleteResult = Collection.deleteOne(Filters.eq(field, value));
        
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
         MongoCollection<Document> collection = database.getCollection("Address");
        
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
        MongoCollection<Document> collection = database.getCollection("Address");

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


}
