/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hahmolista.servlets;

import hahmolista.models.Item;
import hahmolista.models.Player;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ilmu
 */
public class ItemServlet extends TemplateServlet {

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        if(!tarkistaKirjautuminen(request)) {
            response.sendRedirect("login");
        }
        
        ArrayList<Item> items = new ArrayList();
        
        //Etsitään esinettä
        if("search".equals(request.getParameter("searchButton"))) {
            try {
            items.add(hahmolista.models.Item.hae(request.getParameter("item")));
            } catch(Exception e) {
                System.out.println("search: " + e.getMessage());
            }
        //Tulostetaan esineet tietokannasta    
        } else {
        try {
            items = hahmolista.models.Item.haeKaikki();
        } catch(Exception e) {
            System.out.println("hae kaikki: " + e.getMessage());
        }
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("item.jsp");
        dispatcher.forward(request, response);
        
 
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
