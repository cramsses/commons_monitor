package com.sabadell.MonitorAmbientesBatch.setter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.batch.item.database.ItemPreparedStatementSetter;

import com.sabadell.MonitorAmbientesBatch.dto.MONTOperacionDTO;

public class MONTOperacionSetter implements ItemPreparedStatementSetter<MONTOperacionDTO> {

	public MONTOperacionSetter() {
		// TODO Auto-generated constructor stub
	}
	
	private static final Integer UNO = 1;
	private static final Integer DOS = 1;
	private static final Integer TRES = 1;
	private static final Integer CUATRO = 1;
	
	
	@Override
	public void setValues(MONTOperacionDTO item, PreparedStatement ps) throws SQLException {
		ps.setInt(UNO, item.getIdServidor());
        ps.setInt(DOS, item.getIdEstatus());
        ps.setDate(TRES, (java.sql.Date) item.getFecha());
		ps.setDouble(CUATRO,  item.getTiempoRespuesta());
		
		System.out.println(item);
	}

}
