
package com.apu.servlets;

import com.apu.beans.User;
import com.apu.ejb.DAO;
import com.apu.ejb.dbs.DAOImpl;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Register", urlPatterns = {"/register"})
public class Register extends HttpServlet {

    private DAO userDAO=new DAOImpl();
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
       String message = "";
       String destinationPage="register.jsp";
       
       try
       {
           String fName=request.getParameter("firstName");
           String lName=request.getParameter("lastName");
           String uEmail=request.getParameter("email");
           String uName=request.getParameter("userName");
           String uPassword=request.getParameter("password");
           String uType=request.getParameter("userType");
           String uGender=request.getParameter("gender");
           
           if(fName.equals("") || lName.equals("") || uEmail.equals("") || 
              uName.equals("") || uPassword.equals("") || uType.equals("") 
              || uGender.equals(""))
           { 
               message = "All Fields are Mandatory";
               
           }
           else if(isValidEmail(uEmail) && isValidName(fName) &&isValidName(lName))
           {
              
               User user=new User(fName,lName,uEmail,uName,uPassword,uType,uGender);
               boolean isAdded=userDAO.addUser(user);
               if(isAdded)
               {
                   message = "Account Created Successfully!";
                   destinationPage="index.jsp";
               }
               else
               {
                   message="Failed to Create an Account!";
               }
           }
           else
           {
               message = "Please Provide Valid Fields";
           }
   
       }
       catch(Exception e)
       {
           System.out.println("Exception: "+e.getMessage());
           System.out.println("Stack Trace");
           e.printStackTrace();
       }
       
        request.setAttribute("message", message);
          
        RequestDispatcher rq=request.getRequestDispatcher(destinationPage);
        try 
        {
            rq.forward(request, response);
        } 
        catch (ServletException ex) 
        {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
    private boolean isValidName(String name)
    {
        int count=0;
        for(int i=0;i<name.length();i++)
            if((name.charAt(i)>='A' && name.charAt(i)<='Z') || (name.charAt(i)>='a' && name.charAt(i)<='z'))
                count++;
        
        return (count==name.length());
    }
    
    private boolean isValidEmail(String email)
    {
        for(int i=0;i<email.length();i++)
            if(email.charAt(i)=='@' && email.endsWith(".com"))
                return true;
        return false;
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
