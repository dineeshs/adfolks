import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-rms',
  templateUrl: './rms.component.html',
  styleUrls: ['./rms.component.css']
})
export class RmsComponent implements OnInit {

  searchid:string;
  rateid:string;
  ratedescription:string;
  rateeffectivedate:string;
  rateexpirationdate:string;
  amount:string;

  constructor() { }

  ngOnInit(): void {
  }

  searchRate() {
    
  }

}
