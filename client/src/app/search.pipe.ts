import { Pipe, PipeTransform } from '@angular/core';
import { Contact } from './contact';

@Pipe({
  name: 'search'
})
export class SearchPipe implements PipeTransform {

  transform(contacts: Contact[], searchTerm: string): any {

    if (!contacts) {
      return null;
    }
    if (!searchTerm) {
      return contacts;
    }

    searchTerm = searchTerm.toLowerCase();

    return contacts.filter((value: Contact) => {
      return JSON.stringify(value).toLowerCase().includes(searchTerm);
    });
  }

}
