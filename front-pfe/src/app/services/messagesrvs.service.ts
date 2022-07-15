import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Message } from '../models/message';

@Injectable({
  providedIn: 'root',
})
export class MessagesrvsService {
  constructor(private http: HttpClient) {}
  apiUrl = 'http://localhost:9898/message';

  findAll() {
    return this.http.get<Message[]>(`${this.apiUrl}/all`);
  }
  add(newMessage: Message) {
    return this.http.post<Message>(`${this.apiUrl}/add`, newMessage);
  }
  delete(id: number | undefined) {
    return this.http.delete(`${this.apiUrl}/delete/${id}`);
  }
}
