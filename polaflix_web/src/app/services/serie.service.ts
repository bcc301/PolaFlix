import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SerieService {

  // url base para las peticiones
  private url_base = "http://localhost:8000/series";

  constructor(private http: HttpClient) {

  }


  // metodo para recuperar una serie por su id
  public getSerie(serieId: number): Observable<any> {
    
    // formar url concreta de la peticion
    return this.http.get(this.url_base + "/" + serieId)
  }

  // metodo para recuperar una serie por su letra inicial
  public getSeriesByInicial(inicial: string): Observable<any> {
    
    // formar url concreta de la peticion
    return this.http.get(this.url_base + "?inicial=" + inicial)
  }

  // metodo para recuperar todas las series de la bbdd
  public getSeries(): Observable<any> {
    
    // url base es ya la url de la peticion
    return this.http.get(this.url_base)
  }

}
