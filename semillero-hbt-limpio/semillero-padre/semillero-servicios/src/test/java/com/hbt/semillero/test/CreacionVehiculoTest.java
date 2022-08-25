package com.hbt.semillero.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.hbt.semillero.enums.TipoVehiculoEnum;
import com.hbt.semillero.poo.Automovil;

/**
 * 
 * <b>Descripción:<b> Clase que determina las pruebas unitarias para la creacion
 * de un vehiculo
 * <b>Caso de Uso:<b>Semillero2022 
 * @author Diego Fernado Alvarez Silva
 * @version 1.0
 */
public class CreacionVehiculoTest {
	
	private final static Logger LOGGER = Logger.getLogger(CreacionVehiculoTest.class);
	
	@Before
	public void inicializar() {
		BasicConfigurator.configure();
		LOGGER.info("Se inicia la configuracion de log4j antes de ejecutar UT");
	}
	
	//WHENGIVENTHEN
	@Test
	public void whenCreateCarGivenSuccessThenOK() {
		LOGGER.info("Inicia ejecucion del test whenCreateCarGivenSuccessThenOK()");
		Automovil mazda = new Automovil();
		mazda.setPrecio(new BigDecimal(100));
		mazda.setColor("Blanco");
		mazda.setTipo(TipoVehiculoEnum.TERRESTRE);
		mazda.setCapacidad(4);
		
		assertNotNull(mazda);
		assertEquals(TipoVehiculoEnum.TERRESTRE, mazda.getTipo());
		assertEquals(4, mazda.getCapacidad());
		LOGGER.info("Finaliza ejecucion del test whenCreateCarGivenSuccessThenOK()");
	}
	
	@Test
	public void whenDeterminarTipoVehiculoGivenTrueThenExito() throws Exception {
		LOGGER.info("Inicia ejecucion del test whenDeterminarTipoVehiculoGivenTrueThenExito()");
		Automovil mazda = new Automovil();
		mazda.setTipo(TipoVehiculoEnum.TERRESTRE);
		
		boolean respuesta = mazda.determinarTipoVehiculo(mazda.getTipo());
		assertTrue(respuesta);
		LOGGER.info("Finaliza ejecucion del test whenDeterminarTipoVehiculoGivenTrueThenExito()");
	}
	
	@Test
	public void whenDeterminarTipoVehiculoGivenFalseThenFallido() {
		LOGGER.info("Inicia ejecucion del test whenDeterminarTipoVehiculoGivenFalseThenFallido()");
		Automovil mazda = new Automovil();
		mazda.setTipo(TipoVehiculoEnum.ESPACIAL);
		
		Exception exception = assertThrows(Exception.class, () -> {
			mazda.determinarTipoVehiculo(mazda.getTipo());
		});
		
		assertNotNull(exception);
		assertEquals("El tipo de vehiculo asignado es erroneo, debe ser " + TipoVehiculoEnum.TERRESTRE.getTipo(), 
				exception.getMessage());
		LOGGER.info("Finaliza ejecucion del test whenDeterminarTipoVehiculoGivenFalseThenFallido()");
	}
	
	@Test
	public void ejemploMock() {
		LOGGER.info("Inicia ejecucion del test ejemploMock()");
		
		Automovil kiaMock = new Automovil();
		kiaMock = mock(Automovil.class);
		
		when(kiaMock.acelerar()).thenReturn("El automovil ha tomado velocidad de 15km/h");
		assertEquals(kiaMock.acelerar(), "El automovil ha tomado velocidad de 15km/h");
		
		LOGGER.info("Finaliza ejecucion del test ejemploMock()");
	}
	
	@Test
	@Ignore
	public void pruebaFallida() {
		LOGGER.info("Inicia ejecucion del test whenDeterminarTipoVehiculoGivenFalseThenFallido()");
		Automovil mazda = new Automovil();
		mazda.setTipo(TipoVehiculoEnum.ESPACIAL);
		
		Exception exception = assertThrows(Exception.class, () -> {
			mazda.determinarTipoVehiculo(mazda.getTipo());
		});
		
		assertNull(exception);
		LOGGER.info("Finaliza ejecucion del test whenDeterminarTipoVehiculoGivenFalseThenFallido()");
	}
}
