import { Component, OnInit } from '@angular/core';
import { TranslateService } from '@ngx-translate/core';
import { ComicDTO } from '../../dto/comic.dto';
import { MultiLanguage } from '../../multilanguage/multilanguage';

@Component({
  selector: 'gestionar-comic',
  templateUrl: './gestionar-comic.component.html'
})
export class GestionarComicComponent extends MultiLanguage implements OnInit {

  public comicDTO : ComicDTO;
  public comicDTOData : ComicDTO;
  public listaComics : Array<ComicDTO>;
  public mostrarItem : boolean;
  public tituloComplemento : any;
  public mostrarData : boolean;

  constructor(public translate: TranslateService) { 
    super(translate);
  }

  ngOnInit() {
    this.tituloComplemento = {
      nombreSemillero : "Semillero 2022"
    }
    this.listaComics = new Array<ComicDTO>();
    this.comicDTO = new ComicDTO();

  }

  public crearComic() : void {
    this.listaComics.push(this.comicDTO);
    this.comicDTO = new ComicDTO();
    this.mostrarItem = true;
  }

  public cerrar() : void {
    this.mostrarItem = false;
    this.mostrarData = false;
  }

  public imprimirDataComic(indice : number) : void {
    this. comicDTOData = this.listaComics[indice];
    this.mostrarData = true;
  }

}
