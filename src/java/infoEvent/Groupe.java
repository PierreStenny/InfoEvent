/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infoEvent;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Androy
 */
@XmlRootElement(name = "Groupe") 
public class Groupe {
    private String id;
    private String admin;
    private String nomAdmin;
    private String prenomAdmin;
    private String nom;
    private String description;
    private String type;
    private String pays;
    private String region;
    private String ville;
    private int nombre;
    public Groupe(){}
    public Groupe(String i,String adm,String nm,String desc,String tp,String pay,String reg,String vil)throws Exception{
        try{
            this.id=i;
            this.admin=adm;
            this.nom=nm;
            this.description=desc;
            this.type=tp;
            this.pays=pay;
            this.region=reg;
            this.ville=vil;
        }catch(Exception ex){
            throw ex;
        }
    }
    public Groupe(String adm,String nm,String desc,String tp,String pay,String reg,String vil)throws Exception{
        try{
            this.admin=adm;
            this.nom=nm;
            this.description=desc;
            this.type=tp;
            this.pays=pay;
            this.region=reg;
            this.ville=vil;
        }catch(Exception ex){
            throw ex;
        }
    }
    @XmlElement
    public String getId(){return this.id;}
    @XmlElement
    public String getAdmin(){return this.admin;}
    @XmlElement
    public String getNom(){return this.nom;}
    @XmlElement
    public String getDescription(){return this.description;}
    @XmlElement
    public String getType(){return this.type;}
    @XmlElement
    public String getPays(){return this.pays;}
    @XmlElement
    public String getRegion(){return this.region;}
    @XmlElement
    public String getVille(){return this.ville;}
     @XmlElement
     public String getNomAdmin(){return this.nomAdmin;}
      @XmlElement
     public String getPrenomAdmin(){return this.prenomAdmin;}
     @XmlElement
     public int getNombre(){return this.nombre;}
     
     public void setNomAdmin(String v){this.nomAdmin=v;}
     
     public void setPrenomAdmin(String v){this.prenomAdmin=v;}
     public void setNombre(int v){this.nombre=v;}
}
