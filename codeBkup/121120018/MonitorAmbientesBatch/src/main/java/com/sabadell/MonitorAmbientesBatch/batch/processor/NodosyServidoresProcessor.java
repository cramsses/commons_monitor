package com.sabadell.MonitorAmbientesBatch.batch.processor;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;

import com.sabadell.MonitorAmbientesBatch.batch.dao.OperacionDAO;
import com.sabadell.MonitorAmbientesBatch.dto.MONTOperacionDTO;
import com.sabadell.MonitorAmbientesBatch.dto.NodosyServidoresDTO;
import com.sabadell.MonitorAmbientesBatch.utils.Utils;

public class NodosyServidoresProcessor implements ItemProcessor<NodosyServidoresDTO, MONTOperacionDTO> {

	private static final long MIL = 1000;
	private static final Logger LOGGER = Logger.getLogger(NodosyServidoresProcessor.class);
	@Autowired
	private OperacionDAO operacionDAO;
	
	private Integer sequence;
	
    @BeforeStep
    public void beforeStep(StepExecution stepExecution) {
    	LOGGER.info("beforeStep");
    	sequence=operacionDAO.obtenerSequence();
    }

	@Override
	public MONTOperacionDTO process(NodosyServidoresDTO objeto) throws Exception {
		MONTOperacionDTO objetoOperacion = new MONTOperacionDTO();
		objetoOperacion.setFecha(new Date(System.currentTimeMillis()));
		Long tiempoInicial = System.currentTimeMillis();
		objetoOperacion.setIdOperacion(sequence);
		objetoOperacion.setIdEstatus(Utils.validarEstatusURL(objeto.getDireccion()));
		objetoOperacion.setIdServidor(objeto.getIdServidor());
		objetoOperacion.setTiempoRespuesta((double)(System.currentTimeMillis()-tiempoInicial)/MIL);
		LOGGER.info("Llega al processor, sequence: "+sequence+". "+objetoOperacion.getIdEstatus());
		return objetoOperacion;	
	}
}