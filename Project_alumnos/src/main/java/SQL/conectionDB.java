package SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
	
	/*public static void main(String[] args) throws SQLException {
		conectionDB c1 = new conectionDB();
		c1.addProfeDB(null, 0, 0);
	}*/

}
