package com.sabadell.MonitorAmbientesBatch.dto;

import java.util.Date;

public class MONAServidoresDTO {
	
	private Integer idServidor;
	private Integer idNodo;
	private Integer iIdUrl;
	private Integer idTipoServ;
	private String descripcionServidor;
	private Integer idAmbiente;
	private Date fechaInicio;
	private Date fechaFin;
	
	
	
	public MONAServidoresDTO() {
		super();
	}
	
	public MONAServidoresDTO(Integer idServidor) {
		super();
		this.idServidor = idServidor;
	}
	public Integer getIdServidor() {
		return idServidor;
	}
	public void setIdServidor(Integer idServidor) {
		this.idServidor = idServidor;
	}
	public Integer getIdNodo() {
		return idNodo;
	}
	public void setIdNodo(Integer idNodo) {
		this.idNodo = idNodo;
	}
	public Integer getiIdUrl() {
		return iIdUrl;
	}
	public void setiIdUrl(Integer iIdUrl) {
		this.iIdUrl = iIdUrl;
	}
	public Integer getIdTipoServ() {
		return idTipoServ;
	}
	public void setIdTipoServ(Integer idTipoServ) {
		this.idTipoServ = idTipoServ;
	}
	public String getDescripcionServidor() {
		return descripcionServidor;
	}
	public void setDescripcionServidor(String descripcionServidor) {
		this.descripcionServidor = descripcionServidor;
	}
	public Integer getIdAmbiente() {
		return idAmbiente;
	}
	public void setIdAmbiente(Integer idAmbiente) {
		this.idAmbiente = idAmbiente;
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
	@Override
	public String toString() {
		return "MONAServidoresDTO [idServidor=" + idServidor + ", idNodo=" + idNodo + ", iIdUrl=" + iIdUrl
				+ ", idTipoServ=" + idTipoServ + ", descripcionServidor=" + descripcionServidor + ", idAmbiente="
				+ idAmbiente + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + "]";
	}
	
	

}
