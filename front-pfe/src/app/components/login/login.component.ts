import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from 'src/app/models/user';
import { TokenService } from 'src/app/services/token.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
})
export class LoginComponent implements OnInit {
  constructor(
    private userService: UserService,
    private router: Router,
    private tokenService: TokenService,
    private httpClient: HttpClient
  ) {}
  loguser: User = {
    email: 'admin@gmail.com',
    password: 'admin',
  };

  errorMessage = '';
  ngOnInit(): void {
    this.loginForm.value.email = 'loginForm.value.email';
  }

  loginForm = new FormGroup({
    email: new FormControl(null, [Validators.required, Validators.email]),
    password: new FormControl(null, [
      Validators.required,
      Validators.minLength(2),
    ]),
  });
  get f() {
    return this.loginForm.controls;
  }

  loginUser() {
    this.userService.login(this.loginForm.value).subscribe(
      (res) => {
        this.tokenService.handle(res);
        this.tokenService.changeStatus(true);
        this.router.navigate(['/menu']);
      },
      (error: Response) => {
        console.log(error);
        this.errorMessage = 'Vérifier vos informations';
      }
    );
  }
}
