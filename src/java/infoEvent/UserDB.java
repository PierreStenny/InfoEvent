    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infoEvent;

import com.mongodb.BasicDBObject;
import com.mongodb.*;
import com.mongodb.DBCollection;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Androy
 */
public class UserDB {
    public String insertUser(User use)throws Exception{
         MongoClient mongo=null;
        try{
             Connection conec=new Connection();
             mongo=conec.connect();
               DB database = mongo.getDB("infoevent");  
               DBCollection collection = database.getCollection("Utilisateur"); 
             //System.out.println("Collection myCollection selected successfully"); 
             String res="USE"+collection.count();
              BasicDBObject document = new BasicDBObject(); 
              document.put("id","USE"+collection.count());
              document.put("Email",use.getEmail()) ;
              document.put("Mdp",use.getMdp()); 
              document.put("Groupe",new ArrayList());
              document.put("Amis",new ArrayList());
              document.put("Admin",use.getAdmin());
            document.put("nom",use.getNom());
            document.put("prenom",use.getPrenom());
             document.put("dateNaiss",use.getDateNaiss());
              document.put("sexe",use.getSexe());
              document.put("pays",use.getPays());
               document.put("region",use.getRegion());
                document.put("Ville",use.getVille());
                
            collection.insert(document);
           return res;
        }catch(Exception ex){
            throw ex;
        }
        finally{
            if(mongo!=null){mongo.close();}
        }
    }
    public ArrayList getUser(String nomreg,String nomvill,String idUse)throws Exception{
         MongoClient mongo=null;
        try{
            int rest=10;
               DBObject dbObject=null;
               DBObject info=null;
            ArrayList liste=new ArrayList();
             Connection conec=new Connection();
             mongo=conec.connect();
               DB database = mongo.getDB("infoevent");  
                DBCollection collection = database.getCollection("Utilisateur"); 
                DBObject User1=collection.findOne(new BasicDBObject("id",idUse));
                 ArrayList listAmis=(ArrayList)User1.get("Amis");
                 listAmis.add(idUse);
               /////////////par ville
            BasicDBObject requet= new BasicDBObject();
                          requet.put("Ville",nomvill);
                          requet.append("id",new BasicDBObject("$nin",listAmis));
                 DBCursor listVille=collection.find(requet);
                User use=null;
                    while (listVille.hasNext()) {  
                            dbObject = listVille.next();
                           use=new User((String)dbObject.get("id"),(String)dbObject.get("nom"),
                           (String)dbObject.get("prenom"),(String)dbObject.get("pays"),(String)dbObject.get("region"),
                           (String)dbObject.get("Ville"));
                           liste.add(use);
                           listAmis.add(use.getId());
                           rest--;
                           if(rest==0){
                               return liste;
                           }
                       }
                  
                    requet= new BasicDBObject();
                          requet.put("region",nomreg);
                          requet.append("id",new BasicDBObject("$nin",listAmis));
                    listVille=collection.find(requet);
                     while (listVille.hasNext()) {  
                            dbObject = listVille.next();
                           liste.add(new User((String)dbObject.get("id"),(String)dbObject.get("nom"),
                           (String)dbObject.get("prenom"),(String)dbObject.get("pays"),(String)dbObject.get("region"),
                           (String)dbObject.get("Ville")));
                            listAmis.add((String)dbObject.get("id"));
                           rest--;
                           if(rest==0){
                               return liste;
                           }
                       }
                     
                     requet= new BasicDBObject();
                          requet.put("pays",(String)User1.get("pays"));
                          requet.append("id",new BasicDBObject("$nin",listAmis));
                    listVille=collection.find(requet);
                     while (listVille.hasNext()) {  
                            dbObject = listVille.next();
                           liste.add(new User((String)dbObject.get("id"),(String)dbObject.get("nom"),
                           (String)dbObject.get("prenom"),(String)dbObject.get("pays"),(String)dbObject.get("region"),
                           (String)dbObject.get("Ville")));
                            listAmis.add((String)dbObject.get("id"));
                           rest--;
                           if(rest==0){
                               return liste;
                           }
                       }
      return liste;
        }catch(Exception ex){
            throw ex;
        }
        finally{
             if(mongo!=null){mongo.close();}
        }
    }
    
    /*public User getUser(String idUser)throws Exception{
         MongoClient mongo=null;
        try{
             Connection conec=new Connection();
             mongo=conec.connect();
               DB database = mongo.getDB("infoevent");  
               
                DBCollection collection = database.getCollection("Evenement");
                DBObject dbObject = collection.findOne(new BasicDBObject("id","EVENT0"));
                ArrayList listLike=(ArrayList)dbObject.get("like");
               
               
               
               
              collection = database.getCollection("Utilisateur"); 
             //System.out.println("Collection myCollection selected successfully");
            BasicDBObject requete=new BasicDBObject("id",idUser);
                          requete.append("id",new BasicDBObject("$in",listLike));
              DBObject test=collection.findOne(requete);
              
              
              
               User use=null;
        if(test!=null){
        use=new User((String)test.get("id"),(String)test.get("Email"),(String)test.get("Mdp"),
        (String)test.get("nom"),(String)test.get("prenom"),(String)test.get("sexe"),(String)test.get("dateNaiss"),
        (String)test.get("pays"),(String)test.get("region"),(String)test.get("Ville"),(int)test.get("Admin"));
        }
      return use;
        }catch(Exception ex){
            throw ex;
        }
        finally{
             if(mongo!=null){mongo.close();}
        }
    }*/
    public User getUser(String idUser)throws Exception{
         MongoClient mongo=null;
        try{
             Connection conec=new Connection();
             mongo=conec.connect();
               DB database = mongo.getDB("infoevent");  
               DBCollection collection = database.getCollection("Utilisateur"); 
             //System.out.println("Collection myCollection selected successfully"); 
              DBObject test=collection.findOne(new BasicDBObject("id",idUser));
             
        User use=new User((String)test.get("id"),(String)test.get("Email"),(String)test.get("Mdp"),
        (String)test.get("nom"),(String)test.get("prenom"),(String)test.get("sexe"),(String)test.get("dateNaiss"),
        (String)test.get("pays"),(String)test.get("region"),(String)test.get("Ville"),(int)test.get("Admin"));
      return use;
        }catch(Exception ex){
            throw ex;
        }
        finally{
             if(mongo!=null){mongo.close();}
        }
    }
    public String login(String email,String mdp)throws Exception{
         MongoClient mongo=null;
        try{
            String id="1";
            Connection conec=new Connection();
             mongo=conec.connect();
               DB database = mongo.getDB("infoevent");  
               DBCollection collection = database.getCollection("Utilisateur"); 
               DBObject use=null;
               DBObject test=collection.findOne(new BasicDBObject("Email",email));
               if(test!=null){
               use= collection.findOne(new BasicDBObject("Email",email).append("Mdp",mdp));
               }
               else{
                   id="0";
               }
               if(use!=null){
                   id=(String)use.get("id");
               }
            return id;
        }catch(Exception ex){
            throw ex;
        }
         finally{
             if(mongo!=null){mongo.close();}
        }
    }
    public String AjouterAmis(String idUser1,String idUser2,int et)throws Exception{
         MongoClient mongo=null;
        try{
            int rest=10;
               DBObject dbObject=null;
               DBObject info=null;
          
             Connection conec=new Connection();
             mongo=conec.connect();
               DB database = mongo.getDB("infoevent");  
                DBCollection collection = database.getCollection("Utilisateur"); 
               /////////////par ville
              if(et==1){
                 DBObject User1=collection.findOne(new BasicDBObject("id",idUser1));
                ArrayList listAmis=(ArrayList)User1.get("Amis");
                listAmis.add(idUser2);
                collection.update(new BasicDBObject("id",idUser1), new BasicDBObject("$set", new BasicDBObject("Amis", listAmis)));
                
                 DBObject User2=collection.findOne(new BasicDBObject("id",idUser2));
                 listAmis=(ArrayList)User2.get("Amis");
                listAmis.add(idUser1);
                collection.update(new BasicDBObject("id",idUser2), new BasicDBObject("$set", new BasicDBObject("Amis", listAmis)));
              }
                DBCollection collection1 = database.getCollection("Invitation"); 
               /////////////
             BasicDBObject req= new BasicDBObject("idUser",idUser2);
                           req.append("idSender", idUser1);
                 DBObject inv=collection1.findOne(req);
                collection1.update(new BasicDBObject("id",(String)inv.get("id")), new BasicDBObject("$set", new BasicDBObject("Etat", et)));
                
      return "ok";
        }catch(Exception ex){
            throw ex;
        }
        finally{
             if(mongo!=null){mongo.close();}
        }
    }
    public ArrayList getAmis(String idUse)throws Exception{
         MongoClient mongo=null;
        try{
               DBObject dbObject=null;
            ArrayList liste=new ArrayList();
             Connection conec=new Connection();
             mongo=conec.connect();
               DB database = mongo.getDB("infoevent");  
                DBCollection collection = database.getCollection("Utilisateur"); 
                DBObject User1=collection.findOne(new BasicDBObject("id",idUse));
                 ArrayList listAmis=(ArrayList)User1.get("Amis");
                 
               /////////////par ville
            BasicDBObject requet= new BasicDBObject();
                            requet.append("id",new BasicDBObject("$ne",idUse));
                          requet.append("id",new BasicDBObject("$in",listAmis));
                 DBCursor listVille=collection.find(requet);
                User use=null;
                    while (listVille.hasNext()) {  
                            dbObject = listVille.next();
                           use=new User((String)dbObject.get("id"),(String)dbObject.get("nom"),
                           (String)dbObject.get("prenom"),(String)dbObject.get("pays"),(String)dbObject.get("region"),
                           (String)dbObject.get("Ville"));
                           liste.add(use);
                           listAmis.add(use);
                       }
      return liste;
        }catch(Exception ex){
            throw ex;
        }
        finally{
             if(mongo!=null){mongo.close();}
        }
    }
    public ArrayList suggestMembre(String idUse,String idGroupe)throws Exception{
         MongoClient mongo=null;
        try{
               DBObject dbObject=null;
            ArrayList liste=new ArrayList();
             Connection conec=new Connection();
             mongo=conec.connect();
               DB database = mongo.getDB("infoevent");  
                DBCollection collection = database.getCollection("Utilisateur"); 
               
               /////////////
               
              DBCollection collection1 = database.getCollection("Groupe");
            
                DBObject groupe = collection1.findOne(new BasicDBObject("id",idGroupe)); 
               ArrayList listMembre=(ArrayList)groupe.get("membre");
               
            BasicDBObject requet= new BasicDBObject();
                          requet.append("id",new BasicDBObject("$nin",listMembre));
                 DBCursor listVille=collection.find(requet);
                User use=null;
                    while (listVille.hasNext()) {  
                            dbObject = listVille.next();
                           use=new User((String)dbObject.get("id"),(String)dbObject.get("nom"),
                           (String)dbObject.get("prenom"),(String)dbObject.get("pays"),(String)dbObject.get("region"),
                           (String)dbObject.get("Ville"));
                           liste.add(use);
                       }
      return liste;
        }catch(Exception ex){
            throw ex;
        }
        finally{
             if(mongo!=null){mongo.close();}
        }
    }
    public ArrayList getCommenteur(String idEvent)throws Exception{
         MongoClient mongo=null;
        try{
               DBObject dbObject=null;
            ArrayList liste=new ArrayList();
             Connection conec=new Connection();
             mongo=conec.connect();
               DB database = mongo.getDB("infoevent");  
                DBCollection collection = database.getCollection("Evenement"); 
                DBObject Event=collection.findOne(new BasicDBObject("id",idEvent));
                 ArrayList listComment=(ArrayList)Event.get("comment");
                 
                 
                 collection = database.getCollection("Utilisateur");
               /////////////par ville
            BasicDBObject requet= new BasicDBObject();
                          requet.append("id",new BasicDBObject("$in",listComment));
                 DBCursor listUse=collection.find(requet);
                User use=null;
                    while (listUse.hasNext()) {  
                            dbObject = listUse.next();
                           use=new User((String)dbObject.get("id"),(String)dbObject.get("nom"),
                           (String)dbObject.get("prenom"),(String)dbObject.get("pays"),(String)dbObject.get("region"),
                           (String)dbObject.get("Ville"));
                           liste.add(use);
                      
                       }
      return liste;
        }catch(Exception ex){
            throw ex;
        }
        finally{
             if(mongo!=null){mongo.close();}
        }
    }
    public ArrayList getLiker(String idEvent)throws Exception{
         MongoClient mongo=null;
        try{
               DBObject dbObject=null;
            ArrayList liste=new ArrayList();
             Connection conec=new Connection();
             mongo=conec.connect();
               DB database = mongo.getDB("infoevent");  
                DBCollection collection = database.getCollection("Evenement"); 
                DBObject Event=collection.findOne(new BasicDBObject("id",idEvent));
                 ArrayList listJaim=(ArrayList)Event.get("like");
                 
                 
                 collection = database.getCollection("Utilisateur");
               /////////////par ville
            BasicDBObject requet= new BasicDBObject();
                          requet.append("id",new BasicDBObject("$in",listJaim));
                 DBCursor listUse=collection.find(requet);
                User use=null;
                    while (listUse.hasNext()) {  
                            dbObject = listUse.next();
                           use=new User((String)dbObject.get("id"),(String)dbObject.get("nom"),
                           (String)dbObject.get("prenom"),(String)dbObject.get("pays"),(String)dbObject.get("region"),
                           (String)dbObject.get("Ville"));
                           liste.add(use);
                      
                       }
      return liste;
        }catch(Exception ex){
            throw ex;
        }
        finally{
             if(mongo!=null){mongo.close();}
        }
    }
    
}
