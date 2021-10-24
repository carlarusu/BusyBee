import {Observer} from './Observer';
import {Subject} from './Subject';
import {CardModel} from '../../models/card.model';
import {TaskModel} from '../../models/task.model';

export class ConcreteSubject implements Subject {

  public state: number;

  private observers: Observer[] = [];
  public date: Date = new Date();

  public attach(observer: Observer): void {
    const isExist = this.observers.includes(observer);
    if (isExist) {
      return console.log('Subject: Observer has been attached already.');
    }

    console.log('Subject: Attached an observer.');
    this.observers.push(observer);
  }

  public detach(observer: Observer): void {
    const observerIndex = this.observers.indexOf(observer);
    if (observerIndex === -1) {
      return console.log('Subject: Nonexistent observer.');
    }

    this.observers.splice(observerIndex, 1);
    console.log('Subject: Detached an observer.');
  }


  public notify(): void {
    console.log('Subject: Notifying observers...');
    for (const observer of this.observers) {
      observer.update(this);
    }
  }

  // parse a date in yyyy-mm-dd format
  // 2020-06-25T00:00:00.000+00:00
  public parseDate(input) {
    const parts = input.match(/(\d+)/g);
    // new Date(year, month [, date [, hours[, minutes[, seconds[, ms]]]]])
    return new Date(parts[0], parts[1] - 1, parts[2]); // months are 0-based
  }

  public checkDueDates(task: TaskModel): void {
    const taskDate = this.parseDate(task.dueDate);

    // console.log(taskDate);
    // console.log(this.date);

    let time: number;
    let days: number;
    time = taskDate.getTime() - this.date.getTime();
    days = Math.ceil(time / (1000 * 3600 * 24));
    // console.log('days: ' + days);

    if (days <= 3 && days > 0){
      // console.log('ALMOST DUE');
      this.state = 1;
    }else if (days <= 0) {
      // console.log('OVERDUE');
      this.state = 0;
    }else {
      // console.log('NOT YET DUE');
      this.state = 2;
    }
    this.notify();
  }
}
