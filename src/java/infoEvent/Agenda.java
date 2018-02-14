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
@XmlRootElement(name = "Agenda") 
public class Agenda {
    private String id;
    private String idUser;
    private String idEvent;
    private String Date;
    private int Heure;
    private int Minute;
    private String situation;
    private int etat;
    public Agenda(){}
    public Agenda(String iU,String iE,String dt,int h,int min,String sit)throws Exception{
        try{
            this.idUser=iU;
            this.idEvent=iE;
            this.Date=dt;
            this.Heure=h;
            this.Minute=min;
            this.situation=sit;
            this.etat=0;
        }catch(Exception ex){
            throw ex;
        }
    }
    public Agenda(String i,String iU,String iE,String dt,int heure,int minute,String sit)throws Exception{
        try{
            this.id=i;
            this.idUser=iU;
            this.idEvent=iE;
            this.Date=dt;
            this.Heure=heure;
            this.Minute=minute;
            this.situation=sit;
        }catch(Exception ex){
            throw ex;
        }
    }
    @XmlElement
    public String getId(){return this.id;}
    @XmlElement
    public String getIdUser(){return this.idUser;}
    @XmlElement
    public String getIdEvent(){return this.idEvent;}
    @XmlElement
    public String getDate(){return this.Date;}
    @XmlElement
    public int getHeure(){return this.Heure;}
    @XmlElement
    public int getMinute(){return this.Minute;}
    @XmlElement
    public String getSituation(){return this.situation;}
    
    public int getEtat(){return this.etat;}
}
