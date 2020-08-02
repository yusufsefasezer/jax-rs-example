import { Component, OnInit } from '@angular/core';
import { WrapperService } from '../wrapper.service';
import { Contact } from '../contact';
import { DomSanitizer } from '@angular/platform-browser';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {

  constructor(
    private wrapperService: WrapperService,
    private sanitizer: DomSanitizer) {
    this.wrapperService.globalService.createContactForm();
  }

  ngOnInit() {
    this.wrapperService.globalService.showAdd();
    // this.wrapperService.globalService.currentContact = new Contact(null, null, null, null, '/assets/no-image.svg', null, null);
    this.wrapperService.globalService.currentContact = new Contact();
    this.wrapperService.globalService.currentContact.photo = 'assets/no-image.svg';

  }

  get f() {
    return this.wrapperService.globalService.contactForm.controls;
  }

}
