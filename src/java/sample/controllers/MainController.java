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

/**
 *
 * @author 84904
 */
public class MainController extends HttpServlet {
    private static final String WELCOME ="login.jsp";
    private static final String LOGIN ="login";
    private static final String LOGIN_CONTROLLER ="loginController";
    private static final String LOGOUT ="logout";
    private static final String LOGOUT_CONTROLLER ="logoutController";
    private static final String HUMAN_LIST_CONTROLLER ="humanListController";
    private static final String HUMAN_LIST="humanList";
    private static final String TYPE_LIST_CONTROLLER ="typeListController";
    private static final String TYPE_LIST="typeList";
    private static final String SEARCH_HUMAN="searchHuman";
    private static final String SEARCH_HUMAN_CONTROLLER="searchHumanController";
    private static final String SEARCH_TYPE="searchType";
    private static final String SEARCH_TYPE_CONTROLLER="searchTypeController";
    private static final String DELETE_TYPE="deleteType";
    private static final String DELETE_TYPE_CONTROLLER="deleteTypeController";
    private static final String DELETE_HUMAN="deleteHuman";
    private static final String DELETE_HUMAN_CONTROLLER="deleteHumanController";
    private static final String UPDATE_HUMAN="updateHuman";
    private static final String UPDATE_HUMAN_CONTROLLER="updateHumanController";
    private static final String UPDATE_TYPE="updateType";
    private static final String UPDATE_TYPE_CONTROLLER="updateTypeController";
    private static final String CREATE_HUMAN="createHuman";
    private static final String CREATE_HUMAN_CONTROLLER="createHumanController";
        private static final String CREATE_TYPE="createType";
    private static final String CREATE_TYPE_CONTROLLER="createTypeController";
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
        String url = WELCOME;
        try {
            String action = request.getParameter("action");
            if(action == null){
                url= WELCOME;
            }else if(LOGIN.equals(action)){
                url=LOGIN_CONTROLLER;
            }else if(LOGOUT.equals(action)){
                url = LOGOUT_CONTROLLER;
            }else if(HUMAN_LIST.equals(action)){
                url = HUMAN_LIST_CONTROLLER;
            }else if(TYPE_LIST.equals(action)){
                url = TYPE_LIST_CONTROLLER;
            }else if(SEARCH_HUMAN.equals(action)){
                url = SEARCH_HUMAN_CONTROLLER;
            }else if(SEARCH_TYPE.equals(action)){
                url = SEARCH_TYPE_CONTROLLER;
            }else if(DELETE_TYPE.equals(action)){
                url = DELETE_TYPE_CONTROLLER;
            }else if(DELETE_HUMAN.equals(action)){
                url = DELETE_HUMAN_CONTROLLER;
            }else if(UPDATE_HUMAN.equals(action)){
                url = UPDATE_HUMAN_CONTROLLER;
            }else if(UPDATE_TYPE.equals(action)){
                url = UPDATE_TYPE_CONTROLLER;
            }else if(CREATE_HUMAN.equals(action)){
                url = CREATE_HUMAN_CONTROLLER;
            }else if(CREATE_TYPE.equals(action)){
                url = CREATE_TYPE_CONTROLLER;
            }
        } catch (Exception e) {
            log("ERROR at MainController: "+e.toString());
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
