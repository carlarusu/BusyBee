export class TaskModel {
  id: number;
  description: string;
  dueDate: Date;
  due: number;

  constructor()
  constructor(description: string, dueDate: Date)
  constructor(description?: string, dueDate?: Date) {
    this.description = description
    this.dueDate = dueDate;
  }
}
