package com.bancosabadell.monitorAmbientes.monitoreo.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bancosabadell.monitorAmbientes.monitoreo.service.CalendarizadorService;
import com.bancosabadell.monitorAmbientes.monitoreo.service.MonitorHttpService;

/**
 * Servicio que se encarga de calendarizar la revisi&oacute;n de los ambientes y servidores.
 * Banco Sabadell M&eacute;xico.
 * 
 * @author Jes&uacute;s Alfredo Hern&aacute;ndez Orozco
 *
 */
@Service
public class CalendarizadorServiceImpl implements CalendarizadorService {
	
	private static final Logger LOGGER = Logger.getLogger(CalendarizadorServiceImpl.class);

	@Autowired
	private MonitorHttpService monitorHttpService;
	
	@Override
	public void ejecutarProceso() {
		LOGGER.info("JAHO - Tiempo de respuesta: "+monitorHttpService.contarTiempoDeRespuesta());
	}
}
