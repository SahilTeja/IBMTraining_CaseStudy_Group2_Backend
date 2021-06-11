import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AddUserModel } from 'src/adduser.module';
import { HomeLoanService } from '../services/home-loan.service';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  userid : number = 0;
  userbyId : AddUserModel = new AddUserModel();

  constructor(private service:HomeLoanService, private router:Router) { }

  ngOnInit(): void {
    if(localStorage.getItem('UserId')!=null){
      this.userid = JSON.parse(localStorage.getItem("UserId") || '{}');
      
      this.service.getUserById(this.userid).subscribe(data => this.userbyId = data);
    }
  }

  updateProfile() {
    alert("Profile is Updated");
    this.service.upadateProfile(this.userbyId);
    this.router.navigate(['user']);
  }

}
