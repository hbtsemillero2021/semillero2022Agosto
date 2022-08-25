package com.hbt.semillero.poo;

import com.hbt.semillero.poo.abtracts.AccionesVehiculoAbstract;

public class Bicicleta extends AccionesVehiculoAbstract {

	@Override
	public int obtenerVelocidadMaxima() {

		return 10;
	}

	@Override
	public Long obternerPesoMaximoCarga() {

		return 90L;
	}

}
