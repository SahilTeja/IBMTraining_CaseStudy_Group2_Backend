import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Base64 } from 'js-base64';
import { AddUserModel } from 'src/adduser.module';
import { HomeLoanService } from '../services/home-loan.service';

@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.css']
})
export class AddUserComponent implements OnInit {

  user : AddUserModel = new AddUserModel();

  allUser : AddUserModel[] = [];
  allEmail : String[] = [];
  statusEmail : Boolean = false;

  constructor(private service:HomeLoanService, private router:Router) { }

  ngOnInit(): void {
    this.service.getAllUser().then(data=>this.allUser=data);
  }

  checkProfileEmail() {
    for(var index in this.allUser) {
      this.allEmail.push(this.allUser[index].email);
    }
    this.allEmail = this.allEmail.filter(function (e) {return e != null;});

    if(this.allEmail.includes(this.user.email)){
      alert("Email already registered");
      this.statusEmail=true;
      location.reload();
    }
  }


  addUser(){
    this.checkProfileEmail();
    if(this.statusEmail==false){
        this.user.password = Base64.btoa(this.user.password).toString();
        this.service.addUser(this.user);
        alert(this.user.name+" is successfully registered");
        this.router.navigate(['loginuser']);
      }
  }

  Login() {
    this.router.navigate(['loginuser']);
  }


}
