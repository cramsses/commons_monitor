package com.bancosabadell.monitorAmbientes.monitoreo.dto;

public class TiempoRespuestaAmbienteDTO {
	
	private int idAmbiente;
	private String ambiente;
	private String hora;
	private float tiempoRespAvg;
	
	
	public String getAmbiente() {
		return ambiente;
	}
	public void setAmbiente(String ambiente) {
		this.ambiente = ambiente;
	}
	public String getHora() {
		return hora.replaceFirst("^0+(?!$)", "");
	}
	public void setHora(String hora) {
		
		this.hora = hora;
	}
	public float getTiempoRespAvg() {
		return tiempoRespAvg;
	}
	public void setTiempoRespAvg(float tiempoRespAvg) {
		this.tiempoRespAvg = tiempoRespAvg;
	}
	public int getIdAmbiente() {
		return idAmbiente;
	}
	public void setIdAmbiente(int idAmbiente) {
		this.idAmbiente = idAmbiente;
	}
}
