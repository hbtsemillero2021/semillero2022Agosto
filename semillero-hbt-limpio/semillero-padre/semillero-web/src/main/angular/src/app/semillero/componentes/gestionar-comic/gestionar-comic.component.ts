import { BaseRowDef } from '@angular/cdk/table';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';
import { ComicDTO } from '../../dto/comic.dto';
import { MultiLanguage } from '../../multilanguage/multilanguage';
import { TematicaEnum } from '../crear-persona/enums/tematica.enum';

@Component({
  selector: 'gestionar-comic',
  templateUrl: './gestionar-comic.component.html'
})
export class GestionarComicComponent extends MultiLanguage implements OnInit {

  public gestionarComicForm: FormGroup;
  public comicDTO: ComicDTO;
  public comicDTOData: ComicDTO;
  public listaComics: Array<ComicDTO>;
  public mostrarItem: boolean;
  public tituloComplemento: any;
  public mostrarData: boolean;
  public validoFormulario: boolean;

  constructor(public translate: TranslateService, private formBuilder: FormBuilder, private router : Router) {
    super(translate);
    this.gestionarComicForm = this.formBuilder.group({
      nombre: [null, Validators.required],
      editorial: [null, Validators.required],
      tematicaEnum: [null, Validators.required],
      coleccion: [null],
      numeroPaginas: [null, Validators.required],
      precio: [null, Validators.required],
      autores: [null],
      color: [true],
      cantidad: [null],
    });
  }

  ngOnInit() {
    this.tituloComplemento = {
      nombreSemillero: "Semillero 2022"
    }
    this.listaComics = new Array<ComicDTO>();
    this.comicDTO = new ComicDTO();

  }

  public crearComic(): void {
    if(this.gestionarComicForm.invalid) {
      this.validoFormulario = true; 
      return;
    }
    
    
    this.comicDTO = this.gestionarComicForm.value;
    this.listaComics.push(this.comicDTO);
    this.validoFormulario = false;
    this.comicDTO = new ComicDTO();
    this.mostrarItem = true;
    this.limpiarForm();
  }

  private limpiarForm() : void {
    this.gestionarComicForm.reset(); // Opcion 1 limpiar formulario
    // this.gestionarComicForm.disable();
    // this.gestionarComicForm.enable();
    // Opcion 2 limpiar formulario
    // this.f.nombre.setValue(null);
    // this.f.editorial.setValue(null); 
    // this.f.tematicaEnum.setValue(null); 
    // this.f.coleccion.setValue(null); 
    // this.f.numeroPaginas.setValue(null); 
    // this.f.precio.setValue(null); 
    // this.f.autores.setValue(null); 
    // this.f.color.setValue(true);
    // this.f.cantidad.setValue(null); 
  }

  public cerrar(): void {
    this.mostrarItem = false;
    this.mostrarData = false;
  }

  public imprimirDataComic(indice: number): void {
    this.comicDTOData = this.listaComics[indice];
    this.mostrarData = true;
  }

  public agregarValidacionColeccion() : void {
    let tematicaEnumRequiereColeccion = [TematicaEnum.AVENTURA.toUpperCase(),TematicaEnum.HORROR.toUpperCase()];
    let tematicaSeleccionada = this.f.tematicaEnum.value;
    this.f.coleccion.enable();
    // this.f.coleccion.clearValidators();
    // this.f.coleccion.updateValueAndValidity();

    if(tematicaEnumRequiereColeccion.indexOf(tematicaSeleccionada) >= 0) {
      this.f.coleccion.disable();
      // this.f.coleccion.setValidators(Validators.required);
      // this.f.coleccion.updateValueAndValidity();
    }

  }

  public irAConsultarComic(comic : ComicDTO) : void {
    this.router.navigate(['consultar-comic', comic], { skipLocationChange : true })
  }

  get f() {
    return this.gestionarComicForm.controls;
  }

}
