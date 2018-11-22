package com.bancosabadell.monitorAmbientes.monitoreo.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bancosabadell.monitorAmbientes.monitoreo.dto.DisponibilidadDetalleDTO;

public class DisponibilidadDetalleMapper implements RowMapper<DisponibilidadDetalleDTO>{

	@Override
	public DisponibilidadDetalleDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		DisponibilidadDetalleDTO objeto = new DisponibilidadDetalleDTO();
		objeto.setNombre(rs.getString("NOMBRE"));
		objeto.setDisponibilidadRequerida(rs.getFloat("DISPONIBILIDAD_REQ"));
		objeto.setDisponibilidadReal(rs.getFloat("DISPONIBILIDAD_REAL"));
		return objeto;
	}
	
}
