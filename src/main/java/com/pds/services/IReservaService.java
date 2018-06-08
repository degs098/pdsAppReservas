package com.pds.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pds.models.Reserva;
import com.pds.utils.ResponseMessage;

@Service
public interface IReservaService {
	
	public ResponseMessage saveReserva(Reserva reserva);
	
	public List<Reserva> getReservas();
}
