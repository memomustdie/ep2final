/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package pe.isil.webappjsp.user.controller;

import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import pe.isil.webappjsp.user.dao.UserDao;
import pe.isil.webappjsp.user.model.User;

/**
 *
 * @author Guillermo Hurtado
 */
@WebServlet(name = "DeleteUserServlet", urlPatterns = {"/DeleteUserServlet"})
public class DeleteUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/delete.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        UserDao userDao = new UserDao();
        String mensaje = "";
        
        
        String nroDoc = request.getParameter("nroDoc");
        
        
        User user = new User();   
        
        user.setNroDoc(nroDoc);
        
        
        try{
            mensaje = userDao.deleteUser(user);
            
        }catch(Exception e){
            mensaje = e.toString();
            e.printStackTrace();
            
            
        }
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/success.jsp");
        
        request.setAttribute("message", mensaje);
        
        dispatcher.forward(request,response);
        
        
    }


}
