import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})

export class UsuarioService {

  // url base para los api endpoints de los usuarios
  private url_base = "http://localhost:8000/usuarios";

  constructor(private http: HttpClient) {

  }

  // TODO: pendiente revisar
  /*public getUsuarioByEmail(email: string): Observable<any> {
    return this.http.get(this.url_base + "?email=" + email)
  }*/

  // recuperar usuario por su id
  public getUsuarioById(usuarioId: number): Observable<any> {
    return this.http.get(this.url_base + "/" + usuarioId)
  }

  // recuperar ultimo capitulo visto de una serie por parte de un usuario
  public getUltCapVisto(usuarioId: number, serieId: number): Observable<any> {
    return this.http.get(this.url_base + "/" + usuarioId + "/ultimo-capitulo-visto/" + serieId)
  }

  // marcar un capitulo como visto
  public verCapitulo(usuarioId: number, serieId: number, seasonNumber: number, chapterNumber: number): Observable<any> {
    return this.http.put(this.url_base + "/" + usuarioId + "/visualizaciones-capitulo/serie-vista/" + serieId + "/season/" + seasonNumber + "/chapter/" + chapterNumber, {})
  }

  // anadir una serie a series pendientes de un usuario
  public anadirSerieAPendientes(usuarioId: number, serieId: number): Observable<any> {
    return this.http.put(this.url_base + "/" + usuarioId + "/series-pendientes/" + serieId, {})
  }

  // recuperar las facturas de un usuario
  public getFacturas(usuarioId: number): Observable<any> {
    return this.http.get(this.url_base + "/" + usuarioId + "/facturas")
  }

  // recuperar series empezadas de un usuario
  public getSeriesEmpezadas(usuarioId: number): Observable<any> {
    return this.http.get(this.url_base + "/" + usuarioId + "/series-empezadas")
  }

  // recuperar series pendientes de un usuario
  public getSeriesPendientes(usuarioId: number): Observable<any> {
    return this.http.get(this.url_base + "/" + usuarioId + "/series-pendientes")
  }

  // recuperar las series terminadas de un usuario
  public getSeriesTerminadas(usuarioId: number): Observable<any> {
    return this.http.get(this.url_base + "/" + usuarioId + "/series-terminadas")
  }

}
