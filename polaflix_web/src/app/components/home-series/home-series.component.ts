import { Component, Input } from '@angular/core';



@Component({
  styleUrls: ['./home-series.component.css'],
  selector: 'app-home-series',
  templateUrl: './home-series.component.html'
})



export class HomeSeriesComponent {

  @Input() series: any[] = [];
  @Input() usuarioId: number = 1;
  @Input() titulo: string = '';
  
}
