package in.skyline.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import in.skyline.util.JdbcUtil;

public class Login {
public static void main(String []args) {
	Connection connection=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	Scanner sc=new Scanner(System.in);
    int cardNo=0;
    int pinNo=0;
   System.out.println("Login page");
   
   char ch=0;
   while(ch>'3'||ch<'1') {
	   System.out.println("Enter 1 for Login");
	   System.out.println("Enter 2 for Signup");
	   System.out.println("Enter 3 for exit");
	   try {
		   System.out.print("Enter:: ");
		ch=(char)System.in.read();
	  } catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
   switch(ch) {
   case '1' ->{
	   String query="select cardnumber from login where cardnumber=? and pin=?";
	   try {
		   connection=JdbcUtil.jdbcConnection();
		   if(connection!=null) {
			   pstmt=connection.prepareStatement(query);
			   if(pstmt!=null) {
			      login(rs, pstmt);
			   }
		   }
	   }catch(SQLException se) {
		   se.printStackTrace();
	   } catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	 }finally {
		 try {
			JdbcUtil.closeConnection(rs, pstmt, connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
   }
   case '2'->{
	   System.out.println("Sign Up");
   }
   case '3'->{
	   System.exit(0);
   }
   }
   
}

private static void login(ResultSet rs, PreparedStatement pstmt) throws SQLException {
	   String cardNo=null;
	   String pinNo=null;
	   Scanner sc=new Scanner(System.in);
	   System.out.print("Enter Card Number:: ");
	   cardNo=sc.next();
	   sc.nextLine();
	   System.out.print("Enter Pin Number:: ");
	   pinNo=sc.next();
	   pstmt.setString(1,cardNo);
	   pstmt.setString(2, pinNo);
	   rs=pstmt.executeQuery();
	   if(rs!=null) {
		   if(rs.next()) {
			   System.out.println("Login Succesfull");
		   }
		   else {
			   System.out.println("Incorrect pin");
			   login(rs,pstmt);
		   }
	   }
}
}
