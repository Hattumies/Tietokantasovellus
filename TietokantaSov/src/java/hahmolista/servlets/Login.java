/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hahmolista.servlets;

import hahmolista.models.Player;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ilmarihu
 */
public class Login extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");

        String kayttajanimi = request.getParameter("username");
        String salasana = request.getParameter("password");
        try{
        if (Player.haePelaaja(kayttajanimi).getPasswd().equals(salasana)) {
            HttpSession session = request.getSession();
            session.setAttribute("kirjautunut", Player.haePelaaja(kayttajanimi));
            response.sendRedirect("character.jsp");
        } else {
            request.setAttribute("virhe", "Väärä käyttäjänimi tai salasana" + kayttajanimi + " " + salasana);
            dispatcher.forward(request, response);
        }
        } catch(Exception e) {
            System.out.println("kirjautuminen: " + e.getMessage());
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
