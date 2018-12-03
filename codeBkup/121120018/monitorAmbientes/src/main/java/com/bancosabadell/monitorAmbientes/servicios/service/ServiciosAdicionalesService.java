package com.bancosabadell.monitorAmbientes.servicios.service;

import java.text.ParseException;

/**
 * Servicio que se utiliza para obtener distintos valores del sistema.
 * 
 * @author Jesus Alfredo Hernandez Orozco
 *
 */
public interface ServiciosAdicionalesService {

	/**
	 * Obtiene la hora del sistema y le asigna un formato retornandola como String
	 * @param formatoDeFecha Formato de fecha a utilizar
	 * @return String de la fecha con el formato solicitado.
	 */
	String obtenerHoraDelSistema(String formatoDeHora) throws ParseException;
}
