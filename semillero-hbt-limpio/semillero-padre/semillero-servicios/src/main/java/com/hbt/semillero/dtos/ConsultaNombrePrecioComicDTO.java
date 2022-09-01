package com.hbt.semillero.dtos;

import java.io.Serializable;
import java.math.BigDecimal;

import com.hbt.semillero.util.JsonUtils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsultaNombrePrecioComicDTO extends ResultadoDTO implements Serializable {

	/**
	 * Atributo que determina  
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private BigDecimal precio;

	/**
	 * Método encargado de convertir los datos recibidos en JSON al tipo ComicDTO.
	 * <b>Caso de Uso:</b>
	 * 
	 * @param arg Cadena que representa el objeto complejo JSON.
	 * @return Instancia con los datos recibidos.
	 */
	public static ComicDTO valueOf(String arg) {
		return JsonUtils.valueOf(arg, ComicDTO.class);
	}

	/**
	 * Método encargado de convertir los datos recibidos en ComicDTO al JSON
	 * esperado
	 * 
	 * @param dto DTO
	 * 
	 * @return Json
	 */
	@Override
	public String toString() {
		return JsonUtils.toStringJson(this);
	}
}
