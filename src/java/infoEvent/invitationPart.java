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
@XmlRootElement(name = "invitationPart")
public class invitationPart {
    private String id;
    private String idUser;
    private String nomSender;
    private String prenomSender;
     private String nomUser;
    private String prenomUser;
     private String idSender;
     private String nomEvent;
    private String idEvent;
    private int Etat;
    public invitationPart(){}
    public invitationPart(String i,String iU,String iS,String nE,String iE,int et)throws Exception{
        try{
            this.id=i;
            this.idSender=iS;
            this.idUser=iU;
            this.nomEvent=nE;
            this.idEvent=iE;
            this.Etat=et;
        }catch(Exception ex){
            throw ex;
        }
    }
    
    @XmlElement
    public String getId(){return this.id;}
    @XmlElement
    public String getSender(){return this.idSender;} 
    @XmlElement
    public String getIdUser(){return this.idUser;}
     @XmlElement
    public String getNomEvent(){return this.nomEvent;}
    @XmlElement
    public String getIdEvent(){return this.idEvent;}
    @XmlElement
    public int getEtat(){return this.Etat;}
    @XmlElement
    public String getNomSender(){return this.nomSender;}
    @XmlElement
    public String getPrenomSender(){return this.prenomSender;}
    @XmlElement
    public String getNomUser(){return this.nomUser;}
    @XmlElement
    public String getPrenomUser(){return this.prenomUser;}
    
     public void setNomEvent(String v){this.nomEvent=v;}
     public void setNomSender(String nm){this.nomSender=nm;}
    public void setPrenomSender(String pr){this.prenomSender=pr;}
    public void setNomUser(String nm){this.nomUser=nm;}
    public void setPrenomUser(String pr){this.prenomUser=pr;}
}
