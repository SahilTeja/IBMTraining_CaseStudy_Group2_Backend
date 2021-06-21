import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { EMIChart } from 'src/emiChart.module';
import { HomeLoanService } from '../services/home-loan.service';

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
  EMIperMonth : number = 0;
  totalAmountPaid : number = 0;
  totalInterest : number = 0;
  count : boolean = false;

  constructor(private service:HomeLoanService, private router:Router) { }

  ngOnInit(): void {
  }

  generateEMI() {
    this.service.getEmiChart(this.amount, this.duration, this.interest).then(data => this.EMIList = data);
    
  }
  EMIDetails() {
    if(this.count==false) {
      this.EMIperMonth = this.EMIList[0].emi/12;
      for(var index in this.EMIList){
        this.totalAmountPaid = this.totalAmountPaid + this.EMIList[index].emi;
      }
      this.totalInterest = this.totalAmountPaid - this.amount;
      this.count = true;
      console.log("---------->"+this.EMIperMonth+"===="+this.totalAmountPaid+"===="+this.totalInterest);
    }
  }

  register() {
    this.router.navigate(['adduser']).then(()=>location.reload());
  }

}
