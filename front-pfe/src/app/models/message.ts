import { Student } from './student';

export interface Message {
  id?: number;

  // sender?: string;
  // eamailsender?: string;
  // receiver?: String;
  content?: String;
  date?: String;
  etudiantId: Student;
}
