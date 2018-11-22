package com.bancosabadell.monitorAmbientes.utils;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.http.client.fluent.Request;

public final class Utils {
	
	private Utils() {
		
	}
	
	/*AMBIENTES*/
	public static final int AMB_DESA  	= 1;
	public static final int AMB_INTE  	= 2;
	public static final int AMB_ACEP  	= 3;
	public static final int AMB_ACEP2  	= 4;
	public static final int AMB_CERT  	= 5;
	public static final int AMB_FIXI  	= 6;
	public static final int AMB_PREP  	= 7;
	public static final int AMB_PROD  	= 8;
	public static final int AMB_GOS  	= 9;
	
	/*STATUS*/
	public static final int NOT_FOUND_STATUS  = 404; 
	public static final int UNAUTHORIZED_STATUS  = 401; 
	public static final int OK_STATUS  = 200; 
	public static final int TIME_OUT   = 100;
	public static final int PUERTO_SSH = 22;
	
	/*SERVIDOR*/
	public static final String SERVER_NODO1  = "NODO1";
	public static final String SERVER_NODO2  = "NODO2"; 
	public static final String SERVER_BALANCER  = "BALANCEADOR";
	public static final String ND  = "ND";
	
	
	public static final int ID_NODO_BANAPP1D  = 1;
	public static final int ID_NODO_BANAPP2D  = 2;
	public static final int ID_NODO_BANAPP1I  = 3;
	public static final int ID_NODO_BANAPP2I  = 4;
	public static final int ID_NODO_BANAPP1A  = 5;
	public static final int ID_NODO_BANAPP2A  = 6;
	public static final int ID_NODO_BANAPP1C  = 7;
	public static final int ID_NODO_BANAPP2C  = 8;
	
	public static final int ID_NODO_BANAPP6A  = 9;
	public static final int ID_NODO_BANAPP1R  = 10;
	public static final int ID_NODO_BANAPP2R  = 11;
	
	public static final int ID_NODO_MX1TC01RBSAB  = 12;
	public static final int ID_NODO_MX2TC01RBSAB  = 13;
	
	public static final int ID_NODO_BANAPP1F  = 14;
	public static final int ID_NODO_BANAPP2F  = 15;
	
	public static final int ID_APP_IBM  	= 1;
	public static final int ID__APP_SOFOM  	= 2; 
	
	/**
	 * Valida el estado de los ambientes haciendo una petici&oacute;n HTTP
	 * 
	 * @param url
	 * @return
	 */
	public static int validarEstatusURL(String url) {
		int status = 0;
		try {
			if (url != null) {
				status = Request.Get(url).execute().returnResponse().getStatusLine().getStatusCode();
				if(status == UNAUTHORIZED_STATUS) {
					status = OK_STATUS;
				}
			} else {
				status = NOT_FOUND_STATUS;
			}
            
        } catch (Exception e) {	   
        	status = NOT_FOUND_STATUS;
        }
		return status;
	}
	
	public static boolean hacerPing(String direccion) {		
	    try {
	        try (Socket soc = new Socket()) {
	            soc.connect(new InetSocketAddress(direccion, PUERTO_SSH), TIME_OUT);
	        }
	        return true;
	    } catch (IOException ex) {
	        return false;
	    }
	}
	
	/**
	 * Valida si el formato de fecha es correcto y retorna la fecha con el formato indicado
	 * 
	 * @param formato Formato de la fecha a retornar
	 * @param fecha Fecha a convertir
	 * @return Fecha con formato solicitado.
	 */
    public static String darFormatoFecha(String formato, Date fecha) throws ParseException {
    	DateFormat df = new SimpleDateFormat(formato);
        return df.format(fecha);
    }
}