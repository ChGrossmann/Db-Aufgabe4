package ch.teko.grossmac.db4.a4.dao;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class DBConnection {

    public MongoDatabase db;
    public MongoCollection<Document> mdbCollection;
    
       public void connection(String collection){
        // Verbindung zu localhost, Port: 27017
        MongoClient client = MongoClients.create();

       
        db = client.getDatabase("rechnung");
        mdbCollection = db.getCollection(collection);

        

    }

}
