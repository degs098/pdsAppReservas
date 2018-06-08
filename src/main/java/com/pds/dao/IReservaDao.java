package com.pds.dao;

import org.springframework.stereotype.Repository;

import com.pds.models.Reserva;
import com.pds.utils.ResponseMessage;

@Repository
public interface IReservaDao {

	public ResponseMessage saveReserva(Reserva reserva);
}
