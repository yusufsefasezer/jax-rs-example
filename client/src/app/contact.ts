export class Contact {
  public id: number;
  public checked: boolean;
  public name: string;
  public email: string;
  public phone: string;
  public url: string;
  public photo: string;
  public address: string;
  public notes: string;

  constructor() {
    this.checked = false;
  }

}
