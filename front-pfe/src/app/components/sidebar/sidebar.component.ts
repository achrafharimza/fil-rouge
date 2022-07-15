import { Component, OnInit } from '@angular/core';
import { TokenService } from 'src/app/services/token.service';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css'],
})
export class SidebarComponent implements OnInit {
  constructor(private tokenService: TokenService) {}

  ngOnInit(): void {}
  isAdmin() {
    return this.tokenService.isAdmin();
  }
}
