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
@XmlRootElement(name = "Region")
public class Region {
     private String id;
    private String nom;
    //private ArrayList Ville;
    public Region(){
    }
    public Region(String i,String nm,ArrayList reg)throws Exception{
        try{
            this.id=i;
            this.nom=nm;
            //this.Ville=reg;
        }catch(Exception ex){
            throw ex;
        }
    }
     public Region(String i,String nm)throws Exception{
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
    //public ArrayList getVille(){return this.Ville;}
}
