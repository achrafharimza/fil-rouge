import { Component, OnInit } from '@angular/core';
import { AppComponent } from 'src/app/app.component';
import { Student } from 'src/app/models/student';
import { StudentService } from 'src/app/services/student.service';
import { ButtonModule } from 'primeng/button';
import { DatePipe } from '@angular/common';
import { AbsenceService } from 'src/app/services/absence.service';
import { Absence } from 'src/app/models/absence';
import { JwPaginationComponent } from 'jw-angular-pagination';

import {
  ConfirmationService,
  ConfirmEventType,
  MessageService,
} from 'primeng/api';
import { Message } from 'src/app/models/message';
import { MessagesrvsService } from 'src/app/services/messagesrvs.service';

@Component({
  selector: 'app-absences',
  templateUrl: './absences.component.html',
  styleUrls: ['./absences.component.scss'],
  providers: [
    DatePipe,
    ConfirmationService,
    MessageService,
    JwPaginationComponent,
  ],
})
export class AbsencesComponent implements OnInit {
  constructor(
    private studentService: StudentService,
    private appComponent: AppComponent,
    private datePipe: DatePipe,
    private absenceService: AbsenceService,
    private confirmationService: ConfirmationService,
    private messageService: MessageService,
    private msgsevice: MessagesrvsService
  ) {}
  varhome = 'HomeComponent';
  date = new Date();
  studentsTabOrgin: Student[] = [];
  studentsTab: Student[] = [];
  upStudent: Student = {};
  editeIndex: number = 0;
  searchText = '';
  checked: boolean = true;
  dateStrin: String | any = '';

  stateOptions: any[] = [];
  value1: string = 'on';
  value2: string = 'off';
  newAbsence: Absence = {
    etudiantId: {} as Student,
  };

  displayBasic: boolean | undefined;
  newmessage: Message = {
    etudiantId: {} as Student,
  };
  autoResize: boolean = true;
  pageOfItems: Array<any> | undefined;
  mode = 'list';

  ngOnInit() {
    this.stateOptions = [
      { label: 'off', value: 'off' },
      { label: 'on', value: 'on' },
    ];

    console.log(this.datePipe.transform(this.date, 'yyyy-MM-dd'));
    this.dateStrin = this.datePipe.transform(this.date, 'yyyy-MM-dd');
    this.getStudents(this.dateStrin);
  }
  onChangePage(pageOfItems: Array<any>) {
    // update current page of items
    this.pageOfItems = pageOfItems;
  }
  getStudents(date: String) {
    this.studentService.findAllByABS(date).subscribe(
      (students) => {
        (this.studentsTabOrgin = students), (this.studentsTab = students);
      },
      (error: Response) => {
        alert('error unexpexted');
        console.log(error);
      }
    );
  }
  handleChange(e: any, id: any) {
    var isChecked = e.checked;
    console.log(isChecked);
    console.log(id);
    this.newAbsence.etudiantId.id = id;
    this.newAbsence.date = this.dateStrin;
    this.newAbsence.justification = 'absence injustifiee';
    if (isChecked) {
      this.absenceService.add(this.newAbsence).subscribe(
        (absence) => {
          console.log(absence);
        },
        (error: Response) => {
          alert('error unexpexted');
          console.log(error);
        }
      );
    }
    if (!isChecked) {
      this.absenceService.delete(this.newAbsence).subscribe(
        (absence) => {
          console.log(absence);
        },
        (error: Response) => {
          alert('error unexpexted');
          console.log(error);
        }
      );
    }
  }

  showBasicDialog(student: Student) {
    this.displayBasic = true;

    this.newmessage.etudiantId = student;
    // this.message.etudiantId?.nom = student.nom;
  }
  showSuccess() {
    this.messageService.add({
      severity: 'success',
      summary: 'Success',
      detail: 'Message est bien envoyé',
    });
    this.newmessage.content = '';
  }
  sendmsg() {
    this.newmessage.date = this.dateStrin;
    this.newmessage.content = this.newmessage.content;
    this.msgsevice.add(this.newmessage).subscribe(
      (students) => {
        this.showSuccess();
      },
      (error: Response) => {
        alert('error unexpexted');
        console.log(error);
      }
    );
  }
}
