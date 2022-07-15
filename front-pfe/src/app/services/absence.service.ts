import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Absence } from '../models/absence';

@Injectable({
  providedIn: 'root',
})
export class AbsenceService {
  constructor(private http: HttpClient) {}
  apiUrl = 'http://localhost:9898/absence';

  add(newAbsence: Absence) {
    return this.http.post<Absence>(`${this.apiUrl}/add`, newAbsence);
  }
  delete(newAbsence: Absence) {
    return this.http.delete(
      `${this.apiUrl}/delete/${newAbsence.date}/${newAbsence.etudiantId.id}`
    );
  }
  update(Absence: Absence) {
    return this.http.put<Absence>(
      `${this.apiUrl}/update/${Absence.id}`,
      Absence
    );
  }
}
