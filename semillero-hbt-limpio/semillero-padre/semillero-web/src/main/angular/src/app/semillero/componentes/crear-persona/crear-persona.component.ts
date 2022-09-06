import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'crear-persona',
  templateUrl: './crear-persona.component.html',
  styleUrls: ['./crear-persona.component.css']
})
export class CrearPersonaComponent implements OnInit {

  public saludo : string;

  constructor() { }

  ngOnInit() {
    this.saludo = "Hola semillero 2022"
  }

}
