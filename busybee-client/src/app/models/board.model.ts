import {CardModel} from './card.model';

export class BoardModel {
  id: number;
  name: string;
  cards: CardModel[];

  constructor()
  constructor(name: string, cards: CardModel[])
  constructor(name?: string, cards?: CardModel[]) {
    this.name = name
    this.cards = cards;
  }
}
