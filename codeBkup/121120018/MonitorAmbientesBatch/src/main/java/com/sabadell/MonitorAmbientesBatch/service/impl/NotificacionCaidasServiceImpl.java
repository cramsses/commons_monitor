package com.sabadell.MonitorAmbientesBatch.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sabadell.MonitorAmbientesBatch.batch.dao.MONCUsuariosDAO;
import com.sabadell.MonitorAmbientesBatch.batch.dao.OperacionDAO;
import com.sabadell.MonitorAmbientesBatch.dto.MONCUsuariosDTO;
import com.sabadell.MonitorAmbientesBatch.dto.MONTOperacionDTO;
import com.sabadell.MonitorAmbientesBatch.service.NotificacionCaidasService;
import com.sabadell.MonitorAmbientesBatch.utils.Utils;
import com.sabadell.MonitorAmbientesBatch.utils.email.EmailDTO;
import com.sabadell.MonitorAmbientesBatch.utils.email.EmailService;
import com.sabadell.MonitorAmbientesBatch.utils.email.EmailTemplate;

@Service
public class NotificacionCaidasServiceImpl implements NotificacionCaidasService {

	private static final Logger LOGGER = Logger.getLogger(NotificacionCaidasServiceImpl.class);
	
	private static Set<Integer> lsIdServidoresCaidos;
	private Set<String> lsIdServidoresCaidosANotificar;
	
	private static Calendar banderaTiempo;
	
	@Autowired
	private OperacionDAO operacionDAO;
	
	@Autowired
	private MONCUsuariosDAO usuarioDAO;
	
	@Autowired
    EmailService emailService;
	
	@Override
	public void notificarCaidas() {
		/*
		 * Pasos
		 * 1.- Obtener última corrida de Base de Datos de la tabla operaciones
		 * 2.- Agregar los ids  los servidores caidos no repetidos
		 * 	2.1.- Se valida si ya esta registrado como caido en lista(mapa) de caidos
		 * 	2.2.- Si no esta se agrega a lista(mapa) de caidos
		 * 	2.3.- Si no esta se agrega tambien a lista(mapa) de caidos a Notificar
		 * 3.- Enviar correo de caidos nuevos
		 *  3.1 Si la lista de caidos a notificar NO es VACIA se llama a método de correo
		*/
		
		//Inicializar lista de caidos si es null, osea se resetea despues de la hora
		if(lsIdServidoresCaidos == null){
			lsIdServidoresCaidos = new HashSet<Integer>();
			//Setear bandera de tiempo
			banderaTiempo = Calendar.getInstance();
			
			
		}
		//Inicializar lista de caidos a notificar
		lsIdServidoresCaidosANotificar =  new HashSet<String>();
		
		//1 Retrieve operaciones (Objeto MONTOperacionDTO)
		//2. Validar caidos y agregar a listas
		
		for(MONTOperacionDTO op: operacionDAO.obtenerDatosRecientes()) {
			LOGGER.info(op);
			if(op.getIdEstatus() != Utils.OK_STATUS) {
				LOGGER.info("Servidor: "+op.getIdServidor()+" CAIDO con estatus: "+op.getIdEstatus());
				
				
				if(lsIdServidoresCaidos.add(op.getIdServidor())) {
					//Se agrega nuevo
					lsIdServidoresCaidosANotificar.add(op.getDescripcionServidor());
				}
			}
			
		}
		LOGGER.info("Caidos: "+lsIdServidoresCaidos.size());
		LOGGER.info("Caidos a notificar: "+lsIdServidoresCaidosANotificar.size());
		
		
		
		
		//3. Enviar correo
		if(!lsIdServidoresCaidosANotificar.isEmpty()) {
			//Notificar los servifores en la lista
			LOGGER.info("Enviar notificacion de correo por "+lsIdServidoresCaidosANotificar+" servidores caidos");
			
			ArrayList<String> lsMails = new ArrayList<String>();
			List<MONCUsuariosDTO> lsUsuarios = usuarioDAO.obtenreUsuariosActivos();
			LOGGER.info("Usuarios: "+lsUsuarios.size());
			for(MONCUsuariosDTO user:lsUsuarios) {
				LOGGER.info(user);
				lsMails.add(user.getCorreo());
			}
			
			//Generar y enviar correo
			
			LOGGER.info("Notificacion MAIL");
			String from = "notifica@test";
			String to = lsMails.isEmpty()? "cramsses@gmail.com":Utils.concatenate(lsMails, ",");
			String subject = "Alerta de caida";
			StringBuffer message = new StringBuffer( "");
			String separator = "";
			int idxSalto=1;
			for(String srv: lsIdServidoresCaidosANotificar) {
				LOGGER.info("Servidor: "+srv);
				message.append(separator+srv);
				separator = ", ";
				if(idxSalto%3==0) {
					message.append(System.getProperty("line.separator"));
				}
				idxSalto++;
			}
			
			LOGGER.info("message: "+message);
			
			
			SimpleDateFormat format = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
			EmailTemplate plantilla = new EmailTemplate("notificacion-caida-plano.txt");
			Map<String, String> replacements = new HashMap<String, String>();
			replacements.put("servers", message.toString());
			replacements.put("today", format.format(new Date()));
			
			
			
			EmailDTO email = new EmailDTO(from, to, subject, plantilla.getTemplate(replacements));
			email.setHtml(false);
			try {
				emailService.send(email);
			} catch (Exception e) {
				LOGGER.info("Fallo al enviar correo. Causa: "+e.getCause());
			}
			
		}
		
		
		
		//4.- Validar si se tiene que limpiar 
		Calendar now=Calendar.getInstance();
		long seconds = (now.getTimeInMillis() - banderaTiempo.getTimeInMillis()) / 1000;
		int hours = (int) (seconds / 3600);
		int minutes = (int) (seconds / 60);
		
		LOGGER.info(seconds+" seconds--"+minutes+" minutes--"+hours+" hours");
		
		if(minutes>= 59) {
			//Limpiar listaCaidas
			lsIdServidoresCaidos=null;
		}
		
		
		
		
		

	}

}
