/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infoEvent;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

/**
 *
 * @author Androy
 */
public class LieuEvenementielDB {
    public void insertLieu()throws Exception{
       MongoClient mongo=null;
        try{
             Connection conec=new Connection();
             mongo=conec.connect();
               DB database = mongo.getDB("infoevent"); 
               DBCollection collection = database.getCollection("LieuEvenementiel"); 
             //System.out.println("Collection myCollection selected successfully"); 
              BasicDBObject document = new BasicDBObject(); 
              document.put("id","AG"+collection.count());
               document.put("idUser", "database") ;
              document.put("idEvent", "database") ;
              document.put("date",2);
            collection.insert(document);
        }catch(Exception ex){
            throw ex;
        }
    }
}
