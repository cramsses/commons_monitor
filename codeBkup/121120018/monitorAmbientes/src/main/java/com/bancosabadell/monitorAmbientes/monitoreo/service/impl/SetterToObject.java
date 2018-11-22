package com.bancosabadell.monitorAmbientes.monitoreo.service.impl;

import java.util.concurrent.Callable;

import com.bancosabadell.monitorAmbientes.monitoreo.dto.AmbienteConEstatusDTO;
import com.bancosabadell.monitorAmbientes.utils.Utils;

public class SetterToObject  implements Callable<AmbienteConEstatusDTO> {

	
	private String url;
	private int bandera;
	private String campo;
	private AmbienteConEstatusDTO objeto;
	
	private static final String OK    = "OK";
	private static final String CAIDO = "Caído";
	private static final String NO_APLICA ="N/A";
	
	public SetterToObject(AmbienteConEstatusDTO objeto, String url, int bandera, String campo) {
		this.url = url;
		this.objeto = objeto;
		this.bandera = bandera;
		this.campo = campo;
	}
	
	@Override
	public AmbienteConEstatusDTO call() throws Exception {
		return asignarValores(this.campo);
		
	}
	
	private AmbienteConEstatusDTO asignarValores (String campo) throws InstantiationException, IllegalAccessException  {
	    Class<?> clase;	
		try {
			clase = Class.forName("com.bancosabadell.monitorAmbientes.monitoreo.dto.AmbienteConEstatusDTO");
			clase.getDeclaredField(campo).set(this.objeto, asignarValorACampo());
			
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return this.objeto;
	}
	
	private String asignarValorACampo() {	
		String resultado = null;
		if(url != null) {
			if (bandera==0) {
				resultado = Utils.hacerPing(url)?OK:CAIDO;
			} else if (bandera==1) {
				resultado = Utils.validarEstatusURL(url)==Utils.OK_STATUS?OK:CAIDO;
			}
		}else {
			resultado=NO_APLICA;
		}
		
		return resultado;
	}
}
