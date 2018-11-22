package com.sabadell.MonitorAmbientesBatch.batch.controller;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.sabadell.MonitorAmbientesBatch.service.NotificacionCaidasService;
import com.sabadell.MonitorAmbientesBatch.utils.email.EmailService;

@Component
public class MonitorAmbientesBatchController {
	
	private static final Logger LOGGER = Logger.getLogger(MonitorAmbientesBatchController.class);
	
    @Autowired
    JobLauncher jobLauncher;
    
    @Autowired
    EmailService emailService;
    
    @Autowired
    NotificacionCaidasService notificacionCaidasService;
 
    @Autowired
    @Qualifier("monitorAmbientesJob")
    Job monitorAmbientesJob;
    
    @Scheduled(cron="0 * * ? * *")
    public void monitorear() throws Exception {
    	jobLauncher.run(monitorAmbientesJob, new JobParametersBuilder()
    	        .addDate("date", new Date())
    	        .toJobParameters());
    }
    
    @Scheduled(cron="15 * * ? * *")
    public void notificar() throws Exception {
    	LOGGER.info("----- PROCESO DE NOTIFICACION -----");
    	notificacionCaidasService.notificarCaidas();
    }
}
