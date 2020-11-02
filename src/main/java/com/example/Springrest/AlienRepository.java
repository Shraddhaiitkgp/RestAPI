package com.example.Springrest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class AlienRepository 
{
Connection con = null;
	
	public AlienRepository()
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:lcro","SYS as SYSDBA","shraddha");  
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	//GET
	public List<Alien> getAliens()
	{
		
		List<Alien> aliens = new ArrayList<Alien>();
		String sql = "select * from alien";
		try
		{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next())
			{
				Alien a = new Alien();
				a.setId(rs.getInt(1));
				a.setName(rs.getString(2));
				a.setPoints(rs.getInt(3));
				
				aliens.add(a);
				
			}
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return aliens;
	}
	
	/*
	//GET a single object
	public Alien getAlien(int id)
	{		
		String sql = "select * from alien where id="+id;
		Alien a = new Alien();

		try
		{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			if(rs.next())
			{
				a.setId(rs.getInt(1));
				a.setName(rs.getString(2));
				a.setPoints(rs.getInt(3));
			}			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return a;
	}
*/
	//CREATE, POST
	public void create(Alien a1) 
	{
		String sql = "insert into aliens value(?,?,?)";
		try
		{
			PreparedStatement st = con.prepareStatement(sql);
			System.out.println(a1.getId()+" "+a1.getName()+" "+a1.getPoints());
			st.setInt(1, a1.getId());
			st.setString(2, a1.getName());
			st.setInt(3, a1.getPoints());			
			st.executeUpdate();			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
	
	//UPDATE, PUT
	public void update(Alien a1)
	{		
		String sql = "update alien set id = ?, name=?, points=? where id = 0";
		try
		{
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, a1.getId());
			st.setString(2, a1.getName());
			st.setInt(3, a1.getPoints());
			st.executeUpdate();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
	}

	
	//DELETE
		public void delete(int alien_id)
		{		
			String sql = "delete from alien where id = ?";
			try
			{
				PreparedStatement st = con.prepareStatement(sql);
				st.setInt(1, alien_id);
				st.executeUpdate();
				
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			
			
		}
		
		

}
