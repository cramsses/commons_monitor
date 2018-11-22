package com.bancosabadell.monitorAmbientes.monitoreo.controller;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bancosabadell.monitorAmbientes.exceptions.DataNotFoundException;
import com.bancosabadell.monitorAmbientes.monitoreo.dto.AmbienteConEstatusDTO;
import com.bancosabadell.monitorAmbientes.monitoreo.dto.CaidasAmbienteDTO;
import com.bancosabadell.monitorAmbientes.monitoreo.dto.DisponibiliadAmbientesDTO;
import com.bancosabadell.monitorAmbientes.monitoreo.dto.DisponibilidadDetalleListsDTO;
import com.bancosabadell.monitorAmbientes.monitoreo.dto.TiempoRespuestaAmbienteDTO;
import com.bancosabadell.monitorAmbientes.monitoreo.service.CaidasAmbienteService;
import com.bancosabadell.monitorAmbientes.monitoreo.service.DisponibiliadAmbientesService;
import com.bancosabadell.monitorAmbientes.monitoreo.service.DisponibilidadDetalleService;
import com.bancosabadell.monitorAmbientes.monitoreo.service.MonitorHttpOnDemandService;
import com.bancosabadell.monitorAmbientes.monitoreo.service.TiemposRespuestaAmbienteService;


/**
 * Expone la funcionalidad del Web Service. Entre las cuales se encuentran:
 *  - Calcular los tiempos de respuesta por ambiente.
 *  - Obtener el n&uacute;mero de caidas registradas por d&iacute;a.
 *  - Verificar el porcentaje de disponibilidad de los servidores.
 *  - Verificar la disponibilidad de los ambientes.
 *  
 *  @author Jesus Alfredo Hernandez Orozco
 *  @author Edgar Ramsses Solis Hernandez
 */
@RestController
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@RequestMapping("/MonitorController")
public class MonitorController {
	
	@Autowired
	private MonitorHttpOnDemandService monitorHttpOnDemandService;
	
	@Autowired
	private DisponibiliadAmbientesService disponibiliadAmbientesService;
	
	@Autowired
	private TiemposRespuestaAmbienteService tiemposRespuestaAmbienteService;
	
	@Autowired
	private CaidasAmbienteService caidasAmbienteService;
	
	@Autowired
	private DisponibilidadDetalleService disponibilidadDetalleService;
	
	private static final String DESCRIPCION_EXCEPCION = "No se encuentra información registrada";
	private static final Logger LOGGER = Logger.getLogger(MonitorController.class);
	
	/**
	 * Revisa si los ambientes se encuentran caidos o no (para los nodos, las URL de Bantotal y SOFOM)
	 * 
	 * @return Listado de ambientes y sus estados.
	 */
	@CrossOrigin
	@RequestMapping(path="/ambientes",method=RequestMethod.GET)
	public List<AmbienteConEstatusDTO> retrieveAmbientesEstatus(){
		List<AmbienteConEstatusDTO> lista = monitorHttpOnDemandService.retrieveEstatusByAmbiente();
		LOGGER.info("JAHO - Tamanio de la lista retrieveAmbientesEstatus()"+lista.size());
		if(lista.isEmpty() || lista == null) {
			throw new DataNotFoundException(DESCRIPCION_EXCEPCION);
		}
		Collections.sort(lista);
		return lista;
		
	}

	/**
	 * Retorna una lista del porcentaje de disponibilidad de cada uno de los ambientes.
	 * 
	 * @return lista de disponibilidad de cada uno de los ambientes.
	 */
	@CrossOrigin
	@RequestMapping(path="/disponibilidad",method=RequestMethod.GET)
	public List<DisponibiliadAmbientesDTO> obtenerDisponibilidad(){
		List<DisponibiliadAmbientesDTO> lista = disponibiliadAmbientesService.obtenerDisponibilidad();
		LOGGER.info("JAHO - Tamanio de la lista obtenerDisponibilidad()"+lista.size());
		if(lista.isEmpty() || lista == null) {
			throw new DataNotFoundException(DESCRIPCION_EXCEPCION);
		}
		return lista;
	}
	
	/**
	 * Muestra una lista del tiempo que tarda en responder cada ambiente por hora.
	 * 
	 * @return Lista de tiempo de respuesta por ambiente.
	 */
	@CrossOrigin
	@RequestMapping(path="/tiempos",method=RequestMethod.GET)
	public List<TiempoRespuestaAmbienteDTO> obtenerTiempos(){
		List<TiempoRespuestaAmbienteDTO> lista = tiemposRespuestaAmbienteService.obtenerTiempos();
		LOGGER.info("JAHO - Tamanio de la lista obtenerTiempos()"+lista.size());
		if(lista.isEmpty() || lista == null) {
			throw new DataNotFoundException(DESCRIPCION_EXCEPCION);
		}
		return lista;
	}
	
	/**
	 * Retorna una lista del n&uacute;mero de caidas de cada ambiente por hora.
	 * 
	 * @return Lista del n&uacute;mero de caidas de cada ambiente por hora.
	 */
	@CrossOrigin
	@RequestMapping(path="/caidas",method=RequestMethod.GET)
	public List<CaidasAmbienteDTO> obtenerCaidas(){
		List<CaidasAmbienteDTO> lista = caidasAmbienteService.obtenerCaidas();
		LOGGER.info("JAHO - Tamanio de la lista obtenerCaidas()"+lista.size());
		if(lista.isEmpty() || lista == null) {
			throw new DataNotFoundException(DESCRIPCION_EXCEPCION);
		}
		return lista;
	}
	@CrossOrigin
	@RequestMapping(path="/disponibilidadDetalle",method=RequestMethod.GET)
	public DisponibilidadDetalleListsDTO obtenerDetalleDisponibilidad() {
		return disponibilidadDetalleService.obtenerDetalleDisponibilidad();
	}
}
