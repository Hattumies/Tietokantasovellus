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

/**
 *
 * @author Ilmu
 */
public class NewCharacterServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
      String name,player,mental,physical,social,template;
      int advantage;
      boolean error = false;
      name = request.getParameter("name");
      player = request.getParameter("player");
      mental = request.getParameter("player");
      physical = request.getParameter("player");
      social = request.getParameter("player");
      template = request.getParameter("player");
      advantage = Integer.parseInt(request.getParameter("advantage"));
      if (name.isEmpty() || name.length() > 30) {
          request.setAttribute("error1", "Character must have a name of 30 characters or less.");
          error = true;
      } if (player.isEmpty() || player.length() > 30) {
           request.setAttribute("error2", "Player must have a name of 30 characters or less.");
          error = true;
      } if (mental.length() < 5 || mental.length() > 10 || physical.length() < 5 || physical.length() > 10 || social.length() < 5 || social .length() > 10) {
          request.setAttribute("error3", "All attritibutes must be atleast 5 characters long and 10 at most.");
          error = true;
      } if (template.length() > 10) {
          request.setAttribute("error4", "Template must be at most 10 characters long.");
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
