package com.pds.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.pds.models.Habitacion;
import com.pds.utils.ResponseMessage;

@Repository
public interface IHabitacionDao {
	
	public ResponseMessage saveHabitacion(Habitacion habitacion);
	
	public Integer updateHabitacion(Habitacion habitacion);
	
	public Habitacion getHabitacionById(Integer id);
	
	public List<Habitacion> getHabitaciones();
}
