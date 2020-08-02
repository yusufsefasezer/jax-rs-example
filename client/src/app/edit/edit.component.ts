import { Component, OnInit } from '@angular/core';
import { WrapperService } from '../wrapper.service';
import { ActivatedRoute } from '@angular/router';
import { DomSanitizer } from '@angular/platform-browser';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {

  constructor(
    private wrapperService: WrapperService,
    private sanitizer: DomSanitizer,
    private route: ActivatedRoute
  ) {
    this.wrapperService.globalService.createContactForm();
    this.wrapperService.globalService.showEdit();
    this.wrapperService.checkContact(this.id);
    this.wrapperService.setCopyContact(this.id);
  }

  ngOnInit() { }

  get id(): number {
    return parseInt(this.route.snapshot.paramMap.get('id'), 10);
  }

  get f() {
    return this.wrapperService.globalService.contactForm.controls;
  }

}
