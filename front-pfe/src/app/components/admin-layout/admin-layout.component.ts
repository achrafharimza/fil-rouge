import { Component, OnInit } from '@angular/core';
import { TokenService } from 'src/app/services/token.service';

@Component({
  selector: 'app-admin-layout',
  templateUrl: './admin-layout.component.html',
  styleUrls: ['./admin-layout.component.scss'],
})
export class AdminLayoutComponent implements OnInit {
  constructor(private tokenService: TokenService) {}

  ngOnInit(): void {}
  isAdmin() {
    return this.tokenService.isAdmin();
  }
}
