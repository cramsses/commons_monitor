package com.sabadell.MonitorAmbientesBatch.utils;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.http.client.fluent.Request;

public final class Utils {
	
	private Utils() {
	}
	public static final int NOT_FOUND_STATUS  = 404; 
	public static final int OK_STATUS  = 200; 
	public static final int TIME_OUT   = 100;
	public static final int PUERTO_SSH = 22;
	
	public static final String CONSTANT_BLANK="";
	
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
			} else {
				status = 404;
			}
            
        } catch (Exception e) {	   
        	status = NOT_FOUND_STATUS;
        }
		return status;
	}
	
	/**
	 * valida si un host es accesible:
	 * 
	 * @param direccion
	 * @return
	 */
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
	 * Concatena lista
	 * @param listOfItems
	 * @param separator
	 * @return
	 */
	public static String concatenate(List<String> listOfItems, String separator) {
		StringBuilder sb = new StringBuilder();
		Iterator<String> stit = listOfItems.iterator();

		while (stit.hasNext()) {
			sb.append(stit.next());
			if (stit.hasNext()) {
				sb.append(separator);
			}
		}

		return sb.toString();
	}
	
	private static boolean isCollectionEmpty(Collection<?> collection) {
		if (collection == null || collection.isEmpty()) {
			return true;
		}
		return false;
	}
	
	public static boolean isObjectEmpty(Object object) {
		if(object == null) return true;
		else if(object instanceof String) {
			if (((String)object).trim().length() == 0) {
				return true;
			}
		} else if(object instanceof Collection) {
			return isCollectionEmpty((Collection<?>)object);
		}
		return false;
	}
}