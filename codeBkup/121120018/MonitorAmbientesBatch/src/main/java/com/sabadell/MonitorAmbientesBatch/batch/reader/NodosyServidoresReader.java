package com.sabadell.MonitorAmbientesBatch.batch.reader;

import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.batch.item.support.IteratorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sabadell.MonitorAmbientesBatch.batch.dao.NodosyServidoresDAO;
import com.sabadell.MonitorAmbientesBatch.dto.NodosyServidoresDTO;

@Component
public class NodosyServidoresReader implements ItemReader<NodosyServidoresDTO> {

	@Autowired
	private NodosyServidoresDAO nodosyServidoresDAO;
		
	private ItemReader<NodosyServidoresDTO> delegate;
	
	public NodosyServidoresReader() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public synchronized NodosyServidoresDTO read()
			throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		
		if (delegate == null) {
            delegate = new IteratorItemReader<>(listarElementos());
        }
        return delegate.read();
	}
	
	private List<NodosyServidoresDTO> listarElementos() throws FileNotFoundException {
		return nodosyServidoresDAO.obtenerDatos();
    }

}
