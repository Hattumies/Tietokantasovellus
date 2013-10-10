/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hahmolista.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import hahmolista.models.Player;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author Ilmu
 */
public class NewPlayerServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String name, playerid, passwd;


        name = request.getParameter("player");
        playerid = request.getParameter("id");
        passwd = request.getParameter("passwd");

        if (!tarkistaVirheet(name, playerid, passwd, request)) {
            Player player = new Player(name, playerid, passwd);
            try {
                player.uusiPelaaja();
            } catch(Exception e) {
                   System.out.println("Uusi pelaaja: " + e.getMessage());
            }
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("newPlayer.jsp");
            dispatcher.forward(request, response);
        }

    }

    //Tarkistetaan onko kenttiin syötetty virheellistä tietoa.
    protected boolean tarkistaVirheet(String name, String id, String passwd, HttpServletRequest request) {
        boolean error = false;
        if (name.isEmpty() || name.length() > 30) {
            request.setAttribute("error1", "Player must have a name of 30 characters or less.");
            error = true;
        }
        if (id.isEmpty() || id.length() > 30) {
            request.setAttribute("error2", "Player must have an id that is at most 30 characters long");
            error = true;
        }
        if (passwd.isEmpty() || passwd.length() > 30) {
            request.setAttribute("error3", "Player must have a password that is at most 30 characters long");
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
