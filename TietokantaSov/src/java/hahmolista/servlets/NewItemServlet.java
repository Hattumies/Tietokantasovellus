/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hahmolista.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import hahmolista.models.Character;
import hahmolista.models.Item;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author ilmarihu
 */
public class NewItemServlet extends TemplateServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        if (!tarkistaKirjautuminen(request)) {
            response.sendRedirect("login.jsp");
        } else {
            String item, owner;
            
             item = request.getParameter("item");
             owner = request.getParameter("owner");
             
             if(!tarkistaVirheet(item,owner,request)) {
                 Item esine = new Item(item, owner);
                 try {
                     esine.uusiItem();
                     response.sendRedirect("item");
                 } catch(Exception e) {
                     System.out.println("Uusi esine: " + e.getMessage());
                 }
             } else {
                 RequestDispatcher dispatcher = request.getRequestDispatcher("newItem.jsp");
                 dispatcher.forward(request, response);
             }
             
        }
        
    }
    
    protected boolean tarkistaVirheet(String item, String owner, HttpServletRequest request) {
        boolean error = false;
        if(item.isEmpty() || item.length() > 30) {
             request.setAttribute("error1", "Item must have a name of 30 characters or less.");
                error = true;
        }
        if(owner.isEmpty() || owner.length() > 30 || Character.hae(owner) == null) {
             request.setAttribute("error2", "Item must have an owner that is a character that exists and has a name of 30 characters or less.");
                error = true;
        }
        return error;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
