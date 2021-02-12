package com.apu.beans;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="bookhall")
public class BookHall implements Serializable 
{
    @Id
    @GeneratedValue
    @Column(name="bookingId")
    private int bookingId;
    @Column(name="hallId")
    private int hallId;
    @Column(name="customerId")
    private int bookerId;
    @Column(name="bookingDate")
    private String bookingDate;

    public BookHall() 
    {
    
    }

    public BookHall(int bookingId, int hallId, int bookerId, String bookingDate) 
    {
        this.bookingId = bookingId;
        this.hallId = hallId;
        this.bookerId = bookerId;
        this.bookingDate = bookingDate;
    }

    public BookHall(int hallId, int bookerId, String bookingDate) 
    {
        this.hallId = hallId;
        this.bookerId = bookerId;
        this.bookingDate = bookingDate;
    }

    
    public int getBookingId() 
    {
        return bookingId;
    }

    public void setBookingId(int bookingId) 
    {
        this.bookingId = bookingId;
    }

    public int getHallId() 
    {
        return hallId;
    }

    public void setHallId(int hallId) 
    {
        this.hallId = hallId;
    }

    public int getBookerId() 
    {
        return bookerId;
    }

    public void setBookerId(int bookerId) 
    {
        this.bookerId = bookerId;
    }

    public String getBookingDate() 
    {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) 
    {
        this.bookingDate = bookingDate;
    }
    
    
}
