package com.sabadell.MonitorAmbientesBatch.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sabadell.MonitorAmbientesBatch.dto.MONTOperacionDTO;

public class OperacionesMapper implements RowMapper<MONTOperacionDTO> {
	
	@Override
	public MONTOperacionDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		MONTOperacionDTO objeto = new MONTOperacionDTO();
		objeto.setIdOperacion(rs.getInt("IDOPERACION"));
		objeto.setIdServidor( rs.getInt("IDSERVIDOR") );
		objeto.setIdEstatus(rs.getInt("IDESTATUS"));
		objeto.setFecha(rs.getDate("FECHA"));
		objeto.setTiempoRespuesta(rs.getDouble("TIEMPORESPUESTA"));
		objeto.setDescripcionServidor(rs.getString("DESCRIPCIONSERVIDOR"));
		
		return objeto;
	}
}