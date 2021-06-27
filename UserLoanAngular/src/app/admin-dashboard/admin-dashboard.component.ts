import { Component, OnInit } from '@angular/core';
import { LoanModule } from 'src/loan.module';
import { HomeLoanService } from '../services/home-loan.service';

@Component({
  selector: 'app-admin-dashboard',
  templateUrl: './admin-dashboard.component.html',
  styleUrls: ['./admin-dashboard.component.css']
})
export class AdminDashboardComponent implements OnInit {

  LoanApproval : LoanModule[] = [];
  AdminComment : String = '';
  loanbyID : LoanModule = new LoanModule();

  constructor(private service:HomeLoanService) { }

  ngOnInit(): void {
    if(localStorage.getItem('Admin')!=null){
      this.service.getLoanbyPendingApproval().then(data => this.LoanApproval = data);
    }
  }
  yes(loanId: number) {
    var ans = confirm("Are you sure to Approve Loan?"); 
    if (ans) {
      this.AdminComment = "Loan Accepted";
      console.log(this.AdminComment);
      this.service.approvedLoan(loanId,this.AdminComment);
      location.reload();
    }

  }

  no(loanId: number) {
    var ans = confirm("Are you sure to Reject Loan?");
    if (ans) {
      this.AdminComment = String(prompt('Enter Comments', ''));
      console.log(this.AdminComment);
      this.service.rejectLoan(loanId,this.AdminComment);
      location.reload();
    }
  }

  viewDetails(loanId:number) {
    this.service.getLoanById(loanId).subscribe(data=>this.loanbyID=data);
  }

}
