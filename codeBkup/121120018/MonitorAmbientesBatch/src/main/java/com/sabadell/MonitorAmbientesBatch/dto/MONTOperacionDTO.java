package com.sabadell.MonitorAmbientesBatch.dto;

import java.util.Date;

public class MONTOperacionDTO {

	public MONTOperacionDTO() {
		// TODO Auto-generated constructor stub
	}
	
	private Integer idOperacion;
	private Integer idServidor;//MONAServidoresDTO monaServidoresDTO;//private Integer idServidor;
	private Integer idEstatus;
	private Date fecha;
	private Double tiempoRespuesta;
	
	private String descripcionServidor;
	
	
	public String getDescripcionServidor() {
		return descripcionServidor;
	}
	public void setDescripcionServidor(String descripcionServidor) {
		this.descripcionServidor = descripcionServidor;
	}
	public Integer getIdOperacion() {
		return idOperacion;
	}
	public void setIdOperacion(Integer idOperacion) {
		this.idOperacion = idOperacion;
	}
	
	public Integer getIdServidor() {
		return idServidor;
	}
	public void setIdServidor(Integer idServidor) {
		this.idServidor = idServidor;
	}
	public Integer getIdEstatus() {
		return idEstatus;
	}
	public void setIdEstatus(Integer idEstatus) {
		this.idEstatus = idEstatus;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Double getTiempoRespuesta() {
		return tiempoRespuesta;
	}
	public void setTiempoRespuesta(Double tiempoRespuesta) {
		this.tiempoRespuesta = tiempoRespuesta;
	}
	@Override
	public String toString() {
		return "MONTOperacionDTO [idOperacion=" + idOperacion + ", idServidor=" + idServidor + ", idEstatus="
				+ idEstatus + ", fecha=" + fecha + ", tiempoRespuesta=" + tiempoRespuesta + "]";
	}


}
