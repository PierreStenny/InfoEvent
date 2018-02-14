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
 @XmlRootElement(name = "Jaime") 
public class Jaime {
   
    private String id;
    private String idUser;
    private String nomUser;
    private String prenomUser;
    private String idEvent;
    public Jaime(){ }
     public Jaime(String i,String iU,String nmU,String prnU,String idE)throws Exception{ 
         try{
             this.id=i;
             this.idUser=iU;
             this.nomUser=nmU;
             this.prenomUser=prnU;
             this.idEvent=idE;
         }catch(Exception ex){
             throw ex;
         }
     }
     public Jaime(String iU,String idE)throws Exception{ 
         try{
             this.idUser=iU;
             this.idEvent=idE;
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
     
     public void setNomUser(String v){this.nomUser=v;}
     public void setPrenomUser(String v){this.prenomUser=v;}
}
