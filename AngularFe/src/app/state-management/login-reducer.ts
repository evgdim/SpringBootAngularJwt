import { Action, ActionReducer } from '@ngrx/store';
import { LoginAction } from './login.action';
import { LoginState, initialLoginState, LoginStatus } from './login-state';
import { LOGIN_ATEMPT, LOGIN_ERROR, LOGIN_SUCCESS} from './actions';

export function loginReducer(state = initialLoginState, action: LoginAction) {
    console.log(action);
    switch (action.type) {
        case LOGIN_ERROR: {
            return {status: LoginStatus.LOGIN_ERROR, token: null };
        }
        case LOGIN_SUCCESS: {
            return {status: LoginStatus.LOGGED_IN, token: action.payload.token };
        }
        default: {
            return state;
        }
    }
 }
