package com.bancosabadell.monitorAmbientes.catalogos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bancosabadell.monitorAmbientes.catalogos.service.MONCAmbientesService;
import com.bancosabadell.monitorAmbientes.exceptions.DataNotFoundException;
import com.bancosabadell.monitorAmbientes.monitoreo.dto.MONCAmbientesDTO;

/**
 * Servicio que maneja todas las solicitudes relacionadas con los cat&aacute;logos de ambientes.
 * 
 * @author Jesus Alfredo Hernandez Orozco
 *
 */
@RestController
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@RequestMapping("/catalogosController")
public class CatalogosController {

	@Autowired
	private MONCAmbientesService moncAmbientesService;
	
	/**
	 * Obtiene todos los ambientes registrados en BD con fecha diferente de null.
	 * 
	 * @return Lista de ambientes activos en BD.
	 */
	@CrossOrigin
	@RequestMapping(path="/ambientes",method=RequestMethod.GET)
	public List<MONCAmbientesDTO> retrieveAmbientesEstatus(){
		List<MONCAmbientesDTO> lista = moncAmbientesService.obtenerAmbientes();
		if(lista.isEmpty() ||  lista == null) {
			throw new DataNotFoundException("No se encontraron datos registrados");
		}
		return moncAmbientesService.obtenerAmbientes();
	}

}
