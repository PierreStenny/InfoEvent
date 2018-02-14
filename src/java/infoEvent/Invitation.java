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

@XmlRootElement(name = "invitationEvent") 
public class Invitation {
    private String id;
    private String idUser;
    private String nomSender;
    private String prenomSender;
     private String nomUser;
    private String prenomUser;
     private String idSender;
    private int Etat;
    public Invitation(){}
    public Invitation(String i,String iU,String iS,int et)throws Exception{
        try{
            this.id=i;
            this.idSender=iS;
            this.idUser=iU;
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
    public int getEtat(){return this.Etat;}
    @XmlElement
    public String getNomSender(){return this.nomSender;}
    @XmlElement
    public String getPrenomSender(){return this.prenomSender;}
    @XmlElement
    public String getNomUser(){return this.nomUser;}
    @XmlElement
    public String getPrenomUser(){return this.prenomUser;}
    
     public void setNomSender(String nm){this.nomSender=nm;}
    public void setPrenomSender(String pr){this.prenomSender=pr;}
    public void setNomUser(String nm){this.nomUser=nm;}
    public void setPrenomUser(String pr){this.prenomUser=pr;}
}
