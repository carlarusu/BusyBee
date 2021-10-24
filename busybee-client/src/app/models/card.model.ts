import {TaskModel} from './task.model';

export class CardModel {
  id: number;
  name: string;
  tasks: TaskModel[];

  constructor()
  constructor(name: string, tasks: TaskModel[])
  constructor(name?: string, tasks?: TaskModel[]) {
    this.name = name
    this.tasks = tasks;
  }
}
