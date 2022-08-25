package com.hbt.semillero.poo;

import java.math.BigDecimal;

public class Barco extends Vehiculo {

	private int numeroVelas;
	private String nombreCapitan;
	private String puertoLlegada;
	private float calado;
	
	public Barco() {
		
	}
	
	public Barco(String nombreCapitan, String puertoLlegada, BigDecimal precio) {
		super(precio);
		this.nombreCapitan = nombreCapitan;
		this.puertoLlegada = puertoLlegada;
	}

	/**
	 * @return the numeroVelas
	 */
	public int getNumeroVelas() {
		return numeroVelas;
	}
	/**
	 * @param numeroVelas the numeroVelas to set
	 */
	public void setNumeroVelas(int numeroVelas) {
		this.numeroVelas = numeroVelas;
	}
	/**
	 * @return the nombreCapitan
	 */
	public String getNombreCapitan() {
		return nombreCapitan;
	}
	/**
	 * @param nombreCapitan the nombreCapitan to set
	 */
	public void setNombreCapitan(String nombreCapitan) {
		this.nombreCapitan = nombreCapitan;
	}
	/**
	 * @return the puertoLlegada
	 */
	public String getPuertoLlegada() {
		return puertoLlegada;
	}
	/**
	 * @param puertoLlegada the puertoLlegada to set
	 */
	public void setPuertoLlegada(String puertoLlegada) {
		this.puertoLlegada = puertoLlegada;
	}
	/**
	 * @return the calado
	 */
	public float getCalado() {
		return calado;
	}
	/**
	 * @param calado the calado to set
	 */
	public void setCalado(float calado) {
		this.calado = calado;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Barco [numeroVelas=" + numeroVelas + ", nombreCapitan=" + nombreCapitan + ", puertoLlegada="
				+ puertoLlegada + ", calado=" + calado + "]"
				+ super.toString();
	}
}
