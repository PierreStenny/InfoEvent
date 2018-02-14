/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;
import infoEvent.*;
import java.io.File;
import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Androy
 */
@Path("/WebService")
public class WebService {
    /**
     * Retrieves representation of an instance of infoEvent.WebService
     * @return an instance of java.lang.String
     */
    @GET
     @Path("/listePays") 
         @Consumes({MediaType.TEXT_PLAIN,MediaType.APPLICATION_JSON,MediaType.TEXT_HTML,MediaType.APPLICATION_FORM_URLENCODED})
         @Produces(MediaType.APPLICATION_JSON)
    //@Produces({"text/plain","application/xml","application/json"})
    public Response getPays() {
         ArrayList pay=null;
         Pays[] liste=null;
      try{
          Outils outil=new Outils();
           pay=outil.findPays();
           liste=new Pays[pay.size()];
           for(int i=0;i<pay.size();i++){
               liste[i]=(Pays)pay.get(i);
           }
      }catch(Exception ex){
          
      }
       return Response
            .status(200)
            .header("Access-Control-Allow-Origin", "*")
            .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
            .header("Access-Control-Allow-Credentials", "true")
            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
            .header("Access-Control-Max-Age", "1209600")
            //.type("application/json")
             .entity(liste)
            .build();
    }
    @GET
     @Path("/listeType") 
         @Consumes({MediaType.TEXT_PLAIN,MediaType.APPLICATION_JSON,MediaType.TEXT_HTML,MediaType.APPLICATION_FORM_URLENCODED})
         @Produces(MediaType.APPLICATION_JSON)
    //@Produces({"text/plain","application/xml","application/json"})
    public Response getType() {
         ArrayList typ=null;
         Type[] liste=null;
      try{
          Outils outil=new Outils();
           typ=outil.findType();
           liste=new Type[typ.size()];
           for(int i=0;i<typ.size();i++){
               liste[i]=(Type)typ.get(i);
           }
      }catch(Exception ex){
          
      }
       return Response
            .status(200)
            .header("Access-Control-Allow-Origin", "*")
            .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
            .header("Access-Control-Allow-Credentials", "true")
            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
            .header("Access-Control-Max-Age", "1209600")
            //.type("application/json")
             .entity(liste)
            .build();
    }
    @GET
     @Path("/listeRegion/{idP}") 
         @Consumes({MediaType.TEXT_PLAIN,MediaType.APPLICATION_JSON,MediaType.TEXT_HTML,MediaType.APPLICATION_FORM_URLENCODED})
         @Produces(MediaType.APPLICATION_JSON)
    //@Produces({"text/plain","application/xml","application/json"})
    public Response getRegion(@PathParam("idP")String idP) {
         ArrayList reg=null;
         Region[] liste=null;
      try{
          Outils outil=new Outils();
           reg=outil.findRegion(idP);
           liste=new Region[reg.size()];
           for(int i=0;i<reg.size();i++){
               liste[i]=(Region)reg.get(i);
           }
      }catch(Exception ex){
          
      }
       return Response
            .status(200)
            .header("Access-Control-Allow-Origin", "*")
            .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
            .header("Access-Control-Allow-Credentials", "true")
            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
            .header("Access-Control-Max-Age", "1209600")
            //.type("application/json")
             .entity(liste)
            .build();
    }
    @GET
     @Path("/listeVille/{idP}/{idR}") 
         @Consumes({MediaType.TEXT_PLAIN,MediaType.APPLICATION_JSON,MediaType.TEXT_HTML,MediaType.APPLICATION_FORM_URLENCODED})
         @Produces(MediaType.APPLICATION_JSON)
    //@Produces({"text/plain","application/xml","application/json"})
    public Response getVille(@PathParam("idP")String idP,@PathParam("idR")String idR) {
         ArrayList vil=null;
         Ville[] liste=null;
      try{
          Outils outil=new Outils();
           vil=outil.findVille(idP,idR);
           liste=new Ville[vil.size()];
           for(int i=0;i<vil.size();i++){
               liste[i]=(Ville)vil.get(i);
           }
      }catch(Exception ex){
          
      }
       return Response
            .status(200)
            .header("Access-Control-Allow-Origin", "*")
            .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
            .header("Access-Control-Allow-Credentials", "true")
            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
            .header("Access-Control-Max-Age", "1209600")
            //.type("application/json")
             .entity(liste)
            .build();
    }
    @GET
     @Path("/inscription/{email}/{mdp}/{nom}/{prenom}/{sex}/{dateNais}/{iP}/{iR}/{iV}") 
         @Consumes({MediaType.TEXT_PLAIN,MediaType.APPLICATION_JSON,MediaType.TEXT_HTML,MediaType.APPLICATION_FORM_URLENCODED})
         @Produces(MediaType.APPLICATION_JSON)
    //@Produces({"text/plain","application/xml","application/json"})
    public Response insertUser(@PathParam("email")String email,@PathParam("mdp")String mdp,@PathParam("nom")String nom,@PathParam("prenom")String prenom,
            @PathParam("sex")String sex,@PathParam("dateNais")String dateNais,@PathParam("iP")String iP,@PathParam("iR")String iR,@PathParam("iV")String iV) {
           String res="0";
      try{
          UserDB userD=new UserDB();
          res= userD.insertUser(new User(email,mdp,nom,prenom,sex,dateNais,iP,iR,iV));
           
      }catch(Exception ex){
          return Response
            .status(200)
            .header("Access-Control-Allow-Origin", "*")
            .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
            .header("Access-Control-Allow-Credentials", "true")
            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
            .header("Access-Control-Max-Age", "1209600")
            //.type("application/json")
             .entity("0")
            .build();
      }
       return Response
            .status(200)
            .header("Access-Control-Allow-Origin", "*")
            .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
            .header("Access-Control-Allow-Credentials", "true")
            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
            .header("Access-Control-Max-Age", "1209600")
            //.type("application/json")
             .entity(res)
            .build();
    }
    @GET
     @Path("/login/{email}/{mdp}") 
         @Consumes({MediaType.TEXT_PLAIN,MediaType.APPLICATION_JSON,MediaType.TEXT_HTML,MediaType.APPLICATION_FORM_URLENCODED})
         @Produces(MediaType.TEXT_PLAIN)
    //@Produces({"text/plain","application/xml","application/json"})
    public Response login(@PathParam("email")String email,@PathParam("mdp")String mdp) {
          String result=null;
      try{
          UserDB userD=new UserDB();
          result=userD.login(email, mdp);
           
      }catch(Exception ex){
      }
       return Response
            .status(200)
            .header("Access-Control-Allow-Origin", "*")
            .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
            .header("Access-Control-Allow-Credentials", "true")
            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
            .header("Access-Control-Max-Age", "1209600")
            //.type("application/json")
             .entity(result)
            .build();
    }
    @GET
     @Path("/getUser/{idUse}") 
         @Consumes({MediaType.TEXT_PLAIN,MediaType.APPLICATION_JSON,MediaType.TEXT_HTML,MediaType.APPLICATION_FORM_URLENCODED})
         @Produces(MediaType.APPLICATION_JSON)
    //@Produces({"text/plain","application/xml","application/json"})
    public Response getUser(@PathParam("idUse")String idUse) {
          User result=null;
      try{
          UserDB userD=new UserDB();
          result=userD.getUser(idUse);
           
      }catch(Exception ex){
      }
       return Response
            .status(200)
            .header("Access-Control-Allow-Origin", "*")
            .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
            .header("Access-Control-Allow-Credentials", "true")
            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
            .header("Access-Control-Max-Age", "1209600")
            //.type("application/json")
             .entity(result)
            .build();
    }
    @GET
     @Path("/newEvent/{idUse}/{nom}/{lieu}/{type}/{categ}/{dateDeb}/{heure}/{dateFin}/{pays}/{reg}/{ville}/{desc}") 
         @Consumes({MediaType.TEXT_PLAIN,MediaType.APPLICATION_JSON,MediaType.TEXT_HTML,MediaType.APPLICATION_FORM_URLENCODED})
         @Produces(MediaType.APPLICATION_JSON)
    //@Produces({"text/plain","application/xml","application/json"})
    public Response newEvent(@PathParam("idUse")String idUse,@PathParam("nom")String nom,@PathParam("lieu")String lieu,@PathParam("type")String type,@PathParam("categ")String categ,
            @PathParam("dateDeb")String dateDeb,@PathParam("heure")String heure,@PathParam("dateFin")String dateFin,@PathParam("pays")String pays,@PathParam("reg")String reg,@PathParam("ville")String ville,@PathParam("desc")String desc) {
          User result=null;
      try{
          EvenementDB eveD=new EvenementDB();
          Evenement eve=new Evenement(idUse,nom,lieu,desc,type,pays,reg,ville,dateDeb,heure,dateFin,categ);
           eveD.insertEvenement(eve);
      }catch(Exception ex){
          return Response
            .status(200)
            .header("Access-Control-Allow-Origin", "*")
            .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
            .header("Access-Control-Allow-Credentials", "true")
            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
            .header("Access-Control-Max-Age", "1209600")
            //.type("application/json")
             .entity("Erreur")
            .build();
      }
       return Response
            .status(200)
            .header("Access-Control-Allow-Origin", "*")
            .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
            .header("Access-Control-Allow-Credentials", "true")
            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
            .header("Access-Control-Max-Age", "1209600")
            //.type("application/json")
             .entity("Ok")
            .build();
    }
    @GET
     @Path("/listeEvenement") 
         @Consumes({MediaType.TEXT_PLAIN,MediaType.APPLICATION_JSON,MediaType.TEXT_HTML,MediaType.APPLICATION_FORM_URLENCODED})
         @Produces(MediaType.APPLICATION_JSON)
    //@Produces({"text/plain","application/xml","application/json"})
    public Response getEvenement() {
         ArrayList eve=null;
         Evenement[] liste=null;
      try{
         EvenementDB eventD=new EvenementDB();
          eve=eventD.findEvent();
           liste=new Evenement[eve.size()];
           for(int i=0;i<eve.size();i++){
               liste[i]=(Evenement)eve.get(i);
           }
      }catch(Exception ex){
          
      }
       return Response
            .status(200)
            .header("Access-Control-Allow-Origin", "*")
            .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
            .header("Access-Control-Allow-Credentials", "true")
            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
            .header("Access-Control-Max-Age", "1209600")
            //.type("application/json")
             .entity(liste)
            .build();
    }
    @GET
     @Path("/MesEvenement/{idUser}") 
         @Consumes({MediaType.TEXT_PLAIN,MediaType.APPLICATION_JSON,MediaType.TEXT_HTML,MediaType.APPLICATION_FORM_URLENCODED})
         @Produces(MediaType.APPLICATION_JSON)
    //@Produces({"text/plain","application/xml","application/json"})
    public Response MesEvenement(@PathParam("idUser")String idUser) {
         ArrayList eve=null;
         Evenement[] liste=null;
      try{
         EvenementDB eventD=new EvenementDB();
          eve=eventD.findMyEvent(idUser);
           liste=new Evenement[eve.size()];
           for(int i=0;i<eve.size();i++){
               liste[i]=(Evenement)eve.get(i);
           }
      }catch(Exception ex){
          
      }
       return Response
            .status(200)
            .header("Access-Control-Allow-Origin", "*")
            .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
            .header("Access-Control-Allow-Credentials", "true")
            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
            .header("Access-Control-Max-Age", "1209600")
            //.type("application/json")
             .entity(liste)
            .build();
    }
    @GET
     @Path("/infoEvenement/{idEvent}") 
         @Consumes({MediaType.TEXT_PLAIN,MediaType.APPLICATION_JSON,MediaType.TEXT_HTML,MediaType.APPLICATION_FORM_URLENCODED})
         @Produces(MediaType.APPLICATION_JSON)
    //@Produces({"text/plain","application/xml","application/json"})
    public Response getEvenement(@PathParam("idEvent")String idEvent) {
         Evenement eve=null;
      try{
         EvenementDB eventD=new EvenementDB();
          eve=eventD.findEvent(idEvent);
           
      }catch(Exception ex){
          
      }
       return Response
            .status(200)
            .header("Access-Control-Allow-Origin", "*")
            .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
            .header("Access-Control-Allow-Credentials", "true")
            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
            .header("Access-Control-Max-Age", "1209600")
            //.type("application/json")
             .entity(eve)
            .build();
    }
    @GET
     @Path("/getSuggestion/{nomreg}/{nomville}/{idUse}") 
         @Consumes({MediaType.TEXT_PLAIN,MediaType.APPLICATION_JSON,MediaType.TEXT_HTML,MediaType.APPLICATION_FORM_URLENCODED})
         @Produces(MediaType.APPLICATION_JSON)
    //@Produces({"text/plain","application/xml","application/json"})
    public Response getSuggestion(@PathParam("nomreg")String nomreg,@PathParam("nomville")String nomville,@PathParam("idUse")String idUse) {
          User[] result=null;
      try{
          UserDB userD=new UserDB();
          ArrayList get=userD.getUser(nomreg,nomville,idUse);
           result=new User[get.size()];
           for(int i=0;i<get.size();i++){
               result[i]=(User)get.get(i);
           }
      }catch(Exception ex){
      }
       return Response
            .status(200)
            .header("Access-Control-Allow-Origin", "*")
            .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
            .header("Access-Control-Allow-Credentials", "true")
            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
            .header("Access-Control-Max-Age", "1209600")
            //.type("application/json")
             .entity(result)
            .build();
    }
    
    @GET
     @Path("/AjouterAmis/{idUser1}/{idUser2}/{etat}") 
         @Consumes({MediaType.TEXT_PLAIN,MediaType.APPLICATION_JSON,MediaType.TEXT_HTML,MediaType.APPLICATION_FORM_URLENCODED})
         @Produces(MediaType.APPLICATION_JSON)
    //@Produces({"text/plain","application/xml","application/json"})
    public Response AjouterAmis(@PathParam("idUser1")String idUser1,@PathParam("idUser2")String idUser2,@PathParam("etat")int etat) {
          String result=null;
      try{
          UserDB userD=new UserDB();
          
           result=userD.AjouterAmis(idUser1,idUser2,etat);
      }catch(Exception ex){
      }
       return Response
            .status(200)
            .header("Access-Control-Allow-Origin", "*")
            .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
            .header("Access-Control-Allow-Credentials", "true")
            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
            .header("Access-Control-Max-Age", "1209600")
            //.type("application/json")
             .entity(result)
            .build();
    }
    @GET
     @Path("/getAmis/{idUser}") 
         @Consumes({MediaType.TEXT_PLAIN,MediaType.APPLICATION_JSON,MediaType.TEXT_HTML,MediaType.APPLICATION_FORM_URLENCODED})
         @Produces(MediaType.APPLICATION_JSON)
    //@Produces({"text/plain","application/xml","application/json"})
    public Response getAmis(@PathParam("idUser")String idUser) {
          User[] result=null;
      try{
          UserDB userD=new UserDB();
          
           ArrayList liste=userD.getAmis(idUser);
           result=new User[liste.size()];
           for(int i=0;i<liste.size();i++){
               result[i]=(User)liste.get(i);
           }
      }catch(Exception ex){
      }
       return Response
            .status(200)
            .header("Access-Control-Allow-Origin", "*")
            .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
            .header("Access-Control-Allow-Credentials", "true")
            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
            .header("Access-Control-Max-Age", "1209600")
            //.type("application/json")
             .entity(result)
            .build();
    }
    @GET
     @Path("/suggestMembre/{idUser}/{idGroupe}") 
         @Consumes({MediaType.TEXT_PLAIN,MediaType.APPLICATION_JSON,MediaType.TEXT_HTML,MediaType.APPLICATION_FORM_URLENCODED})
         @Produces(MediaType.APPLICATION_JSON)
    //@Produces({"text/plain","application/xml","application/json"})
    public Response suggestMembre(@PathParam("idUser")String idUser,@PathParam("idGroupe")String idGroupe) {
          User[] result=null;
      try{
          UserDB userD=new UserDB();
          
           ArrayList liste=userD.suggestMembre(idUser,idGroupe);
           result=new User[liste.size()];
           for(int i=0;i<liste.size();i++){
               result[i]=(User)liste.get(i);
           }
      }catch(Exception ex){
      }
       return Response
            .status(200)
            .header("Access-Control-Allow-Origin", "*")
            .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
            .header("Access-Control-Allow-Credentials", "true")
            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
            .header("Access-Control-Max-Age", "1209600")
            //.type("application/json")
             .entity(result)
            .build();
    }
    @GET
     @Path("/AjouterMembre/{idUser}/{idGroupe}") 
         @Consumes({MediaType.TEXT_PLAIN,MediaType.APPLICATION_JSON,MediaType.TEXT_HTML,MediaType.APPLICATION_FORM_URLENCODED})
         @Produces(MediaType.APPLICATION_JSON)
    //@Produces({"text/plain","application/xml","application/json"})
    public Response AjouterMembre(@PathParam("idUser")String idUser,@PathParam("idGroupe")String idGroupe) {
          String result=null;
      try{
          GroupeDB grpD=new GroupeDB();
          
          
           result=grpD.AjouterMembre(idUser, idGroupe);
      }catch(Exception ex){
      }
       return Response
            .status(200)
            .header("Access-Control-Allow-Origin", "*")
            .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
            .header("Access-Control-Allow-Credentials", "true")
            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
            .header("Access-Control-Max-Age", "1209600")
            //.type("application/json")
             .entity(result)
            .build();
    }
    @GET
     @Path("/invitationEvent/{idUser}/{idSender}/{idEvent}") 
         @Consumes({MediaType.TEXT_PLAIN,MediaType.APPLICATION_JSON,MediaType.TEXT_HTML,MediaType.APPLICATION_FORM_URLENCODED})
         @Produces(MediaType.APPLICATION_JSON)
    //@Produces({"text/plain","application/xml","application/json"})
    public Response invitationEvent(@PathParam("idUser")String idUser,@PathParam("idSender")String idSender,@PathParam("idEvent")String idEvent) {
      try{
          invitationEventDB invitD=new invitationEventDB();
          invitationEvent invite=new invitationEvent("",idUser,idSender,"",idEvent,0);
          invitD.invitationEventDB(invite);
      }catch(Exception ex){
      }
       return Response
            .status(200)
            .header("Access-Control-Allow-Origin", "*")
            .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
            .header("Access-Control-Allow-Credentials", "true")
            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
            .header("Access-Control-Max-Age", "1209600")
            //.type("application/json")
             .entity("ok")
            .build();
    }
    @GET
     @Path("/getInvitationEvent/{idUser}") 
         @Consumes({MediaType.TEXT_PLAIN,MediaType.APPLICATION_JSON,MediaType.TEXT_HTML,MediaType.APPLICATION_FORM_URLENCODED})
         @Produces(MediaType.APPLICATION_JSON)
    //@Produces({"text/plain","application/xml","application/json"})
    public Response getInvitationEvent(@PathParam("idUser")String idUser) {
      invitationEvent[] result=null;
        try{
          invitationEventDB invitD=new invitationEventDB();
          ArrayList invite=invitD.getInvitationEvent(idUser);
          result=new invitationEvent[invite.size()];
          for(int i=0;i<invite.size();i++){
              result[i]=(invitationEvent)invite.get(i);
          }
      }catch(Exception ex){
      }
       return Response
            .status(200)
            .header("Access-Control-Allow-Origin", "*")
            .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
            .header("Access-Control-Allow-Credentials", "true")
            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
            .header("Access-Control-Max-Age", "1209600")
            //.type("application/json")
             .entity(result)
            .build();
    }
    @GET
     @Path("/getMyInvitationEvent/{idEvent}") 
         @Consumes({MediaType.TEXT_PLAIN,MediaType.APPLICATION_JSON,MediaType.TEXT_HTML,MediaType.APPLICATION_FORM_URLENCODED})
         @Produces(MediaType.APPLICATION_JSON)
    //@Produces({"text/plain","application/xml","application/json"})
    public Response getMyInvitationEvent(@PathParam("idEvent")String idEvent) {
      invitationEvent[] result=null;
        try{
          invitationEventDB invitD=new invitationEventDB();
          ArrayList invite=invitD.getMyInvitationEvent(idEvent);
          result=new invitationEvent[invite.size()];
          for(int i=0;i<invite.size();i++){
              result[i]=(invitationEvent)invite.get(i);
          }
      }catch(Exception ex){
      }
       return Response
            .status(200)
            .header("Access-Control-Allow-Origin", "*")
            .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
            .header("Access-Control-Allow-Credentials", "true")
            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
            .header("Access-Control-Max-Age", "1209600")
            //.type("application/json")
             .entity(result)
            .build();
    }
    @GET
     @Path("/AcceptInvitation/{idUser}/{idEvent}/{etat}") 
         @Consumes({MediaType.TEXT_PLAIN,MediaType.APPLICATION_JSON,MediaType.TEXT_HTML,MediaType.APPLICATION_FORM_URLENCODED})
         @Produces(MediaType.APPLICATION_JSON)
    //@Produces({"text/plain","application/xml","application/json"})
    public Response getInvitationEvent(@PathParam("idUser")String idUser,@PathParam("idEvent")String idEvent,@PathParam("etat")int etat) {
      String result=null;
        try{
          invitationEventDB invitD=new invitationEventDB();
          result=invitD.AcceptInvitation(idUser,idEvent,etat);
      }catch(Exception ex){
      }
       return Response
            .status(200)
            .header("Access-Control-Allow-Origin", "*")
            .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
            .header("Access-Control-Allow-Credentials", "true")
            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
            .header("Access-Control-Max-Age", "1209600")
            //.type("application/json")
             .entity(result)
            .build();
    }
    @GET
     @Path("/getAgenda/{idUser}") 
         @Consumes({MediaType.TEXT_PLAIN,MediaType.APPLICATION_JSON,MediaType.TEXT_HTML,MediaType.APPLICATION_FORM_URLENCODED})
         @Produces(MediaType.APPLICATION_JSON)
    //@Produces({"text/plain","application/xml","application/json"})
    public Response getAgenda(@PathParam("idUser")String idUser) {
      Agenda[] result=null;
        try{
          AgendaDB ageD=new AgendaDB();
          ArrayList age=ageD.findAgenda(idUser);
          result=new Agenda[age.size()];
          for(int i=0;i<age.size();i++){
              result[i]=(Agenda)age.get(i) ;
          }
      }catch(Exception ex){
      }
       return Response
            .status(200)
            .header("Access-Control-Allow-Origin", "*")
            .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
            .header("Access-Control-Allow-Credentials", "true")
            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
            .header("Access-Control-Max-Age", "1209600")
            //.type("application/json")
             .entity(result)
            .build();
    }
    @GET
     @Path("/FinirAgenda/{id}") 
         @Consumes({MediaType.TEXT_PLAIN,MediaType.APPLICATION_JSON,MediaType.TEXT_HTML,MediaType.APPLICATION_FORM_URLENCODED})
         @Produces(MediaType.APPLICATION_JSON)
    //@Produces({"text/plain","application/xml","application/json"})
    public Response FinirAgenda(@PathParam("id")String id) {
      String result="fin";
        try{
          AgendaDB ageD=new AgendaDB();
          result=ageD.FinirAgenda(id);
        
      }catch(Exception ex){
      }
       return Response
            .status(200)
            .header("Access-Control-Allow-Origin", "*")
            .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
            .header("Access-Control-Allow-Credentials", "true")
            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
            .header("Access-Control-Max-Age", "1209600")
            //.type("application/json")
             .entity(result)
            .build();
    }
    @GET
     @Path("/Commentaire/{idUser}/{idEvent}/{texte}") 
         @Consumes({MediaType.TEXT_PLAIN,MediaType.APPLICATION_JSON,MediaType.TEXT_HTML,MediaType.APPLICATION_FORM_URLENCODED})
         @Produces(MediaType.APPLICATION_JSON)
    //@Produces({"text/plain","application/xml","application/json"})
    public Response Commentaire(@PathParam("idUser")String idUser,@PathParam("idEvent")String idEvent,@PathParam("texte")String texte) {
          String result="ok";
      try{
          CommentaireDB comD=new CommentaireDB();
          Commentaire com=new Commentaire(idUser,idEvent,texte);
          comD.insertCommentaire(com);
      }catch(Exception ex){
      }
       return Response
            .status(200)
            .header("Access-Control-Allow-Origin", "*")
            .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
            .header("Access-Control-Allow-Credentials", "true")
            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
            .header("Access-Control-Max-Age", "1209600")
            //.type("application/json")
             .entity(result)
            .build();
    }
    @GET
     @Path("/getCommentaire/{idEvent}") 
         @Consumes({MediaType.TEXT_PLAIN,MediaType.APPLICATION_JSON,MediaType.TEXT_HTML,MediaType.APPLICATION_FORM_URLENCODED})
         @Produces(MediaType.APPLICATION_JSON)
    //@Produces({"text/plain","application/xml","application/json"})
    public Response getCommentaire(@PathParam("idEvent")String idEvent) {
          Commentaire[] result=null;
      try{
          CommentaireDB comD=new CommentaireDB();
          ArrayList com=comD.findCommentaire(idEvent);
          result=new Commentaire[com.size()];
          for(int i=0;i<com.size();i++){
              result[i]=(Commentaire)com.get(i);
          }
      }catch(Exception ex){
      }
       return Response
            .status(200)
            .header("Access-Control-Allow-Origin", "*")
            .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
            .header("Access-Control-Allow-Credentials", "true")
            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
            .header("Access-Control-Max-Age", "1209600")
            //.type("application/json")
             .entity(result)
            .build();
    }
    @GET
     @Path("/Jaime/{idUser}/{idEvent}") 
         @Consumes({MediaType.TEXT_PLAIN,MediaType.APPLICATION_JSON,MediaType.TEXT_HTML,MediaType.APPLICATION_FORM_URLENCODED})
         @Produces(MediaType.APPLICATION_JSON)
    //@Produces({"text/plain","application/xml","application/json"})
    public Response Jaime(@PathParam("idUser")String idUser,@PathParam("idEvent")String idEvent) {
          String result="ok";
      try{
          JaimeDB jaimD=new JaimeDB();
          Jaime jaim=new Jaime(idUser,idEvent);
          jaimD.insertJaime(jaim);
      }catch(Exception ex){
      }
       return Response
            .status(200)
            .header("Access-Control-Allow-Origin", "*")
            .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
            .header("Access-Control-Allow-Credentials", "true")
            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
            .header("Access-Control-Max-Age", "1209600")
            //.type("application/json")
             .entity(result)
            .build();
    }
  
    @GET
     @Path("/getCommentUser/{idEvent}") 
         @Consumes({MediaType.TEXT_PLAIN,MediaType.APPLICATION_JSON,MediaType.TEXT_HTML,MediaType.APPLICATION_FORM_URLENCODED})
         @Produces(MediaType.APPLICATION_JSON)
    //@Produces({"text/plain","application/xml","application/json"})
    public Response getCommentUser(@PathParam("idEvent")String idEvent) {
          User[] result=null;
      try{
          UserDB userD=new UserDB();
          ArrayList use=userD.getCommenteur(idEvent);
          result=new User[use.size()];
          for(int i=0;i<use.size();i++){
              result[i]=(User)use.get(i);
          }
           
      }catch(Exception ex){
      }
       return Response
            .status(200)
            .header("Access-Control-Allow-Origin", "*")
            .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
            .header("Access-Control-Allow-Credentials", "true")
            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
            .header("Access-Control-Max-Age", "1209600")
            //.type("application/json")
             .entity(result)
            .build();
    }
    @GET
     @Path("/getJaimeUser/{idEvent}") 
         @Consumes({MediaType.TEXT_PLAIN,MediaType.APPLICATION_JSON,MediaType.TEXT_HTML,MediaType.APPLICATION_FORM_URLENCODED})
         @Produces(MediaType.APPLICATION_JSON)
    //@Produces({"text/plain","application/xml","application/json"})
    public Response getJaimeUser(@PathParam("idEvent")String idEvent) {
          User[] result=null;
      try{
          UserDB userD=new UserDB();
          ArrayList use=userD.getLiker(idEvent);
          result=new User[use.size()];
          for(int i=0;i<use.size();i++){
              result[i]=(User)use.get(i);
          }
           
      }catch(Exception ex){
      }
       return Response
            .status(200)
            .header("Access-Control-Allow-Origin", "*")
            .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
            .header("Access-Control-Allow-Credentials", "true")
            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
            .header("Access-Control-Max-Age", "1209600")
            //.type("application/json")
             .entity(result)
            .build();
    }
    @GET
     @Path("/invitationPart/{idUser}/{idSender}/{idEvent}") 
         @Consumes({MediaType.TEXT_PLAIN,MediaType.APPLICATION_JSON,MediaType.TEXT_HTML,MediaType.APPLICATION_FORM_URLENCODED})
         @Produces(MediaType.APPLICATION_JSON)
    //@Produces({"text/plain","application/xml","application/json"})
    public Response invitationPart(@PathParam("idUser")String idUser,@PathParam("idSender")String idSender,@PathParam("idEvent")String idEvent) {
      try{
          invitationPartDB invitD=new invitationPartDB();
          invitationPart invite=new invitationPart("",idUser,idSender,"",idEvent,0);
          invitD.invitationPart(invite);
      }catch(Exception ex){
      }
       return Response
            .status(200)
            .header("Access-Control-Allow-Origin", "*")
            .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
            .header("Access-Control-Allow-Credentials", "true")
            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
            .header("Access-Control-Max-Age", "1209600")
            //.type("application/json")
             .entity("ok")
            .build();
    }
    @GET
     @Path("/getInvitationPart/{idUser}") 
         @Consumes({MediaType.TEXT_PLAIN,MediaType.APPLICATION_JSON,MediaType.TEXT_HTML,MediaType.APPLICATION_FORM_URLENCODED})
         @Produces(MediaType.APPLICATION_JSON)
    //@Produces({"text/plain","application/xml","application/json"})
    public Response getInvitationPart(@PathParam("idUser")String idUser) {
      invitationPart[] result=null;
        try{
          invitationPartDB invitD=new invitationPartDB();
          ArrayList invite=invitD.getInvitationPart(idUser);
          result=new invitationPart[invite.size()];
          for(int i=0;i<invite.size();i++){
              result[i]=(invitationPart)invite.get(i);
          }
      }catch(Exception ex){
      }
       return Response
            .status(200)
            .header("Access-Control-Allow-Origin", "*")
            .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
            .header("Access-Control-Allow-Credentials", "true")
            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
            .header("Access-Control-Max-Age", "1209600")
            //.type("application/json")
             .entity(result)
            .build();
    }
    @GET
     @Path("/getMyInvitationPart/{idEvent}") 
         @Consumes({MediaType.TEXT_PLAIN,MediaType.APPLICATION_JSON,MediaType.TEXT_HTML,MediaType.APPLICATION_FORM_URLENCODED})
         @Produces(MediaType.APPLICATION_JSON)
    //@Produces({"text/plain","application/xml","application/json"})
    public Response getMyInvitationPart(@PathParam("idEvent")String idEvent) {
      invitationPart[] result=null;
        try{
          invitationPartDB invitD=new invitationPartDB();
          ArrayList invite=invitD.getMyInvitationPart(idEvent);
          result=new invitationPart[invite.size()];
          for(int i=0;i<invite.size();i++){
              result[i]=(invitationPart)invite.get(i);
          }
      }catch(Exception ex){
      }
       return Response
            .status(200)
            .header("Access-Control-Allow-Origin", "*")
            .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
            .header("Access-Control-Allow-Credentials", "true")
            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
            .header("Access-Control-Max-Age", "1209600")
            //.type("application/json")
             .entity(result)
            .build();
    }
    @GET
     @Path("/AcceptInvitationPart/{idUser}/{idEvent}/{etat}") 
         @Consumes({MediaType.TEXT_PLAIN,MediaType.APPLICATION_JSON,MediaType.TEXT_HTML,MediaType.APPLICATION_FORM_URLENCODED})
         @Produces(MediaType.APPLICATION_JSON)
    //@Produces({"text/plain","application/xml","application/json"})
    public Response getInvitationPart(@PathParam("idUser")String idUser,@PathParam("idEvent")String idEvent,@PathParam("etat")int etat) {
      String result=null;
        try{
          invitationPartDB invitD=new invitationPartDB();
          result=invitD.AcceptInvitation(idUser,idEvent,etat);
      }catch(Exception ex){
      }
       return Response
            .status(200)
            .header("Access-Control-Allow-Origin", "*")
            .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
            .header("Access-Control-Allow-Credentials", "true")
            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
            .header("Access-Control-Max-Age", "1209600")
            //.type("application/json")
             .entity(result)
            .build();
    }
    @GET
     @Path("/newGroupe/{idUse}/{nom}/{type}/{pays}/{reg}/{ville}/{desc}") 
         @Consumes({MediaType.TEXT_PLAIN,MediaType.APPLICATION_JSON,MediaType.TEXT_HTML,MediaType.APPLICATION_FORM_URLENCODED})
         @Produces(MediaType.APPLICATION_JSON)
    //@Produces({"text/plain","application/xml","application/json"})
    public Response newGroupe(@PathParam("idUse")String idUse,@PathParam("nom")String nom,@PathParam("type")String type,@PathParam("pays")String pays,@PathParam("reg")String reg,@PathParam("ville")String ville,@PathParam("desc")String desc) {
          
      try{
          GroupeDB eveD=new GroupeDB();
          Groupe eve=new Groupe(idUse,nom,desc,type,pays,reg,ville);
           eveD.insertGroupe(eve);
      }catch(Exception ex){
          return Response
            .status(200)
            .header("Access-Control-Allow-Origin", "*")
            .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
            .header("Access-Control-Allow-Credentials", "true")
            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
            .header("Access-Control-Max-Age", "1209600")
            //.type("application/json")
             .entity("Erreur")
            .build();
      }
       return Response
            .status(200)
            .header("Access-Control-Allow-Origin", "*")
            .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
            .header("Access-Control-Allow-Credentials", "true")
            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
            .header("Access-Control-Max-Age", "1209600")
            //.type("application/json")
             .entity("Ok")
            .build();
    }
    @GET
     @Path("/getMyGroupe/{idUser}") 
         @Consumes({MediaType.TEXT_PLAIN,MediaType.APPLICATION_JSON,MediaType.TEXT_HTML,MediaType.APPLICATION_FORM_URLENCODED})
         @Produces(MediaType.APPLICATION_JSON)
    //@Produces({"text/plain","application/xml","application/json"})
    public Response getMyGroupe(@PathParam("idUser")String idUser) {
            Groupe[] result=null;
        try{
            GroupeDB groupD=new GroupeDB();
          ArrayList group=groupD.findGroupe(idUser);
          result=new Groupe[group.size()];
          for(int i=0;i<group.size();i++){
              result[i]=(Groupe)group.get(i);
          }
      }catch(Exception ex){
      }
       return Response
            .status(200)
            .header("Access-Control-Allow-Origin", "*")
            .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
            .header("Access-Control-Allow-Credentials", "true")
            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
            .header("Access-Control-Max-Age", "1209600")
            //.type("application/json")
             .entity(result)
            .build();
    }
    @GET
     @Path("/suggestGroupe/{pay}/{reg}/{vil}/{idUser}") 
         @Consumes({MediaType.TEXT_PLAIN,MediaType.APPLICATION_JSON,MediaType.TEXT_HTML,MediaType.APPLICATION_FORM_URLENCODED})
         @Produces(MediaType.APPLICATION_JSON)
    //@Produces({"text/plain","application/xml","application/json"})
    public Response getMyGroupe(@PathParam("pay")String pay,@PathParam("reg")String reg,@PathParam("vil")String vil,@PathParam("idUser")String idUser) {
            Groupe[] result=null;
        try{
            GroupeDB groupD=new GroupeDB();
          ArrayList group=groupD.findGroupe(pay,reg,vil,idUser);
          result=new Groupe[group.size()];
          for(int i=0;i<group.size();i++){
              result[i]=(Groupe)group.get(i);
          }
      }catch(Exception ex){
      }
       return Response
            .status(200)
            .header("Access-Control-Allow-Origin", "*")
            .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
            .header("Access-Control-Allow-Credentials", "true")
            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
            .header("Access-Control-Max-Age", "1209600")
            //.type("application/json")
             .entity(result)
            .build();
    }
    @GET
     @Path("/getInfoGroupe/{idGroupe}") 
         @Consumes({MediaType.TEXT_PLAIN,MediaType.APPLICATION_JSON,MediaType.TEXT_HTML,MediaType.APPLICATION_FORM_URLENCODED})
         @Produces(MediaType.APPLICATION_JSON)
    //@Produces({"text/plain","application/xml","application/json"})
    public Response getInfoGroupe(@PathParam("idGroupe")String idGroupe) {
            Groupe result=null;
        try{
            GroupeDB groupD=new GroupeDB();
          result=groupD.InfoGroupe(idGroupe);
      }catch(Exception ex){
      }
       return Response
            .status(200)
            .header("Access-Control-Allow-Origin", "*")
            .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
            .header("Access-Control-Allow-Credentials", "true")
            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
            .header("Access-Control-Max-Age", "1209600")
            //.type("application/json")
             .entity(result)
            .build();
    }
    @GET
     @Path("/demande/{idUser}/{idSender}") 
         @Consumes({MediaType.TEXT_PLAIN,MediaType.APPLICATION_JSON,MediaType.TEXT_HTML,MediaType.APPLICATION_FORM_URLENCODED})
         @Produces(MediaType.APPLICATION_JSON)
    //@Produces({"text/plain","application/xml","application/json"})
    public Response demande(@PathParam("idUser")String idUser,@PathParam("idSender")String idSender) {
      try{
          InvitationDB invitD=new InvitationDB();
          Invitation invite=new Invitation("",idUser,idSender,0);
          invitD.invitation(invite);
      }catch(Exception ex){
      }
       return Response
            .status(200)
            .header("Access-Control-Allow-Origin", "*")
            .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
            .header("Access-Control-Allow-Credentials", "true")
            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
            .header("Access-Control-Max-Age", "1209600")
            //.type("application/json")
             .entity("ok")
            .build();
    }
    @GET
     @Path("/getDemande/{idUser}") 
         @Consumes({MediaType.TEXT_PLAIN,MediaType.APPLICATION_JSON,MediaType.TEXT_HTML,MediaType.APPLICATION_FORM_URLENCODED})
         @Produces(MediaType.APPLICATION_JSON)
    //@Produces({"text/plain","application/xml","application/json"})
    public Response getDemande(@PathParam("idUser")String idUser) {
      Invitation[] result=null;
        try{
          InvitationDB invitD=new InvitationDB();
          ArrayList invite=invitD.getInvitation(idUser);
          result=new Invitation[invite.size()];
          for(int i=0;i<invite.size();i++){
              result[i]=(Invitation)invite.get(i);
          }
      }catch(Exception ex){
      }
       return Response
            .status(200)
            .header("Access-Control-Allow-Origin", "*")
            .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
            .header("Access-Control-Allow-Credentials", "true")
            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
            .header("Access-Control-Max-Age", "1209600")
            //.type("application/json")
             .entity(result)
            .build();
    }
    @GET
     @Path("/Upload/{file}/{idUser}") 
         @Consumes({MediaType.TEXT_PLAIN,MediaType.APPLICATION_JSON,MediaType.TEXT_HTML,MediaType.APPLICATION_FORM_URLENCODED})
         @Produces(MediaType.APPLICATION_JSON)
    //@Produces({"text/plain","application/xml","application/json"})
    public Response Upload(@PathParam("file")String file,@PathParam("idUser")String idUser) {
      String result="ok";
        try{
            Outils outil=new Outils();
           // result=outil.upload(file,idUser);
      }catch(Exception ex){
      }
       return Response
            .status(200)
            .header("Access-Control-Allow-Origin", "*")
            .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
            .header("Access-Control-Allow-Credentials", "true")
            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
            .header("Access-Control-Max-Age", "1209600")
            //.type("application/json")
             .entity(result)
            .build();
    }
    
}
