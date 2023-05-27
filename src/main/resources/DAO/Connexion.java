package DAO; 
import java.sql.*; 
public class Connexion { 
    
public static String driver="com.mysql.jdbc.Driver"; 
public static String url="jdbc:mysql://localhost:3306/db_biblio";
public static String user="root"; 
public static String password=""; 
public static Connection con=null; 
public static Connection getConnection()throws Exception{ 
Class.forName(driver); 
return con = DriverManager.getConnection(url, user,password); 
} 
public static void Sedeconnecter() throws Exception{ 
if(con!=null) 
con.close(); 
} 
} 
