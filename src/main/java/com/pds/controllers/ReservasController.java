package com.pds.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pds.models.Reserva;
import com.pds.services.IReservaService;
import com.pds.utils.ResponseMessage;

@Controller
@RequestMapping("api/reservas")
public class ReservasController {
	
	@Autowired
	IReservaService reservaService;
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public @ResponseBody ResponseMessage post(@RequestBody Reserva reserva) {
		return reservaService.saveReserva(reserva);
	}
}
