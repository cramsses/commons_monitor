package com.bancosabadell.monitorAmbientes.monitoreo.dto;

public class AmbienteConEstatusDTO implements Comparable<AmbienteConEstatusDTO> {
	
	public String idAmbiente;

	public String nombreAmbiente;
	public String nombreCorto;
	
	public String nodo1;
	public String nodo2;
    
	public String bantotal;
	public String bantotalNodo1;
	public String bantotalNodo2;
    
	public String sofom; 	
	public String sofomNodo1; 	
	public String sofomNodo2;
	
	public String getIdAmbiente() {
		return idAmbiente;
	}

	public void setIdAmbiente(String idAmbiente) {
		this.idAmbiente = idAmbiente;
	}


	public String getNombreCorto() {
		return nombreCorto;
	}

	public void setNombreCorto(String nombreCorto) {
		this.nombreCorto = nombreCorto;
	}

	public AmbienteConEstatusDTO() {
		super();
	}

	public String getNodo1() {
		return nodo1;
	}

	public void setNodo1(String nodo1) {
		this.nodo1 = nodo1;
	}

	public String getNodo2() {
		return nodo2;
	}

	public void setNodo2(String nodo2) {
		this.nodo2 = nodo2;
	}
	public String getNombreAmbiente() {
		return nombreAmbiente;
	}

	public void setNombreAmbiente(String nombreAmbiente) {
		this.nombreAmbiente = nombreAmbiente;
	}

	public String getBantotal() {
		return bantotal;
	}

	public void setBantotal(String bantotal) {
		this.bantotal = bantotal;
	}

	public String getBantotalNodo1() {
		return bantotalNodo1;
	}

	public void setBantotalNodo1(String bantotalNodo1) {
		this.bantotalNodo1 = bantotalNodo1;
	}

	public String getBantotalNodo2() {
		return bantotalNodo2;
	}

	public void setBantotalNodo2(String bantotalNodo2) {
		this.bantotalNodo2 = bantotalNodo2;
	}

	public String getSofom() {
		return sofom;
	}

	public void setSofom(String sofom) {
		this.sofom = sofom;
	}

	public String getSofomNodo1() {
		return sofomNodo1;
	}

	public void setSofomNodo1(String sofomNodo1) {
		this.sofomNodo1 = sofomNodo1;
	}

	public String getSofomNodo2() {
		return sofomNodo2;
	}

	public void setSofomNodo2(String sofomNodo2) {
		this.sofomNodo2 = sofomNodo2;
	}

	@Override
	public int compareTo(AmbienteConEstatusDTO compareAmb) {
		
		String compareId = ((AmbienteConEstatusDTO)compareAmb).getIdAmbiente();
		
		//Ascending
		return this.idAmbiente.compareTo(compareId);
		
		//Descending
		//return compareId-this.idAmbiente;
	}
	/*
	public int compareTo(AmbienteConEstatusDTO compareAmb) {
		
		String compareNombre = ((AmbienteConEstatusDTO)compareAmb).getNombreAmbiente();
		
		//Ascending
		return this.nombreAmbiente.compareTo(compareNombre);
	}
	*/
//TODO cambiar compare para ID

	@Override
	public String toString() {
		return "AmbienteConEstatusDTO [nombreAmbiente=" + nombreAmbiente
				+ ", nombreCorto=" + nombreCorto + ", nodo1=" + nodo1 + ", nodo2=" + nodo2 + ", bantotal=" + bantotal
				+ ", bantotalNodo1=" + bantotalNodo1 + ", bantotalNodo2=" + bantotalNodo2 + ", sofom=" + sofom
				+ ", sofomNodo1=" + sofomNodo1 + ", sofomNodo2=" + sofomNodo2 + "]";
	}

}
