package com.apu.beans;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="feedback")
public class Feedback implements Serializable 
{
    @Id
    @GeneratedValue
    @Column(name="feedbackId")
    private int feedbackId;
    @Column(name="customerId")
    private int customerId;
    @Column(name="hallId")
    private int hallId;
    @Column(name="ownerId")
    private int ownerId;
    @Column(name="feedback")
    private String feedback;

    public Feedback() 
    {
    
    }

    public Feedback(int customerId, int hallId, int ownerId, String feedback) 
    {
        this.customerId = customerId;
        this.hallId = hallId;
        this.ownerId=ownerId;
        this.feedback = feedback;
    }
    
    public Feedback(int feedbackId, int customerId, int hallId,int ownerId, String feedback) 
    {
        this.feedbackId = feedbackId;
        this.customerId = customerId;
        this.hallId = hallId;
        this.ownerId=ownerId;
        this.feedback = feedback;
    }

    
    
    public int getFeedbackId() 
    {
        return feedbackId;
    }

    public void setFeedbackId(int feedbackId) 
    {
        this.feedbackId = feedbackId;
    }

    public int getCustomerId() 
    {
        return customerId;
    }

    public void setCustomerId(int customerId) 
    {
        this.customerId = customerId; 
    }

    public int getHallId() 
    {
        return hallId;
    }

    public void setHallId(int hallId) 
    {
        this.hallId = hallId;
    }

    public String getFeedback() 
    {
        return feedback;
    }

    public void setFeedback(String feedback) 
    {
        this.feedback = feedback;
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
