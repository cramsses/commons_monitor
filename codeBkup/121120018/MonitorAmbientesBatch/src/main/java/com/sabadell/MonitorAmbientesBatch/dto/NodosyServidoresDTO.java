package com.sabadell.MonitorAmbientesBatch.dto;

public class NodosyServidoresDTO {

	private Integer idServidor;
	private String ambiente;
	private String nodo;
	private String direccion;
	private String app;
	
	public Integer getIdServidor() {
		return idServidor;
	}
	public void setIdServidor(Integer idServidor) {
		this.idServidor = idServidor;
	}
	public String getAmbiente() {
		return ambiente;
	}
	public void setAmbiente(String ambiente) {
		this.ambiente = ambiente;
	}
	public String getNodo() {
		return nodo;
	}
	public void setNodo(String nodo) {
		this.nodo = nodo;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getApp() {
		return app;
	}
	public void setApp(String app) {
		this.app = app;
	}
	
	@Override
	public String toString() {
		return "NodosyServidoresDTO [ambiente=" + ambiente + ", nodo=" + nodo + ", direccion=" + direccion + ", app="
				+ app + "]";
	}
}
