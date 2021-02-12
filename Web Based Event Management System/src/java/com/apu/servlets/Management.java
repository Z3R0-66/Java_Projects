package com.apu.servlets;

import com.apu.beans.Account;
import com.apu.beans.BookHall;
import com.apu.beans.Feedback;
import com.apu.beans.Hall;
import com.apu.beans.User;
import com.apu.ejb.dbs.DAOImpl;
import com.apu.ejb.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Management", urlPatterns = {"/Management"})
public class Management extends HttpServlet 
{

    DAO userDAO=new DAOImpl();
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
        String action=request.getParameter("action");
        String destinationPage="error404.jsp";
        String passMessage="";
       try
       {
           
           HttpSession session=request.getSession();
           User user=(User)session.getAttribute("user");
           if(action.equalsIgnoreCase("edit"))
           {
                destinationPage="editprofile.jsp";
           }          
            else if(action.equalsIgnoreCase("account"))
            {
                if(user.getUserType().equalsIgnoreCase("sales representatives") 
                   || user.getUserType().equalsIgnoreCase("customers"))
                {
                    destinationPage="account.jsp";
                }
            }
            else if(action.equalsIgnoreCase("edith"))
            {
                destinationPage="edithall.jsp";
            }
            else if(action.equalsIgnoreCase("book"))
            {
                destinationPage="bookhall.jsp";
            }
            else if(action.equalsIgnoreCase("add"))
            {
                destinationPage="addhall.jsp";
            }
            else if(action.equalsIgnoreCase("feedback"))
            {
                if(user.getUserType().equalsIgnoreCase("sales representatives"))
                    destinationPage="viewfbs.jsp";
                else if(user.getUserType().equalsIgnoreCase("customers"))
                    destinationPage="feedback.jsp";
            }
            else if(action.equalsIgnoreCase("mybook"))
            {
                if(user.getUserType().equalsIgnoreCase("customers"))
                    destinationPage="viewbookings.jsp";
            }
            else if(action.equalsIgnoreCase("updatepass"))
            {
               String currentPassword=request.getParameter("currentPassword");
               String newPassword=request.getParameter("newPassword");
               String confirmPassword=request.getParameter("confirmPassword");
               if(currentPassword.equals(user.getUserPassword()))
               {
                   if(newPassword.equals(confirmPassword))
                   {
                        user.setUserPassword(newPassword);
                        boolean isUpdated=userDAO.updateUser(user,user.getUserId());
                        if(isUpdated)
                        {
                            if(user.getUserType().equalsIgnoreCase("customers"))
                                destinationPage="customer.jsp";
                            else if(user.getUserType().equalsIgnoreCase("sales representatives"))
                                destinationPage="salesrepresentative.jsp";
                            passMessage="Successful!";
                        }
                   }
                   else
                   {
                       passMessage="Invalid Current Password!";
                       destinationPage="editprofile.jsp";
                   }
               }
               else
               {
                   passMessage="Invalid Fields!";
                   destinationPage="editprofile.jsp";
               }
            }
           else if(action.equalsIgnoreCase("updateacc"))
            {
                if(user.getUserType().equalsIgnoreCase("sales representatives") 
                   || user.getUserType().equalsIgnoreCase("customers"))
                {
                    String accountNumberStr=request.getParameter("accountNumber");
                    String balanceStr=request.getParameter("balance");
                    
                    if(accountNumberStr.equals("") || balanceStr.equals(""))
                    {
                        destinationPage="account.jsp";
                        passMessage="Invalid Values";
                    }
                    else
                    {
                        int accountNumber=Integer.parseInt(accountNumberStr);
                        int balance=Integer.parseInt(balanceStr);
                        if(balance>0)
                        {
                            Account account=new Account(user.getUserId(),accountNumber,balance);
                            boolean isUpdated=userDAO.updateAccount(account, user.getUserId());
                            if(isUpdated)
                            {
                                if(user.getUserType().equalsIgnoreCase("customers"))
                                    destinationPage="customer.jsp";
                                else if(user.getUserType().equalsIgnoreCase("sales representatives"))
                                    destinationPage="salesrepresentative.jsp";
                                passMessage="Successful!";
                        
                            }
                            else
                                passMessage="Unsucessful!";
                            destinationPage="account.jsp";
                        }
                        else
                        {
                            passMessage="Balance should be positive";
                            destinationPage="account.jsp";
                        }

                    }
                }
            }
            else if(action.equalsIgnoreCase("addh"))
            {
                if(user.getUserType().equalsIgnoreCase("sales representatives"))
                {    
                   String hallName=request.getParameter("hallName");
                   String hallPlace=request.getParameter("hallPlace");
                   int hallCharges=Integer.parseInt(request.getParameter("hallCharges"));
                   String hallDetails=request.getParameter("hallDetails");
                   int ownerId=user.getUserId();
                   
                   Hall hall=new Hall(hallName, hallDetails, hallPlace, hallCharges, ownerId, 0);
                   boolean isAdded=userDAO.addHall(hall);
                   if(isAdded)
                   {
                        if(user.getUserType().equalsIgnoreCase("customers"))
                            destinationPage="customer.jsp";
                        else if(user.getUserType().equalsIgnoreCase("sales representatives"))
                            destinationPage="salesrepresentative.jsp";
                   }
                   else
                   {
                       destinationPage="addhall.jsp";
                       passMessage="Unable to add Hall";
                   }
                }
            }
            else if(action.equalsIgnoreCase("updthall"))
            {
                if(user.getUserType().equalsIgnoreCase("sales representatives"))
                {
                    String hallChargesStr=request.getParameter("hallCharges");
                    String hallIdStr=request.getParameter("hallId");
                    if(hallChargesStr.equals(""))
                    {
                        hallChargesStr="0";
                    }
                    else
                    {
                       int hallCharges=Integer.parseInt(hallChargesStr);
                       int hallId=Integer.parseInt(hallIdStr);
                       if(userDAO.getHall(hallId).getOwnerId()==user.getUserId())
                       {
                           Hall hall=userDAO.getHall(hallId); 
                           hall.setHallPrice(hallCharges);
                           boolean isUpdated=userDAO.updateHall(hallId, user.getUserId(), hall);
                           if(isUpdated)
                           {
                                if(user.getUserType().equalsIgnoreCase("customers"))
                                    destinationPage="customer.jsp";
                                else if(user.getUserType().equalsIgnoreCase("sales representatives"))
                                    destinationPage="salesrepresentative.jsp";
                            
                           }
                       }
                       else
                       {
                           destinationPage="edithall.jsp";
                           passMessage="Edit your own hall";
                       }
                       
                       
                    }
                }
            }
            else if(action.equalsIgnoreCase("bookhal"))
            {
                String hallIdStr=request.getParameter("hallId");
                String bookingDateStr=request.getParameter("bookingDate");
                if(user.getUserType().equalsIgnoreCase("customers"))
                {
                    if(hallIdStr==null || bookingDateStr==null)
                    {
                        destinationPage="bookhall.jsp";
                        passMessage="Empty Fields";
                    }
                    else
                    {
                        int hallId=Integer.parseInt(hallIdStr);
                        int customerBalance=userDAO.getCustomerBalance(user.getUserId());
                        int hallCharges=userDAO.getHallCharges(hallId);
                        int ownerId=userDAO.getHall(hallId).getOwnerId();
                        BookHall bookHall=new BookHall(hallId,user.getUserId(), bookingDateStr);
                        if(userDAO.isHallBooked(bookHall))
                        {
                            destinationPage="bookhall.jsp";
                            passMessage="Hall is Already Booked on the date";
                        }
                        else
                        {
                            if(hallCharges<customerBalance)
                            {
                                boolean isBooked=userDAO.bookHall(bookHall);
                                if(isBooked)
                                {
                                    Account customerAccount=userDAO.getAccountById(user.getUserId());
                                    customerAccount.setBalance(customerBalance-hallCharges);
                                    userDAO.updateAccount(customerAccount,user.getUserId());
                                    Account ownerAccount=userDAO.getAccountById(ownerId);
                                    ownerAccount.setBalance(ownerAccount.getBalance()+hallCharges);
                                    Hall hall=userDAO.getHall(hallId);
                                    hall.setBookedTimes(hall.getBookedTimes()+1);
                                    userDAO.updateAccount(ownerAccount, ownerId);
                                    userDAO.updateHall(hallId, ownerId, hall);
                                    if(user.getUserType().equalsIgnoreCase("customers"))
                                        destinationPage="customer.jsp";
                                    else if(user.getUserType().equalsIgnoreCase("sales representatives"))
                                        destinationPage="salesrepresentative.jsp";
                                }
                                else
                                {
                                    passMessage="Unsuccessful!";
                                    destinationPage="bookhall.jsp";
                                }
                            }
                            else
                            {
                                passMessage="Check Balance";
                                destinationPage="bookhall.jsp";
                            }
                        }
                    }
                }
            }
            else if(action.equalsIgnoreCase("submitfb"))
            {
                if(user.getUserType().equalsIgnoreCase("customers"))
                {
                    int hallId=Integer.parseInt(request.getParameter("hallId"));
                    String customerFb=request.getParameter("feedback");
                    Hall hall=userDAO.getHall(hallId);
                    Feedback fb=new Feedback(user.getUserId(), hallId, hall.getOwnerId(),customerFb);
                    if(userDAO.isHallBookedByUser(user.getUserId()))
                    {
                        boolean isAdded=userDAO.addFeedback(fb);
                        if(isAdded)
                            destinationPage="customer.jsp";
                        else
                            passMessage="Failed to submit feedback!";
                        destinationPage="feedback.jsp";
                    }
                    else
                    {
                        passMessage="You Can't Provide Feedback for this hall";
                        destinationPage="feedback.jsp";
                    }
                    
                }
            }
            else
            {
                destinationPage="error404.jsp";
            } 
       }
       catch(Exception e)
       {
           System.out.println("Exception: "+e.getMessage());
           System.out.println("Stack Trace");
           e.printStackTrace();
           destinationPage="error404.jsp";
           
       }
       request.setAttribute("passMessage", passMessage);
       RequestDispatcher rq=request.getRequestDispatcher(destinationPage);
        try 
        {
            rq.forward(request,response);
        }
        catch (ServletException ex)
        {
            Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
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
