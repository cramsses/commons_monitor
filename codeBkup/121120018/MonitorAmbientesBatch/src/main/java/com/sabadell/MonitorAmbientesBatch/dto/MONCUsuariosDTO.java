package com.sabadell.MonitorAmbientesBatch.dto;

import java.util.Date;

public class MONCUsuariosDTO {

	public MONCUsuariosDTO() {
		// TODO Auto-generated constructor stub
	}
	
	private String cveUsuario;
	private String nombre;
	private String correo;
	private Date fechaInicio;
	private Date fechaFin;
	
	public String getCveUsuario() {
		return cveUsuario;
	}
	public void setCveUsuario(String cveUsuario) {
		this.cveUsuario = cveUsuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
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
		return "MONC_UsuariosDTO [cveUsuario=" + cveUsuario + ", nombre=" + nombre + ", correo=" + correo
				+ ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + "]";
	}
}
