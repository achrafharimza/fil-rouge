import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { NotfoundComponent } from './components/notfound/notfound.component';
import { AdminLayoutComponent } from './components/admin-layout/admin-layout.component';
import { AbsencesComponent } from './components/absences/absences.component';
import { AnnoncesComponent } from './components/annonces/annonces.component';
import { MessageComponent } from './components/message/message.component';
import { ProfileComponent } from './components/profile/profile.component';
import { AuthGuard } from './guards/auth.guard';
import { IsadminGuard } from './guards/isadmin.guard';
import { WelcomeComponent } from './components/welcome/welcome.component';

const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },

  { path: 'login', component: LoginComponent },
  {
    path: 'menu',
    canActivate: [AuthGuard],

    component: AdminLayoutComponent,
    children: [
      { path: '', redirectTo: 'welcome', pathMatch: 'full' },
      {
        path: 'absences',
        canActivate: [IsadminGuard],

        component: AbsencesComponent,
      },
      {
        path: 'welcome',

        component: WelcomeComponent,
      },
      {
        path: 'annonces',

        component: AnnoncesComponent,
      },
      {
        path: 'messages',

        component: MessageComponent,
      },
      {
        path: 'profile',

        component: ProfileComponent,
      },
    ],
  },

  { path: '**', component: NotfoundComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
