package com.bancosabadell.monitorAmbientes.servicios.service.impl;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.bancosabadell.monitorAmbientes.servicios.dao.ServiciosAdicionalesDAO;
import com.bancosabadell.monitorAmbientes.servicios.service.ServiciosAdicionalesService;
import com.bancosabadell.monitorAmbientes.utils.Utils;

/**
 * Servicio que se utiliza para obtener distintos valores del sistema.
 * 
 * @author Jesus Alfredo Hernandez Orozco
 *
 */
@Service
public class ServiciosAdicionalesServiceImpl implements ServiciosAdicionalesService {

	public ServiciosAdicionalesServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	private ServiciosAdicionalesDAO serviciosAdicionalesDAO;

	/**
	 * Obtiene la hora del sistema y le asigna un formato retornandola como String
	 * @param formatoDeFecha Formato de fecha a utilizar
	 * @return String de la fecha con el formato solicitado.
	 * @throws ParseException 
	 */
	@Override
	@Transactional(isolation = Isolation.DEFAULT, readOnly = true)
	public String obtenerHoraDelSistema(String formatoDeFecha) throws ParseException {
		return Utils.darFormatoFecha(formatoDeFecha, serviciosAdicionalesDAO.obtenerHoraDelSistema());
	}

}
