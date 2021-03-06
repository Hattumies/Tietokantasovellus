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
import hahmolista.models.Player;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ilmu
 */
public class PlayerServlet extends TemplateServlet {

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        //Tarkastetaan onko käyttäjä kirjautunut palveluun
        if (!tarkistaKirjautuminen(request)) {
            response.sendRedirect("login.jsp");
        } else {
            ArrayList<Player> players = new ArrayList();
            //Etsitään pelaaja
            if ("search".equals(request.getParameter("searchButton"))) {
                try {
                    players.add(Player.haePelaaja(request.getParameter("playerName")));
                } catch (Exception e) {
                    System.out.println("hae pelaajaa: " + e.getMessage());
                }
                //Poistetaan pelaaja
            } else if ("delete".equals(request.getParameter("deleteButton"))) {
                try {
                    Player player = Player.haePelaaja(request.getParameter("playerName"));
                    Player.poistaPelaaja(request.getParameter("playerName"));
                    players.remove(player);
                } catch (Exception e) {
                    System.out.println("poista pelaaja: " + e.getMessage());
                }
                //Tulostetaan kaikki pelaajat
            } else {

                try {
                    players = Player.haeKaikkiPelaajat();
                } catch (Exception e) {
                    System.out.println("Hae kaikki: " + e.getMessage());
                }
            }

            request.setAttribute("players", players);
            RequestDispatcher dispatcher = request.getRequestDispatcher("player.jsp");
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
