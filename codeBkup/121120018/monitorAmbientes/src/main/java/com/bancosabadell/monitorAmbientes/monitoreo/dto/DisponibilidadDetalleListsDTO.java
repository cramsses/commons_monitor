package com.bancosabadell.monitorAmbientes.monitoreo.dto;

import java.util.List;

public class DisponibilidadDetalleListsDTO {
	
	private List<DisponibilidadDetalleDTO> listaNodos;
	private List<DisponibilidadDetalleDTO> listaAmbientes;
	private List<DisponibilidadDetalleDTO> listaBaseDatos;
	private List<DisponibilidadDetalleDTO> listaAplicaciones;
	
	
	public List<DisponibilidadDetalleDTO> getListaNodos() {
		return listaNodos;
	}
	public void setListaNodos(List<DisponibilidadDetalleDTO> listaNodos) {
		this.listaNodos = listaNodos;
	}
	public List<DisponibilidadDetalleDTO> getListaAmbientes() {
		return listaAmbientes;
	}
	public void setListaAmbientes(List<DisponibilidadDetalleDTO> listaAmbientes) {
		this.listaAmbientes = listaAmbientes;
	}
	public List<DisponibilidadDetalleDTO> getListaBaseDatos() {
		return listaBaseDatos;
	}
	public void setListaBaseDatos(List<DisponibilidadDetalleDTO> listaBaseDatos) {
		this.listaBaseDatos = listaBaseDatos;
	}
	public List<DisponibilidadDetalleDTO> getListaAplicaciones() {
		return listaAplicaciones;
	}
	public void setListaAplicaciones(List<DisponibilidadDetalleDTO> listaAplicaciones) {
		this.listaAplicaciones = listaAplicaciones;
	}
	
	
	

}
