package SQL;

import java.sql.Connection;
import java.sql.DriverManager;


public class conectionDB {
	public conectionDB(){
		try {
			
		Connection conn = DriverManager.getConnection("jdbc:odbc:ARTICLES");
		}catch(Exception e) {
			e.getMessage();
		}
	}

}
