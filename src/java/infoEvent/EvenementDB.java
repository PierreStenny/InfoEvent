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
public class EvenementDB {
    public void insertEvenement(Evenement event)throws Exception{
         MongoClient mongo=null;
        try{
             Connection conec=new Connection();
             mongo=conec.connect();
               DB database = mongo.getDB("infoevent"); 
               DBCollection collection = database.getCollection("Evenement"); 
             //System.out.println("Collection myCollection selected successfully"); 
              BasicDBObject document = new BasicDBObject(); 
              document.put("id","EVENT"+collection.count());
               document.put("nom",event.getNom());
               document.put("Lieu",event.getLieu());
                document.put("organisateur",event.getIdOrganisateur());
              document.put("like", new ArrayList());
              document.put("comment", new ArrayList());
          
            document.put("type",event.getType());
             document.put("categorie",event.getCategorie());
            document.put("descreption",event.getDescription());
             document.put("datePost",event.getDate());
             document.put("dateDebut",event.getDateCommence());
             document.put("heure",event.getHeure());
             document.put("minute",event.getMinute());
             document.put("dateFin",event.getDateFin());
              document.put("pays",event.getPays());
               document.put("region",event.getRegion());
                document.put("ville",event.getVille());
           
            document.put("partenaire",new ArrayList<BasicDBObject>());
           
            Agenda age=new Agenda(event.getIdOrganisateur(),"EVENT"+collection.count(),event.getDateCommence(),event.getHeure(),event.getMinute(),"Organiser: "+event.getNom());
                AgendaDB ageD=new AgendaDB();
                ageD.insertAgenda(age, database);
                 collection.insert(document);
        }catch(Exception ex){
            throw ex;
        }
    }
    public Evenement findEvent(String idEvent)throws Exception{
         MongoClient mongo=null;
        try{
            ArrayList listeFinal=new ArrayList();
           
         
            
             Connection conec=new Connection();
             mongo=conec.connect();
               DB database = mongo.getDB("infoevent");  
               DBCollection collection = database.getCollection("Evenement");
                DBObject dbObject = collection.findOne(new BasicDBObject("id",idEvent));
                
                ArrayList listLike=null;
                ArrayList listComment=null;
                listLike=(ArrayList)dbObject.get("like");
                    listComment=(ArrayList)dbObject.get("comment");
                  Evenement  Event=new Evenement((String)dbObject.get("id"),(String)dbObject.get("nom"),(String)dbObject.get("Lieu"),(String)dbObject.get("organisateur"),
                    (String)dbObject.get("descreption"),(String)dbObject.get("type"),(String)dbObject.get("pays"),(String)dbObject.get("region"),(String)dbObject.get("ville"),
                    (String)dbObject.get("datePost"),(String)dbObject.get("dateDebut"),(int)dbObject.get("heure"),(int)dbObject.get("minute"),(String)dbObject.get("dateFin"),(String)dbObject.get("categorie"),listLike.size(),listComment.size());
                   
            return Event;
        }catch(Exception ex){
            throw ex;
        }
        finally{
            if(mongo!=null){mongo.close();}
        }
    }
    public ArrayList findEvent()throws Exception{
         MongoClient mongo=null;
        try{
            ArrayList listeFinal=new ArrayList();
           
         Outils outil=new Outils();
            
             Connection conec=new Connection();
             mongo=conec.connect();
               DB database = mongo.getDB("infoevent");  
               DBCollection collection = database.getCollection("Evenement");
                
                Evenement Event=null;
                ArrayList listLike=null;
                ArrayList listComment=null;
               
             ArrayList listType=new ArrayList();
             listType=outil.findType();
           DBObject dbObject = null; 
           Type type=null;
             for(int i=0;i<listType.size();i++){
                 type=(Type)listType.get(i);
                 dbObject = collection.findOne(new BasicDBObject("type",type.getNom())); 
                 if(dbObject!=null){
                 listLike=(ArrayList)dbObject.get("like");
                    listComment=(ArrayList)dbObject.get("comment");
                    Event=new Evenement((String)dbObject.get("id"),(String)dbObject.get("nom"),(String)dbObject.get("Lieu"),(String)dbObject.get("organisateur"),
                    (String)dbObject.get("descreption"),(String)dbObject.get("type"),(String)dbObject.get("pays"),(String)dbObject.get("region"),(String)dbObject.get("ville"),
                    (String)dbObject.get("datePost"),(String)dbObject.get("dateDebut"),(int)dbObject.get("heure"),(int)dbObject.get("minute"),(String)dbObject.get("dateFin"),(String)dbObject.get("categorie"),listLike.size(),listComment.size());
                    listeFinal.add(Event);
                 }
             }
             
                  
            return listeFinal;
        }catch(Exception ex){
            throw ex;
        }
        finally{
            if(mongo!=null){mongo.close();}
        }
    }
    public ArrayList findMyEvent(String idUser)throws Exception{
         MongoClient mongo=null;
        try{
            ArrayList listeFinal=new ArrayList();
           
         
            
             Connection conec=new Connection();
             mongo=conec.connect();
               DB database = mongo.getDB("infoevent");  
               DBCollection collection = database.getCollection("Evenement");
                DBCursor iterDoc = collection.find(new BasicDBObject("organisateur",idUser)); 
                Evenement Event=null;
                ArrayList listLike=null;
                ArrayList listComment=null;
                DBObject dbObject=null;
            
                 while (iterDoc.hasNext()) {  
                    dbObject = iterDoc.next();
                   
                    listLike=(ArrayList)dbObject.get("like");
                    listComment=(ArrayList)dbObject.get("comment");
                    Event=new Evenement((String)dbObject.get("id"),(String)dbObject.get("nom"),(String)dbObject.get("Lieu"),(String)dbObject.get("organisateur"),
                    (String)dbObject.get("descreption"),(String)dbObject.get("type"),(String)dbObject.get("pays"),(String)dbObject.get("region"),(String)dbObject.get("ville"),
                    (String)dbObject.get("datePost"),(String)dbObject.get("dateDebut"),(int)dbObject.get("heure"),(int)dbObject.get("minute"),(String)dbObject.get("dateFin"),(String)dbObject.get("categorie"),listLike.size(),listComment.size());
                    listeFinal.add(Event);
                 }
            return listeFinal;
        }catch(Exception ex){
            throw ex;
        }
        finally{
            if(mongo!=null){mongo.close();}
        }
    }
    public ArrayList findTypeEvent(String Type)throws Exception{
        MongoClient mongo=null;
        try{
            ArrayList listeFinal=new ArrayList();
           
         
            
             Connection conec=new Connection();
             mongo=conec.connect();
               DB database = mongo.getDB("infoevent");  
               DBCollection collection = database.getCollection("Evenement");
                DBCursor iterDoc = collection.find(new BasicDBObject("type",Type)); 
                Evenement Event=null;
                ArrayList listLike=null;
                ArrayList listComment=null;
                DBObject dbObject=null;
            
                 while (iterDoc.hasNext()) {  
                    dbObject = iterDoc.next();
                   
                    listLike=(ArrayList)dbObject.get("like");
                    listComment=(ArrayList)dbObject.get("comment");
                    Event=new Evenement((String)dbObject.get("id"),(String)dbObject.get("nom"),(String)dbObject.get("Lieu"),(String)dbObject.get("organisateur"),
                    (String)dbObject.get("descreption"),(String)dbObject.get("type"),(String)dbObject.get("pays"),(String)dbObject.get("region"),(String)dbObject.get("ville"),
                    (String)dbObject.get("datePost"),(String)dbObject.get("dateDebut"),(int)dbObject.get("heure"),(int)dbObject.get("minute"),(String)dbObject.get("dateFin"),(String)dbObject.get("categorie"),listLike.size(),listComment.size());
                    listeFinal.add(Event);
                 }
            return listeFinal;
        }catch(Exception ex){
            throw ex;
        }
        finally{
            if(mongo!=null){mongo.close();}
        }
    }
}
