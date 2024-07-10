import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})


export class LoginService {

  private url_base = "http://localhost:8000/usuarios";

  constructor(private http: HttpClient) {

  }



  public login(email: string, contrasena: string): Observable<any> {
    return this.http.get(this.url_base + "?email=" + email)
  }
  
}
