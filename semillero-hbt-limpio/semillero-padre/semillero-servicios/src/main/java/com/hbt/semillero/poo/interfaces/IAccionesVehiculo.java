package com.hbt.semillero.poo.interfaces;

import com.hbt.semillero.enums.TipoVehiculoEnum;

public interface IAccionesVehiculo {

	public int obtenerVelocidadMaxima();
	
	public Long obternerPesoMaximoCarga();
	
	public boolean determinarTipoVehiculo(TipoVehiculoEnum tipoVehiculoEmun) throws Exception;
	
	default public String acelerar() {
		System.out.println("El vehiculo ha iniciado acelerar");
		return "El vehiculo ha iniciado acelerar";
	}
}
