/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import infoEvent.Commentaire;
import infoEvent.CommentaireDB;
import infoEvent.Jaime;
import infoEvent.JaimeDB;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Sk
 */
@WebServlet(name = "likeEvent", urlPatterns = {"/likeEvent"})
public class likeEvent extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet likeEvent</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet likeEvent at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            HttpSession sessionUser = request.getSession();
            String idU = sessionUser.getAttribute("idUser").toString();
            JaimeDB jm = new JaimeDB();
            CommentaireDB com = new CommentaireDB();
            if(request.getParameter("idEventL") != null){
                Jaime j = new Jaime(idU,request.getParameter("idEventL"));
                jm.insertJaime(j);
                response.sendRedirect("listeEvent.jsp");
            }else if(request.getParameter("event") != null){
                response.sendRedirect("details.jsp?idEventC="+request.getParameter("idEventC")+"");
                if(idU != null && request.getParameter("idEventC") !=null && request.getParameter("coms") != null){
                    Commentaire c = new Commentaire(idU, request.getParameter("idEventC"), request.getParameter("coms"));
                    com.insertCommentaire(c);
                }               
                
            }else{
                response.sendRedirect("listeEvent.jsp");
            }
        }catch(Exception ex){
            response.sendRedirect("listeEvent.jsp?erreur="+ex.getMessage());
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
