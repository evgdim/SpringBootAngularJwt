import { Component, OnInit } from '@angular/core';
import { Store } from '@ngrx/store';
import { LoginState } from '../../state-management/login-state';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthenticationService } from '../../services/authentication.service';
import { Login } from '../../model/login';
import { LOGIN_ATEMPT } from '../../state-management/actions';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup;
  loginData: any;

  constructor(private fb: FormBuilder, private auth: AuthenticationService, private loginStore: Store<LoginState>) {
    this.loginForm = fb.group({
      username: ['', Validators.required],
      password: ['', Validators.required]
    });
    console.log(loginStore);
    loginStore.select('status').subscribe(s => console.log('status', s));
  }

  ngOnInit() {
  }

  login(loginData) {
    console.log(loginData);
    const login: Login = {username: loginData.username, password: loginData.password};
    this.loginStore.dispatch({ type: LOGIN_ATEMPT});
    // this.auth.login(login)
    // .subscribe(resp => console.log(resp), err => console.error(err));
  }
}
