import { Component, OnInit } from '@angular/core';
import { EMIChart } from 'src/emiChart.module';
import { HomeLoanService } from '../services/home-loan.service';
/**
 * 
 * @author Harsh Anand
 *
 */
@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {

  amount : number = 0;
  duration : number = 0;
  interest : number = 0;
  EMIList : EMIChart[] = [];

  constructor(private service:HomeLoanService) { }

  ngOnInit(): void {
  }

  generateEMI() {
    this.service.getEmiChart(this.amount, this.duration, this.interest).then(data => this.EMIList = data);
  }

}
