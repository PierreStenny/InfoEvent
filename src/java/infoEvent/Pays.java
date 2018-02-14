/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infoEvent;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Androy
 */
@XmlRootElement(name = "pays") 
public class Pays {
    private String id;
    private String nom;
    //private ArrayList Region;
    
    /*public Pays(String i,String nm,ArrayList reg)throws Exception{
        try{
            this.id=i;
            this.nom=nm;
           // this.Region=reg;
        }catch(Exception ex){
            throw ex;
        }
    }*/
    public Pays(){
    }
     public Pays(String i,String nm)throws Exception{
        try{
            this.id=i;
            this.nom=nm;
        }catch(Exception ex){
            throw ex;
        }
    }
    @XmlElement
    public String getId(){return this.id; }
   @XmlElement
    public String getNom(){return this.nom;}
   /* @XmlElement
    public ArrayList getRegion(){return this.Region;}*/
}
