import { Injectable, Inject } from '@angular/core';
import { Contact } from './contact';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ContactService {

  private baseUrl: string;

  constructor(private httpClient: HttpClient, @Inject('BASE_URL') baseUrl: string) {
    this.baseUrl = baseUrl;
  }

  getContacts() {
    return this.httpClient.get<Contact[]>(this.baseUrl + 'webapi/Contacts');
  }

  addContact(contact: Contact) {
    return this.httpClient.post<Contact>(this.baseUrl + 'webapi/Contacts', contact);
  }

  updateContact(contact: Contact) {
    return this.httpClient.put<Contact>(this.baseUrl + 'webapi/Contacts/' + contact.id, contact);
  }

  deleteContactById(id: number) {
    return this.httpClient.delete(this.baseUrl + 'webapi/Contacts/' + id);
  }

}
