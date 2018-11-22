package com.bancosabadell.monitorAmbientes.monitoreo.dao;

import java.util.List;

import com.bancosabadell.monitorAmbientes.monitoreo.dto.DisponibilidadDetalleDTO;

public interface DisponibilidadDetalleDAO {
	/***
	 * Disponibilidad  de Nodos
	 */
	public static final String QRY1_DISPONIBILIDAD_DETALLE="SELECT " + 
			" nds.NOMNODO as NOMBRE, " + 
			" nds.DISPONIBILIDAD_REQ, " + 
			" ((SUM(case when op.IDESTATUS = 200 then 1 else 0 end)*100) / count(1) ) as DISPONIBILIDAD_REAL " + 
			" FROM mont_operacion op " + 
			" INNER JOIN mona_servidores srv ON op.IDSERVIDOR=srv.IDSERVIDOR " + 
			" INNER JOIN monc_nodos nds on srv.IDNODO=nds.IDNODO " + 
			" group by nds.NOMNODO,nds.DISPONIBILIDAD_REQ";
	/***
	 * Disponibilidad  de Ambientes
	 */
	public static final String QRY2_DISPONIBILIDAD_DETALLE="SELECT   amb.NOMBREAMBIENTE as NOMBRE,  amb.DISPONIBILIDAD_REQ,  \r\n" + 
			" ((SUM(case when op.IDESTATUS = 200 then 1 else 0 end)*100) / count(1) ) as DISPONIBILIDAD_REAL  \r\n" + 
			" FROM mont_operacion op  \r\n" + 
			" INNER JOIN mona_servidores srv ON op.IDSERVIDOR=srv.IDSERVIDOR  \r\n" + 
			" INNER JOIN monc_ambientes amb on amb.IDAMBIENTE=srv.IDAMBIENTE  \r\n" + 
			" INNER JOIN mona_url urls on srv.IDURL=urls.IDURL  \r\n" + 
			" group BY amb.NOMBREAMBIENTE , amb.DISPONIBILIDAD_REQ";
	
	public static final String QRY3_DISPONIBILIDAD_DETALLE="SELECT 'DESA_DB' as NOMBRE, '97' as DISPONIBILIDAD_REQ,'80' as DISPONIBILIDAD_REAL from dual";
	public static final String QRY4_DISPONIBILIDAD_DETALLE="SELECT 'GxCode Produccion' as NOMBRE,'97' as DISPONIBILIDAD_REQ,'80' as DISPONIBILIDAD_REAL from dual";
	
	List<DisponibilidadDetalleDTO> obtenerDisponibilidadDetalle(String query);

}
