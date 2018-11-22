package com.bancosabadell.monitorAmbientes.monitoreo.dto;

import java.util.Date;

public class MONCAmbientesDTO {

	public MONCAmbientesDTO() {
		// TODO Auto-generated constructor stub
	}
	
	private Integer idAmbiente;
	private String nombreAmbiente;
	private String nombreCorto;
	private String descripcionAmbiente;
	private Date fechaInicio;
	private Date fechaFin;
	
	public String getNombreCorto() {
		return nombreCorto;
	}
	public void setNombreCorto(String nombreCorto) {
		this.nombreCorto = nombreCorto;
	}
	public Integer getIdAmbiente() {
		return idAmbiente;
	}
	public void setIdAmbiente(Integer idAmbiente) {
		this.idAmbiente = idAmbiente;
	}
	public String getNombreAmbiente() {
		return nombreAmbiente;
	}
	public void setNombreAmbiente(String nombreAmbiente) {
		this.nombreAmbiente = nombreAmbiente;
	}
	public String getDescripcionAmbiente() {
		return descripcionAmbiente;
	}
	public void setDescripcionAmbiente(String descripcionAmbiente) {
		this.descripcionAmbiente = descripcionAmbiente;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

}
