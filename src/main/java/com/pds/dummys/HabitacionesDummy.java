package com.pds.dummys;

import java.util.ArrayList;
import java.util.List;

import com.pds.models.Habitacion;

public class HabitacionesDummy {
	
	public static List<Habitacion> lista = new ArrayList<>();
	
	public static void setHabitaciones(List<Habitacion> newList) {
		lista = newList;
	}
	
	public static List<Habitacion> getHabitaciones(){
		return lista;
	}
}
