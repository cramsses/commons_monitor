package com.bancosabadell.monitorAmbientes.monitoreo.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bancosabadell.monitorAmbientes.monitoreo.dao.NodosyServidoresDAO;
import com.bancosabadell.monitorAmbientes.monitoreo.dto.AmbienteConEstatusDTO;
import com.bancosabadell.monitorAmbientes.monitoreo.dto.NodosyServidoresDTO;
import com.bancosabadell.monitorAmbientes.monitoreo.service.MonitorHttpOnDemandService;

@Service
public class MonitorHttpOnDemandServiceImpl implements MonitorHttpOnDemandService {

	private static final int DOS    = 2;
	private static final int TRES   = 3;
	private static final int CUATRO = 4;
	private static final int CINCO  = 5;
	private static final int SEIS   = 6;
	private static final int DIEZ   = 10;
	private static final Logger LOGGER = Logger.getLogger(MonitorHttpOnDemandServiceImpl.class);

	@Autowired
	private NodosyServidoresDAO nodosyServidoresDAO;

	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRES_NEW, readOnly = true)
	@Override
	public List<AmbienteConEstatusDTO> retrieveEstatusByAmbiente() {

		ExecutorService pool = Executors.newFixedThreadPool(DIEZ);
		Set<Future<AmbienteConEstatusDTO>> set = new HashSet<Future<AmbienteConEstatusDTO>>();
		List<AmbienteConEstatusDTO> lista = new ArrayList<AmbienteConEstatusDTO>();

		for (AmbienteConEstatusDTO objeto : mapearDatosAObjeto()) {
			Callable<AmbienteConEstatusDTO> callable = new MonitorHttpExecutor(objeto);
			Future<AmbienteConEstatusDTO> future = pool.submit(callable);
			set.add(future);
		}
		
		for (Future<AmbienteConEstatusDTO> dato : set) {
			try {
				lista.add(dato.get());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		pool.shutdown();
		return lista;
	}

	private List<AmbienteConEstatusDTO> mapearDatosAObjeto() {
		int i = 1;
		String ambienteActual = null;
		String ambienteAnterior = null;
		List<AmbienteConEstatusDTO> lista = new ArrayList<AmbienteConEstatusDTO>();
		List<NodosyServidoresDTO> listaDatos = nodosyServidoresDAO.obtenerDatos();

		AmbienteConEstatusDTO objetoAmbiente = null;
		for (NodosyServidoresDTO objeto : listaDatos) {
			ambienteActual = objeto.getAmbiente();
			if (i == 1) {
				objetoAmbiente = new AmbienteConEstatusDTO();
				objetoAmbiente.setIdAmbiente(objeto.getIdAmbiente().toString());
				objetoAmbiente.setNombreAmbiente(objeto.getNombreCorto());
				objetoAmbiente.setNodo1(objeto.getNodo());
				objetoAmbiente.setBantotalNodo1(objeto.getDireccion());
				ambienteAnterior = ambienteActual;

			} else if (i == DOS && ambienteActual.compareTo(ambienteAnterior) == 0) {
				if (objeto.getAmbiente().compareTo("GOS") != 0) {
					objetoAmbiente.setNodo2(objeto.getNodo());
					objetoAmbiente.setBantotalNodo2(objeto.getDireccion());
				} else {
					
					objetoAmbiente.setSofomNodo1(objeto.getDireccion());
				}

			} else if (i == TRES && ambienteActual.compareTo(ambienteAnterior) == 0) {
				objetoAmbiente.setBantotal(objeto.getDireccion());

			} else if (i == CUATRO && ambienteActual.compareTo(ambienteAnterior) == 0) {
				objetoAmbiente.setSofomNodo1(objeto.getDireccion());

			} else if (i == CINCO && ambienteActual.compareTo(ambienteAnterior) == 0) {
				objetoAmbiente.setSofomNodo2(objeto.getDireccion());

			} else if (i == SEIS && ambienteActual.compareTo(ambienteAnterior) == 0) {
				objetoAmbiente.setSofom(objeto.getDireccion());
			}
			i++;

			if (ambienteActual.compareTo(ambienteAnterior) != 0) {
				lista.add(objetoAmbiente);
				i = 1;
				objetoAmbiente = new AmbienteConEstatusDTO();
				objetoAmbiente.setIdAmbiente(objeto.getIdAmbiente().toString());
				objetoAmbiente.setNombreAmbiente(objeto.getNombreCorto());
				objetoAmbiente.setNodo1(objeto.getNodo());
				objetoAmbiente.setBantotalNodo1(objeto.getDireccion());
				ambienteAnterior = ambienteActual;
				i++;
			}
			ambienteAnterior = ambienteActual;
		}
		lista.add(objetoAmbiente);

		for (AmbienteConEstatusDTO objeto : lista) {
			LOGGER.info(objeto);
		}
		return lista;
	}
}