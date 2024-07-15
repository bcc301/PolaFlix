import { UsuarioService } from 'src/app/services/usuario.service';
import { ActivatedRoute } from '@angular/router';
import { Component } from '@angular/core';
import { SerieService } from 'src/app/services/serie.service';

@Component({
  selector: 'app-series',
  templateUrl: './series.component.html',
  styleUrls: ['./series.component.css']
})


export class SeriesComponent {

  abecedario: string[] = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'.split('');
  inicialEscogida: string = '';
  textoBusqueda: string = '';
  
  seriesPendientes: any[] = [];
  series: any[] = [];
  allSeries: any[] = [];
  
  usuarioId: number = 1;
  descripcion: boolean[] = [];
  
  mensajeError: string = "";



  constructor(private serieService: SerieService, private usuarioService: UsuarioService, private route: ActivatedRoute) { }

  ngOnInit(): void {

    this.route.params.subscribe(params => {
      this.usuarioId = params['usuarioId'];
    });

    this.serieService.getSeries().subscribe({
      next: series => {
        this.series = series;
        this.allSeries = series;
        this.ordenarSeries();
      }, 

      error: error => {

        if (error.status == 0) {

          this.mensajeError = "Error. Servidor no disponible.";
          console.log(this.mensajeError);

        } else {

          this.mensajeError = "Error obteniendo las series.";
          console.log(this.mensajeError);
        }
      }

    });
  }

  // metodo para buscar serie
  buscar(textoBusqueda: string) {

    console.log(textoBusqueda);
    this.series = this.allSeries.filter(serie => serie.titulo.toLowerCase().includes(textoBusqueda.toLowerCase()));
    this.ordenarSeries();

    this.series.forEach(serie => {
      serie.exactMatch = serie.title.toLowerCase() === textoBusqueda.toLowerCase();
    });

  }

  // mostrar la sinopsis de la serie
  mostrarDescripcion(serie: any): void {
    this.descripcion[serie.id] = !this.descripcion[serie.id];
  }

  // ordenar series por orden alfabetico
  ordenarSeries(): void {

    if (Array.isArray(this.series)) {
      this.series = this.series.sort((a, b) => {

        if (a.titulo > b.titulo) {
          return 1;
        }

        if (a.titulo < b.titulo) {
          return -1;
        }

        return 0;

      });
    }
  }


  esSeriePendiente(serie: any): boolean {
    return this.seriesPendientes.some((ps: { id: any; }) => ps.id === serie.id);
  }

  // coger la letra inicial de la serie
  filtrar(inicial: string): void {

    this.inicialEscogida = inicial;
    this.series = this.allSeries.filter(serie => serie.titulo.charAt(0) === inicial);
  
  }

  limpiarFiltro(): void {

    // eliminar la incial escogida del filtro de busqueda
    this.inicialEscogida = '';
    this.series = this.allSeries;
  
  }


  anadirSeriePendiente(serie: any) {

    this.usuarioService.anadirSerieAPendientes(this.usuarioId, serie.id).subscribe({
      next: seriesPendientes => {
        this.seriesPendientes = seriesPendientes;
      },

      error: error => {

        if (error.status == 404) {
          this.mensajeError = "Error. El usuario o la serie no existen";
          console.log(this.mensajeError);

        } else if (error.status == 0) {

          this.mensajeError = "Error. Servidor no disponible";
          console.log(this.mensajeError);

        } else {

          this.mensajeError = "Error añdiendo la serie a series pendientes.";
          console.log(error);

        }
      }
    });

  }
}