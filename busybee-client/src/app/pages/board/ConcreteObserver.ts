import {Observer} from './Observer';
import {ConcreteSubject} from './ConcreteSubject';

export class ConcreteObserver implements Observer {
  due = 0;
  public update(subject: ConcreteSubject): void {
    if (subject.state === 1) {
      // console.log('almost due');
      this.due = 1;
    }
    else if (subject.state === 0){
      // console.log('overdue');
      this.due = 0;
    } else {
      // console.log('not yet due');
      this.due = 2;
    }
  }
}
