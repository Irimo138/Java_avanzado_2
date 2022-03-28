package SQL;

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

import Beans.Escuela;
import Beans.Profesor;


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

		

	public void addProfeDB(Profesor p) throws ClassNotFoundException {
		PreparedStatement stmt;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Java","root", "");
			stmt = conn.prepareStatement("insert into profesor (nombre, añoInicio, cantidadAlumnos) values(?,?,?)");
			stmt.setString(1, p.getNombre());
			stmt.setInt(2, p.getAñoInicio());
			stmt.setInt(3, p.getCantidadAlumnos());
			stmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void addEscuelaDB(Escuela e) throws ClassNotFoundException {
		PreparedStatement stmt;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Java","root", "");
			stmt = conn.prepareStatement("insert into escuela (nombre, añoInicio, cantidadProfes) values(?,?,?)");
			stmt.setString(1, e.getNombre());
			stmt.setInt(2, e.getAñoInicio());
			stmt.setInt(3, e.getCantidadProfesor());
			stmt.executeUpdate();
			
			
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		
	}
	
	public ArrayList<Profesor> mostrarProfes() throws ClassNotFoundException {
		PreparedStatement stmt;
		ArrayList<Profesor> lista = new ArrayList<Profesor>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Java","root", "");
			stmt = conn.prepareStatement("select * from profesor");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Profesor addp = new Profesor();
				addp.setNombre(rs.getNString(1));
				addp.setAñoInicio(rs.getInt(2));
				addp.setAñoInicio(rs.getInt(3));
				lista.add(addp);
			}
			
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		return lista;
		
	}
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		conectionDB c1 = new conectionDB();
		c1.mostrarProfes();
	}

}
