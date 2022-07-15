import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TokenService } from 'src/app/services/token.service';

@Component({
  selector: 'app-menubar',
  templateUrl: './menubar.component.html',
  styleUrls: ['./menubar.component.scss'],
})
export class MenubarComponent implements OnInit {
  constructor(private tokenService: TokenService, private router: Router) {}
  currentuser: any = null;
  isadmin: any = null;
  ngOnInit(): void {
    console.log('ngOnInit');
    this.tokenService.authStatus.subscribe((res) => {
      this.currentuser = this.tokenService.getInfos();
      console.log('currentuserNG : ', this.currentuser);
      this.isadmin = this.tokenService.isAdmin();
      console.log('isadminNG : ', this.isadmin);
    });
  }

  logout() {
    this.tokenService.remove();
    this.tokenService.changeStatus(false);
    this.router.navigateByUrl('/login');
  }
}
