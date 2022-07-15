import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TokenService } from 'src/app/services/token.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss'],
})
export class NavbarComponent implements OnInit {
  constructor(private tokenService: TokenService, private router: Router) {}

  ngOnInit(): void {
    this.isAdmin();
  }
  isAdmin() {
    return this.tokenService.isAdmin();
  }
  isAuthentificated() {
    return this.tokenService.loggedIn();
  }
  logout() {
    this.tokenService.remove();
    this.tokenService.changeStatus(false);
    this.router.navigateByUrl('/login');
  }
}
