/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.RentHouseModel;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Kid
 */
public class UpdateCustomer extends HttpServlet {

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
            out.println("<title>Servlet UpdateCustomer</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateCustomer at " + request.getContextPath() + "</h1>");
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
         RequestDispatcher dispatch = request.getRequestDispatcher("/UpdateCustomer.jsp");
            dispatch.forward(request, response);
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
         
            String idcustomer = request.getParameter("idcustomer");
            String nama = request.getParameter("nama");
            String birthdate = request.getParameter("birthdate");
            String address = request.getParameter("address");
            String phonenumber = request.getParameter("phonenumber");
            String cardtype = request.getParameter("cardtype");
            String cardnumber = request.getParameter("cardnumber");
            
            RentHouseModel obj = new RentHouseModel();
            obj.setIDCustomer(idcustomer);
            obj.setNama(nama);
            obj.setBirthdate(birthdate);
            obj.setAddress(address);
            obj.setPhoneNumber(phonenumber);
            obj.setCardType(cardtype);
            obj.setCardNumber(cardnumber);
            
            
            int res = obj.updateCustomer();
            
            if (res!=0) {
                //response.sendRedirect("BookAdd?message=Data has been saved");
                response.sendRedirect("ListCustomer");
            } else {
                response.sendRedirect("BookAdd?message=Input Failed");
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
