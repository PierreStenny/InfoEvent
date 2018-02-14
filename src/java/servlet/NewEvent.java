/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import infoEvent.Evenement;
import infoEvent.EvenementDB;
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
@WebServlet(name = "NewEvent", urlPatterns = {"/NewEvent"})
public class NewEvent extends HttpServlet {

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
            out.println("<title>Servlet NewEvent</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NewEvent at " + request.getContextPath() + "</h1>");
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
            EvenementDB ev = new EvenementDB();
            HttpSession sessionUser = request.getSession();
            String idU = sessionUser.getAttribute("idUser").toString();
            if(idU != null && request.getParameter("nomEvent") != null && request.getParameter("heure") != null && request.getParameter("lieuEvent") != null && request.getParameter("typeEvent") != null && request.getParameter("categEvent") != null && request.getParameter("debutEvent") != null && request.getParameter("finEvent") != null && request.getParameter("pays") != null && request.getParameter("region") != null && request.getParameter("ville") != null && request.getParameter("descEvent") != null){
                Evenement event = new Evenement(idU,request.getParameter("nomEvent"), request.getParameter("lieuEvent"), request.getParameter("descEvent"), request.getParameter("typeEvent"), request.getParameter("pays"),request.getParameter("region"),request.getParameter("ville"),request.getParameter("debutEvent"),request.getParameter("heure"),request.getParameter("finEvent"),request.getParameter("categEvent"));
                ev.insertEvenement(event);
            }
            
        }catch(Exception ex){
            response.sendRedirect("NewEvents.jsp?erreur="+ex.getMessage());
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
