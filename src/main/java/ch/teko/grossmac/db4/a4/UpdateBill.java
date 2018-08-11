/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.teko.grossmac.db4.a4;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.gte;
import com.mongodb.client.model.UpdateOptions;
import static com.mongodb.client.model.Updates.inc;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.bson.Document;

/**
 *
 * @author ch.grossmann
 */
public class UpdateBill extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
        
                MongoClient client = MongoClients.create();
        MongoDatabase db = client.getDatabase("kurs");
        MongoCollection<Document> updateDemo = db.getCollection("updateDemo");

        updateDemo.drop();

        for (int i = 0; i < 10; i++) {
            updateDemo.insertOne(new Document()
                    .append("_id", i)
                    .append("x", i)
                    .append("y", true)
            );
        }

        updateDemo.replaceOne(eq("x", 2),
                new Document("x", 20)
                        .append("updated", true));

        updateDemo.updateOne(eq("x", 4),
                new Document("$set", new Document("x", 20)
                        .append("updated", true)));

        updateDemo.updateOne(eq("x", 12),
                new Document("$set", new Document("x", 20)
                        .append("updated", true)), new UpdateOptions().upsert(true));

        updateDemo.updateMany(gte("x", 6), inc("x", 1));

//        List<Document> all = updateDemo.find().into(new ArrayList<>());
//        for (Document d : all) {
//            System.out.println(d.toJson());
        }

    }


