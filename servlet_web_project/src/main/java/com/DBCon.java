package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBCon {

	public DBCon(){
	      try{
		  Class.forName("com.mysl.cj.jdbc.Driver");
		  }catch(Exception e){
		  e.printStackTrace();
		  }
	   }

	public boolean checkuser(String uname, String upass) {
		try {

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/aspire", "root", "root");
			PreparedStatement ps = con.prepareStatement("select * from users where uname=? amd upass=?");
			ps.setString(1, uname);
			ps.setString(1, upass);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	public int register(int uid,String uname,String upass,int flag) {
	  try{
	    Connection con=DriverManager.getConnection("jdbc:mysql://localhost/aspire","root","root");
	  PreparedStatement ps=con.prepareStatement("insert into users value(?,?,?,?)");
	  ps.setInt(1,uid);
	  ps.setString(1,uname);
	  ps.setString(1,upass);
	  ps.setInt(3,flag);
	  
	  int i=ps.executeUpdate();
	  return i;
	    
	  }catch(Exception e){e.printStackTrace();;
	     e.printStackTrace();
		 return 0;}
	}

	public static void main(String[] args) {
		DBCon dbcon=new DBCon();
		  System.out.println(dbcon.checkuser("rahim","secret"));

	}

}
