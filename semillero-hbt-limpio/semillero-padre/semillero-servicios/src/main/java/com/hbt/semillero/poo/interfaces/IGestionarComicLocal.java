package com.hbt.semillero.poo.interfaces;

import javax.ejb.Local;

import com.hbt.semillero.dtos.ComicDTO;
import com.hbt.semillero.dtos.ConsultaNombrePrecioComicDTO;
import com.hbt.semillero.dtos.ResultadoDTO;

@Local
public interface IGestionarComicLocal {

	public ConsultaNombrePrecioComicDTO consultarNombrePrecioComic(Long idComic);
	
	public ResultadoDTO crearComic(ComicDTO comicDTO) throws Exception;
	
}
