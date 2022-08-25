package com.hbt.semillero.poo.abtracts;

public abstract class AccionesVehiculoAbstract {

	public abstract int obtenerVelocidadMaxima();
	
	public abstract Long obternerPesoMaximoCarga();
	
	public void acelerar() {
		System.out.println("El vehiculo ha iniciado acelerar");
	}
}
