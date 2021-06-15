package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
    public static Connection getDBConnection(){
        try
		{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bluebus","root","password");   
			
            System.out.println("Connection : "+con);

            return con;
		}
		catch(Exception e)
		{ 
			System.out.println(e);
		}    
        return null;
    } 
}
