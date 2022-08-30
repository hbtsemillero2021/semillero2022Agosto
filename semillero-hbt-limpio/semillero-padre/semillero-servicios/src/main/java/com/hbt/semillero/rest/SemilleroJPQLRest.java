/**
 * SemilleroJPQLRest.java
 */
package com.hbt.semillero.rest;

import java.util.List;

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
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.hbt.semillero.entity.Comic;
import com.hbt.semillero.enums.EstadoEnum;
import com.hbt.semillero.enums.TematicaEnum;

/**
 * <b>Descripción:<b> Clase que determina
 * <b>Caso de Uso:<b> 
 * @author Diego Fernando Alvarez Silva
 * @version 1.0
 */
@Path("/SemilleroJPQLRest")
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class SemilleroJPQLRest {

	/**
	 * Constante que contendra el log de la clase AritmeticaTest
	 */
	private final static Logger LOG = Logger.getLogger(SemilleroJPQLRest.class);

	@PersistenceContext
	private EntityManager em;

	@GET
	@Path("/test")
	@Produces(MediaType.APPLICATION_JSON)
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	@SuppressWarnings("unchecked")
	public String generarOperacionComic() {
		LOG.info("Se ejecuta generarOperacionComic()");
		Comic comic = null;

		try {
			// Obtencion de un registro de la tabla comic haciendo uso del metodo find de la clase EntityManager
			// SELECT * FROM COMIC WHERE ID = 15;
			comic = em.find(Comic.class, 15L);
			LOG.info("DATA COMIC" + comic.toString());

			//Consults en JPQL para obtener un comic con el id 15 pero quemado o hardcodeado haciendo uso del metodo getSingleResult
			String consulta = "SELECT c FROM Comic c WHERE c.id = 15 ";
			Query queryUnComic = em.createQuery(consulta);
			comic = (Comic) queryUnComic.getSingleResult();


			//Consulta en JPQL para obtener un comic con el id 6 tematicaenum y color haciendo uso del metodo getSingleResult y setParameter
			String consultaDos = "SELECT cm FROM Comic cm "
					+ " WHERE cm.id = 15 "
					+ " AND cm.tematicaEnum = 'FANTASTICO'"
					+ " AND cm.color = 0 "
					+ " AND cm.estadoEnum = 'ACTIVO' " ;
			Query queryUnComicDos = em.createQuery(consultaDos);			
			comic = (Comic) queryUnComicDos.getSingleResult();


			String consultaTres = "SELECT cm FROM Comic cm "
					+ " WHERE cm.id = :idComic "
					+ " AND cm.tematicaEnum = :tematicaEnum "
					+ " AND cm.color = :color "
					+ " AND cm.estadoEnum = :estado " ;
			Query queryUnComicTres = em.createQuery(consultaTres);
			queryUnComicTres.setParameter("idComic", comic.getId());
			queryUnComicTres.setParameter("tematicaEnum", TematicaEnum.FANTASTICO);
			queryUnComicTres.setParameter("color", Boolean.FALSE);
			queryUnComicTres.setParameter("estado", EstadoEnum.ACTIVO);
			comic = (Comic) queryUnComicTres.getSingleResult();

			// Query que genera una exception de tipo NoResultException debido a que la consulta no retorna nada
			//			String consultaCuarto = "SELECT cm FROM Comic cm WHERE cm.id = :idComic "
			//					+ " AND cm.tematicaEnum = :tematicaEnum AND cm.color = :colorComic ";
			//			Query queryUnComicCuatro = em.createQuery(consultaCuarto);
			//			queryUnComicCuatro.setParameter("idComic", comic.getId());
			//			queryUnComicCuatro.setParameter("tematicaEnum", TematicaEnum.HUMORISTICO);
			//			queryUnComicCuatro.setParameter("colorComic", Boolean.TRUE);
			//			comic = (Comic) queryUnComicCuatro.getSingleResult();

			//Traer los comics filtrando por tematica y color como lista
			String consultaListaComics = "SELECT cm FROM Comic cm WHERE cm.tematicaEnum = :tematicaEnum"
					+ " AND cm.color = :colorComic ";
			Query queryListComics = em.createQuery(consultaListaComics);
			queryListComics.setParameter("tematicaEnum", TematicaEnum.FANTASTICO);
			queryListComics.setParameter("colorComic", Boolean.FALSE);
			List<Comic> listComics = queryListComics.getResultList();

			for (Comic comicList : listComics) {
				LOG.info("DATA COMIC" + comicList.toString());
			}

			// Query que genera una exception de tipo NonUniqueResultException debido a que la consulta retorna mas de 1 registro
			String consultaListaNonUnique = "SELECT cm FROM Comic cm WHERE cm.tematicaEnum = :tematicaEnum"
					+ " AND cm.color = :colorComic ";
			Query queryNonUnique = em.createQuery(consultaListaNonUnique);
			queryNonUnique.setParameter("tematicaEnum", TematicaEnum.FANTASTICO);
			queryNonUnique.setParameter("colorComic", Boolean.FALSE);
			comic = (Comic) queryNonUnique.getSingleResult();
			//List<Comic> listComics = queryListComics.getSingleResult();

		} catch (NonUniqueResultException nure) {
			LOG.error("Se ha presentado ducplicidad de datos con el id 15" + nure.getMessage());
		} catch (NoResultException nre) {
			LOG.error("No se encontro registro para el id 15" + nre.getMessage());
		} catch (Exception e) {
			LOG.error("Se ha presentado un error tecnico" + e.getMessage());
		}

		LOG.info("Finaliza generarOperacionComic()");
		return "";
	}






}
