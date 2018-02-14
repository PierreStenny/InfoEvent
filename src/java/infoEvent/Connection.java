/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infoEvent;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

/**
 *
 * @author Androy
 */
public class Connection {
    public MongoClient connect()throws Exception{
        try{
               MongoClientURI uri  = new MongoClientURI("mongodb://itu:admin@ds111638.mlab.com:11638/infoevent");
                MongoClient mongo = new MongoClient(uri);
              
                return mongo;
        }catch(Exception ex){
            throw new Exception("Probleme de connexion !!! ");
        }
    }
}
