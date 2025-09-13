/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package sample.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Date;
import sample.human.HumanDAO;
import sample.human.HumanDTO;

/**
 *
 * @author 84904
 */
public class updateHumanController extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            String humanId = request.getParameter("humanId");
            String humanName = request.getParameter("humanName");
            String dobstr = request.getParameter("dob");
            Date dob = Date.valueOf(dobstr);
            boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
            int typeId = Integer.parseInt(request.getParameter("typeId"));
            String userHuman = request.getParameter("uname");
            String passHuman = request.getParameter("psw");
            String role = request.getParameter("role");
            
            HumanDTO human = new HumanDTO(humanId, humanName, dob, gender, typeId, userHuman, passHuman, role);
            HumanDAO dao = new HumanDAO();
            boolean check = dao.update(human);
            if(check){
                request.setAttribute("SUCCESS", "Update successfully");
            }else{
                request.setAttribute("ERROR_UPDATE", "Type ID is not exist!");
            }
        } catch (Exception e) {
            log("ERROR at updateHumanController:"+e.toString());
        } finally {
            request.getRequestDispatcher("searchHumanController").forward(request, response);
    } 
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
