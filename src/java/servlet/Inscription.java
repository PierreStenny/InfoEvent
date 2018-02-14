/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import infoEvent.User;
import infoEvent.UserDB;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sk
 */
@WebServlet(name = "Inscription", urlPatterns = {"/Inscription"})
public class Inscription extends HttpServlet {

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
            out.println("<title>Servlet Inscription</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Inscription at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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
       try{
           UserDB us = new UserDB();
           if(request.getParameter("insEmail") != null && request.getParameter("insPass") != null && request.getParameter("insNom") != null && request.getParameter("insPrenom") != null && request.getParameter("insDate") != null && request.getParameter("insSexe") != null && request.getParameter("pays") != null && request.getParameter("region") != null && request.getParameter("ville") != null){
               User u = new User(request.getParameter("insEmail"),request.getParameter("insPass"),request.getParameter("insNom"),request.getParameter("insPrenom"),request.getParameter("insDate"),request.getParameter("insSexe"),request.getParameter("pays"),request.getParameter("region"),request.getParameter("ville"));
               us.insertUser(u);
               //PrintWriter  out = response.getWriter();
               //out.print(request.getParameter("insEmail"));
               response.sendRedirect("login.jsp");
           }
       }catch(Exception ex){
           response.sendRedirect("login.jsp?erreur="+ex.getMessage());
       }
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
