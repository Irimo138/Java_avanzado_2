package Controllers;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import Beans.Juego;
import DB_Connections.DBconection;

@Controller
public class JuegosController {
	private DBconection c1;
	public JuegosController(DBconection c) {
		c1 = c;
	}

	
	@GetMapping("/")
	public String listaJuegos() {
		ArrayList<Juego> lista;
		try {
			lista = c1.mostrarJuegos();
			for(int i = 0; i < lista.size(); i++) {
				System.out.println(lista.get(i).getNombre());
			}
			//returnHome();*/
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return("showJuegos");
	}
}