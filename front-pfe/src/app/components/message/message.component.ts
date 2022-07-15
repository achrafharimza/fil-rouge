import { Component, OnInit } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Message } from 'src/app/models/message';
import { Student } from 'src/app/models/student';
import { MessagesrvsService } from 'src/app/services/messagesrvs.service';
import { TokenService } from 'src/app/services/token.service';

@Component({
  selector: 'app-message',
  templateUrl: './message.component.html',
  styleUrls: ['./message.component.scss'],
})
export class MessageComponent implements OnInit {
  constructor(
    private messageService: MessagesrvsService,
    private modalService: NgbModal,
    private tokenService: TokenService
  ) {
    this.getAll();
  }

  ngOnInit(): void {}

  pageOfItems: Array<any> | undefined;
  messageTab: Message[] = [];
  messageClicked: Message = {
    etudiantId: {} as Student,
  };
  closeResult: any;
  getAll() {
    this.messageService.findAll().subscribe(
      (messages) => {
        this.messageTab = messages;
      },
      (error: Response) => {
        alert('error unexpexted');
        console.log(error);
      }
    );
  }
  delete(event: any, id: number | undefined) {
    event.stopPropagation();
    this.messageService.delete(id).subscribe(
      (messages) => {},
      (error: Response) => {
        alert('error unexpexted');
        console.log(error);
      }
    );
  }

  open(content: any, message: Message) {
    this.messageClicked = message;
    console.log('INNNNNopen' + this.messageClicked.etudiantId.nom);
    console.log('INNNNNopen' + this.messageClicked.content);
    console.log('INNNNNopen' + this.messageClicked.date);
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
