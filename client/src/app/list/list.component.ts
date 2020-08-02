import { Component, OnInit } from '@angular/core';
import { WrapperService } from '../wrapper.service';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {

  constructor(
    private wrapperService: WrapperService) { }

  ngOnInit() { }

}
