package com.bancosabadell.monitorAmbientes.monitoreo.dto;

public class DisponibilidadDetalleDTO {
	
	private String nombre;
	private float disponibilidadRequerida;
	private float disponibilidadReal;
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public float getDisponibilidadRequerida() {
		return disponibilidadRequerida;
	}
	public void setDisponibilidadRequerida(float disponibilidadRequerida) {
		this.disponibilidadRequerida = disponibilidadRequerida;
	}
	
	public float getDisponibilidadReal() {
		return disponibilidadReal;
	}
	public void setDisponibilidadReal(float disponibilidadReal) {
		this.disponibilidadReal = disponibilidadReal;
	}
	
	
	
	

}
