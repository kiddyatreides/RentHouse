/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.RentHouseModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Kid
 */
@WebServlet(name = "CekLogin", urlPatterns = {"/CekLogin"})
public class CekLogin extends HttpServlet {

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
             String username = request.getParameter("username");
            String password = request.getParameter("password");
            
            RentHouseModel a = new RentHouseModel();
            a.setUsername(username);
            a.setPassword(password);
            ArrayList data = a.validate();
             if (!data.isEmpty())
           {
                HttpSession session = request.getSession(true);
                session.setAttribute("idadmin", data.get(0).toString());
                session.setAttribute("nama", data.get(1).toString());
                session.setAttribute("username", username);
                session.setAttribute("token", "yausd7asBD&Ftbs&@B723e21b7b");
                RequestDispatcher dispatch = request.getRequestDispatcher("/LoginCek.jsp");
                dispatch.forward(request, response);
           }
             else{
                RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");
                request.setAttribute("return", "The username and password you entered did not match our records. Please double-check and try again.\n");
                rd.forward(request, response);
             }
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
