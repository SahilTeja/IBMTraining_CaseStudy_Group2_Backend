import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { filter } from 'rxjs/operators';
import { LoanModule } from 'src/loan.module';
import { HomeLoanService } from '../services/home-loan.service';
/**
 * 
 * @author Harsh Anand
 *
 */
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

<<<<<<< HEAD
  constructor(private service:HomeLoanService,
    private router: Router) { }
=======
  constructor(private service:HomeLoanService, private router:Router, private aroute : ActivatedRoute) { }
>>>>>>> 339eae746b37e9c9acbad0a433ddfd8f1f1b417a

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
    this.router.navigate(['edit'],{queryParams : {loanId: loanId }});
  }

}
