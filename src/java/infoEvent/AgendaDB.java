/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infoEvent;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import java.util.ArrayList;

/**
 *
 * @author Androy
 */
public class AgendaDB {
    public void insertAgenda(Agenda age,DB database)throws Exception{
        MongoClient mongo=null;
        try{
               DBCollection collection = database.getCollection("Agenda"); 
             //System.out.println("Collection myCollection selected successfully"); 
              BasicDBObject document = new BasicDBObject(); 
              document.put("id","AG"+collection.count());
               document.put("idUser",age.getIdUser()) ;
              document.put("idEvent",age.getIdEvent()) ;
              document.put("date",age.getDate());
              document.put("heure",age.getHeure());
              document.put("minute",age.getMinute());
              document.put("situation",age.getSituation());
              document.put("etat",age.getEtat());
            collection.insert(document);
        }catch(Exception ex){
            throw ex;
        }
    }
    public ArrayList findAgenda(String idUser)throws Exception{
         MongoClient mongo=null;
        try{
            ArrayList listeFinal=new ArrayList();
        
             Connection conec=new Connection();
             mongo=conec.connect();
               DB database = mongo.getDB("infoevent");  
               DBCollection collection = database.getCollection("Agenda");
                BasicDBObject req=new BasicDBObject("idUser",idUser);
                              req.append("etat",0);
                DBCursor iterDoc = collection.find(req); 
                Agenda age=null;
               
                DBObject dbObject=null;
                 while (iterDoc.hasNext()) {  
                    dbObject = iterDoc.next();
                    age=new Agenda((String)dbObject.get("id"),(String)dbObject.get("idUser"),(String)dbObject.get("idEvent"),(String)dbObject.get("date"),(int)dbObject.get("heure"),(int)dbObject.get("minute"),(String)dbObject.get("situation"));
                    listeFinal.add(age);
                 }
            return listeFinal;
        }catch(Exception ex){
            throw ex;
        }
        finally{
            if(mongo!=null){mongo.close();}
        }
    }
    public String FinirAgenda(String id)throws Exception{
         MongoClient mongo=null;
        try{
   
             Connection conec=new Connection();
             mongo=conec.connect();
               DB database = mongo.getDB("infoevent");  
                DBCollection collection = database.getCollection("Agenda"); 
               /////////////
                collection.update(new BasicDBObject("id",id), new BasicDBObject("$set", new BasicDBObject("etat",-1)));
                
      return "ok";
        }catch(Exception ex){
            throw ex;
        }
        finally{
             if(mongo!=null){mongo.close();}
        }
    }
}
