package com.bancosabadell.monitorAmbientes.monitoreo.dto;

public class DatosPorAmbiente {
	private String nombreAmbiente;
	private int porcentajeDisponibilidad;
	private int bantotalServidor;
	private int bantotalNodo1;
	private int bantotalNodo2;
	private int nodo1;
	private int nodo2;
	
	public String getNombreAmbiente() {
		return nombreAmbiente;
	}
	public void setNombreAmbiente(String nombreAmbiente) {
		this.nombreAmbiente = nombreAmbiente;
	}
	public int getPorcentajeDisponibilidad() {
		return porcentajeDisponibilidad;
	}
	public void setPorcentajeDisponibilidad(int porcentajeDisponibilidad) {
		this.porcentajeDisponibilidad = porcentajeDisponibilidad;
	}
	public int getBantotalServidor() {
		return bantotalServidor;
	}
	public void setBantotalServidor(int bantotalServidor) {
		this.bantotalServidor = bantotalServidor;
	}
	public int getBantotalNodo1() {
		return bantotalNodo1;
	}
	public void setBantotalNodo1(int bantotalNodo1) {
		this.bantotalNodo1 = bantotalNodo1;
	}
	public int getBantotalNodo2() {
		return bantotalNodo2;
	}
	public void setBantotalNodo2(int bantotalNodo2) {
		this.bantotalNodo2 = bantotalNodo2;
	}
	public int getNodo1() {
		return nodo1;
	}
	public void setNodo1(int nodo1) {
		this.nodo1 = nodo1;
	}
	public int getNodo2() {
		return nodo2;
	}
	public void setNodo2(int nodo2) {
		this.nodo2 = nodo2;
	}
}
