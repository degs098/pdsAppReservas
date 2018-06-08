package com.pds.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pds.dao.IHabitacionDao;
import com.pds.models.Habitacion;
import com.pds.models.Reserva;
import com.pds.utils.ResponseMessage;
import com.pds.utils.Constants;

@Service
public class HabitacionService implements IHabitacionService{

	@Autowired
	IHabitacionDao habitacionDao;
	
	@Autowired
	IReservaService reservaService;
	
	@Override
	public ResponseMessage saveHabitacion(Habitacion habitacion) {	
		ResponseMessage response = new ResponseMessage();
		try {
			if(habitacion.getTipoHabitacion() == Constants.HABITACION_PRIVADA) {
				if(habitacion.getNumCamas() != null && habitacion.getNumCamas() >= Constants.MIN_CAMAS_PRIVADA 
						&& habitacion.getNumCamas() <= Constants.MAX_CAMAS_PRIVADA) {
					response = habitacionDao.saveHabitacion(habitacion);								
				}else {
					response.setMessage(Constants.errorNumCamasInvalido);
					response.setStatus(-1);
				}
			}else {
				if(habitacion.getNumCamas() != null && habitacion.getNumCamas() >= Constants.MIN_CAMAS_COMPARTIDA 
						&& habitacion.getNumCamas() <= Constants.MAX_CAMAS_COMPARTIDA) {
					response = habitacionDao.saveHabitacion(habitacion);								
				}else {
					response.setMessage(Constants.errorNumCamasInvalido);
					response.setStatus(-1);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.setMessage(Constants.errorInsertResponse);
			response.setStatus(-1);
		}
		return response;
	}

	@Override
	public Habitacion getHabitacionById(Integer id) {		
		try {
			Habitacion habitacion = habitacionDao.getHabitacionById(id);
			return habitacion;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Integer updateHabitacion(Habitacion habitacion) {
		try {
			Integer response = habitacionDao.updateHabitacion(habitacion);
			return response;
		} catch (Exception e) {
			e.printStackTrace();
			return 500;
		}		
	}
	
	@Override
	public Double calcularPrecioxCama(String tipoHabitacion, Integer numCamas) {
		Double precio = 0.0;
		if(tipoHabitacion.equals(Constants.HABITACION_PRIVADA))
			precio = (double) (Constants.PRECIO_CAMA_PRIVADA * numCamas);
		else
			precio = (double) (Constants.PRECIO_CAMA_COMPARTIDA * numCamas);
		return precio;
	}

	@Override
	public Double getValorHabitacionCamasDisponible() {
		Double valor = 0D;		
		List<Habitacion> habitacionesDisponibles = habitacionDao.getHabitaciones().stream()
				.filter(h -> h.getNumCamas() > 0)
				.collect(Collectors.toList());	
		for(Habitacion h : habitacionesDisponibles) {
			valor += calcularPrecioxCama(h.getTipoHabitacion(), h.getNumCamas());
		}		
		return valor;
	}

	@Override
	public Integer getHabitacionesCamaReservada() {
		Integer response = 0;
		try {
			List<Habitacion> habitaciones = habitacionDao.getHabitaciones();
			List<Reserva> reservas = reservaService.getReservas();
			for(Habitacion h : habitaciones) {
				Reserva reservaUnicaHabitacion = reservas.stream()
						.filter(r -> r.getIdHabitacion() == h.getIdHabitacion())
						.findFirst().get();
				if(reservaUnicaHabitacion != null) {
					response++;
				}
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return response;
	}

}
