import { Injectable } from '@angular/core';
import { Contact } from './contact';
import { FormGroup, FormControl } from '@angular/forms';

@Injectable({
  providedIn: 'root'
})
export class GlobalService {
  public title = 'Angular Contact List';
  public RESIZE_IMAGE = true;
  public MAX = 250;

  public footer = false;
  public isSelect = false;
  public isAdd = false;
  public isEdit = false;
  public isDelete = false;
  public isDeleteAll = false;
  public isUpdate = false;
  public selectedCount = 0;
  public searchTerm = '';

  public contacts: Contact[] = [];
  public currentContact: Contact;

  public contactForm: FormGroup;

  constructor() { }

  createContactForm() {
    this.contactForm = new FormGroup({
      photo: new FormControl(),
      name: new FormControl(),
      email: new FormControl(),
      phone: new FormControl(),
      url: new FormControl(),
      address: new FormControl(),
      notes: new FormControl()
    });
  }

  formatPhoneNumber(phone) {
    return phone ? phone.substr(0, 3) + ' ' + phone.substr(0, 3) + ' ' + phone.substr(0, 3) : phone;
  }

  filterChecked() {
    this.selectedCount = this.contacts.filter((contact: Contact) => {
      return contact.checked === true;
    }).length;
  }

  showContact() {
    this.resetStatus();
    this.footer = true;
    this.isEdit = true;
    this.isUpdate = false;
  }

  showEdit() {
    this.resetStatus();
    this.footer = true;
    this.isDelete = true;
    this.isUpdate = true;
  }

  resetStatus() {
    this.footer = false;
    this.isSelect = false;
    this.isAdd = false;
    this.isEdit = false;
    this.isDelete = false;
    this.isDeleteAll = false;
    this.isUpdate = false;
    this.selectedCount = 0;
    this.contacts.forEach((contact) => {
      contact.checked = false;
    });
  }

  selectContact() {
    this.resetStatus();
    this.footer = true;
    this.isSelect = true;
    this.isDeleteAll = true;
  }

  showAdd() {
    this.resetStatus();
    this.footer = true;
    this.isAdd = true;
  }

}
