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
public class GroupeDB {
    public void insertGroupe(Groupe grp)throws Exception{
        MongoClient mongo=null;
        try{
             Connection conec=new Connection();
             mongo=conec.connect();
               DB database = mongo.getDB("infoevent"); 
               DBCollection collection = database.getCollection("Groupe"); 
              ArrayList membre=new ArrayList();
              membre.add(grp.getAdmin());
              BasicDBObject document = new BasicDBObject(); 
              document.put("id","GRP"+collection.count());
               document.put("idAdmin",grp.getAdmin()) ;
              document.put("nom",grp.getNom()) ;
              document.put("description",grp.getDescription());
              document.put("type",grp.getType());
              document.put("pays",grp.getPays());
              document.put("region",grp.getRegion());
              document.put("ville",grp.getVille());
              document.put("membre",membre);
              
             DBCollection collection1 = database.getCollection("Utilisateur"); 
               DBObject User2=collection1.findOne(new BasicDBObject("id",grp.getAdmin()));
                ArrayList listMembre=(ArrayList)User2.get("Groupe");
                listMembre.add("GRP"+collection.count());
                collection1.update(new BasicDBObject("id",grp.getAdmin()), new BasicDBObject("$set", new BasicDBObject("Groupe", listMembre)));
            collection.insert(document);
        }catch(Exception ex){
            throw ex;
        }
    }
    public ArrayList findGroupe(String idUser)throws Exception{
         MongoClient mongo=null;
        try{
            ArrayList listeFinal=new ArrayList();
        
             Connection conec=new Connection();
             mongo=conec.connect();
               DB database = mongo.getDB("infoevent");  
               
                DBCollection collection = database.getCollection("Utilisateur"); 
                DBObject User1=collection.findOne(new BasicDBObject("id",idUser));
                 ArrayList listGroupe=(ArrayList)User1.get("Groupe");
               
               collection = database.getCollection("Groupe");
              BasicDBObject requet= new BasicDBObject();
                            requet.append("id",new BasicDBObject("$in",listGroupe));
                DBCursor iterDoc = collection.find(requet); 
                Groupe grp=null;
               
                DBObject dbObject=null;
                 while (iterDoc.hasNext()) {  
                    dbObject = iterDoc.next();
                    grp=new Groupe((String)dbObject.get("id"),(String)dbObject.get("idAdmin"),(String)dbObject.get("nom"),
                            (String)dbObject.get("description"),(String)dbObject.get("type"),(String)dbObject.get("pays"),(String)dbObject.get("region"),(String)dbObject.get("ville"));
                    listeFinal.add(grp);
                 }
            return listeFinal;
        }catch(Exception ex){
            throw ex;
        }
        finally{
            if(mongo!=null){mongo.close();}
        }
    }
    public Groupe InfoGroupe(String idGroupe)throws Exception{
         MongoClient mongo=null;
        try{
            ArrayList listeFinal=new ArrayList();
        
             Connection conec=new Connection();
             mongo=conec.connect();
               DB database = mongo.getDB("infoevent");  
               
              DBCollection collection = database.getCollection("Groupe");
            
                DBObject dbObject = collection.findOne(new BasicDBObject("id",idGroupe)); 
                ArrayList nombre=(ArrayList)dbObject.get("membre");
               
                   Groupe grp=new Groupe((String)dbObject.get("id"),(String)dbObject.get("idAdmin"),(String)dbObject.get("nom"),
                            (String)dbObject.get("description"),(String)dbObject.get("type"),(String)dbObject.get("pays"),(String)dbObject.get("region"),(String)dbObject.get("ville"));
                   
                   collection = database.getCollection("Utilisateur"); 
                DBObject User1=collection.findOne(new BasicDBObject("id",(String)dbObject.get("idAdmin")));
                   grp.setNomAdmin((String)User1.get("nom"));
                   grp.setPrenomAdmin((String)User1.get("prenom"));
                   grp.setNombre(nombre.size());
            return grp;
        }catch(Exception ex){
            throw ex;
        }
        finally{
            if(mongo!=null){mongo.close();}
        }
    }
    public String AjouterMembre(String idUser,String idGroupe)throws Exception{
         MongoClient mongo=null;
        try{
            int rest=10;
               DBObject dbObject=null;
               DBObject info=null;
          
             Connection conec=new Connection();
             mongo=conec.connect();
               DB database = mongo.getDB("infoevent");  
                DBCollection collection = database.getCollection("Groupe"); 
               /////////////par ville
                 DBObject grp=collection.findOne(new BasicDBObject("id",idGroupe));
                ArrayList listAmis=(ArrayList)grp.get("membre");
              Boolean dejat=  listAmis.remove(idUser);
              listAmis.add(idUser);
                collection.update(new BasicDBObject("id",idGroupe), new BasicDBObject("$set", new BasicDBObject("membre", listAmis)));
                if(dejat){
                 DBCollection collection1 = database.getCollection("Utilisateur"); 
               DBObject User2=collection1.findOne(new BasicDBObject("id",idUser));
                ArrayList listMembre=(ArrayList)User2.get("Groupe");
                listMembre.add(idGroupe);
                collection1.update(new BasicDBObject("id",idUser), new BasicDBObject("$set", new BasicDBObject("Groupe", listMembre)));
                }
      return "ok";
        }catch(Exception ex){
            throw ex;
        }
        finally{
             if(mongo!=null){mongo.close();}
        }
    }
    public ArrayList findGroupe(String nompay,String nomreg,String nomvill,String idUser)throws Exception{
         MongoClient mongo=null;
        try{
            int rest=10;
            ArrayList listeFinal=new ArrayList();
        
             Connection conec=new Connection();
             mongo=conec.connect();
               DB database = mongo.getDB("infoevent");  
               
               DBCollection collection1 = database.getCollection("Utilisateur"); 
                DBObject User1=collection1.findOne(new BasicDBObject("id",idUser));
                 ArrayList listGroupe=(ArrayList)User1.get("Groupe");
               
              DBCollection collection = database.getCollection("Groupe");
              BasicDBObject req=new BasicDBObject();
                            req.append("ville",nomvill);
                            req.append("id",new BasicDBObject("$nin",listGroupe));
             
                DBCursor iterDoc = collection.find(req); 
                Groupe grp=null;
               
                DBObject dbObject=null;
                 while (iterDoc.hasNext()) {  
                    dbObject = iterDoc.next();
                    grp=new Groupe((String)dbObject.get("id"),(String)dbObject.get("idAdmin"),(String)dbObject.get("nom"),
                            (String)dbObject.get("description"),(String)dbObject.get("type"),(String)dbObject.get("pays"),(String)dbObject.get("region"),(String)dbObject.get("ville"));
                    listeFinal.add(grp);
                    listGroupe.add((String)dbObject.get("id"));
                    rest--;
                    if(rest==0){
                        return listeFinal;
                    }
                 }
                 
                collection = database.getCollection("Groupe");
              req=new BasicDBObject();
                            req.append("region",nomreg);
                            req.append("id",new BasicDBObject("$nin",listGroupe));
             
               iterDoc = collection.find(req); 
               
                 while (iterDoc.hasNext()) {  
                    dbObject = iterDoc.next();
                    grp=new Groupe((String)dbObject.get("id"),(String)dbObject.get("idAdmin"),(String)dbObject.get("nom"),
                            (String)dbObject.get("description"),(String)dbObject.get("type"),(String)dbObject.get("pays"),(String)dbObject.get("region"),(String)dbObject.get("ville"));
                    listeFinal.add(grp);
                    listGroupe.add((String)dbObject.get("id"));
                    rest--;
                    if(rest==0){
                        return listeFinal;
                    }
                 }
                  
               collection = database.getCollection("Groupe");
              req=new BasicDBObject();
                            req.append("pays",nompay);
                            req.append("id",new BasicDBObject("$nin",listGroupe));
             
               iterDoc = collection.find(req);
                 while (iterDoc.hasNext()) {  
                    dbObject = iterDoc.next();
                    grp=new Groupe((String)dbObject.get("id"),(String)dbObject.get("idAdmin"),(String)dbObject.get("nom"),
                            (String)dbObject.get("description"),(String)dbObject.get("type"),(String)dbObject.get("pays"),(String)dbObject.get("region"),(String)dbObject.get("ville"));
                    listeFinal.add(grp);
                    listGroupe.add((String)dbObject.get("id"));
                    rest--;
                    if(rest==0){
                        return listeFinal;
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
}
