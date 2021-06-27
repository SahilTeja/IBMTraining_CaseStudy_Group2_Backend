import { Component, OnInit } from '@angular/core';
import { LoanModule } from 'src/loan.module';
import { HomeLoanService } from '../services/home-loan.service';

@Component({
  selector: 'app-admin-loan-dashboard',
  templateUrl: './admin-loan-dashboard.component.html',
  styleUrls: ['./admin-loan-dashboard.component.css']
})
export class AdminLoanDashboardComponent implements OnInit {

  Loans : LoanModule[] = [];
  selectType : String[] = ["Loan Id","Name"];
  check : String = "";
  query : string = '';
  loanbyID : LoanModule = new LoanModule();

  constructor(private service:HomeLoanService) { }

  ngOnInit(): void {
    if(localStorage.getItem('Admin')!=null){
      this.service.getAllLoan().then(data => this.Loans = data);
    }
  }
  orderByName(){
    this.Loans.sort((a,b) => a.name > b.name ? 1 :(a.name < b.name ? -1:0 ));
  }
  orderByApproval(){
    this.Loans.sort((a,b) => a.status > b.status ? 1 :(a.status < b.status ? -1:0 ));
  }

  search() {
    if(this.check=="Loan Id")
      this.service.findLoanById(parseInt(this.query)).then(data => this.Loans = data);
    else if(this.check=="Name")
      this.service.findLoanByName(this.query).then(data => this.Loans = data);
    
    
  }
  reload() {
    location.reload();
  }

  viewDetails(loanId:number) {
    this.service.getLoanById(loanId).subscribe(data=>this.loanbyID=data);
  }

}
