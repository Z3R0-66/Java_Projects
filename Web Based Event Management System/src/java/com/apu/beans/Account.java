package com.apu.beans;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="account")
public class Account implements Serializable 
{
    @Id
    @Column(name="accountId")
    private int accountId;
    @Column(name="ownerId")
    private int ownerId;
    @Column(name="balance")
    private int balance;

    public Account() 
    {
    
    }

    public Account(int ownerId, int accountId, int balance) 
    {
        this.accountId = accountId;
        this.ownerId = ownerId;
        this.balance = balance;
    }
 
    public int getAccountId() 
    {
        return accountId;
    }

    public void setAccountId(int accountId) 
    {
        this.accountId = accountId;
    }

    public int getOwnerId() 
    {
        return ownerId;
    }

    public void setOwnerId(int ownerId) 
    {
        this.ownerId = ownerId;
    }

    public int getBalance() 
    {
        return balance;
    }

    public void setBalance(int balance) 
    {
        this.balance = balance;
    } 
    
  
}
