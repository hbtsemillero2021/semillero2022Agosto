package com.hbt.semillero.poo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.hbt.semillero.enums.TipoVehiculoEnum;

public class CreacionVehiculoApp {

	private final static Logger LOGGER = Logger.getLogger(CreacionVehiculoApp.class);
	private static final BigDecimal SMLV = new BigDecimal(100000);
	private static final String VELOCIDAD_MAXIMA = "Velocidad maxima:";


	public static void main(String[] args) {
		BasicConfigurator.configure();
		Vehiculo mazda = new Vehiculo(new BigDecimal(105));
		//BigDecimal valorPrecio = new BigDecimal(105);

		//mazda.setPrecio(new BigDecimal(105));

		Long valor1 = 100L;
		Float valor2 = 100F;
		Double valor3 = 100D;

		Vehiculo kia = new Vehiculo((short)2022, TipoVehiculoEnum.TERRESTRE, 1000.9, "Rojo", 5, new BigDecimal(110));
		
		if(kia.getTipo().equals(TipoVehiculoEnum.TERRESTRE) ) {
			// WIP
			System.out.println("El vehiculo es terrestre");
		} else {
			System.out.println("El vehiculo es " + kia.getTipo());
		}	

		Barco barco = new Barco("Semillero","Barranquilla", new BigDecimal(999));
		barco.setColor("Blanco");

		System.out.println("Valor vehiculo mazda es de: " + mazda.getPrecio());
		System.out.println("Valor vehiculo kia es de: " + kia.toString());
		System.out.println("Valor vehiculo barco es de: " + barco.toString());

		// Polimorfismo
		Vehiculo vehiculo1 = new Vehiculo();
		vehiculo1.arrancarEnMedio();

		Avion avion = new Avion();
		avion.arrancarEnMedio();

		Vehiculo avion2 = new Avion();
		avion2.arrancarEnMedio();

		Bicicleta bicicleta = new Bicicleta();
		bicicleta.acelerar();
		System.out.println(VELOCIDAD_MAXIMA + bicicleta.obtenerVelocidadMaxima());
		System.out.println("Peso maximo:" + bicicleta.obternerPesoMaximoCarga());

		//AccionesVehiculoAbstract v1 = new AccionesVehiculoAbstract();

		//Avion avion3 = new Vehiculo(); genera error

		Automovil auto = new Automovil(new BigDecimal(999999));
		auto.setTipo(TipoVehiculoEnum.ACUATICO);
		auto.acelerar();
		System.out.println(VELOCIDAD_MAXIMA + auto.obtenerVelocidadMaxima());
		System.out.println("Peso maximo:" + auto.obternerPesoMaximoCarga());
		
		try {
			auto.determinarTipoVehiculo(auto.getTipo());
		} catch (Exception e) {
			LOGGER.error("Se ha presentado un error " + e.getMessage());
			System.out.println("SE HA PRESESENTADO UN ERROR " + e.getMessage());
		}

		List<Vehiculo> listaVehiculos = new ArrayList<>();
		listaVehiculos.add(auto);
		listaVehiculos.add(kia);
		listaVehiculos.add(barco);
		for (Vehiculo vehiculo : listaVehiculos) {
			System.out.println(vehiculo.getPrecio());
		}
		
		listaVehiculos.remove(kia);
		for (Vehiculo vehiculo : listaVehiculos) {
			System.out.println(vehiculo.getPrecio());
		}
		
		Map<String, Vehiculo> mapaVehiculos = new HashMap<>();
		mapaVehiculos.put("china",kia);
		mapaVehiculos.put("japon",mazda);
		
		System.out.println(mapaVehiculos.get("china"));
	}
}
