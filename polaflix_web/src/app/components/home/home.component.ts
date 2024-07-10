import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { UsuarioService } from '../../services/usuario.service';


@Component({
  selector: 'app-home',
  styleUrls: ['./home.component.css'],
  templateUrl: './home.component.html'
})


export class HomeComponent implements OnInit {


  usuarioId: number = 1;

  seriesEmpezadas: any = {};
  seriesTerminadas: any = {};
  seriesPendientes: any = {};
  
  mensajeError: string = "";

  constructor(private usuarioService: UsuarioService, private route: ActivatedRoute) { }

  ngOnInit(): void {

    this.route.params.subscribe(params => {
      
      this.usuarioId = params['usuarioId'];

    });
    
    this.usuarioService.getUsuarioById(this.usuarioId).subscribe({
      next: usuario => {

        this.seriesEmpezadas = Object.values(usuario.seriesEmpezadas);
        this.seriesTerminadas = Object.values(usuario.seriesTerminadas);
        this.seriesPendientes = Object.values(usuario.seriesPendientes);
        
      },
      error: error => {

        if (error.status == 404) {

          this.mensajeError = "Error. El usuario no existe.";

        } else if (error.status == 0) {
          
          this.mensajeError = "Error. Servidor no está disponible.";

        } else {

          this.mensajeError = "Error obteniendo el usuario indicado.";
          console.log(error);

        }
      }
    })
  }
}
