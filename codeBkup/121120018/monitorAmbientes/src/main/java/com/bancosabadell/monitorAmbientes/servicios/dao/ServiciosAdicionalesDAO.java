package com.bancosabadell.monitorAmbientes.servicios.dao;

import java.util.Date;

/**
 * Obtiene distintos valores de la base de datos.
 * 
 * @author Jesus Alfredo Hernandez Orozco.
 *
 */
public interface ServiciosAdicionalesDAO {
	
	/**
	 * Obtiene la hora de la base de datos.
	 */
	Date obtenerHoraDelSistema();
}
