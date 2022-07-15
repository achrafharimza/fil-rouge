import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Student } from '../models/student';

@Injectable({
  providedIn: 'root',
})
export class StudentService {
  constructor(private http: HttpClient) {}
  apiUrl = 'http://localhost:9898/etudiant';

  findAll() {
    return this.http.get<Student[]>(`${this.apiUrl}/all`);
  }
  findAllByABS(date: String) {
    return this.http.get<Student[]>(`${this.apiUrl}/getByDate/${date}`);
  }
  add(newStudent: Student) {
    return this.http.post<Student>(`${this.apiUrl}/add`, newStudent);
  }
  delete(id: number | undefined) {
    return this.http.delete(`${this.apiUrl}/delete/${id}`);
  }
  update(student: Student) {
    return this.http.put<Student>(
      `${this.apiUrl}/update/${student.id}`,
      student
    );
  }
}
