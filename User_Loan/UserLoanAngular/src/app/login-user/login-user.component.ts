import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserLoginModel } from 'src/userlogin.module';
import { HomeLoanService } from '../services/home-loan.service';
/**
 * 
 * @author Harsh Anand
 *
 */
@Component({
  selector: 'app-login-user',
  templateUrl: './login-user.component.html',
  styleUrls: ['./login-user.component.css']
})
export class LoginUserComponent implements OnInit {

  auth:UserLoginModel[] = [];
  username : string = '';
  password : string = '';
  userid : number = 0;

  constructor(private service : HomeLoanService, private router:Router) { }

  ngOnInit(): void {
    this.service.getUserLogin().then(data=>this.auth=data);
  }

  authenticate(){
    var status = false;
    //console.log("==="+this.auth);
    for(var index in this.auth){
      if(this.auth[index].username==this.username && this.auth[index].password==this.password){
        alert("User login Successful");
        status = true;
        this.userid = this.auth[index].userId;

        localStorage.setItem("UserId",this.userid.toString());

        this.router.navigate(['user']).then(()=>location.reload());
        break;
      }
    }
    if(status==false){
      alert("Invalid Creditintials");
      location.reload();
    }
  }


}
