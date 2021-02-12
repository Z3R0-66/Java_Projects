package com.apu.servlets;

import com.apu.ejb.dbs.DAOImpl;
import com.apu.ejb.DAO;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.apu.beans.User;

@WebServlet(name = "Login", urlPatterns = {"/login"})
public class Login extends HttpServlet 
{

    DAO userDAO=new DAOImpl();
    private User user;
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
    {
        String message="";
        String destinationPage="index.jsp";
        HttpSession session=request.getSession();
        
        try
        {
           String uName=request.getParameter("userName");
           String uPassword=request.getParameter("password");
           if(uName.equals("") && uPassword.equals(""))
           { 
               message = "All Fields are Mandatory";
           }
           else
           {
               user=userDAO.getUser(uName, uPassword);
               if(user!=null)
               {
                   message="Successful Login";
                   session.setAttribute("user", user);
                   if(user.getUserType().equalsIgnoreCase("Managing Staff"))
                   {
                       destinationPage="managingstaff.jsp";
                   }
                   else if(user.getUserType().equalsIgnoreCase("sales representatives"))
                   {
                       destinationPage="salesrepresentative.jsp";
                   }
                   else if(user.getUserType().equalsIgnoreCase("customers"))
                   {
                       destinationPage="customer.jsp";
                   }
               }
               else
               {
                   message="Invalid username/password";
                   
               }
               
           }
           session.setAttribute("message", message);
           
           
           
        }
        catch(Exception e)
        {
           System.out.println("Exception: "+e.getMessage());
           System.out.println("Stack Trace");
           e.printStackTrace();
           destinationPage="error404.jsp";
        }
        RequestDispatcher rq=request.getRequestDispatcher(destinationPage);
        try {
            rq.forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
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
