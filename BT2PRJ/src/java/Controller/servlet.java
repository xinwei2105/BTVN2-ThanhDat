/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 *
 * @author XinWei
 */
@WebServlet(name="servlet", urlPatterns={"/servlet"})
public class servlet extends HttpServlet {
   
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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet servlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet servlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
    response.setContentType("text/html;charset=UTF-8");
    String choice = request.getParameter("choice");
    String address = request.getParameter("address");
    String name = request.getParameter("name");
    String[] food = request.getParameterValues("food");
    PrintWriter out = response.getWriter();
    String ms = "";
    String foods = "";
    String occupation = request.getParameter("occupation");
    if(choice.equalsIgnoreCase("no")){
        ms+="Chúng tôi không thể chấp nhận yêu cầu bạn";
    }
    else{
        if(name.isBlank()){
          ms+=" Không được để trống Tên";  
        }
        else if(address.isBlank()){
            ms+=" Không được để trống địa chỉ";  
        }
        else{
            
                try {
                    for(int i = 0;i<food.length;i++){
                    foods+= food[i]+" ,";
                    }
                    foods = foods.substring(0, foods.length() - 1);
                    ms+= name+"("+address+")"+"-"+foods +"- "+ occupation;
                } catch (Exception e) {
                    e.printStackTrace();
                }
        
        
        }
    }
    out.append("<body><h1 style=\"color:red;\">" + ms + "</h1></body>");   
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
