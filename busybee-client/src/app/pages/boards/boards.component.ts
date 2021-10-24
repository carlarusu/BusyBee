import {Component, OnInit} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Router} from '@angular/router';
import {BoardModel} from '../../models/board.model';

@Component({
  selector: 'app-boards',
  templateUrl: './boards.component.html',
  styleUrls: ['./boards.component.scss']
})
export class BoardsComponent implements OnInit {

  board: BoardModel = new BoardModel();
  boards: BoardModel[];
  username: string;
  boardNo: number;

  constructor(private http: HttpClient, private router: Router) {
  }

  ngOnInit(): void {
    this.username = window.localStorage.getItem('username');
    this.getBoards();
  }

  logout() {
    this.router.navigateByUrl('');
  }

  display_modal() {
    const modal = document.getElementById('modal-page');
    modal.style.display = 'block';
  }

  close_modal() {
    const modal = document.getElementById('modal-page');
    modal.style.display = 'none';
  }

  create_board() {
    const httpOptions = {
      headers: new HttpHeaders({
        userId: window.localStorage.getItem('userId')
      })
    };

    this.http.post<string>('http://localhost:8080/boards/addBoard', this.board, httpOptions).subscribe(
      result => {
        console.log(result);
        alert('Successfully created board.');
      },
      error => {
        console.log(error);
        alert('ERROR: Wrong input.');
      });
    setTimeout(() => {
      this.getBoards();
    }, 1000);

    const modal = document.getElementById('modal-page');
    modal.style.display = 'none';
  }

  getBoards() {
    this.username = window.localStorage.getItem('username');
    const httpOptions = {
      headers: new HttpHeaders({
        userId: window.localStorage.getItem('userId')
      })
    };

    this.http.get<BoardModel[]>('http://localhost:8080/boards/getBoards',
      httpOptions).subscribe(result => {
        this.boards = result;
        console.table(this.boards);
      },
      error => console.log(error));

    setTimeout(() => {
      this.countBoards();
    }, 1000);
  }

  goToBoard(id: number) {
    window.localStorage.setItem('boardId', String(id));
    console.log(id);
    this.router.navigateByUrl('/board');
  }

  countBoards() {
    this.boardNo = 0;
    if (this.boards !== null) {
      for (const b of this.boards) {
        this.boardNo += 1;
      }
    }
  }
}
