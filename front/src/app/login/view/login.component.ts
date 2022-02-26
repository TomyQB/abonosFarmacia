import { UserOutput } from './../model/User';
import { LoginHttpService } from './../service/Login-http.service';
import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  userOutput: UserOutput = {};
  
    
  nameFormControl = new FormControl('', [
    Validators.required,
  ]);

  passwordFormControl = new FormControl('', [
    Validators.required,
  ]);

  constructor(private loginHttpService: LoginHttpService, private router: Router) { }

  ngOnInit(): void {
  }

  login() {
    this.userOutput.name = this.nameFormControl.value;
    this.userOutput.password = this.passwordFormControl.value

    if(this.userOutput.name != null && this.userOutput.password != null) {
      this.loginHttpService.login(this.userOutput).subscribe(user => {
        if(user != null) {
          localStorage.setItem('user', "true");
          this.router.navigateByUrl("/search");
        } else {
          alert("Usuario o contraseña erronea")
        }
      })
    }
  }

}
