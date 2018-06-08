package com.pds.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pds.dao.IReservaDao;
import com.pds.dummys.ReservasDummy;
import com.pds.models.Habitacion;
import com.pds.models.Reserva;
import com.pds.utils.Constants;
import com.pds.utils.ResponseMessage;

@Service
public class ReservaService implements IReservaService{

	@Autowired
	IReservaDao reservaDao;
	
	@Autowired
	IHabitacionService habitacionService;

	@Override
	public ResponseMessage saveReserva(Reserva reserva) {
		ResponseMessage response = new ResponseMessage();
		try {
			Habitacion habitacion = habitacionService.getHabitacionById(reserva.getIdHabitacion());
			if(habitacion != null) {
				if(reserva.getNumCamas() <= habitacion.getNumCamas() && reserva.getNumCamas() > 0) {
					if(habitacion.getTipoHabitacion().equals(Constants.HABITACION_PRIVADA))
						reserva.setNumCamas(Constants.MAX_CAMAS_PRIVADA); 					
					Double precio = habitacionService.calcularPrecioxCama(habitacion.getTipoHabitacion(), reserva.getNumCamas());
					reserva.setPrecioxCama(precio);					
					habitacion.setNumCamas(habitacion.getNumCamas() - reserva.getNumCamas());
					Integer updateHabitacion = habitacionService.updateHabitacion(habitacion);
					if(updateHabitacion.intValue() == 200) {
						response = reservaDao.saveReserva(reserva);
					}else {
						response.setMessage(Constants.errorUpdateResponse);
						response.setStatus(-1);
					}
				}else {
					if(reserva.getNumCamas() == 0) {
						response.setMessage(Constants.errorNumCamasInvalido);
						response.setStatus(-1);
					}else {
						response.setMessage(Constants.errorSinDisponibilidad);
						response.setStatus(-1);
					}					
				}
			}else {
				response.setMessage(Constants.habitacionNoExiste);
				response.setStatus(-1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.setMessage(Constants.errorInsertResponse);
			response.setStatus(500);
		}		
		return response;
	}

	@Override
	public List<Reserva> getReservas() {		
		return ReservasDummy.getReservas();
	}	
}
