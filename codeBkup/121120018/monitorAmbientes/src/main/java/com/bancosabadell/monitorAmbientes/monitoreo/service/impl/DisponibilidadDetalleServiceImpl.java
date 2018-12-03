package com.bancosabadell.monitorAmbientes.monitoreo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bancosabadell.monitorAmbientes.monitoreo.dao.DisponibilidadDetalleDAO;
import com.bancosabadell.monitorAmbientes.monitoreo.dto.DisponibilidadDetalleListsDTO;
import com.bancosabadell.monitorAmbientes.monitoreo.service.DisponibilidadDetalleService;

@Service
public class DisponibilidadDetalleServiceImpl implements DisponibilidadDetalleService {

	@Autowired
	private DisponibilidadDetalleDAO disponibilidadDetalleDAO;

	@Override
	public DisponibilidadDetalleListsDTO obtenerDetalleDisponibilidad() {
		DisponibilidadDetalleListsDTO objetoDetalle = new DisponibilidadDetalleListsDTO();
		objetoDetalle.setListaNodos(disponibilidadDetalleDAO
				.obtenerDisponibilidadDetalle(DisponibilidadDetalleDAO.QRY1_DISPONIBILIDAD_DETALLE));
		objetoDetalle.setListaAmbientes(disponibilidadDetalleDAO
				.obtenerDisponibilidadDetalle(DisponibilidadDetalleDAO.QRY2_DISPONIBILIDAD_DETALLE));
		objetoDetalle.setListaBaseDatos(disponibilidadDetalleDAO
				.obtenerDisponibilidadDetalle(DisponibilidadDetalleDAO.QRY3_DISPONIBILIDAD_DETALLE));
		objetoDetalle.setListaAplicaciones(disponibilidadDetalleDAO
				.obtenerDisponibilidadDetalle(DisponibilidadDetalleDAO.QRY4_DISPONIBILIDAD_DETALLE));
		return objetoDetalle;
	}

}
