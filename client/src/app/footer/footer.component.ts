import { Component, OnInit } from '@angular/core';
import { WrapperService } from '../wrapper.service';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css']
})
export class FooterComponent implements OnInit {

  constructor(private wrapperService: WrapperService) { }

  ngOnInit() { }

}
