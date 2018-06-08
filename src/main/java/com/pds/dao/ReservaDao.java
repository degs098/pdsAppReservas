package com.pds.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.pds.dummys.ReservasDummy;
import com.pds.models.Reserva;
import com.pds.utils.ResponseMessage;
import com.pds.utils.Constants;

@Repository
public class ReservaDao implements IReservaDao{

	@Override
	public ResponseMessage saveReserva(Reserva reserva) {
		ResponseMessage response = new ResponseMessage();
		List<Reserva> reservas = ReservasDummy.getReservas();
		try {
			reserva.setIdReserva(reservas.size() + 1);
			reservas.add(reserva);
			response.setMessage(Constants.successInsertResponse);
			response.setStatus(200);
		} catch (Exception e) {
			e.printStackTrace();
			response.setMessage(Constants.errorInsertResponse);
			response.setStatus(-1);
		}
		return response;		
	}

}
