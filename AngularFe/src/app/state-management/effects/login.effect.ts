import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { Actions, Effect } from '@ngrx/effects';
import { Observable } from 'rxjs/Observable';
import { AuthenticationService } from '../../services/authentication.service';
import { LOGIN_ATEMPT, LOGIN_SUCCESS, LOGIN_ERROR } from '../actions';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/startWith';
import 'rxjs/add/operator/switchMap';
import 'rxjs/add/operator/do';
import { of } from 'rxjs/Observable/of';

@Injectable()
export class AuthEffects {
  constructor(
    private http: Http,
    private actions$: Actions,
    private auth: AuthenticationService
  ) { }

  @Effect() login$ = this.actions$
      .ofType(LOGIN_ATEMPT)
      //.map(action => action.payload)
      .do(p => console.log(p))
      .switchMap(payload => this.auth.login(payload.payload)
        .map(res => ({ type: LOGIN_SUCCESS, payload: res.json() }))
        .catch(() => of({ type: LOGIN_ERROR }))
      );
}