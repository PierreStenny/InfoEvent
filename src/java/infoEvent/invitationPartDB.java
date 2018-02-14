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
import infoEvent.Connection;
import infoEvent.invitationEvent;
import java.util.ArrayList;

/**
 *
 * @author Androy
 */
public class invitationPartDB {
    public void invitationPart(invitationPart inv)throws Exception{
        MongoClient mongo=null;
        try{
             Connection conec=new Connection();
             mongo=conec.connect();
               DB database = mongo.getDB("infoevent"); 
               DBCollection collection = database.getCollection("InvitationPart"); 
              
              BasicDBObject document = new BasicDBObject(); 
              document.put("id","INVP"+collection.count());
               document.put("idUser",inv.getIdUser()) ;
              document.put("idSender",inv.getSender()) ;
              document.put("idEvent",inv.getIdEvent());
              document.put("Etat",inv.getEtat());
            collection.insert(document);
        }catch(Exception ex){
            throw ex;
        }
    }
    public ArrayList getInvitationPart(String idUse)throws Exception{
         MongoClient mongo=null;
        try{
               DBObject dbObject=null;
            ArrayList liste=new ArrayList();
             ArrayList listeIdE=new ArrayList();
             Connection conec=new Connection();
             mongo=conec.connect();
               DB database = mongo.getDB("infoevent");  
                DBCollection collection = database.getCollection("InvitationPart"); 
                invitationPart invE=null;
               BasicDBObject req= new BasicDBObject("idUser",idUse);
                                req.append("Etat", 0);
                 DBCursor listInvit=collection.find(req);
                    while (listInvit.hasNext()) {  
                            dbObject = listInvit.next();
                            invE=new invitationPart((String)dbObject.get("id"),(String)dbObject.get("idUser"),(String)dbObject.get("idSender"),"",(String)dbObject.get("idEvent"),(int)dbObject.get("Etat"));
                            invE=this.setInvitationPart(invE,database);
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
    public invitationPart setInvitationPart(invitationPart inv,DB database)throws Exception{
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
                DBCollection collection = database.getCollection("InvitationPart"); 
               /////////////
             BasicDBObject req= new BasicDBObject("idUser",idUser);
                           req.append("idEvent", idEvent);
                 DBObject inv=collection.findOne(req);
                collection.update(new BasicDBObject("id",(String)inv.get("id")), new BasicDBObject("$set", new BasicDBObject("Etat", et)));
                
                collection = database.getCollection("Evenement");
                 DBObject eve=collection.findOne(new BasicDBObject("id", idEvent));
                if(et==1){
                Agenda age=new Agenda(idUser,idEvent,(String)eve.get("dateDebut"),(int)eve.get("heure"),(int)eve.get("minute"),"Organiser: "+(String)eve.get("nom"));
                AgendaDB ageD=new AgendaDB();
                ageD.insertAgenda(age, database);
                }
                collection = database.getCollection("Evenement");
                DBObject dbObject = collection.findOne(new BasicDBObject("id",idEvent));
                ArrayList parte=(ArrayList)dbObject.get("partenaire");
                parte.add(idUser);
                collection.update(new BasicDBObject("id",idEvent), new BasicDBObject("$set", new BasicDBObject("partenaire",parte)));
            return "ok";
        }catch(Exception ex){
            throw ex;
        }
        finally{
             if(mongo!=null){mongo.close();}
        }
    }
    public ArrayList getMyInvitationPart(String idEvent)throws Exception{
         MongoClient mongo=null;
        try{
               DBObject dbObject=null;
            ArrayList liste=new ArrayList();
             ArrayList listeIdE=new ArrayList();
             Connection conec=new Connection();
             mongo=conec.connect();
               DB database = mongo.getDB("infoevent");  
                DBCollection collection = database.getCollection("InvitationPart"); 
                invitationPart invE=null;
               BasicDBObject req= new BasicDBObject("idEvent",idEvent);
                                
                 DBCursor listInvit=collection.find(req);
                    while (listInvit.hasNext()) {  
                            dbObject = listInvit.next();
                            invE=new invitationPart((String)dbObject.get("id"),(String)dbObject.get("idUser"),(String)dbObject.get("idSender"),"",(String)dbObject.get("idEvent"),(int)dbObject.get("Etat"));
                            invE=this.setMyInvitationPart(invE,database);
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
    public invitationPart setMyInvitationPart(invitationPart inv,DB database)throws Exception{
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
