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

  Loans : LoanModule[] = [];

  constructor(private service:HomeLoanService) { }

  ngOnInit(): void {
    if(localStorage.getItem('Admin')!=null){
      this.service.getAllLoan().then(data => this.Loans = data);
    }
  }

}
