import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { filter } from 'rxjs/operators';
import { AddUserModel } from 'src/adduser.module';
import { CibilScoreModule } from 'src/cibilScore.module';
import { LoanModule } from 'src/loan.module';
import { HomeLoanService } from '../services/home-loan.service';

@Component({
  selector: 'app-edit-user',
  templateUrl: './edit-user.component.html',
  styleUrls: ['./edit-user.component.css']
})
export class EditUserComponent implements OnInit {

  loan : LoanModule = new LoanModule();
  allcibilScore : CibilScoreModule[] = [];
  cibilScore : Number = 0;
  AgeTillRetairment : number = 0;

  constructor(private service: HomeLoanService,
    private router: Router,
    private aroute: ActivatedRoute) { }

  ngOnInit(): void {
    this.aroute.queryParams.pipe(filter(params => params.loanId)).subscribe(params=>{
      var c = params.loanId;
      this.service.getLoanById(c).subscribe(data=>this.loan = data);
      this.service.getAllCibil().then(data => this.allcibilScore = data);
    })
  }
  
  formValidate() {
    var yearDOB = +this.loan.dateofbirth.split("-",1);
    this.AgeTillRetairment = yearDOB+60-(new Date()).getFullYear();
    console.log(this.AgeTillRetairment);
    for(var index in this.allcibilScore) {
      if(this.loan.panCard==this.allcibilScore[index].panCard) {
        this.cibilScore = this.allcibilScore[index].cibilscore;
      }
    }
  }

  edit(){
    if (this.loan.status!="Approved"){
      if((this.AgeTillRetairment-this.loan.duration)>=0) {
        this.service.editLoan(this.loan);
        alert("Your Loan Details have been Updated");
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
      alert("You can not update now");
      this.router.navigate(['user']).then(()=>location.reload());
    }
  }

}
