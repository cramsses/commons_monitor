package com.sabadell.MonitorAmbientesBatch;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class MonitorAmbientesBatchApplication extends SpringBootServletInitializer {

	private static final Logger LOGGER = Logger.getLogger(MonitorAmbientesBatchApplication.class);
	public static void main(String[] args) {
		LOGGER.info("JAHO - Inicia el proceso Batch");
		SpringApplication.run(MonitorAmbientesBatchApplication.class, args);
	}
}