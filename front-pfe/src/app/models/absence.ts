import { Student } from './student';

export interface Absence {
  id?: number;

  date?: string;

  justification?: String;
  etudiantId: Student;
}
