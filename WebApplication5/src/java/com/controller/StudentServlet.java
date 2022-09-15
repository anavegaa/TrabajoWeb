/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.udea.model.Student;
import com.udea.model.StudentDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hp
 */
public class StudentServlet extends HttpServlet {

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
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet StudentServlet</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet StudentServlet at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
//    }

            throws ServletException, IOException {
        String action=request.getParameter("action");
        String acceso="";
        String studentIdStr= request.getParameter("studentId");
        int studentId=0;
        if(studentIdStr!=null && !studentIdStr.equals(""))
            studentId=Integer.parseInt(studentIdStr);
        
        String firstname=request.getParameter("firstname");
        String lastname=request.getParameter("lastname");
        String yearLevelStr=request.getParameter("yearLevel");
        int yearLevel=0;
        if(yearLevelStr!=null && !yearLevelStr.equals(""))
            yearLevel=Integer.parseInt(yearLevelStr);
        
        Student student=new Student(studentId,firstname,lastname,yearLevel);
            if("Add".equalsIgnoreCase(action)){
                acceso= addStudent(student);
                
        }   else if("Edit".equalsIgnoreCase(action)){
                StudentDAO.editStudent(student);
                
        }   else if("Delete".equalsIgnoreCase(action)){
                StudentDAO.deleteStudent(studentId);
                
        }   else if("Search".equalsIgnoreCase(action)){
                student=StudentDAO.getStudent(studentId);
        }
            
            request.setAttribute("student",student);
            request.setAttribute("allStudents", StudentDAO.getAllStudents());
            request.getRequestDispatcher("studentinfo.jsp").forward(request, response);
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
