import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent implements OnInit{
  title = 'UserLoanAngular';
  loggedin : boolean = false;
  Adminloggedin : boolean = false;

  constructor(private router:Router){}

  ngOnInit(): void {
    if(localStorage.getItem("UserId")!=null)
      this.loggedin = true;
    else
      this.loggedin = false;

    if(localStorage.getItem("Admin")!=null)
      this.Adminloggedin = true;
    else
      this.Adminloggedin = false;
  }

  Userlogout(){
    localStorage.removeItem("UserId");
    this.router.navigate(['home']).then(()=>location.reload());
  }
  Adminlogout(){
    localStorage.removeItem("Admin");
    this.router.navigate(['home']).then(()=>location.reload());
  }
}