package com.hbt.semillero.entity;



import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.hbt.semillero.enums.EstadoEnum;
import com.hbt.semillero.enums.TematicaEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <b>Descripción:<b> Entidad que contiene la informacion de la tabla
 * comic en la base de datos de semillero
 * <b>Caso de Uso:<b> SEMILLERO2022
 * @author Diego Fernando Alvarez Silva
 * @version 1.0
 */
@Entity
@Table(name = "COMIC")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Comic implements Serializable {

	/**
	 * Serializar es pasar un Objeto a un array de bytes y viceversa. Atributo que
	 * determina serialVersionUID es el id único que identifica una clase cuando lo
	 * serializamos. ;ediante este id podemos identificar el objeto convertido en un
	 * array de bytes.
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(allocationSize = 1, name = "COMIC_SCID_GENERATOR", sequenceName = "SEQ_COMIC")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMIC_SCID_GENERATOR")
	@Column(name = "SCID")
	private Long id;
	
	@Column(name = "SCNOMBRE")
	private String nombre;
	
	@Column(name = "SCEDITORIAL")
	private String editorial;
	
	@Column(name = "SCTEMATICA")
	@Enumerated(value = EnumType.STRING)
	private TematicaEnum tematicaEnum;
	
	@Column(name = "SCCOLECCION")
	private String coleccion;
	
	@Column(name = "SCNUMEROPAGINAS")
	private Integer numeroPaginas;
	
	@Column(name = "SCPRECIO")	
	private BigDecimal precio;
	
	@Column(name = "SCAUTORES")
	private String autores;

	@Column(name = "SCCOLOR")
	private Boolean color;
	
	@Column(name = "SCFECHA_VENTA")
	private LocalDate fechaVenta;
	
	@Column(name = "SCESTADO")
	@Enumerated(value = EnumType.STRING)
	private EstadoEnum estadoEnum;

	@Column(name = "SCCANTIDAD")
	private Long cantidad;

	
}
