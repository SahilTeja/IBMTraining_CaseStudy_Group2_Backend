import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { filter } from 'rxjs/operators';

@Component({
  selector: 'app-payment-gateway',
  templateUrl: './payment-gateway.component.html',
  styleUrls: ['./payment-gateway.component.css']
})
export class PaymentGatewayComponent implements OnInit {

  Username : String = '';
  EmiAmount : number = 0;
  ReceivedOTP : number = 54321;
  EnteredOTP : number = 0;
  submit:boolean=false;
  loanID : number = 0;

  constructor(private router:Router, private aroute : ActivatedRoute) { }

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
    alert("Enter OTP sent in your registered EmailID ");
  }
  OTPpayment(){
    if(this.EnteredOTP==this.ReceivedOTP){
      alert("Payment Successful");
      this.router.navigate(['user'], {queryParams: {Loanid: this.loanID, Payment:true}}).then(()=>location.reload());
    }
    else{
      alert("You have Entered wrong details");
    }
  }
  cancelPayment() {
    alert("Are You Sure want to cancel Payment");
    this.router.navigate(['user']).then(()=>location.reload());
  }
}
