import { ActivatedRoute } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { UsuarioService } from '../../services/usuario.service';


@Component({
  selector: 'app-cabecera',
  styleUrls: ['./cabecera.component.css'],
  templateUrl: './cabecera.component.html'
})


export class CabeceraComponent implements OnInit {

  usuarioId: number = 1;
  nombreUsuario: string = "";

  constructor(private usuarioService: UsuarioService, private route: ActivatedRoute) {}


  ngOnInit(): void {

    this.route.params.subscribe(params => {
      this.usuarioId = params['usuarioId'];
    });


    this.usuarioId = 1;

    this.usuarioService.getUsuarioById(this.usuarioId).subscribe({

      next: respuesta => {
        this.nombreUsuario = respuesta.nombreUsuario;
      },
      
      error: error => {

        if (error.status == 404) {
          console.log("Usuario no encontrado");
        } else
          console.log(error);
      }
    });

  }

} 
