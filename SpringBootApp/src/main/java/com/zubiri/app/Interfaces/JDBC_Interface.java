package com.zubiri.app.Interfaces;

import com.zubiri.app.beans.Juego;
import com.zubiri.app.beans.Jugador;

public interface JDBC_Interface {
	Jugador save (Jugador j);
	Juego saveGame(Juego j);
}
