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
  LoansById : LoanModule[] = [];

  constructor(private service:HomeLoanService,
    private router: Router) { }

  ngOnInit(): void {
    if(localStorage.getItem('UserId')!=null){
      this.userid = JSON.parse(localStorage.getItem("UserId") || '{}');
      
      this.service.getAllLoanbyUserId(this.userid).then(data => this.LoansById = data);
    }
  }

  
  edit(loanId:number){
    this.router.navigate(['edit'],{queryParams : {loanId: loanId }});
  }

}
