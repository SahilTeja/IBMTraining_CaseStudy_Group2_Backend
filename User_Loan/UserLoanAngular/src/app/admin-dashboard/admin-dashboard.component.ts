import { Component, OnInit } from '@angular/core';
import { LoanModule } from 'src/loan.module';
import { HomeLoanService } from '../services/home-loan.service';
/**
 * 
 * @author Harsh Anand
 *
 */
@Component({
  selector: 'app-admin-dashboard',
  templateUrl: './admin-dashboard.component.html',
  styleUrls: ['./admin-dashboard.component.css']
})
export class AdminDashboardComponent implements OnInit {

  LoanApproval : LoanModule[] = [];

  constructor(private service:HomeLoanService) { }

  ngOnInit(): void {
    if(localStorage.getItem('Admin')!=null){
      this.service.getLoanbyPendingApproval().then(data => this.LoanApproval = data);
    }
  }
  yes(loanId: number) {
    var ans = confirm("Are u sure to Approve Loan?"); 
    if (ans) {
      this.service.approvedLoan(loanId);
      location.reload();
    }

  }

  no(loanId: number) {
    var ans = confirm("Are u sure to Reject?");
    if (ans) {
      this.service.rejectLoan(loanId);
      location.reload();
    }
  }

}
