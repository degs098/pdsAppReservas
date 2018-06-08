package com.pds.services;

import org.springframework.stereotype.Service;

import com.pds.models.Habitacion;
import com.pds.utils.ResponseMessage;

@Service
public interface IHabitacionService {

	public ResponseMessage saveHabitacion(Habitacion habitacion);
	
	public Habitacion getHabitacionById(Integer id);
	
	public Integer updateHabitacion(Habitacion habitacion);
	
	public Double calcularPrecioxCama(String tipoHabitacion, Integer numCamas);
	
	public Double getValorHabitacionCamasDisponible();
	
	public Integer getHabitacionesCamaReservada();
}
