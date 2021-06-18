import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { filter } from 'rxjs/operators';
import { EMIChart } from 'src/emiChart.module';
import { LoanModule } from 'src/loan.module';
import { HomeLoanService } from '../services/home-loan.service';

@Component({
  selector: 'app-user-dashboard',
  templateUrl: './user-dashboard.component.html',
  styleUrls: ['./user-dashboard.component.css']
})
export class UserDashboardComponent implements OnInit {

  userid : number = 0;
  loanID : number = 0;
  LoansById : LoanModule[] = [];
  PaymentStatus : boolean = false;

  EMIList : EMIChart[] = [];
  

  constructor(private service:HomeLoanService, private router:Router, private aroute : ActivatedRoute) { }

  ngOnInit(): void {
    if(localStorage.getItem('UserId')!=null){
      this.userid = JSON.parse(localStorage.getItem("UserId") || '{}');
      
      this.service.getAllLoanbyUserId(this.userid).then(data => this.LoansById = data);
      
    }
    this.aroute.queryParams.pipe(filter(params => params.Payment))
      .subscribe(params => {
        this.loanID = params.Loanid;
        this.PaymentStatus = params.Payment;
        console.log("pay status :"+this.PaymentStatus);
        this.service.EMICompleted(this.loanID);
      });
  }

  payment(loanid:number, name : String, amount : number){
    this.loanID = loanid;
    this.router.navigate(['payment'], {queryParams: {Loanid: this.loanID, Uname:name, Eamount:amount}});
  }

  edit(loanId:number){
    this.router.navigate(['edit'],{queryParams : {loanId: loanId }}).then(()=>location.reload());
  }

  EmiChart(loan:LoanModule) {
    this.service.getEmiChart(loan.amount, loan.duration, loan.interest).then(data => this.EMIList = data);
  }

}
