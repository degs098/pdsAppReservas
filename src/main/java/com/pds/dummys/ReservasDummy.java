package com.pds.dummys;

import java.util.ArrayList;
import java.util.List;

import com.pds.models.Reserva;

public class ReservasDummy {
	
	public static List<Reserva> lista = new ArrayList<>();
	
	public static void setReservas(List<Reserva> newList) {
		lista = newList;
	}
	
	public static List<Reserva> getReservas(){
		return lista;
	}

}
