import { Component, OnInit } from '@angular/core';
import { WrapperService } from '../wrapper.service';
import { ActivatedRoute } from '@angular/router';
import { DomSanitizer } from '@angular/platform-browser';

@Component({
  selector: 'app-show',
  templateUrl: './show.component.html',
  styleUrls: ['./show.component.css']
})
export class ShowComponent implements OnInit {

  constructor(
    private wrapperService: WrapperService,
    private sanitizer: DomSanitizer,
    private route: ActivatedRoute
  ) {
    this.subscribe();
  }

  ngOnInit() {
    this.route.params.subscribe(() => {
      this.subscribe();
    });
  }

  subscribe(): void {
    this.wrapperService.globalService.showContact();
    this.wrapperService.checkContact(this.id);
    this.wrapperService.setContact(this.id);
  }

  get id(): number {
    return parseInt(this.route.snapshot.paramMap.get('id'), 10);
  }

}
