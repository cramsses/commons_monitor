package com.bancosabadell.monitorAmbientes.servicios.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bancosabadell.monitorAmbientes.exceptions.BadRequestException;
import com.bancosabadell.monitorAmbientes.exceptions.DataNotFoundException;
import com.bancosabadell.monitorAmbientes.servicios.service.ServiciosAdicionalesService;

/**
 * Servicio que entrega datos adicionales a los cat&aacute;logos y datos de monitoreo.
 * 
 * @author Jesus Alfredo Hernandez Orozco.
 *
 */
@RestController
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@RequestMapping("/ServiciosAdicionales")
public class ServiciosAdicionales {

	public ServiciosAdicionales() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired 
	private ServiciosAdicionalesService serviciosAdicionalesService;
	
	/**
	 * Obtiene la hora del sistema y le asigna un formato retornandola como String
	 * @param formatoDeFecha Formato de fecha a utilizar
	 * @return String de la fecha con el formato solicitado.
	 */
	@CrossOrigin
	@GetMapping(path="/hora/{formatoDeFecha}")
	public String obtenerHoraDelSistemaConFormato(@Valid @PathVariable String formatoDeFecha) {
		
		String hora = null;
		if (formatoDeFecha == null) {
			throw new BadRequestException("No se tiene formato de entrada");
		} else {
			try {
				hora=serviciosAdicionalesService.obtenerHoraDelSistema(formatoDeFecha);
			} catch (Exception e) {
				throw new BadRequestException("Formato de hora no válido. ");
			}
		}
		if(hora == null) {
			throw new DataNotFoundException("Hubo un problema al obtener la hora de BD");
		}
		return hora;
	}

}
