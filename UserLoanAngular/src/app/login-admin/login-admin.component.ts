import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminLoginModel } from 'src/adminlogin.module';
import { HomeLoanService } from '../services/home-loan.service';

@Component({
  selector: 'app-login-admin',
  templateUrl: './login-admin.component.html',
  styleUrls: ['./login-admin.component.css']
})
export class LoginAdminComponent implements OnInit {

  auth:AdminLoginModel[] = [];
  username : string = '';
  password : string = '';

  constructor(private service : HomeLoanService, private router:Router) { }

  ngOnInit(): void {
    this.service.getAdminLogin().then(data=>this.auth=data);
   }

  authenticate(){
    var status = false;
    for(var index in this.auth){
      if(this.auth[index].userName==this.username && this.auth[index].password==this.password){
        alert("Admin login Successful");
        status = true;
        localStorage.setItem("Admin","Login");

        this.router.navigate(['admin']).then(()=>location.reload());
        break;
      }
    }
    if(status==false) {
      alert("Invalid Credentials");
      location.reload();
    }
  }

}
