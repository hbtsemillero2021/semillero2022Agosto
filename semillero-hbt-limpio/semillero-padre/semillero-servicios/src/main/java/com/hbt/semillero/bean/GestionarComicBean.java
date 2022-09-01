package com.hbt.semillero.bean;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.hbt.semillero.dtos.ComicDTO;
import com.hbt.semillero.dtos.ConsultaNombrePrecioComicDTO;
import com.hbt.semillero.dtos.ResultadoDTO;
import com.hbt.semillero.entity.Comic;
import com.hbt.semillero.poo.interfaces.IGestionarComicLocal;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class GestionarComicBean implements IGestionarComicLocal {

	private final static Logger LOGGER = Logger.getLogger(GestionarComicBean.class);
	
	@PersistenceContext
	private EntityManager em;

	@Override
	@SuppressWarnings("unchecked")
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public ConsultaNombrePrecioComicDTO consultarNombrePrecioComic(Long idComic) {
		LOGGER.info("Inicia ejecucion consultarNombrePrecioComic() ");
		
		ConsultaNombrePrecioComicDTO dto = new ConsultaNombrePrecioComicDTO();	
		String consultaNombrePrecioComic = "SELECT new com.hbt.semillero.dtos.ConsultaNombrePrecioComicDTO(nombre, precio) "
				+ " FROM Comic "
				+ " WHERE id = :idComic ";
		try {
			Query queryConsultaNombrePrecioComic = em.createQuery(consultaNombrePrecioComic);
			queryConsultaNombrePrecioComic.setParameter("idComic", idComic);
			dto = (ConsultaNombrePrecioComicDTO) queryConsultaNombrePrecioComic.getSingleResult();
			dto.setExitoso(true);
			dto.setMensajeEjecucion("Se ha ejecutado exitosamente");
		} catch (NonUniqueResultException nure) {
			LOGGER.info("Se ha presentado NonUniqueResultException: " + nure.getMessage());
			dto.setExitoso(false);
			dto.setMensajeEjecucion("Existen registros duplicados para el id " + idComic);
		} catch (NoResultException nre) {
			LOGGER.info("Se ha presentado NoResultException: " + nre.getMessage());
			dto.setExitoso(false);
			dto.setMensajeEjecucion("No existen registros para el comic con id " + idComic);
		} catch (Exception e) {
			dto.setExitoso(false);
			dto.setMensajeEjecucion("Se ha presentado un error tecnico " + e.getMessage());
			LOGGER.info("Se ha presentado un error tecnico " + e.getMessage());
		}
//		try {
//			Query queryConsultaNombrePrecioComic = em.createQuery(consultaNombrePrecioComic);
//			queryConsultaNombrePrecioComic.setParameter("idComic", idComic);
//			List<ConsultaNombrePrecioComicDTO> dtoList = queryConsultaNombrePrecioComic.getResultList();
//			
//			if(dtoList.isEmpty()) {
//				dto.setExitoso(false);
//				dto.setMensajeEjecucion("No existen registros para el comic con id " + idComic);
//				return dto;
//			}
//			dto.setNombre(dtoList.get(0).getNombre());
//			dto.setPrecio(dtoList.get(0).getPrecio());
//			dto.setExitoso(true);
//			dto.setMensajeEjecucion("Se ha ejecutado exitosamente");	
//		} catch (Exception e) {
//			dto.setExitoso(false);
//			dto.setMensajeEjecucion("Se ha presentado un error tecnico " + e.getMessage());
//			LOGGER.info("Se ha presentado un error tecnico " + e.getMessage());
//		}
		
		
		LOGGER.info("Finaliza ejecucion consultarNombrePrecioComic() ");
		
		return dto;
	}
	
	
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public ResultadoDTO crearComic(ComicDTO comicDTO) throws Exception {
		
		if(comicDTO.getNombre() == null) {
			throw new Exception("El campo nombre es requerido");
		}
		
		Comic comic = this.convertirComicDTOToComic(comicDTO);
		em.persist(comic);
		
		ResultadoDTO resultadoDTO = new ResultadoDTO();
		resultadoDTO.setExitoso(true);
		resultadoDTO.setMensajeEjecucion("El comic ha sido creado exitosamente");
		return resultadoDTO;
	}
	
	private Comic convertirComicDTOToComic(ComicDTO comicDTO) {
		Comic comic = new Comic();
		comic.setId(comicDTO.getId());
		comic.setNombre(comicDTO.getNombre());
		comic.setEditorial(comicDTO.getEditorial());
		comic.setTematicaEnum(comicDTO.getTematicaEnum());
		comic.setColeccion(comicDTO.getColeccion());
		comic.setNumeroPaginas(comicDTO.getNumeroPaginas());
		comic.setPrecio(comicDTO.getPrecio());
		comic.setAutores(comicDTO.getAutores());
		comic.setColor(comicDTO.getColor());
		comic.setFechaVenta(comicDTO.getFechaVenta());
		comic.setEstadoEnum(comicDTO.getEstadoEnum());
		comic.setCantidad(comicDTO.getCantidad());
		return comic;
	}
}
