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
public class JaimeDB {
    public void insertJaime(Jaime jaim)throws Exception{
         MongoClient mongo=null;
        try{
             Connection conec=new Connection();
             mongo=conec.connect();
               DB database = mongo.getDB("infoevent"); 
             
               DBCollection collection = database.getCollection("Jaime"); 
             //System.out.println("Collection myCollection selected successfully"); 
              BasicDBObject document = new BasicDBObject(); 
              document.put("id","JAIM"+collection.count());
               document.put("idUser",jaim.getIdUser()) ;
              document.put("idEvent",jaim.getIdEvent()) ;
            collection.insert(document);
            
             collection = database.getCollection("Evenement"); 
            DBObject dbObject = collection.findOne(new BasicDBObject("id",jaim.getIdEvent())); 
            ArrayList listJaime=(ArrayList)dbObject.get("like");
            listJaime.remove(jaim.getIdUser());
            listJaime.add(jaim.getIdUser());
            collection.update(new BasicDBObject("id",jaim.getIdEvent()), new BasicDBObject("$set", new BasicDBObject("like", listJaime)));
        
        }catch(Exception ex){
            throw ex;
        }
    }
    /*public ArrayList findJaime(String idEvent)throws Exception{
         MongoClient mongo=null;
        try{
            ArrayList listeFinal=new ArrayList();
        
             Connection conec=new Connection();
             mongo=conec.connect();
               DB database = mongo.getDB("infoEvent");  
               DBCollection collection = database.getCollection("Jaime");
               
                DBCursor iterDoc = collection.find(new BasicDBObject("idEvent",idEvent)); 
                Jaime jaim=null;
               
                DBObject dbObject=null;
                 while (iterDoc.hasNext()) {  
                    dbObject = iterDoc.next();
                    jaim=new Jaime((String)dbObject.get("id"),(String)dbObject.get("idUser"),"","",(String)dbObject.get("idEvent"));
                    jaim=this.setJaime(jaim, database);
                    listeFinal.add(jaim);
                 }
            return listeFinal;
        }catch(Exception ex){
            throw ex;
        }
        finally{
            if(mongo!=null){mongo.close();}
        }
    }
    public Jaime setJaime(Jaime jaim,DB database)throws Exception{
         MongoClient mongo=null;
        try{
               DBObject dbObject=null;
                DBCollection collection = database.getCollection("Utilisateur"); 
                invitationEvent invE=null;
                 DBObject use=collection.findOne(new BasicDBObject("id",jaim.getIdUser()));
                    jaim.setNomUser((String)use.get("nom"));
                    jaim.setPrenomUser((String)use.get("prenom"));
                    
      return jaim;
        }catch(Exception ex){
            throw ex;
        }
        
    }*/
}
