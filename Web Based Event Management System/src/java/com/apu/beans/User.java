package com.apu.beans;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User implements Serializable 
{
    @Id
    @GeneratedValue
    @Column(name="userId")
    private int userId;
    @Column(name="firstName")
    private String firstName;
    @Column(name="lastName")
    private String lastName;
    @Column(name="email")
    private String userEmail;
    @Column(name="userName")
    private String userName;
    @Column(name="password")
    private String userPassword;
    @Column(name="userType")
    private String userType;
    @Column(name="gender")
    private String gender;
   

    public User() 
    {
        
    }
    
    public User(int uId, String firstName, String lastName, String uEmail, String uName, String uPassword, String uType, String gender) 
    {
        this.userId=uId;
        this.firstName=firstName;
        this.lastName=lastName;
        this.userEmail=uEmail;
        this.userName=uName;
        this.userPassword=uPassword;
        this.userType=uType;
        this.gender=gender;
    }
    
    public User(String firstName, String lastName, String uEmail, String uName, String uPassword, String uType, String gender) 
    {
        this.firstName=firstName;
        this.lastName=lastName;
        this.userEmail=uEmail;
        this.userName=uName;
        this.userPassword=uPassword;
        this.userType=uType;
        this.gender=gender;
    }

    public int getUserId() 
    {
        return userId;
    }

    public void setUserId(int userId) 
    {
        this.userId = userId;
    }

    public String getFirstName() 
    {
        return firstName;
    }

    public void setFirstName(String firstName) 
    {
        this.firstName = firstName;
    }

    public String getLastName() 
    {
        return lastName;
    }

    public void setLastName(String lastName) 
    {
        this.lastName = lastName;
    }

    public String getUserEmail() 
    {
        return userEmail;
    }

    public void setUserEmail(String userEmail) 
    {
        this.userEmail = userEmail;
    }

    public String getUserName() 
    {
        return userName;
    }

    public void setUserName(String userName) 
    {
        this.userName = userName;
    }

    public String getUserPassword() 
    {
        return userPassword;
    }

    public void setUserPassword(String userPassword) 
    {
        this.userPassword = userPassword;
    }

    public String getUserType() 
    {
        return userType;
    }

    public void setUserType(String userType) 
    {
        this.userType = userType;
    }

    public String getGender() 
    {
        return gender;
    }

    public void setGender(String gender) 
    {
        this.gender = gender;
    }
    
}
