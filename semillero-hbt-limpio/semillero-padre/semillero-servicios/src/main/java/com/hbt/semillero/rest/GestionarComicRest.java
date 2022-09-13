package com.hbt.semillero.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.hbt.semillero.dtos.ComicDTO;
import com.hbt.semillero.dtos.ConsultaNombrePrecioComicDTO;
import com.hbt.semillero.dtos.ObjetoListaDTO;
import com.hbt.semillero.dtos.ResultadoDTO;
import com.hbt.semillero.poo.interfaces.IGestionarComicLocal;

/**
 * 
 * <b>Descripción:<b> Clase que contiene el catalogo de servicios o apis que contienen
 * la logica de gestionar un comic o el CRUD
 * <b>Caso de Uso:<b> SEMILLERO 2022
 * @author Diego Fernado Alvarez Silva
 * @version
 */
@Path("/gestionarComicRest")
public class GestionarComicRest {

	@EJB
	private IGestionarComicLocal gestionarComicLocal;
	
	/**
	 * 
	 * Metodo encargado de 
	 * <b>Caso de Uso</b>
	 * @author PC
	 * 
	 * @param idComic
	 * @return
	 */
	@GET
	@Path("/consultarNombrePrecioComic")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ConsultaNombrePrecioComicDTO consultarNombrePrecioComic(@QueryParam("idComic") Long idComic) {
		return this.gestionarComicLocal.consultarNombrePrecioComic(idComic);
	}
	
	@GET
	@Path("/obtenerComics")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<ComicDTO> obtenerComics() {
		return this.gestionarComicLocal.obtenerComics();
	}
	
	@GET
	@Path("/obtenerTematicaEnum")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<ObjetoListaDTO> obtenerTematicaEnum() {
		return this.gestionarComicLocal.obtenerTematicaEnum();
	}
	
	@POST
	@Path("/crearComic")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResultadoDTO crearComic(ComicDTO comicDTO) {
		ResultadoDTO resultadoDTO = new ResultadoDTO();
		try {
			resultadoDTO = this.gestionarComicLocal.crearComic(comicDTO);	
		} catch (Exception e) {
			resultadoDTO.setExitoso(false);
			resultadoDTO.setMensajeEjecucion(e.getMessage());
		}
		return resultadoDTO;	
	}

}
