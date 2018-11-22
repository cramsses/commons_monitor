package com.bancosabadell.monitorAmbientes.monitoreo.dto;

public class NodosyServidoresDTO {
	private Integer idAmbiente;
	private String ambiente;
	private String nombreCorto;
	private String nodo;
	private String direccion;
	private String app;
	
	public Integer getIdAmbiente() {
		return idAmbiente;
	}
	public void setIdAmbiente(Integer idAmbiente) {
		this.idAmbiente = idAmbiente;
	}
	public String getAmbiente() {
		return ambiente;
	}
	public void setAmbiente(String ambiente) {
		this.ambiente = ambiente;
	}
	
	public String getNombreCorto() {
		return nombreCorto;
	}
	public void setNombreCorto(String nombreCorto) {
		this.nombreCorto = nombreCorto;
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
		return "NodosyServidoresDTO [ambiente=" + ambiente + "nombreCorto="+nombreCorto+", nodo=" + nodo + ", direccion=" + direccion + ", app="
				+ app + "]";
	}
}
