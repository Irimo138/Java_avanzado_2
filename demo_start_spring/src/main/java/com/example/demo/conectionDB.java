package com.example.demo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.print.attribute.Size2DSyntax;



public class conectionDB {
	Connection conn;
	public conectionDB(){
		try {
		Class.forName("com.mysql.jdbc.Driver");
		this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Java","root", "");
		System.err.println("realizado");
		
		}catch(Exception e) {
			e.getMessage();
			
		}
	}

		

	

}
