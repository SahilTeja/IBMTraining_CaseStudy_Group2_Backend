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

  constructor(private router:Router, private aroute : ActivatedRoute) { }

  ngOnInit(): void {
    this.aroute.queryParams.pipe(filter(params => params.Uname))
      .subscribe(params => {
        this.Username = params.Uname;
        this.EmiAmount = params.Eamount;
      });
  }

  payment(){
    alert("payment");
  }
}
