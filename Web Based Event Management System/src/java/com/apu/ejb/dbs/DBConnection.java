package com.apu.ejb.dbs;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.ejb.Singleton;


@Singleton
public class DBConnection 
{
    private static Connection connection=null;
    
    public static Connection getDBConnection()
    {
	if(connection==null)
	{
            try
            {
                
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/apu_dbs?useTimeZone=true&serverTimezone=UTC&autoReconnect=true&useSSL=false","root","toor");
            }
            catch(Exception e)
            {
		System.out.println("Exception: "+e.getMessage());
                System.out.println("Stack Trace");
                e.printStackTrace();
            }
        }
	return connection;
    }
}
