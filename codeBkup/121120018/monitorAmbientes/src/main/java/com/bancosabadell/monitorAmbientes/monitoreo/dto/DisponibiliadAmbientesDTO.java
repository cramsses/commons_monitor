package com.bancosabadell.monitorAmbientes.monitoreo.dto;

public class DisponibiliadAmbientesDTO {

	private String ambiente;
	private float disponibilidad;
	
	public String getAmbiente() {
		return ambiente;
	}
	public void setAmbiente(String ambiente) {
		this.ambiente = ambiente;
	}
	public float getDisponibilidad() {
		return disponibilidad;
	}
	public void setDisponibilidad(float disponibilidad) {
		this.disponibilidad = disponibilidad;
	}
}
