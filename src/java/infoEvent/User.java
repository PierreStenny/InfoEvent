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
@XmlRootElement(name = "User") 
public class User {
    private String id;
    private String email;
    private String mdp;
    
    private String nom;
    private String prenom;
    private String sexe;
    private String dateNaiss;
    
    private String Pays;
    private String Region;
    private String Ville;
    private int admin=0;
    public User(){}
    public User(String em,String md,String nm,String pren,String sex,String dNaiss,String iP,String iR,String iV)throws Exception{
        try{
            
            this.email=em;
            this.mdp=md;
            this.nom=nm;
            this.prenom=pren;
            this.sexe=sex;
            this.dateNaiss=dNaiss;
            this.Pays=iP;
            this.Region=iR;
            this.Ville=iV;
        }catch(Exception ex){
            throw ex;
        }
    }
    public User(String i,String em,String md,String nm,String pren,String sex,String dNaiss,String iP,String iR,String iV,int adm)throws Exception{
        try{
            this.id=i;
            this.email=em;
            this.mdp=md;
            this.nom=nm;
            this.prenom=pren;
            this.sexe=sex;
            this.dateNaiss=dNaiss;
              this.Pays=iP;
            this.Region=iR;
            this.Ville=iV;
            this.admin=adm;
        }catch(Exception ex){
            throw ex;
        }
    }
    public User(String i,String nm,String pren,String iP,String iR,String iV)throws Exception{
        try{
            this.id=i;
            this.nom=nm;
            this.prenom=pren;
            this.Pays=iP;
            this.Region=iR;
            this.Ville=iV;
        }catch(Exception ex){
            throw ex;
        }
    }
   
    public void setPays(String v){this.Pays=v;}
    public void setRegion(String v){this.Region=v;}
    public void setVille(String v){this.Ville=v;}
    
    @XmlElement
    public String getId(){ return this.id;}
    @XmlElement
    public String getEmail(){return this.email;}
    @XmlElement
    public String getMdp(){return this.mdp;}
    @XmlElement
    public String getNom(){return this.nom;}
    @XmlElement
    public String getPrenom(){return this.prenom;}
    @XmlElement
    public String getDateNaiss(){return this.dateNaiss;}
    @XmlElement
     public String getPays(){return this.Pays;}
     @XmlElement
    public String getRegion(){return this.Region;}
    @XmlElement
    public String getVille(){return this.Ville;}
    @XmlElement
    public String getSexe(){return this.sexe;}
     @XmlElement
    public int getAdmin(){return this.admin;}
}
