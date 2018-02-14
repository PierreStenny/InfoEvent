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
public class CommentaireDB {
    public void insertCommentaire(Commentaire com)throws Exception{
         MongoClient mongo=null;
        try{
             Connection conec=new Connection();
             mongo=conec.connect();
               DB database = mongo.getDB("infoevent"); 
               DBCollection collection = database.getCollection("Commentaire"); 
             //System.out.println("Collection myCollection selected successfully"); 
              BasicDBObject document = new BasicDBObject(); 
              document.put("id","COM"+collection.count());
               document.put("idUser",com.getIdUser()) ;
              document.put("idEvent",com.getIdEvent()) ;
              document.put("commentaire",com.getText()); 
              document.put("date",com.getDate());
            collection.insert(document);
            
            collection = database.getCollection("Evenement"); 
            DBObject dbObject = collection.findOne(new BasicDBObject("id",com.getIdEvent())); 
            ArrayList listComment=(ArrayList)dbObject.get("comment");
            listComment.add(com.getIdUser());
            collection.update(new BasicDBObject("id",com.getIdEvent()), new BasicDBObject("$set", new BasicDBObject("comment", listComment)));
        
        }catch(Exception ex){
            throw ex;
        }
    }
    public ArrayList findCommentaire(String idEvent)throws Exception{
         MongoClient mongo=null;
        try{
            ArrayList listeFinal=new ArrayList();
        
             Connection conec=new Connection();
             mongo=conec.connect();
               DB database = mongo.getDB("infoevent");  
               DBCollection collection = database.getCollection("Commentaire");
               
                DBCursor iterDoc = collection.find(new BasicDBObject("idEvent",idEvent)); 
                Commentaire com=null;
               
                DBObject dbObject=null;
                 while (iterDoc.hasNext()) {  
                    dbObject = iterDoc.next();
                    com=new Commentaire((String)dbObject.get("id"),(String)dbObject.get("idUser"),"","",(String)dbObject.get("idEvent"),(String)dbObject.get("commentaire"),(String)dbObject.get("date"));
                    com=this.setCommentaire(com, database);
                    listeFinal.add(com);
                 }
            return listeFinal;
        }catch(Exception ex){
            throw ex;
        }
        finally{
            if(mongo!=null){mongo.close();}
        }
    }
    public Commentaire setCommentaire(Commentaire com,DB database)throws Exception{
         MongoClient mongo=null;
        try{
               DBObject dbObject=null;
                DBCollection collection = database.getCollection("Utilisateur"); 
                invitationEvent invE=null;
                 DBObject use=collection.findOne(new BasicDBObject("id",com.getIdUser()));
                    com.setNomUser((String)use.get("nom"));
                    com.setPrenomUser((String)use.get("prenom"));
                    
      return com;
        }catch(Exception ex){
            throw ex;
        }
        
    }
}
