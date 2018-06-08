package com.pds.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pds.dummys.HabitacionesDummy;
import com.pds.models.Habitacion;
import com.pds.services.IHabitacionService;
import com.pds.utils.ResponseMessage;
import com.pds.utils.Constants;

@Repository
public class HabitacionDao implements IHabitacionDao{
	
	@Autowired
	IHabitacionService habitacionService;

	@Override
	public ResponseMessage saveHabitacion(Habitacion habitacion) {
		ResponseMessage response = new ResponseMessage();
		List<Habitacion> habitaciones = HabitacionesDummy.getHabitaciones();
		try {
			habitacion.setIdHabitacion(habitaciones.size() + 1);
			habitaciones.add(habitacion);
			HabitacionesDummy.setHabitaciones(habitaciones);
			response.setMessage(Constants.successInsertResponse);
			response.setStatus(200);
		} catch (Exception e) {
			e.printStackTrace();
			response.setMessage(Constants.errorInsertResponse);
			response.setStatus(-1);
		}
		return response;
	}

	@Override
	public Habitacion getHabitacionById(Integer id) {
		Habitacion habitacion = new Habitacion();
		try {
			List<Habitacion> habitaciones = HabitacionesDummy.getHabitaciones();
			habitacion = habitaciones.stream().filter(h -> h.getIdHabitacion() == id).findFirst().get();
			return habitacion;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Integer updateHabitacion(Habitacion habitacion) {		
		try {
			List<Habitacion> habitaciones = HabitacionesDummy.getHabitaciones();
			Habitacion habitacionExist = getHabitacionById(habitacion.getIdHabitacion());
			if(habitacionExist != null) {
				Integer index = habitaciones.indexOf(habitacionExist);
				habitaciones.set(index, habitacion);
				HabitacionesDummy.setHabitaciones(habitaciones);
				return 200;
			}else {
				return -1;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return 500;
		}		
	}

	@Override
	public List<Habitacion> getHabitaciones() {		
		return HabitacionesDummy.getHabitaciones();
	}

	
	
}
