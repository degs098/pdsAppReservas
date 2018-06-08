package com.pds.models;

public class Reserva {
	
	private Integer idReserva;
	private Integer idHabitacion;
	private Integer numCamas;
	private Double precioxCama;
	
	public Reserva() {
	
	}

	public Reserva(Integer idReserva, Integer idHabitacion, Integer numCamas, Double precioxCama) {
		super();
		this.idReserva = idReserva;
		this.idHabitacion = idHabitacion;
		this.numCamas = numCamas;
		this.precioxCama = precioxCama;
	}
	
	public Integer getIdReserva() {
		return idReserva;
	}
	public void setIdReserva(Integer idReserva) {
		this.idReserva = idReserva;
	}
	public Integer getIdHabitacion() {
		return idHabitacion;
	}
	public void setIdHabitacion(Integer idHabitacion) {
		this.idHabitacion = idHabitacion;
	}
	public Integer getNumCamas() {
		return numCamas;
	}
	public void setNumCamas(Integer numCamas) {
		this.numCamas = numCamas;
	}
	public Double getPrecioxCama() {
		return precioxCama;
	}
	public void setPrecioxCama(Double precioxCama) {
		this.precioxCama = precioxCama;
	}
	
	
	
	

}
