package com.hbt.semillero.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.hbt.semillero.enums.TematicaEnum;

/**
 * 
 * <b>Descripción:<b> Clase que contiene la informacion de la tabla comic
 * en la BD de semillero
 * <b>Caso de Uso:<b> Semillero2022
 * @author Diego Fernado Alvarez Silva
 * @version 1
 */
@Entity
@Table(name="COMIC")
public class Comic implements Serializable {
	
	/**
	 * Atributo que determina  
	 */
	private static final long serialVersionUID = 216164349106318793L;

	@Id
	@Column(name="SCID")
	@SequenceGenerator(allocationSize= 1, name="COMIC_SCID_GENERATOR", sequenceName="SEQ_COMIC")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="COMIC_SCID_GENERATOR")
	private Long id;
	
	@Column(name="SCNOMBRE", nullable = false, length=50)
	private String nombre;
	
	@Column(name="SCTEMATICA")
	private TematicaEnum tematica;
	
	@Column(name="SCCOLOR")
	private Boolean color;
	
	@Column(name="SCFECHA_VENTA")
	private LocalDate fechaVenta;

	/**
	 * Metodo encargado de retornar el valor del atributo id
	 * @return El id asociado a la clase
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo id
	 * @param id El nuevo id a modificar.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo nombre
	 * @return El nombre asociado a la clase
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo nombre
	 * @param nombre El nuevo nombre a modificar.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo tematica
	 * @return El tematica asociado a la clase
	 */
	public TematicaEnum getTematica() {
		return tematica;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo tematica
	 * @param tematica El nuevo tematica a modificar.
	 */
	public void setTematica(TematicaEnum tematica) {
		this.tematica = tematica;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo color
	 * @return El color asociado a la clase
	 */
	public Boolean getColor() {
		return color;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo color
	 * @param color El nuevo color a modificar.
	 */
	public void setColor(Boolean color) {
		this.color = color;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo fechaVenta
	 * @return El fechaVenta asociado a la clase
	 */
	public LocalDate getFechaVenta() {
		return fechaVenta;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo fechaVenta
	 * @param fechaVenta El nuevo fechaVenta a modificar.
	 */
	public void setFechaVenta(LocalDate fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	/** 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Comic [id=" + id + ", nombre=" + nombre + ", tematica=" + tematica + ", color=" + color
				+ ", fechaVenta=" + fechaVenta + "]";
	}
}
