package com.takeo.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.protocol.Resultset;
import com.takeo.web.model.Alien;

public class AlienDao
{
	public Alien getAlien(int aid) 
	{
		Alien a = new Alien();
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_dept", "root", "123456");
			java.sql.Statement st = con.createStatement();
			Resultset rs = (Resultset) st.executeQuery("select *from alien where aid = " + aid);
			//shifts the pointer to the next row
			if(((ResultSet) rs).next())
			{
				a.setAid(((ResultSet) rs).getInt("aid"));
				a.setAname(((ResultSet) rs).getString("aname"));
				a.setTech(((ResultSet) rs).getString("tech"));
			}
			con.close();
			st.close();
			
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		return a;
		
	}
	public String saveAlien(Alien a)
	{
		String result ="Data entered successfully";
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_dept", "root", "123456");
			java.sql.Statement st = con.createStatement();
			
			String sql = "insert into alien values(?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(0,a.getAid());
			ps.setString(1, a.getAname());
			ps.setString(2, a.getTech());
			ps.executeUpdate();
				
		}
		catch(SQLException e)
		{
			System.out.println(e);
			result = "data not saved";
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		return result;
		
		
	}
}
