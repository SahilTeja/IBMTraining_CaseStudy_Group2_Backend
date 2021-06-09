import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { filter } from 'rxjs/operators';
import { LoanModule } from 'src/loan.module';
import { LoanStatus } from 'src/loanStatus.module';
import { HomeLoanService } from '../services/home-loan.service';
/**
 * 
 * @author Harsh Anand
 *
 */
@Component({
  selector: 'app-add-loan',
  templateUrl: './add-loan.component.html',
  styleUrls: ['./add-loan.component.css']
})
export class AddLoanComponent implements OnInit {

  userid : number = 0;
  loan : LoanModule = new LoanModule();
  LoansById : LoanModule[] = [];
  isEmiCompleted : String = '';
  // loanStatus : LoanStatus = new LoanStatus();

  constructor(private service:HomeLoanService, private router:Router) { }

  ngOnInit(): void {
    if(localStorage.getItem('UserId')!=null){
      this.userid = JSON.parse(localStorage.getItem("UserId") || '{}');

      this.service.getAllLoanbyUserId(this.userid).then(data => this.LoansById = data);
    }
  }

  CheckloanStatus(userid : number) {
    for(var index in this.LoansById) {
      this.isEmiCompleted = this.LoansById[index].emiCompleted;
    }
  }

  applyLoan() {
    this.CheckloanStatus(this.userid);
    if(this.isEmiCompleted!="No"){
      this.service.addloan(this.loan,this.userid);
      alert("Loan Applied");
      this.router.navigate(['user']);
    }
    else{
      alert("You have already active Loan");
      this.router.navigate(['user']);
    }
    
  }
  // applyLoan() {
  //   this.service.addloan(this.loan,this.userid).subscribe(data => this.loanStatus = data);
  //   if(this.loanStatus.status==0) {
  //     alert("You have already active Loan");
  //   }
  //   else{
  //     alert("Loan Applied");
  //   }
  // }
  

}
