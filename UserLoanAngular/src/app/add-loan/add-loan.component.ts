import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AddUserModel } from 'src/adduser.module';
import { CibilScoreModule } from 'src/cibilScore.module';
import { LoanModule } from 'src/loan.module';
import { HomeLoanService } from '../services/home-loan.service';

@Component({
  selector: 'app-add-loan',
  templateUrl: './add-loan.component.html',
  styleUrls: ['./add-loan.component.css']
})
export class AddLoanComponent implements OnInit {

  userid : number = 0;
  loan : LoanModule = new LoanModule();
  LoansById : LoanModule[] = [];
  isEmiCompleted : String = 'Yes';
  loanStatus : String = '';
  userbyId : AddUserModel = new AddUserModel();
  allcibilScore : CibilScoreModule[] = [];
  cibilScore : Number = 0;
  AgeTillRetairment : number = 0;

  constructor(private service:HomeLoanService, private router:Router) { }

  ngOnInit(): void {
    if(localStorage.getItem('UserId')!=null){
      this.userid = JSON.parse(localStorage.getItem("UserId") || '{}');
      this.service.getUserById(this.userid).subscribe(data => this.userbyId = data);
      this.service.getAllLoanbyUserId(this.userid).then(data => this.LoansById = data);
      this.service.getAllCibil().then(data => this.allcibilScore = data);
    }
    
  }

  formValidate() {
    
    // console.log(this.userbyId.aadhar+"......"+this.userbyId.panCard+"......."+this.userbyId.salary);
    if(this.userbyId.aadhar==""||this.userbyId.panCard==""||this.userbyId.salary==0){
      alert("Please Complete Profile first, then apply the Loan");
      this.router.navigate(['profile']);
    }
    // console.log(this.userbyId.dateofbirth);
    var yearDOB = +this.userbyId.dateofbirth.split("-",1);
    this.AgeTillRetairment = yearDOB+60-(new Date()).getFullYear();
    
    for(var index in this.allcibilScore) {
      if(this.userbyId.panCard==this.allcibilScore[index].panCard) {
        this.cibilScore = this.allcibilScore[index].cibilscore;
      }
    }
  }

  CheckloanStatus(userid : number) {
    for(var index in this.LoansById) {
      this.isEmiCompleted = this.LoansById[index].emiCompleted;
      this.loanStatus = this.LoansById[index].status;
    }
  }

  applyLoan() {
    this.CheckloanStatus(this.userid);

    this.loan.name=this.userbyId.name;
    this.loan.email=this.userbyId.email;
    this.loan.salary=this.userbyId.salary;
    this.loan.aadhar=this.userbyId.aadhar;
    this.loan.panCard=this.userbyId.panCard;
    this.loan.dateofbirth=this.userbyId.dateofbirth;
    
    if((this.isEmiCompleted=="Yes") || this.loanStatus=="Rejected"){
      if((this.AgeTillRetairment-this.loan.duration)>=0) {
        this.service.addloan(this.loan,this.userid);
        alert("Loan Applied");
        this.router.navigate(['user']).then(()=>location.reload());
      }
      else if((this.AgeTillRetairment)<0) {
        alert("You are already above 60 Years of Age. So, You are not eligible to apply for Loan. ");
      }
      else {
        alert("According to Your Age you can apply Loan for maximum : "+this.AgeTillRetairment + " Years");
      }
      
    }
    else{
      alert("You have already active Loan");
      this.router.navigate(['user']);
    }
    
  }
  

}
