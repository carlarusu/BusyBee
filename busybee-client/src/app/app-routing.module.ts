import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {BoardComponent} from './pages/board/board.component';
import {LoginComponent} from './pages/login/login.component';
import {HttpClientModule} from '@angular/common/http';
import {BrowserModule} from '@angular/platform-browser';
import {FormsModule} from '@angular/forms';
import {BoardsComponent} from './pages/boards/boards.component';


const routes: Routes = [
  {path: 'board', component: BoardComponent},
  {path: '', component: LoginComponent},
  {path: 'login', component: LoginComponent},
  {path: 'boards', component: BoardsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes), HttpClientModule, BrowserModule, FormsModule],
  exports: [RouterModule]
})
export class AppRoutingModule { }
