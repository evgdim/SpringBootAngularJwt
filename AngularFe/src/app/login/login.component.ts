import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthenticationService } from '../authentication.service';
import { Login } from '../model/login';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup;
  loginData: any;

  constructor(private fb: FormBuilder, private auth: AuthenticationService) {
    this.loginForm = fb.group({
      username: ['', Validators.required],
      password: ['', Validators.required]
    });
  }

  ngOnInit() {
  }

  login(loginData) {
    console.log(loginData);
    const login: Login = {username: loginData.username, password: loginData.password};
    this.auth.login(login)
    .subscribe(resp => console.log(resp), err => console.error(err));
  }
}
