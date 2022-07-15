import { Component, OnInit } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Annonce } from 'src/app/models/annonce';
import { AnnonceService } from 'src/app/services/annonce.service';
import { TokenService } from 'src/app/services/token.service';

@Component({
  selector: 'app-annonces',
  templateUrl: './annonces.component.html',
  styleUrls: ['./annonces.component.scss'],
})
export class AnnoncesComponent implements OnInit {
  constructor(
    private annonceService: AnnonceService,
    private modalService: NgbModal,
    private tokenService: TokenService
  ) {}

  ngOnInit(): void {
    this.getAll();
  }
  mode = 'list';
  pageOfItems: Array<any> | undefined;
  annonceTab: Annonce[] = [];
  annonceClicked: any;
  closeResult: any;
  getAll() {
    this.annonceService.findAll().subscribe(
      (annonces) => {
        this.annonceTab = annonces;
      },
      (error: Response) => {
        alert('error unexpexted');
        console.log(error);
      }
    );
  }
  delete(event: any, id: number | undefined) {
    event.stopPropagation();
    this.annonceService.delete(id).subscribe(
      () => {},
      (error: Response) => {
        alert('error unexpexted');
        console.log(error);
      }
    );
  }
  onNewAnnonce() {
    if (this.mode != 'new-annonce') {
      this.mode = 'new-annonce';
    } else {
      this.mode = 'list';
    }
  }
  onSaveAnnonce(value: Annonce) {
    this.mode = 'list';
    this.annonceService.add(value).subscribe(
      (data) => {
        // spread operator
        this.annonceTab = [data, ...this.annonceTab];
      },
      (err) => {
        console.log(err);
      }
    );
  }
  open(content: any, annonce: Annonce) {
    this.annonceClicked = annonce;
    this.modalService
      .open(content, { ariaLabelledBy: 'modal-basic-title' })
      .result.then(
        (result) => {
          this.closeResult = `Closed with: ${result}`;
        },
        (reason) => {
          this.closeResult = `Dismissed`;
        }
      );
  }
  onChangePage(pageOfItems: Array<any>) {
    // update current page of items
    this.pageOfItems = pageOfItems;
  }
  isAdmin() {
    return this.tokenService.isAdmin();
  }
}
