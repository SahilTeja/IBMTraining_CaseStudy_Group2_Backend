import { Component, OnInit } from '@angular/core';
import { EMI_chart } from 'src/emichart.module';
import { FlightService } from '../service/flight.service';


@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {

  EMIList : EMI_chart[] = [];
  totalEmi:number=0;

  constructor(private service:FlightService) { }

  ngOnInit(): void {
    // this.flightList = this.service.getFlightlist();
    this.service.getFlightlist().then(data => this.EMIList = data);
  }
 
}
