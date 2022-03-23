package SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class conectionDB {
	
	public conectionDB(){
		try {
			
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Java","root", "");
		System.err.println("realizado");
		
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM profesor");
		
		while(rs.next()) {
			String RESULT_NOMBRE = rs.getString(1);
			String RESULT_ANO = rs.getString("añoInicio");
			String RESULT_ALUMNOS = rs.getString(3);
			
			System.out.println( RESULT_NOMBRE + RESULT_ANO + RESULT_ALUMNOS);
			
		}
		
		}catch(Exception e) {
			e.getMessage();
			
		}
	}
	
	public static void main(String[] args) {
		conectionDB c1 = new conectionDB();
	}

}
