package com.pds.models;

public class Habitacion {
	
	private Integer idHabitacion;
	private String tipoHabitacion;
	private Integer numCamas;
	
	public Habitacion() {
		
	}
	
	public Habitacion(Integer idHabitacion, String tipoHabitacion, Integer numCamas) {		
		this.idHabitacion = idHabitacion;
		this.tipoHabitacion = tipoHabitacion;
		this.numCamas = numCamas;
	}
	public Integer getIdHabitacion() {
		return idHabitacion;
	}
	public void setIdHabitacion(Integer idHabitacion) {
		this.idHabitacion = idHabitacion;
	}
	public String getTipoHabitacion() {
		return tipoHabitacion;
	}
	public void setTipoHabitacion(String tipoHabitacion) {
		this.tipoHabitacion = tipoHabitacion;
	}
	public Integer getNumCamas() {
		return numCamas;
	}
	public void setNumCamas(Integer numCamas) {
		this.numCamas = numCamas;
	}
	
	

}
