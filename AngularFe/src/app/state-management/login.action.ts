import { Action } from '@ngrx/store';
import { Login } from '../model/login';
export class LoginAction implements Action {
    constructor(public type: string, public payload: any) {}
}
