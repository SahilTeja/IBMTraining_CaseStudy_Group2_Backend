import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { filter } from 'rxjs/operators';
import { LoanModule } from 'src/loan.module';
import { HomeLoanService } from '../services/home-loan.service';

@Component({
  selector: 'app-edit-user',
  templateUrl: './edit-user.component.html',
  styleUrls: ['./edit-user.component.css']
})
export class EditUserComponent implements OnInit {

  loan : LoanModule = new LoanModule();

  constructor(private service: HomeLoanService,
    private router: Router,
    private aroute: ActivatedRoute) { }

  ngOnInit(): void {
    this.aroute.queryParams.pipe(filter(params => params.loanId)).subscribe(params=>{
      var c = params.loanId;
      this.service.getLoanById(c).subscribe(data=>this.loan = data);
    })
  }
  

  edit(){
    if (this.loan.status!="Approved"){
      this.service.editLoan(this.loan);
      alert("you data have been updated ");
      this.router.navigate(['user']).then(()=>location.reload());
    }
    else{
      alert("You cant update now");
      this.router.navigate(['user']).then(()=>location.reload());
    }
  }

}
