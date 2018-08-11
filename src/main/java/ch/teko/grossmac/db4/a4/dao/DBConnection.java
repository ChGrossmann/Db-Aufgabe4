package ch.teko.grossmac.db4.a4.dao;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 * DBConnection erstellt die Verbindung zur DB.
 * @author ch.grossmann
 */
public class DBConnection {

    public MongoDatabase db;
    public MongoCollection<Document> mdbCollection;
    
    /**
     * connection erwartet ein Parameter für den Namen der Collection.
     * @param collection 
     */
       public void connection(String collection){
        // Verbindung zu localhost, Port: 27017
        MongoClient client = MongoClients.create();

       /**
        * Die Db rechnung
        */
        db = client.getDatabase("rechnung");
        
        /**
         * Die Collection nach Parameter
         */
        mdbCollection = db.getCollection(collection);

        

    }

}
