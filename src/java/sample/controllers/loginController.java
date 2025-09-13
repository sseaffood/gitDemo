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
import jakarta.servlet.http.HttpSession;
import sample.human.HumanDAO;
import sample.human.HumanDTO;

/**
 *
 * @author 84904
 */
public class loginController extends HttpServlet {
    private static final String ERROR = "login.jsp";
    private static final String SUCCESS = "user.jsp";
    private static final String LOGIN_INCORRECT = "Your user name or password is INCORRECT. Try again...";
    
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
        String url = ERROR;
        try {
            String uname = request.getParameter("uname");
            String psw = request.getParameter("psw");
            HttpSession session = request.getSession();
            Integer count = (Integer) session.getAttribute("COUNT");
            if(count == null){
                count=0;
            }
            HumanDTO dn = new HumanDAO().checkLogin(uname, psw);
            if(dn!=null){
                session.setAttribute("COUNT", 0);
                session.setAttribute("DN", dn);
                url=SUCCESS;
            }else{
                count++;
                session.setAttribute("COUNT", count);
                if(count>=5){
                    session.setMaxInactiveInterval(300);
                    request.setAttribute("ERROR", "The account is locked for 5 minutes");
                }else{
                    request.setAttribute("ERROR", LOGIN_INCORRECT+"( "+count+"/5 )");
                }
            }
        } catch (Exception e) {
            log("ERROR at loginController: "+ e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
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
