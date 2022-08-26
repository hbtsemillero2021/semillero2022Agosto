package com.hbt.semillero.enums;

/**
 * 		
 * <b>Descripción:<b> Clase que determina
 * <b>Caso de Uso:<b> 
 * @author Diego Fernado Alvarez Silva
 * @version
 */
public enum TematicaEnum {

	AVENTURAS("enum.tematica.aventuras"),
	BELICO("enum.tematica.belico"), 
	HUMORISTICO("enum.tematica.humoristico"), 
	DEPORTIVO("enum.tematica.deportivo"), 
	FANTASTICO("enum.tematica.fantastico"), 
	CIENCIA_FICCION("enum.tematica.cienciaFiccion"), 
	HISTORICO("enum.tematica.historico"), 
	HORROR("enum.tematica.horror"),
	
	;
	
	private String etiqueta;
	
	TematicaEnum(String etiqueta) {
		this.etiqueta = etiqueta;
	}
	
	public String getEtiqueta() {
		return etiqueta;
	}
}
