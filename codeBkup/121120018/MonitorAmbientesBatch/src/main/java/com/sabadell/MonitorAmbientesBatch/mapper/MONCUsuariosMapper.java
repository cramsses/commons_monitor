package com.sabadell.MonitorAmbientesBatch.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.sabadell.MonitorAmbientesBatch.dto.MONCUsuariosDTO;

/**
 * Mapea los datos de la tabla MONC_Usuarios con los del objeto MONCUsuariosDTO
 * 
 * @author Jesus Alfredo Hernandez Orozco
 *
 */
public class MONCUsuariosMapper implements RowMapper<MONCUsuariosDTO> {

	public MONCUsuariosMapper() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Mapea los datos de la tabla MONC_Usuarios con los del objeto MONCUsuariosDTO
	 */
	@Override
	public MONCUsuariosDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		MONCUsuariosDTO objeto = new MONCUsuariosDTO();
		objeto.setCveUsuario(rs.getString("CVEUSUARIO"));
		objeto.setNombre(rs.getString("NOMBRE"));
		objeto.setCorreo(rs.getString("CORREO"));
		objeto.setFechaInicio(rs.getDate("FECHAINICIO"));
		objeto.setFechaFin(rs.getDate("FECHAFIN"));
		return objeto;
	}
}