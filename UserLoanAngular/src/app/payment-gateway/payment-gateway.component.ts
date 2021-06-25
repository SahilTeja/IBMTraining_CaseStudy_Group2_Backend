import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { filter } from 'rxjs/operators';
import { HomeLoanService } from '../services/home-loan.service';

@Component({
  selector: 'app-payment-gateway',
  templateUrl: './payment-gateway.component.html',
  styleUrls: ['./payment-gateway.component.css']
})
export class PaymentGatewayComponent implements OnInit {

  Username : String = '';
  EmiAmount : number = 0;
  ReceivedOTP : number = 0;
  EnteredOTP : number = 0;
  submit:boolean=false;
  loanID : number = 0;
  

  constructor(private router:Router, private aroute : ActivatedRoute,
    private service: HomeLoanService) { }

  ngOnInit(): void {
    this.aroute.queryParams.pipe(filter(params => params.Uname))
      .subscribe(params => {
        this.loanID = params.Loanid;
        this.Username = params.Uname;
        this.EmiAmount = params.Eamount;
      });
  }


  payment(){
    this.submit=true;
    this.ReceivedOTP = Math.floor(Math.random() * 1000000); 
    this.service.sendOtp(this.ReceivedOTP,this.loanID);
    alert("Enter OTP sent in your registered EmailID ");
  }
  OTPpayment(){
    if(this.EnteredOTP==this.ReceivedOTP){
      alert("Payment Successful");
      this.service.LoanCompletition(this.loanID);
      this.router.navigate(['user'], {queryParams: {Loanid: this.loanID, Payment:true}}).then(()=>location.reload());
    }
    else{
      alert("You have Entered Incorrect OTP");
    }
  }
  cancelPayment() {
    alert("Are You Sure want to cancel Payment");
    this.router.navigate(['user']).then(()=>location.reload());
  }

  

}