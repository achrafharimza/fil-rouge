import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Annonce } from '../models/annonce';

@Injectable({
  providedIn: 'root',
})
export class AnnonceService {
  constructor(private http: HttpClient) {}
  apiUrl = 'http://localhost:9898/annonce';

  findAll() {
    return this.http.get<Annonce[]>(`${this.apiUrl}/all`);
  }
  add(newAnnonce: Annonce) {
    return this.http.post<Annonce>(`${this.apiUrl}/add`, newAnnonce);
  }
  delete(id: number | undefined) {
    return this.http.delete(`${this.apiUrl}/delete/${id}`);
  }
}
