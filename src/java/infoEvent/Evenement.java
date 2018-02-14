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
@XmlRootElement(name = "Evenement")
public class Evenement {
    private String id;
    private String nom;
    private String lieu;
    private String description;
    private String type;
   private int aime;
   private int comment;
    private String date;
    private String  dateCommence;
    private int heure;
    private int minute;
    private String dateFin;
    private String categorie;
    private String idOrg;
     public String Pays;
    private String Region;
    private String Ville;
    public Evenement(){}
    public Evenement(String i,String nm,String li,String iu,String desc,String tp,String pay,
    String reg,String vil,String date,String dateCom,int h,int m,String dateF,String cat,int lik,int cmt)throws Exception{
        try{
            this.id=i;
            this.nom=nm;
            this.lieu=li;
            this.description=desc;
            this.type=tp;
            this.idOrg=iu;
            this.Pays=pay;
            this.Region=reg;
            this.Ville=vil;
            this.date=date;
            this.dateCommence=dateCom;
            this.heure=h;
            this.minute=m;
            this.dateFin=dateF;
            this.categorie=cat;
          this.aime=lik;
            this.comment=cmt;
        }catch(Exception ex){
            throw ex;
        }
    }
    String[] HHH=null;
    public Evenement(String iu,String nm,String li,String desc,String tp,String pay,
    String reg,String vil,String dateCom,String heure,String dateF,String cat)throws Exception{
        try{ 
            HHH=heure.split(":");
            this.idOrg=iu;
            this.nom=nm;
            this.lieu=li;
            this.description=desc;
            this.type=tp;
            Date date =new Date();
            this.Pays=pay;
            this.Region=reg;
            this.Ville=vil;
            this.date=(date.getYear()+1900)+"-"+(date.getMonth()+1)+"-"+date.getDate();
            this.dateCommence=dateCom;
            this.heure=Integer.valueOf(HHH[0]);
            this.minute=Integer.valueOf(HHH[1]);
            this.dateFin=dateF;
            this.categorie=cat;
            
        }catch(Exception ex){
            throw ex;
        }
    }
    @XmlElement
    public String getId(){return this.id;}
    @XmlElement
    public String getNom(){return this.nom;}
    @XmlElement
    public String getLieu(){return this.lieu;}
    @XmlElement
    public String getDescription(){return this.description;}
    @XmlElement
    public String getType(){return this.type;}
    @XmlElement
    public String getDate(){return this.date;}
    @XmlElement
    public String getDateCommence(){return this.dateCommence;}
     @XmlElement
    public int getHeure(){return this.heure;}
     @XmlElement
    public int getMinute(){return this.minute;}
    @XmlElement
    public String getDateFin(){return this.dateFin;}
    @XmlElement
    public String getCategorie(){return this.categorie;}
    @XmlElement
    public String getIdOrganisateur(){return this.idOrg;}
    @XmlElement
    public String getPays(){return this.Pays;}
    @XmlElement
    public String getRegion(){return this.Region;}
    @XmlElement
    public String getVille(){return this.Ville;}
     @XmlElement
    public int getLike(){return this.aime;}
    @XmlElement
    public int getComment(){return this.comment;}
}
