/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infoEvent;

import com.mongodb.*;
import com.mongodb.MongoClient;
import com.mongodb.gridfs.*;
import com.mongodb.gridfs.GridFSInputFile;
import java.io.*;
import java.util.ArrayList;
import org.apache.tomcat.util.codec.binary.Base64;
/**
 *
 * @author Androy
 */
public class Outils {
     public static byte[] LoadImage(String filePath) throws Exception {
        File file = new File(filePath);
        int size = (int)file.length();
        byte[] buffer = new byte[size];
        FileInputStream in = new FileInputStream(file);
        in.read(buffer);
        in.close();
        return buffer;
    }
    public void insertImage(String id,String path)throws Exception{
         MongoClient mongo=null;
        try{
             Connection conec=new Connection();
             mongo=conec.connect();
             DB database = mongo.getDB("infoevent"); 
            
             byte[] imageBytes = LoadImage(path);
            GridFS fs = new GridFS( database );
        //Save image into database
            GridFSInputFile in = fs.createFile( imageBytes );
            in.setFilename(id);
             in.save();
        }catch(Exception ex){
            throw ex;
        }
        finally{
             if(mongo!=null){mongo.close();}
        }
    }
    public String getImage(String id)throws Exception{
        MongoClient mongo=null;
        String image="";
        try{
             Connection conec=new Connection();
             mongo=conec.connect();
             DB database = mongo.getDB("infoevent"); 
             GridFS fs = new GridFS( database );
                        GridFSDBFile outer = fs.findOne( new BasicDBObject( "filename" ,"glenn4"));
                       if(outer!=null){
                       ByteArrayOutputStream o = new ByteArrayOutputStream();
                        outer.writeTo(o);
                        byte[]  data = o.toByteArray();
                        
                    byte[] encodeBase64 = Base64.encodeBase64(data);
                    image = new String(encodeBase64 , "UTF-8");
                       }
            return image;
        }catch(Exception ex){
            throw ex;
        }
    }
    public ArrayList findPays()throws Exception{
         MongoClient mongo=null;
        try{
            ArrayList listeFinal=new ArrayList();
            ArrayList listePays=new ArrayList();
            ArrayList listeReg=new ArrayList();
         
            
             Connection conec=new Connection();
             mongo=conec.connect();
               DB database = mongo.getDB("infoevent");  
               DBCollection collection = database.getCollection("Pays");
               
                DBCursor iterDoc = collection.find(); 
                Pays pay=null;
                DBObject dbObject=null;
                 while (iterDoc.hasNext()) {  
                    dbObject = iterDoc.next();
                    pay=new Pays((String)dbObject.get("id"),(String)dbObject.get("nom")/*,(ArrayList<Region>)dbObject.get("region")*/);
                    listePays.add(pay);
                 }
            return listePays;
        }catch(Exception ex){
            throw ex;
        }
        finally{
            if(mongo!=null){mongo.close();}
        }
    }
    public Pays findPays(String idPays)throws Exception{
         MongoClient mongo=null;
        try{
             Connection conec=new Connection();
             mongo=conec.connect();
               DB database = mongo.getDB("infoevent");  
               DBCollection collection = database.getCollection("Pays");
                DBObject pays  = collection.findOne(new BasicDBObject("id",idPays)); 
            return new Pays((String)pays.get("id"),(String)pays.get("nom"));
        }catch(Exception ex){
            throw ex;
        }
        finally{
            if(mongo!=null){mongo.close();}
        }
    }
    public void insertPays(String nom)throws Exception{
         MongoClient mongo=null;
        try{
             Connection conec=new Connection();
             mongo=conec.connect();
               DB database = mongo.getDB("infoevent");  
               DBCollection collection = database.getCollection("Pays"); 
             //System.out.println("Collection myCollection selected successfully"); 
            
              BasicDBObject pays = new BasicDBObject(); 
              pays.put("id","PAY"+(collection.count()+1));
              pays.put("nom",nom) ;
              pays.put("region", new ArrayList<DBObject>());
            collection.insert(pays);
          
        }catch(Exception ex){
            throw ex;
        }
        finally{
            if(mongo!=null){mongo.close();}
        }
    }
    public ArrayList findRegion(String idPays)throws Exception{
         MongoClient mongo=null;
        try{
           
            ArrayList<Region> listeReg=new ArrayList();
             Connection conec=new Connection();
             mongo=conec.connect();
               DB database = mongo.getDB("infoevent");  
               DBCollection collection = database.getCollection("Pays");
               
                DBObject pays  = collection.findOne(new BasicDBObject("nom",idPays)); 
                listeReg=(ArrayList<Region>)pays.get("region");
                 DBObject reg=null;
                for(int i=0;i<listeReg.size();i++){
                    reg=(DBObject)listeReg.get(i);
                    listeReg.set(i,new Region((String)reg.get("idRegion"),(String)reg.get("nom")));
                }
            return listeReg;
        }catch(Exception ex){
            throw ex;
        }
        finally{
            if(mongo!=null){mongo.close();}
        }
    }
    public void insertRegion(String idPays,String nom)throws Exception{
         MongoClient mongo=null;
        try{
             Connection conec=new Connection();
             mongo=conec.connect();
               DB database = mongo.getDB("infoevent");  
               DBCollection collection = database.getCollection("Pays"); 
             
                   DBObject pays = collection.findOne(new BasicDBObject("id",idPays));
                  ArrayList listeReg=(ArrayList)pays.get("region");
                
           BasicDBObject newReg = new BasicDBObject();
            newReg.put("idRegion","REG"+(listeReg.size()+1));
            newReg.put("nom",nom);
            newReg.put("Ville",new ArrayList<DBObject>());
            listeReg.add(newReg);
            collection.update(new BasicDBObject("id",pays.get("id")), new BasicDBObject("$set", new BasicDBObject("region", listeReg)));
        
        }catch(Exception ex){
            throw ex;
        }
        finally{
            if(mongo!=null){mongo.close();}
        }
    }
    public ArrayList findVille(String idPays,String idReg)throws Exception{
         MongoClient mongo=null;
        try{
           
            ArrayList<Region> listeReg=new ArrayList();
             Connection conec=new Connection();
             mongo=conec.connect();
               DB database = mongo.getDB("infoevent");  
               DBCollection collection = database.getCollection("Pays");
               
                DBObject pays  = collection.findOne(new BasicDBObject("nom",idPays));; 
                listeReg=(ArrayList<Region>)pays.get("region");
                BasicDBObject newVil = null;
                  DBObject tempo = null;
                  DBObject temporaire = null;
                  ArrayList listeVille=new ArrayList();
                  for(int i=0;i<listeReg.size();i++){
                      tempo=(DBObject)listeReg.get(i);
                      
                      if(idReg.compareTo((String)tempo.get("nom"))==0){
                          // throw new Exception("eto alo");
                           listeVille=(ArrayList)tempo.get("Ville");
                           for(int s=0;s<listeVille.size();s++){
                               temporaire=(DBObject)listeVille.get(s);
                               listeVille.set(s,new Ville((String)temporaire.get("idVille"),(String)temporaire.get("nom")));
                           }
                           return listeVille;
                      }
                  }
            return listeVille;
        }catch(Exception ex){
            throw ex;
        }
        finally{
            if(mongo!=null){mongo.close();}
        }
    }
    public void insertVille(String idPays,String idReg,String nom)throws Exception{
         MongoClient mongo=null;
        try{
             Connection conec=new Connection();
             mongo=conec.connect();
               DB database = mongo.getDB("infoevent");  
               DBCollection collection = database.getCollection("Pays"); 
             
                   DBObject pays = collection.findOne(new BasicDBObject("id",idPays));
                  ArrayList<BasicDBObject> listeReg=(ArrayList)pays.get("region");
                  
                 
                  BasicDBObject newVil = null;
                  BasicDBObject tempo = null;
                  ArrayList listeVille=new ArrayList();
                  for(int i=0;i<listeReg.size();i++){
                      tempo=listeReg.get(i);
                      
                      if(idReg.compareTo((String)tempo.get("idRegion"))==0){
                          // throw new Exception("eto alo");
                           listeVille=(ArrayList)tempo.get("Ville");
                           newVil = new BasicDBObject();
                             newVil.put("idVille","VIL"+(listeVille.size()+1));
                             newVil.put("nom",nom);
                             listeVille.add(newVil);
                             listeReg.set(i,tempo);
                          break;
                      }
                  }
                collection.update(new BasicDBObject("id",idPays), new BasicDBObject("$set", new BasicDBObject("region", listeReg)));
        
           }catch(Exception ex){
            throw ex;
        }
        finally{
            if(mongo!=null){mongo.close();}
        }
    }
    public void insertType(String nom)throws Exception{
         MongoClient mongo=null;
        try{
             Connection conec=new Connection();
             mongo=conec.connect();
               DB database = mongo.getDB("infoevent");  
               DBCollection collection = database.getCollection("Type"); 
             //System.out.println("Collection myCollection selected successfully"); 
            
              BasicDBObject type = new BasicDBObject(); 
              type.put("id","Typ"+(collection.count()+1));
              type.put("nom",nom) ;
            collection.insert(type);
          
        }catch(Exception ex){
            throw ex;
        }
        finally{
            if(mongo!=null){mongo.close();}
        }
    }
    public ArrayList findType()throws Exception{
         MongoClient mongo=null;
        try{
            ArrayList listeType=new ArrayList();
             Connection conec=new Connection();
             mongo=conec.connect();
               DB database = mongo.getDB("infoevent");  
               DBCollection collection = database.getCollection("Type");
               
                DBCursor iterDoc = collection.find(); 
                Type typ=null;
                DBObject dbObject=null;
                 while (iterDoc.hasNext()) {  
                    dbObject = iterDoc.next();
                    typ=new Type((String)dbObject.get("id"),(String)dbObject.get("nom")/*,(ArrayList<Region>)dbObject.get("region")*/);
                    listeType.add(typ);
                 }
            return listeType;
        }catch(Exception ex){
            throw ex;
        }
        finally{
            if(mongo!=null){mongo.close();}
        }
    }
    public String upload(String DataString,String idUser )throws Exception{
        String reponse="upload ok";
       MongoClient mongo=null;
        try{
             String[] tempo=DataString.split(",");
           byte[] encodeBase64=tempo[1].getBytes();
           
            ArrayList listeFinal=new ArrayList();
           
         Outils outil=new Outils();
            
             Connection conec=new Connection();
             mongo=conec.connect();
               DB database = mongo.getDB("infoevent");  
                GridFS fs = new GridFS( database );
               GridFSInputFile in = fs.createFile(encodeBase64 );
                in.put("id",idUser);
                in.save();
        
           
            return reponse;
        }catch(Exception ex){
            throw ex;
        }
    }
}
