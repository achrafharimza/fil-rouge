import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  constructor(private http: HttpClient) {}

  // apiUrl = 'http://localhost:3100/users';
  apiUrlLogin = 'http://localhost:9898/login';
  apiUrl = 'http://localhost:9898/user';

  login(data: { email: string; password: string }) {
    return this.http.post(this.apiUrlLogin, data);
  }
  register(newuser: User) {
    return this.http.post<User>(`${this.apiUrl}/add`, newuser);
  }
}
