package com.bancosabadell.monitorAmbientes.monitoreo.service.impl;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.bancosabadell.monitorAmbientes.monitoreo.dto.AmbienteConEstatusDTO;

public class MonitorHttpExecutor  implements Callable<AmbienteConEstatusDTO> {
	
	public MonitorHttpExecutor () {
		super();
	}
	
	private static final int OCHO = 8;
	
	private AmbienteConEstatusDTO dato;
	
	MonitorHttpExecutor(AmbienteConEstatusDTO dato) {
          this.dato=dato;           
    }          

	@Override
	public AmbienteConEstatusDTO call() throws Exception {
		AmbienteConEstatusDTO ambEst = new AmbienteConEstatusDTO();		
		ExecutorService pool = Executors.newFixedThreadPool(OCHO);
		Set<Future<AmbienteConEstatusDTO>> set = new HashSet<Future<AmbienteConEstatusDTO>>();
		
		Method metodo = null;
		String nodo = null;
		for (String campo : obtenerListaDeCampos()) {
			metodo=dato.getClass().getMethod("get"+capitalizar(campo), null);
			nodo=(String) metodo.invoke(dato, null);
			Callable<AmbienteConEstatusDTO> callable = new SetterToObject(ambEst, nodo,campo.contains("nodo")?0:1, campo);
			Future<AmbienteConEstatusDTO> future = pool.submit(callable);
			set.add(future);
		}
		
		for (Future<AmbienteConEstatusDTO> dato : set) {
			try {
				ambEst=dato.get();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		ambEst.setNombreAmbiente(this.dato.getNombreAmbiente());
		ambEst.setIdAmbiente(this.dato.getIdAmbiente());
		
		System.out.println("JAHO - Ambiente: "+dato);
		pool.shutdown();
		
		return ambEst;
	}
	
	
	public List<String> obtenerListaDeCampos() throws NoSuchMethodException, SecurityException {		
		List<String> lista = new ArrayList<>();
		try {
			Class<?> clase = Class.forName("com.bancosabadell.monitorAmbientes.monitoreo.dto.AmbienteConEstatusDTO");
			for (Field campo: clase.getDeclaredFields()) {
				lista.add(campo.getName());
			}
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	private String capitalizar(String line) {
	   return Character.toUpperCase(line.charAt(0)) + line.substring(1);
	}
}
