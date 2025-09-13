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
import sample.human.ERROR;
import sample.human.HumanTypeDAO;
import sample.human.HumanTypeDTO;

/**
 *
 * @author 84904
 */
public class createTypeController extends HttpServlet {

    private static final String ERROR = "createType.jsp";
    private static final String SUCCESS = "createType.jsp";

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
        String url = ERROR;
        ERROR typeError = new ERROR();
        boolean checkValidation = true;
        HumanTypeDAO dao = new HumanTypeDAO();

        try {
            int typeId = Integer.parseInt(request.getParameter("typeId"));
            String typeName = request.getParameter("typeName");
            
            // ===== Validate =====
            boolean checkDuplicate = dao.checkDuplicate(typeId);
            if (checkDuplicate) {
                checkValidation = false;
                typeError.setTypeIdError("Duplicate Type ID");
            }
            
            if (checkValidation) {
                HumanTypeDTO type = new HumanTypeDTO(typeId, typeName);
                boolean checkInsert = dao.insert(type);
                if (checkInsert) {
                    url = SUCCESS;
                } else {
                    typeError.setTypeIdError("Unknown error");
                    request.setAttribute("TYPE_ERROR", typeError);
                }
            } else {
                request.setAttribute("TYPE_ERROR", typeError);
            }
        } catch (Exception e) {
            log("ERROR at createTypeController: " + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
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
