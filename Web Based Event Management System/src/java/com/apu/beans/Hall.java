package com.apu.beans;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "hall")
public class Hall implements Serializable 
{
    @Id
    @GeneratedValue
    @Column(name="hallId")
    private int hallId;
    @Column(name="hallName")
    private String hallName;
    @Column(name="hallDetails")
    private String hallDetails;
    @Column(name="hallPlace")
    private String hallPlace;
    @Column(name="hallCharges")
    private int hallPrice;
    @Column(name="ownerId")
    private int ownerId;
    @Column(name="bookedTimes")
    private int bookedTimes;

    public Hall() 
    {
    
    }

    
    public Hall(int hallId, String hallName, String hallDetails, String hallPlace, int hallPrice, int ownerId,int bookedTimes) 
    {
        this.hallId = hallId;
        this.hallName = hallName;
        this.hallDetails = hallDetails;
        this.hallPlace = hallPlace;
        this.hallPrice = hallPrice;
        this.ownerId = ownerId;
        this.bookedTimes=bookedTimes;
    }

    public Hall(String hallName, String hallDetails, String hallPlace, int hallPrice, int ownerId,int bookedTimes) 
    {
        this.hallName = hallName;
        this.hallDetails = hallDetails;
        this.hallPlace = hallPlace;
        this.hallPrice = hallPrice;
        this.ownerId = ownerId;
        this.bookedTimes=bookedTimes;
    }

    public int getBookedTimes() 
    {
        return bookedTimes;
    }

    public void setBookedTimes(int bookedTimes) 
    {
        this.bookedTimes = bookedTimes;
    }

    
    
    public int getHallId() 
    {
        return hallId;
    }

    public void setHallId(int hallId) 
    {
        this.hallId = hallId;
    }

    public String getHallName() 
    {
        return hallName;
    }

    public void setHallName(String hallName) 
    {
        this.hallName = hallName;
    }

    public String getHallDetails() 
    {
        return hallDetails;
    }

    public void setHallDetails(String hallDetails) 
    {
        this.hallDetails = hallDetails;
    }

    public String getHallPlace() 
    {
        return hallPlace;
    }

    public void setHallPlace(String hallPlace) 
    {
        this.hallPlace = hallPlace;
    }

    public int getHallPrice() 
    {
        return hallPrice;
    }

    public void setHallPrice(int hallPrice) 
    {
        this.hallPrice = hallPrice;
    }

    public int getOwnerId() 
    {
        return ownerId;
    }

    public void setOwnerId(int ownerId) 
    {
        this.ownerId = ownerId;
    }
    
    
}

