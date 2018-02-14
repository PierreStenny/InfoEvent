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
public class invitationEventDB {
    public void invitationEventDB(invitationEvent inv)throws Exception{
        MongoClient mongo=null;
        try{
             Connection conec=new Connection();
             mongo=conec.connect();
               DB database = mongo.getDB("infoevent"); 
               DBCollection collection = database.getCollection("InvitationEvent"); 
              
              BasicDBObject document = new BasicDBObject(); 
              document.put("id","INVE"+collection.count());
               document.put("idUser",inv.getIdUser()) ;
              document.put("idSender",inv.getSender()) ;
              document.put("idEvent",inv.getIdEvent());
              document.put("Etat",inv.getEtat());
            collection.insert(document);
        }catch(Exception ex){
            throw ex;
        }
    }
     public ArrayList getInvitationEvent(String idUse)throws Exception{
         MongoClient mongo=null;
        try{
               DBObject dbObject=null;
            ArrayList liste=new ArrayList();
             ArrayList listeIdE=new ArrayList();
             Connection conec=new Connection();
             mongo=conec.connect();
               DB database = mongo.getDB("infoevent");  
                DBCollection collection = database.getCollection("InvitationEvent"); 
                invitationEvent invE=null;
               BasicDBObject req= new BasicDBObject("idUser",idUse);
                                req.append("Etat", 0);
                 DBCursor listInvit=collection.find(req);
                    while (listInvit.hasNext()) {  
                            dbObject = listInvit.next();
                            invE=new invitationEvent((String)dbObject.get("id"),(String)dbObject.get("idUser"),(String)dbObject.get("idSender"),"",(String)dbObject.get("idEvent"),(int)dbObject.get("Etat"));
                            invE=this.setInvitationEvent(invE,database);
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
    public invitationEvent setInvitationEvent(invitationEvent inv,DB database)throws Exception{
         MongoClient mongo=null;
        try{
               DBObject dbObject=null;
                DBCollection collection = database.getCollection("Utilisateur"); 
                invitationEvent invE=null;
                 DBObject use=collection.findOne(new BasicDBObject("id",inv.getSender()));
                    inv.setNomSender((String)use.get("nom"));
                    inv.setPrenomSender((String)use.get("prenom"));
                    
                    collection = database.getCollection("Evenement");
                    DBObject ev=collection.findOne(new BasicDBObject("id",inv.getIdEvent()));
                    inv.setNomEvent((String)ev.get("nom"));
      return inv;
        }catch(Exception ex){
            throw ex;
        }
        
    }
    public String AcceptInvitation(String idUser,String idEvent,int et)throws Exception{
         MongoClient mongo=null;
        try{
   
             Connection conec=new Connection();
             mongo=conec.connect();
               DB database = mongo.getDB("infoevent");  
                DBCollection collection = database.getCollection("InvitationEvent"); 
               /////////////
             BasicDBObject req= new BasicDBObject("idUser",idUser);
                           req.append("idEvent", idEvent);
                 DBObject inv=collection.findOne(req);
                collection.update(new BasicDBObject("id",(String)inv.get("id")), new BasicDBObject("$set", new BasicDBObject("Etat", et)));
                
                collection = database.getCollection("Evenement");
                 DBObject eve=collection.findOne(new BasicDBObject("id", idEvent));
                if(et==1){
                Agenda age=new Agenda(idUser,idEvent,(String)eve.get("dateDebut"),(int)eve.get("heure"),(int)eve.get("minute"),(String)eve.get("nom"));
                AgendaDB ageD=new AgendaDB();
                ageD.insertAgenda(age, database);
                }
      return "ok";
        }catch(Exception ex){
            throw ex;
        }
        finally{
             if(mongo!=null){mongo.close();}
        }
    }
    public ArrayList getMyInvitationEvent(String idEvent)throws Exception{
         MongoClient mongo=null;
        try{
               DBObject dbObject=null;
            ArrayList liste=new ArrayList();
             ArrayList listeIdE=new ArrayList();
             Connection conec=new Connection();
             mongo=conec.connect();
               DB database = mongo.getDB("infoevent");  
                DBCollection collection = database.getCollection("InvitationEvent"); 
                invitationEvent invE=null;
               BasicDBObject req= new BasicDBObject("idEvent",idEvent);
                                
                 DBCursor listInvit=collection.find(req);
                    while (listInvit.hasNext()) {  
                            dbObject = listInvit.next();
                            invE=new invitationEvent((String)dbObject.get("id"),(String)dbObject.get("idUser"),(String)dbObject.get("idSender"),"",(String)dbObject.get("idEvent"),(int)dbObject.get("Etat"));
                            invE=this.setMyInvitationEvent(invE,database);
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
    public invitationEvent setMyInvitationEvent(invitationEvent inv,DB database)throws Exception{
         MongoClient mongo=null;
        try{
               DBObject dbObject=null;
                DBCollection collection = database.getCollection("Utilisateur"); 
                invitationEvent invE=null;
                 DBObject use=collection.findOne(new BasicDBObject("id",inv.getIdUser()));
                    inv.setNomUser((String)use.get("nom"));
                    inv.setPrenomUser((String)use.get("prenom"));
                    
                    collection = database.getCollection("Evenement");
                    DBObject ev=collection.findOne(new BasicDBObject("id",inv.getIdEvent()));
                    inv.setNomEvent((String)ev.get("nom"));
      return inv;
        }catch(Exception ex){
            throw ex;
        }
        
    }
}
