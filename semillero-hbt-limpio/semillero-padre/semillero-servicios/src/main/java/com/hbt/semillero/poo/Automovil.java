package com.hbt.semillero.poo;

import java.math.BigDecimal;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.hbt.semillero.enums.TipoVehiculoEnum;
import com.hbt.semillero.poo.interfaces.IAccionesVehiculo;

public class Automovil extends Vehiculo implements IAccionesVehiculo{

	private final static Logger LOGGER = Logger.getLogger(Automovil.class);
	
	public Automovil() {
		BasicConfigurator.configure();
		//Constructor vacio
	}
	
	public Automovil(BigDecimal precio) {
		super(precio);
		super.toString();
	}
	
	@Override
	public int obtenerVelocidadMaxima() {

		return 300;
	}

	@Override
	public Long obternerPesoMaximoCarga() {
		return 1000L;
	}

	@Override
	public boolean determinarTipoVehiculo(TipoVehiculoEnum tipoVehiculoEmun) throws Exception {
		if(TipoVehiculoEnum.TERRESTRE.getIdentificador() == (tipoVehiculoEmun.getIdentificador())) {
			System.out.println("El vehiculo si es del tipo asignado (" + tipoVehiculoEmun.getTipo() + ")");
			return true;
		} else {
			LOGGER.error("Se ha presentado un error de xxx");
			throw new Exception("El tipo de vehiculo asignado es erroneo, debe ser " + TipoVehiculoEnum.TERRESTRE.getTipo());
		}
	}

}
