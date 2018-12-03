package com.bancosabadell.monitorAmbientes.monitoreo.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bancosabadell.monitorAmbientes.monitoreo.dto.CaidasAmbienteDTO;
import com.bancosabadell.monitorAmbientes.monitoreo.dto.TiempoRespuestaAmbienteDTO;

public class CaidasAmbienteMapper implements RowMapper<CaidasAmbienteDTO> {

	public CaidasAmbienteMapper()  {
		// TODO Auto-generated constructor stub
	}

	@Override
	public CaidasAmbienteDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		CaidasAmbienteDTO objeto = new CaidasAmbienteDTO();
		objeto.setIdAmbiente(rs.getInt("IDAMBIENTE"));
		objeto.setAmbiente(rs.getString("NOMBREAMBIENTE"));
		objeto.setHora(rs.getString("HORA"));
		objeto.setNumCaidas(rs.getInt("COUNT"));
		return objeto;
	}

}