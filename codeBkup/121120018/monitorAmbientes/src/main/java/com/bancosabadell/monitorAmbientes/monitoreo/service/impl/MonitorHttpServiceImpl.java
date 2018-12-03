package com.bancosabadell.monitorAmbientes.monitoreo.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bancosabadell.monitorAmbientes.monitoreo.service.MonitorHttpService;



@Service
public class MonitorHttpServiceImpl implements MonitorHttpService  {
		
	
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRES_NEW, readOnly=false, noRollbackFor=Exception.class)
	@Override
	public String contarTiempoDeRespuesta() { 
        /*try {
        	ArrayList<Servidores> listadoServ = (ArrayList<Servidores>) servidoresDAO.findAll();	
        	MonitorHttpExecutor myThread = null;
        	for (int j = 0; j < listadoServ.size(); j++) {
        	   myThread = applicationContext.getBean(MonitorHttpExecutor.class);
        	   myThread.setParameter(listadoServ.get(j));
               taskExecutor.execute(myThread);
        	}
            return null;
        } catch (Exception e) {	   
        	e.printStackTrace();
        	return null;
        }*/
		return null;
	}
}
