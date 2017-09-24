export interface LoginState {
    status: LoginStatus;
    token: string;
}

export enum LoginStatus {
    LOGGED_IN, NOT_LOGGED_IN, LOGIN_ERROR, LOGIN_REQ_SENT
}

export const initialLoginState: LoginState = {
    status: LoginStatus.NOT_LOGGED_IN,
    token: null
};

