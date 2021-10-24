import {Component, OnInit} from '@angular/core';
import {CdkDragDrop, moveItemInArray, transferArrayItem} from '@angular/cdk/drag-drop';
import {BoardModel} from '../../models/board.model';
import {CardModel} from '../../models/card.model';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Router} from '@angular/router';
import {TaskModel} from '../../models/task.model';
import {ConcreteSubject} from './ConcreteSubject';
import {ConcreteObserver} from './ConcreteObserver';
import {StringObjModel} from '../../models/stringObj.model';

@Component({
  selector: 'app-board',
  templateUrl: './board.component.html',
  styleUrls: ['./board.component.scss']
})
export class BoardComponent implements OnInit {

  constructor(private http: HttpClient, private router: Router) {
  }

  board: BoardModel = new BoardModel();
  task: TaskModel = new TaskModel();
  tasks: TaskModel[];
  card: CardModel = new CardModel();
  cards: CardModel[];
  lastid: number;
  observer: ConcreteObserver = new ConcreteObserver();
  subject: ConcreteSubject = new ConcreteSubject();
  member: string;
  access: string;
  isView: boolean;
  stringObj: StringObjModel = new StringObjModel();

  ngOnInit(): void {
    this.getAccess();
    this.getBoard();
    this.subject.attach(this.observer);
  }

  logout() {
    this.router.navigateByUrl('');
  }

  back() {
    this.router.navigateByUrl('/boards');
  }

  drop(event: CdkDragDrop<TaskModel[]>) {
    if (event.previousContainer === event.container) {
      moveItemInArray(event.container.data, event.previousIndex, event.currentIndex);
    } else {
      transferArrayItem(event.previousContainer.data,
        event.container.data,
        event.previousIndex,
        event.currentIndex);
    }

    for (const c of this.board.cards) {

      window.localStorage.setItem('cardId', String(c.id));

      const httpOptions = {
        headers: new HttpHeaders({
          cardId: window.localStorage.getItem('cardId')
        })
      };

      this.http.post<string>('http://localhost:8080/tasks/addTasks', c.tasks, httpOptions).subscribe(
        result => {
          console.log(result);
        },
        error => {
          console.log(error);
        });

      window.localStorage.removeItem('cardId');
      setTimeout(() => {
        this.getBoard();
      }, 1000);
    }
  }

  display_task_modal(id: number) {
    if (this.isView === false) {
      const modal = document.getElementById('modal-page');
      modal.style.display = 'block';
      this.lastid = id;
    }
  }

  close_task_modal() {
    const modal = document.getElementById('modal-page');
    modal.style.display = 'none';
  }

  add_task(id: number) {
    window.localStorage.setItem('cardId', String(id));

    const httpOptions = {
      headers: new HttpHeaders({
        cardId: window.localStorage.getItem('cardId')
      })
    };

    this.http.post<string>('http://localhost:8080/tasks/addTask', this.task, httpOptions).subscribe(
      result => {
        console.log(result);
        alert('Successfully created task.');
      },
      error => {
        console.log(error);
        alert('ERROR: Wrong input.');
      });

    window.localStorage.removeItem('cardId');

    setTimeout(() => {
      this.getBoard();
    }, 2000);

    const modal = document.getElementById('modal-page');
    modal.style.display = 'none';
  }

  getBoard() {
    const httpOptions = {
      headers: new HttpHeaders({
        boardId: window.localStorage.getItem('boardId')
      })
    };
    this.http.get<BoardModel>('http://localhost:8080/boards/getBoard',
      httpOptions).subscribe(result => {
        this.board = result;
        console.table(this.board);

        for (const b of this.board.cards) {
          window.localStorage.setItem('cardId', String(b.id));

          const httpOptions1 = {
            headers: new HttpHeaders({
              cardId: window.localStorage.getItem('cardId')
            })
          };
          this.http.get<TaskModel[]>('http://localhost:8080/tasks/getTasks',
            httpOptions1).subscribe(result1 => {
              b.tasks = result1;

              for (const t of b.tasks) {
                if (t.dueDate !== null) {
                  this.subject.checkDueDates(t);
                  t.due = this.observer.due;
                }
              }
            },
            error => console.log(error));
          console.log(b.tasks);
        }
      },
      error => console.log(error));
  }

  getCard(id: number) {
    window.localStorage.setItem('cardId', String(id));

    const httpOptions = {
      headers: new HttpHeaders({
        cardId: window.localStorage.getItem('cardId')
      })
    };

    this.http.get<CardModel[]>('http://localhost:8080/cards/getCards',
      httpOptions).subscribe(result => {
        this.cards = result;
        console.table(this.cards);
      },
      error => console.log(error));
  }

  getTasks(id: number) {
    let tasks;
    window.localStorage.setItem('cardId', String(id));

    const httpOptions = {
      headers: new HttpHeaders({
        cardId: window.localStorage.getItem('cardId')
      })
    };

    this.http.get<TaskModel[]>('http://localhost:8080/tasks/getTasks',
      httpOptions).subscribe(result => {
        tasks = result;
        console.log('HERERERR');
        console.table(tasks);
      },
      error => console.log(error));

    console.log('dsgferg');
    console.table(tasks);
    return tasks;
  }


  add_card() {
    const httpOptions = {
      headers: new HttpHeaders({
        boardId: window.localStorage.getItem('boardId')
      })
    };

    this.http.post<string>('http://localhost:8080/cards/addCard', this.card, httpOptions).subscribe(
      result => {
        console.log(result);
        alert('Successfully created card.');
        window.localStorage.setItem('boardId', String(this.board.id));
      },
      error => {
        console.log(error);
        alert('ERROR: Wrong input.');
      });
    setTimeout(() => {
      this.getBoard();
    }, 2000);

    const modal = document.getElementById('modal-list-page');
    modal.style.display = 'none';
  }

  display_card_modal() {
    if (this.isView === false) {
      const modal = document.getElementById('modal-list-page');
      modal.style.display = 'block';
    }
  }

  close_card_modal() {
    const modal = document.getElementById('modal-list-page');
    modal.style.display = 'none';
  }

  display_member_modal() {
    if (this.isView === false) {
      const modal = document.getElementById('modal-member-page');
      modal.style.display = 'block';
    }
  }

  add_edit_member() {
    console.log('BBBBBBBBBBBBBBBBBBBB ' + this.member);

    const httpOptions = {
      headers: new HttpHeaders({
        boardId: window.localStorage.getItem('boardId')
      })
    };

    this.stringObj.msg = this.member
    console.log('ggggggggggggggggg' + this.stringObj.msg);
    this.http.post<string>('http://localhost:8080/userBoards/addEditMember', this.stringObj.msg, httpOptions).subscribe(
      result => {
        console.log(result);
        alert('Successfully added member.');
      },
      error => {
        console.log(error);
        alert('ERROR: Wrong input.');
      });

    const modal = document.getElementById('modal-member-page');
    modal.style.display = 'none';
  }

  add_view_member() {
    console.log('BBBBBBBBBBBBBBBBBBBB ' + this.member);

    const httpOptions = {
      headers: new HttpHeaders({
        boardId: window.localStorage.getItem('boardId')
      })
    };

    this.http.post<string>('http://localhost:8080/userBoards/addViewMember', this.member, httpOptions).subscribe(
      result => {
        console.log(result);
        alert('Successfully added member.');
      },
      error => {
        console.log(error);
        alert('ERROR: Wrong input.');
      });

    const modal = document.getElementById('modal-member-page');
    modal.style.display = 'none';
  }

  close_member_modal() {
    const modal = document.getElementById('modal-member-page');
    modal.style.display = 'none';
  }

  private getAccess() {
    const httpOptions = {
      headers: new HttpHeaders({
        boardId: window.localStorage.getItem('boardId'),
        userId: window.localStorage.getItem('userId')
      })
    };

    this.http.get<StringObjModel>('http://localhost:8080/userBoards/getAccess',
      httpOptions).subscribe(result => {
        this.access = result.msg;
        console.table('AAAAAAAAAAAAAAAAAAAAAAAAA ' + result.msg);
        if (this.access === 'Edit') {
          this.isView = false;
        } else {
          this.isView = true;
        }
      },
      error => console.log(error));
  }
}
