import { Component, OnInit, Input } from '@angular/core';
import { Contact } from '../contact';
import { WrapperService } from '../wrapper.service';
import { DomSanitizer } from '@angular/platform-browser';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent implements OnInit {

  @Input() private contact: Contact;

  constructor(
    private wrapperService: WrapperService,
    private sanitizer: DomSanitizer
  ) { }

  ngOnInit() { }

}
