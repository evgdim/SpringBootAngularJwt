import { Injectable } from '@angular/core';
import { Http, Headers } from '@angular/http';
import { Login } from './model/login';

@Injectable()
export class AuthenticationService {

  constructor(private http: Http) { }

  login(credentials: Login) {
    const headers = new Headers();
    headers.append('Content-Type', 'application/json');
    return this.http.post('http://localhost:8080/user/token', credentials, headers);
  }

}
