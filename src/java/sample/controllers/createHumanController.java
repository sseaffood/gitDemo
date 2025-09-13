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
import sample.human.ERROR;
import sample.human.HumanDAO;
import sample.human.HumanDTO;

/**
 *
 * @author 84904
 */
public class createHumanController extends HttpServlet {

    private static final String ERROR = "createHuman.jsp";
    private static final String SUCCESS = "createHuman.jsp";

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
        ERROR humanError = new ERROR();
        boolean checkValidation = true;
        HumanDAO dao = new HumanDAO();

        try {
            String humanID = request.getParameter("humanId");
            String humanName = request.getParameter("humanName");
            String dobStr = request.getParameter("dob");
            String genderStr = request.getParameter("gender");
            String typeIdStr = request.getParameter("typeId");
            String userHuman = request.getParameter("uname");
            String passHuman = request.getParameter("psw");
            String confirm = request.getParameter("confirm");
            String role = request.getParameter("role");

            // ===== Validate =====
            boolean checkDuplicate = dao.checkDuplicate(humanID);
            if (checkDuplicate) {
                checkValidation = false;
                humanError.setHumanIDError("Duplicate HumanID");
            }
            boolean duplicateUser = dao.checkDuplicateUser(userHuman);
            if (duplicateUser) {
                checkValidation = false;
                humanError.setuHumanError("Username already exists!");
            }

            if (humanName == null || humanName.trim().length() < 5 || humanName.trim().length() > 30) {
                checkValidation = false;
                humanError.setHumanNameError("Human Name must be in range [5,30]");
            }
            if (!passHuman.equals(confirm)) {
                checkValidation = false;
                humanError.setPasswordError("Password and confirm do not match!");
            }
            Date dob = Date.valueOf(dobStr);
            boolean gender = false;
            try {
                int g = Integer.parseInt(genderStr);
                if (g == 0 || g == 1) {
                    gender = (g == 1);
                } else {
                    checkValidation = false;
                    humanError.setGenderError("Gender must be 0 (female) or 1 (male)");
                }
            } catch (Exception e) {
                checkValidation = false;
                humanError.setGenderError("Gender must be a number 0/1");
            }

            int typeId = 0;
            typeId = Integer.parseInt(typeIdStr);
            if (checkValidation) {
                HumanDTO human = new HumanDTO(humanID, humanName, dob, gender, typeId, userHuman, passHuman, role);
                boolean checkInsert = dao.insert(human);
                if (checkInsert) {
                    url = SUCCESS;
                    request.setAttribute("SUCCESS_CREATE", "Sign up successfully");
                } else {
                    humanError.setError("Unknown error");
                    request.setAttribute("HUMAN_ERROR", humanError);
                }
            } else {
                request.setAttribute("HUMAN_ERROR", humanError);
            }
        } catch (Exception e) {
            log("ERROR at createHumanController: " + e.toString());
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
