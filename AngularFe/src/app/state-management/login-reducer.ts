import { Action, ActionReducer } from '@ngrx/store';
import { LoginState, initialLoginState, LoginStatus } from './login-state';
import { LOGIN_ATEMPT, LOGIN_ERROR, LOGIN_SUCCESS} from './actions';

export const loginReducer: ActionReducer<LoginState> =
 (state = initialLoginState, action: Action) => {
    switch (action.type) {
        case LOGIN_ATEMPT: {
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
 };
