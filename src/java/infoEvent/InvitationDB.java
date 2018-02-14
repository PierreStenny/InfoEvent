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
public class InvitationDB {
    public void invitation(Invitation inv)throws Exception{
        MongoClient mongo=null;
        try{
             Connection conec=new Connection();
             mongo=conec.connect();
               DB database = mongo.getDB("infoevent"); 
               DBCollection collection = database.getCollection("Invitation"); 
              
              BasicDBObject document = new BasicDBObject(); 
              document.put("id","INVE"+collection.count());
               document.put("idUser",inv.getIdUser()) ;
              document.put("idSender",inv.getSender()) ;
              document.put("Etat",inv.getEtat());
            collection.insert(document);
        }catch(Exception ex){
            throw ex;
        }
    }
     public ArrayList getInvitation(String idUse)throws Exception{
         MongoClient mongo=null;
        try{
               DBObject dbObject=null;
            ArrayList liste=new ArrayList();
             ArrayList listeIdE=new ArrayList();
             Connection conec=new Connection();
             mongo=conec.connect();
               DB database = mongo.getDB("infoevent");  
                DBCollection collection = database.getCollection("Invitation"); 
                Invitation invE=null;
               BasicDBObject req= new BasicDBObject("idUser",idUse);
                                req.append("Etat", 0);
                 DBCursor listInvit=collection.find(req);
                    while (listInvit.hasNext()) {  
                            dbObject = listInvit.next();
                            invE=new Invitation((String)dbObject.get("id"),(String)dbObject.get("idUser"),(String)dbObject.get("idSender"),(int)dbObject.get("Etat"));
                            invE=this.setInvitation(invE,database);
                            liste.add(invE);
                       }
      return liste;
        }catch(Exception ex){
            throw ex;
        }
        finally{
             if(mongo!=null){mongo.close();}
        }
    }
    public Invitation setInvitation(Invitation inv,DB database)throws Exception{
         MongoClient mongo=null;
        try{
               DBObject dbObject=null;
                DBCollection collection = database.getCollection("Utilisateur"); 
                Invitation invE=null;
                 DBObject use=collection.findOne(new BasicDBObject("id",inv.getSender()));
                    inv.setNomSender((String)use.get("nom"));
                    inv.setPrenomSender((String)use.get("prenom"));
                    
                
      return inv;
        }catch(Exception ex){
            throw ex;
        }
        
    }
    
    public ArrayList getMyInvitation(String idEvent)throws Exception{
         MongoClient mongo=null;
        try{
               DBObject dbObject=null;
            ArrayList liste=new ArrayList();
             ArrayList listeIdE=new ArrayList();
             Connection conec=new Connection();
             mongo=conec.connect();
               DB database = mongo.getDB("infoevent");  
                DBCollection collection = database.getCollection("Invitation"); 
                Invitation invE=null;
               BasicDBObject req= new BasicDBObject("idEvent",idEvent);
                                
                 DBCursor listInvit=collection.find(req);
                    while (listInvit.hasNext()) {  
                            dbObject = listInvit.next();
                            invE=new Invitation((String)dbObject.get("id"),(String)dbObject.get("idUser"),(String)dbObject.get("idSender"),(int)dbObject.get("Etat"));
                            invE=this.setMyInvitation(invE,database);
                            liste.add(invE);
                       }
      return liste;
        }catch(Exception ex){
            throw ex;
        }
        finally{
             if(mongo!=null){mongo.close();}
        }
    }
    public Invitation setMyInvitation(Invitation inv,DB database)throws Exception{
         MongoClient mongo=null;
        try{
               DBObject dbObject=null;
                DBCollection collection = database.getCollection("Utilisateur"); 
                Invitation invE=null;
                 DBObject use=collection.findOne(new BasicDBObject("id",inv.getIdUser()));
                    inv.setNomUser((String)use.get("nom"));
                    inv.setPrenomUser((String)use.get("prenom"));
                   
      return inv;
        }catch(Exception ex){
            throw ex;
        }
        
    }
}
