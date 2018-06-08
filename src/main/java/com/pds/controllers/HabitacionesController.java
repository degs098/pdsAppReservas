package com.pds.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pds.models.Habitacion;
import com.pds.services.IHabitacionService;
import com.pds.utils.ResponseMessage;

@Controller
@RequestMapping("api/habitaciones")
public class HabitacionesController {
	
	@Autowired
	IHabitacionService habitacionService;
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public @ResponseBody ResponseMessage saveHabitacion(@RequestBody Habitacion habitacion) {
		return habitacionService.saveHabitacion(habitacion);
	}
	
	@RequestMapping(value = "/getValorDisponibles", method = RequestMethod.GET)
	public @ResponseBody String getValorHabitacionesDisponibles() {
		String response = "";
		Double valor = habitacionService.getValorHabitacionCamasDisponible();
		response += "El valor de las habitaciones con camas disponibles es: $" + valor;
		return response;
	}
	
	@RequestMapping(value = "/getReservadas", method = RequestMethod.GET)
	public @ResponseBody String getReservadas() {
		String response = "";
		Integer cantidad = habitacionService.getHabitacionesCamaReservada();
		response += "La cantidad de habitaciones con al menos una cama reservada es de: " + cantidad;
		return response;
	}
}
