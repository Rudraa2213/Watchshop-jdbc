package com.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Set;

import com.model.Productmodel;
import com.service.Productservice;

public class Controller implements Productservice{
		 private Connection conn;
		 private Statement stm;
		 private PreparedStatement pstm;
	
	String query1="create table if not exists "
			+ "product(sno int auto_increment primary key,name text,"
			+ "email text,mobile text,filename text)";
	
	public Controller() {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Database", "root", "root");
		stm=conn.createStatement();
		stm.execute(query1);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}	
	}

	public int Insert(Productmodel pm) {
		try {	
		pstm = conn.prepareStatement("insert into product(sno,name,email,mobile,filename) values(?,?,?,?,?)");
		pstm.setInt(1, pm.getSno());
		pstm.setString(2, pm.getName());
		pstm.setString(3, pm.getEmail());
		pstm.setString(4, pm.getMobile());
		pstm.setString(5, pm.getFile());
		pstm.executeUpdate();
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return 0;
	}
	public ArrayList<Productmodel> fetchalldata() {
		ArrayList<Productmodel> data= new ArrayList<Productmodel>();
		try {
			stm=conn.createStatement();
			ResultSet set=stm.executeQuery("select * from product");
			while(set.next()) {
				Productmodel p=new Productmodel(set.getInt("sno"), set.getString(2), set.getString(3), set.getString(4), set.getString(5));
				data.add(p);	
			}
				return data;
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
			return data;
	}
	public int updaterecord(Productmodel um) {
		try {
		pstm = conn.prepareStatement("update product set name=?,email=?,mobile=?,filename=? where sno=?");
		pstm.setString(1, um.getName());
		pstm.setString(2, um.getEmail());
		pstm.setString(3, um.getMobile());
		pstm.setString(4, um.getFile());
		pstm.setInt(5, um.getSno());
		pstm.executeUpdate();
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return 0;
	}

	public boolean delete(int sno) {
		try {
		pstm=conn.prepareStatement("delete from product where sno=?");
		pstm.setInt(1, sno);
		pstm.executeUpdate();
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public ArrayList<Productmodel> fetchdata() {	
		ArrayList<Productmodel> pm=new ArrayList<Productmodel>();
		try {
		stm=conn.createStatement();
		ResultSet s=stm.executeQuery("select * from product");
		while (s.next()) {
			Productmodel p=new Productmodel(s.getInt("Sno"), s.getString(2), s.getString(3), s.getString(4), s.getString(5));
			pm.add(p);
		}
		return pm;
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return pm;
	}
}
