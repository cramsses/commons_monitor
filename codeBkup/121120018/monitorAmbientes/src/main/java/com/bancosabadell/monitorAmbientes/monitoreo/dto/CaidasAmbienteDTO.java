package com.bancosabadell.monitorAmbientes.monitoreo.dto;

public class CaidasAmbienteDTO {
	
	private Integer idAmbiente;
	private String ambiente;
	private String hora;
	private int numCaidas;
	
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
	
	public int getNumCaidas() {
		return numCaidas;
	}
	public void setNumCaidas(int numCaidas) {
		this.numCaidas = numCaidas;
	}
	public Integer getIdAmbiente() {
		return idAmbiente;
	}
	public void setIdAmbiente(Integer idAmbiente) {
		this.idAmbiente = idAmbiente;
	}
	

}
