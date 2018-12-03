package com.bancosabadell.monitorAmbientes;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bancosabadell.monitorAmbientes.monitoreo.service.CalendarizadorService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MonitorAmbientesApplicationTests {
	
	@Autowired
	private CalendarizadorService calendarizadorService;

	@Test
	public void contextLoads() {
		calendarizadorService.ejecutarProceso();
	}

}
