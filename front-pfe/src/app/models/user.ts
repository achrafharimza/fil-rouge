export class User {
  id?: number;
  nom?: string;
  prenom?: string;
  email?: string;
  password?: string;
  admin?: boolean;

  constructor() {
    this.nom = '';
    this.prenom = '';
    this.email = '';
    this.password = '';
    this.admin = false;
  }
}
