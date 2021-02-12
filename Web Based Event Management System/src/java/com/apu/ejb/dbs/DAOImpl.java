package com.apu.ejb.dbs;

import com.apu.beans.Account;
import com.apu.beans.BookHall;
import com.apu.beans.Feedback;
import com.apu.beans.Hall;
import com.apu.beans.User;
import com.apu.ejb.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

@Stateless
public class DAOImpl implements DAO 
{
    private static Connection connection=DBConnection.getDBConnection();
    
    @Override
    public boolean addUser(User user) 
    {
	try
	{
            String sql = "insert into users(firstName,lastName,email,userName,password,userType,gender) values(?,?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getUserEmail());
            statement.setString(4, user.getUserName());
            statement.setString(5, user.getUserPassword());
            statement.setString(6, user.getUserType());
            statement.setString(7, user.getGender());
            
            int rs=statement.executeUpdate();
            
            if(rs>0)
                return true;
        }catch(Exception e)
        {
            System.out.println("Exception: "+e.getMessage());
        }
	return false;
    }

    @Override
    public User getUser(String userName, String userPassword)
    {
        try
	{
            String sql = "SELECT * FROM users where userName= ? and password = ?";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, userName);
            statement.setString(2, userPassword); 
            
            ResultSet rs=statement.executeQuery();
            
            while(rs.next())
            {
               int uId=rs.getInt("userId");
                String firstName=rs.getString("firstName");
                String lastName=rs.getString("lastName");
                String uEmail=rs.getString("email");
                String uName=rs.getString("userName");
                String uPassword=rs.getString("password");
                String uType=rs.getString("userType");
                String gender=rs.getString("gender");
                
                User user=new User(uId,firstName,lastName,uEmail,uName,uPassword,uType,gender);
                return user;
            }
	}
        catch(Exception e)
	{
            System.out.println("Exception: "+e.getMessage());
	}
        return null;
    }
    
    @Override
    public User getUser(int userId)
    {
        try
	{
            String sql = "SELECT * FROM users where userId=?";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, userId); 
            
            ResultSet rs=statement.executeQuery();
            
            while(rs.next())
            {
               int uId=rs.getInt("userId");
                String firstName=rs.getString("firstName");
                String lastName=rs.getString("lastName");
                String uEmail=rs.getString("email");
                String uName=rs.getString("userName");
                String uPassword=rs.getString("password");
                String uType=rs.getString("userType");
                String gender=rs.getString("gender");
                
                User user=new User(uId,firstName,lastName,uEmail,uName,uPassword,uType,gender);
                return user;
            }
	}
        catch(Exception e)
	{
            System.out.println("Exception: "+e.getMessage());
	}
        return null;
    }
    
    @Override
    public boolean updateUser(User user,int id)
    {
        try
	{
            String sql = "update users set password = ? where userId=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, user.getUserPassword());
            statement.setInt(2, id);
            
            int rs=statement.executeUpdate();
            
            if(rs>0)
                return true;
        }
        catch(Exception e)
        {
            System.out.println("Exception: "+e.getMessage());   
        }
	return false;
    }
    
    @Override
    public boolean addHall(Hall hall)
    {
        try
	{
            String sql = "insert into hall(hallName,hallDetails,hallPlace,hallCharges,ownerId,bookedTimes) values(?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, hall.getHallName());
            statement.setString(2, hall.getHallDetails());
            statement.setString(3, hall.getHallPlace());
            statement.setInt(4, hall.getHallPrice());
            statement.setInt(5, hall.getOwnerId());
            statement.setInt(6, hall.getBookedTimes());
            
            int rs=statement.executeUpdate();
            
            if(rs>0)
            {
                return true;
            }
        }
        catch(Exception e)
        {
            System.out.println("Exception: "+e.getMessage());
       
        }
	return false;

    }
    
    @Override
    public List<Hall> getAllHalls()
    {
        List<Hall> listOfHalls=new ArrayList<>();
        try
	{
            String sql = "SELECT * FROM hall";
          
            PreparedStatement statement = connection.prepareStatement(sql);
            
            ResultSet rs=statement.executeQuery();
            
            while(rs.next())
            {
              
                int hallId=rs.getInt("hallId");
                String hallName=rs.getString("hallName");
                String hallDetails=rs.getString("hallDetails");
                String hallPlace=rs.getString("hallPlace");
                int hallPrice=rs.getInt("hallCharges");
                int ownerId=rs.getInt("ownerId");
                int bookedTimes=rs.getInt("bookedTimes");
                
                Hall hall=new Hall(hallId,hallName,hallDetails,hallPlace,hallPrice,ownerId,bookedTimes);
                
                listOfHalls.add(hall);
                
            }
	}catch(Exception e)
	{
            System.out.println("Exception: "+e.getMessage());
	}
        return listOfHalls;
    }
    
    @Override
    public List<Hall> getHallsByOwnerId(int ownId)
    {
        List<Hall> listOfHalls=new ArrayList<>();
        try
	{
            String sql = "SELECT * FROM hall where ownerId=?";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, ownId);
            
            ResultSet rs=statement.executeQuery();
            
            while(rs.next())
            {
              
                int hallId=rs.getInt("hallId");
                String hallName=rs.getString("hallName");
                String hallDetails=rs.getString("hallDetails");
                String hallPlace=rs.getString("hallPlace");
                int hallPrice=rs.getInt("hallCharges");
                int ownerId=rs.getInt("ownerId");
                int bookedTimes=rs.getInt("bookedTImes");
                
                Hall hall=new Hall(hallId,hallName,hallDetails,hallPlace,hallPrice,ownerId,bookedTimes);
                
                listOfHalls.add(hall);
                
            }
	}
        catch(Exception e)
	{
            System.out.println("Exception: "+e.getMessage());
	}
        return listOfHalls;
    }

    @Override
    public boolean updateHall(int hallId,int ownId,Hall hall)
    {
        try
	{
            String sql = "update hall set hallCharges=?,bookedTimes=? where hallId=? and ownerId=?";
            
            PreparedStatement statement = connection.prepareStatement(sql);
         
            statement.setInt(1, hall.getHallPrice());
            statement.setInt(2, hall.getBookedTimes());
            statement.setInt(3, hallId);
            statement.setInt(4,ownId);
            
            int rs=statement.executeUpdate();
            
            if(rs>0)
            {
                return true;
            }
	}
        catch(Exception e)
	{
            System.out.println("Exception: "+e.getMessage());
	}
        return false;
    }
    
    @Override
    public boolean updateAccount(Account account,int ownerId)
    {
        if(!isAccountPresent(ownerId))
        {
            try
            {
                String sql = "insert into account(ownerId,accountId,balance) values (?,?,?)";
                
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setInt(1, ownerId);
                statement.setInt(2, account.getAccountId());
                statement.setInt(3, account.getBalance());
                
                int rs=statement.executeUpdate();
                
                if(rs>0)
                {
                    return true;
                }
            }
            catch(Exception e)
            {
                System.out.println("Exception: "+e.getMessage());
            }
        }
        else
        {
            try
            {
                String sql = "update account set balance=? where ownerId=?";
                
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setInt(1, account.getBalance());
                statement.setInt(2, ownerId);
            
                int rs=statement.executeUpdate();
                
                if(rs>0)
                {
                    return true;
                }
            }
            catch(Exception e)
            {
                System.out.println("Exception: "+e.getMessage());
            }
        }
        return false;
    }
    
    @Override
    public boolean isAccountPresent(int ownerId)
    {
        try
	{
            String sql = "SELECT accountId FROM account where ownerId=?";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, ownerId);
            
            ResultSet rs=statement.executeQuery();
            
            if(rs.next())
            {
                return true;
            }
            
        }
        catch(Exception e)
	{
            System.out.println("Exception: "+e.getMessage());
	}
        return false;
    }
    
    @Override
    public Account getAccountById(int ownId)
    {
        try
	{
            String sql = "SELECT * FROM account where ownerId=?";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, ownId);
            
            ResultSet rs=statement.executeQuery();
            
            if(rs.next())
            {
                int ownerId=rs.getInt("ownerId");
                int accountId=rs.getInt("accountId");
                int accountBalance=rs.getInt("balance");
                
                Account account=new Account(ownerId,accountId,accountBalance);
                return account;
            }
            
        }
        catch(Exception e)
	{
            System.out.println("Exception: "+e.getMessage());
	}
        return null;
    }
    
    @Override
    public boolean bookHall(BookHall bookHall)
    {
        try
        {
            String sql = "insert into bookhall(hallId,customerId,bookingDate) values (?,?,?)";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, bookHall.getHallId());
            statement.setInt(2, bookHall.getBookerId());
            statement.setString(3, bookHall.getBookingDate());
            
            int rs=statement.executeUpdate();
            
            if(rs>0)
            {
                return true;
            }
        }
        catch(Exception e)
        {
            System.out.println("Exception: "+e.getMessage());
        }
        return false;
    }
    
    @Override
    public Hall getHall(int hallId)
    {
        
        try
	{
            String sql = "SELECT * FROM hall where hallId=?";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, hallId);
            
            ResultSet rs=statement.executeQuery();
            
            while(rs.next())
            {
              
                int hallID=rs.getInt("hallId");
                String hallName=rs.getString("hallName");
                String hallDetails=rs.getString("hallDetails");
                String hallPlace=rs.getString("hallPlace");
                int hallPrice=rs.getInt("hallCharges");
                int ownerId=rs.getInt("ownerId");
                int bookedTimes=rs.getInt("bookedTimes");
                Hall hall=new Hall(hallID,hallName,hallDetails,hallPlace,hallPrice,ownerId,bookedTimes);
                
                return hall;
                
            }
	}
        catch(Exception e)
	{
            System.out.println("Exception: "+e.getMessage());
	}
        return null;
    }
    
    @Override
    public int getHallCharges(int hallId)
    {
        try
	{
            String sql = "SELECT hallCharges FROM hall where hallId=?";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, hallId);
            
            ResultSet rs=statement.executeQuery();
            
            while(rs.next())
            {
              
                int hallCharges=rs.getInt("hallCharges");
                return hallCharges;
                
            }
	}
        catch(Exception e)
	{
            System.out.println("Exception: "+e.getMessage());
	}
        
        return 0;
    }
    
    @Override
    public int getCustomerBalance(int customerId)
    {
        try
	{
            String sql = "SELECT balance FROM account where ownerId=?";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, customerId);
            
            ResultSet rs=statement.executeQuery();
            
            if(rs.next())
            {
                int accountBalance=rs.getInt("balance");
                return accountBalance;
            }
            
        }
        catch(Exception e)
	{
            System.out.println("Exception: "+e.getMessage());
	}
        return 0;
    }
    
    @Override
    public boolean isHallBooked(BookHall bookHall)
    {
        try
        {
            String sql = "select * from bookhall where hallId=? and bookingDate=?";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, bookHall.getHallId());
            statement.setString(2, bookHall.getBookingDate());
            
            ResultSet rs=statement.executeQuery();
            
            if(rs.next())
            {
                return true;
            }
        }
        catch(Exception e)
        {
            System.out.println("Exception: "+e.getMessage());
        }
        return false;
    }
   
    @Override
    public boolean addFeedback(Feedback feedback)
    {
        try
        {
            String sql = "insert into feedback(customerId,hallId,ownerId,feedback) values (?,?,?,?)";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, feedback.getCustomerId());
            statement.setInt(2, feedback.getHallId());
            statement.setInt(3, feedback.getOwnerId());
            statement.setString(4, feedback.getFeedback());
            
            int rs=statement.executeUpdate();
            
            if(rs>0)
            {
                return true;
            }
        }
        catch(Exception e)
        {
            System.out.println("Exception: "+e.getMessage());
        }
        return false;
    }
    
    @Override
    public List<Feedback> getFeedbacksById(int ownId)
    {
        List<Feedback> listOfFeedbacks=new ArrayList<>();
        try
	{
            String sql = "SELECT * FROM feedback where ownerId=?";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, ownId);
            
            ResultSet rs=statement.executeQuery();
            
            while(rs.next())
            {
              
                int feedbackID=rs.getInt("feedbackId");
                int customerId=rs.getInt("customerId");
                int hallId=rs.getInt("hallId");
                int ownerId=rs.getInt("ownerId");
                String feedback=rs.getString("feedBack");
                
                Feedback fback=new Feedback(feedbackID,customerId,hallId,ownerId,feedback);
                
                listOfFeedbacks.add(fback);
                
            }
	}catch(Exception e)
	{
            System.out.println("Exception: "+e.getMessage());
	}
        return listOfFeedbacks;
    }
    
    @Override
    public boolean isHallBookedByUser(int userId)
    {
        List<BookHall> bookingList=new ArrayList<>();
        try
        {
            String sql = "select * from bookhall where customerId=?";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, userId);
            
            ResultSet rs=statement.executeQuery();
            
            if(rs.next())
            {
                return true;
            }
        }
        catch(Exception e)
        {
            System.out.println("Exception: "+e.getMessage());
        }
        
        return false;
    }
    
    @Override
    public List<BookHall> getMyBookings(int userId)
    {
        List<BookHall> listOfMyBookings=new ArrayList<>();
        
        try
        {
            String sql = "select * from bookhall where customerId=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, userId);
            
            ResultSet rs=statement.executeQuery();
            while(rs.next())
            {
                int bookingId=rs.getInt("bookId");
                int hallId=rs.getInt("hallId");
                int customerId=rs.getInt("customerId");
                String bookingDate=rs.getString("bookingDate");
                
                BookHall bookHall=new BookHall(bookingId,hallId,customerId,bookingDate);
                listOfMyBookings.add(bookHall);
            }
        }
        catch(Exception e)
        {
            System.out.println("Exception: "+e.getMessage());
        }
        
        
        return listOfMyBookings;
    }
    @Override
    public List<Hall> getMostBookedHalls()
    {
        List<Hall> listOfHalls=new ArrayList<>();
        try
	{
            String sql = "SELECT * FROM hall order by bookedTimes desc";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            
            ResultSet rs=statement.executeQuery();
            
            while(rs.next())
            {
              
                int hallId=rs.getInt("hallId");
                String hallName=rs.getString("hallName");
                String hallDetails=rs.getString("hallDetails");
                String hallPlace=rs.getString("hallPlace");
                int hallPrice=rs.getInt("hallCharges");
                int ownerId=rs.getInt("ownerId");
                int bookedTimes=rs.getInt("bookedTimes");
                
                Hall hall=new Hall(hallId,hallName,hallDetails,hallPlace,hallPrice,ownerId,bookedTimes);
                
                listOfHalls.add(hall);
                
            }
	}catch(Exception e)
	{
            System.out.println("Exception: "+e.getMessage());
            System.out.println("Stack Trace");
            e.printStackTrace();
	}
        return listOfHalls;
    }
}
