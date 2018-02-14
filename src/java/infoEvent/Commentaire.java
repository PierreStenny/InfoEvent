/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infoEvent;

import java.util.Date;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Androy
 */
@XmlRootElement(name = "Commentaire") 
public class Commentaire {
    private String id;
    private String idUser;
    private String nomUser;
    private String prenomUser;
    private String idEvent;
    private String texte;
    private String date;
    public Commentaire(){ }
     public Commentaire(String i,String iU,String nmU,String prnU,String idE,String txt,String dt)throws Exception{ 
         try{
             this.id=i;
             this.idUser=iU;
             this.nomUser=nmU;
             this.prenomUser=prnU;
             this.idEvent=idE;
             this.texte=txt;
             this.date=dt;
         }catch(Exception ex){
             throw ex;
         }
     }
     public Commentaire(String iU,String idE,String txt)throws Exception{ 
         try{
             Date date =new Date();
             this.idUser=iU;
             this.idEvent=idE;
             this.texte=txt;
             this.date=(date.getYear()+1900)+"-"+(date.getMonth()+1)+"-"+date.getDate();
         }catch(Exception ex){
             throw ex;
         }
     }
     @XmlElement
     public String getId(){return this.id;}
     @XmlElement
     public String getIdUser(){return this.idUser;}
     @XmlElement
     public String getNomUser(){return this.nomUser;}
     @XmlElement
     public String getPrenomUser(){return this.prenomUser;}
     @XmlElement
     public String getIdEvent(){return this.idEvent;}
     @XmlElement
     public String getText(){return this.texte;}
     @XmlElement
     public String getDate(){return this.date;}
     
     public void setNomUser(String v){this.nomUser=v;}
     public void setPrenomUser(String v){this.prenomUser=v;}
}
