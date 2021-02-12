package com.apu.ejb;

import com.apu.beans.Account;
import com.apu.beans.BookHall;
import com.apu.beans.Feedback;
import com.apu.beans.Hall;
import com.apu.beans.User;
import java.util.List;
import javax.ejb.Remote;

@Remote
public interface DAO 
{
    public boolean addUser(User user);
    public User getUser(String userName, String userPassword);
    public User getUser(int userId);
    public boolean updateUser(User user,int id);
    public boolean addHall(Hall hall);
    public List<Hall> getAllHalls();
    public List<Hall> getHallsByOwnerId(int ownId);
    public boolean updateHall(int hallId,int ownId,Hall hall);
    public boolean updateAccount(Account account,int ownerId);
    public boolean isAccountPresent(int ownerId);
    public Account getAccountById(int ownId);
    public boolean bookHall(BookHall bookHall);
    public Hall getHall(int hallId);
    public int getHallCharges(int hallId);
    public int getCustomerBalance(int customerId);
    public boolean isHallBooked(BookHall bookHall);
    public boolean addFeedback(Feedback feedback);
    public List<Feedback> getFeedbacksById(int ownId);
    public boolean isHallBookedByUser(int userId);
    public List<BookHall> getMyBookings(int userId);
    public List<Hall> getMostBookedHalls();
}
