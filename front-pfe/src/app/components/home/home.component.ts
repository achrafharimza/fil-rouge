import { Component, OnInit } from '@angular/core';
import { TokenService } from 'src/app/services/token.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit {
  constructor(private tokenService: TokenService) {}

  ngOnInit(): void {}
  isAuthentificated() {
    return this.tokenService.loggedIn();
  }
}
