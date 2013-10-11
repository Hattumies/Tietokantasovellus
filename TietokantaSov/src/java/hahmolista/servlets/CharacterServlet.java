/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hahmolista.servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import hahmolista.models.Character;
import hahmolista.models.Player;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ilmarihu
 */
public class CharacterServlet extends TemplateServlet {

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        if (!tarkistaKirjautuminen(request)) {
            response.sendRedirect("login.jsp");
        } else {

            ArrayList<Character> hahmot = new ArrayList();
            //Etsitään hahmoa
            if ("search".equals(request.getParameter("searchButton"))) {
                try {
                    hahmot.add(Character.hae(request.getParameter("charName")));
                } catch (Exception e) {
                    System.out.println("search: " + e.getMessage());
                }
            //Poistetaan hahmo tietokannasta
            } else if("delete".equals(request.getParameter("deleteButton")))  {
                try {
                Character hahmo = Character.hae(request.getParameter("charName"));
                Character.poistaHahmo(request.getParameter("charName"));
                hahmot.remove(hahmo);
                } catch(Exception e) {
                    System.out.println("delete: " + e.getMessage());
                }
                
                //Tulostetaan hahmot tietokannasta  
            } else {
                try {
                    hahmot = Character.haeKaikki();

                } catch (Exception e) {
                    System.out.println("hae kaikki: " + e.getMessage());
                }
            }
            request.setAttribute("hahmot", hahmot);
            RequestDispatcher dispatcher = request.getRequestDispatcher("character.jsp");
            dispatcher.forward(request, response);
        }
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
