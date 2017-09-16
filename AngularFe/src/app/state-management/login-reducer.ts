import { Action, ActionReducer } from '@ngrx/store';
import { LoginAction } from './login.action';
import { LoginState, initialLoginState, LoginStatus } from './login-state';
import { LOGIN_ATEMPT, LOGIN_ERROR, LOGIN_SUCCESS} from './actions';

export function loginReducer(state = initialLoginState, action: LoginAction) {
    switch (action.type) {
        case LOGIN_ATEMPT: {
            console.log('login attempt', action);
            return {status: LoginStatus.LOGIN_REQ_SENT, message: '' };
        }
        case LOGIN_ERROR: {
            return {status: LoginStatus.LOGIN_ERROR, message: '' };
        }
        case LOGIN_SUCCESS: {
            return {status: LoginStatus.LOGGED_IN, message: '' };
        }
        default: {
            return state;
        }
    }
 }
