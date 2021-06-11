import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AddUserModel } from 'src/adduser.module';
import { HomeLoanService } from '../services/home-loan.service';
/**
 * 
 * @author Harsh Anand
 *
 */
@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.css']
})
export class AddUserComponent implements OnInit {

  user : AddUserModel = new AddUserModel();

  constructor(private service:HomeLoanService, private router:Router) { }

  ngOnInit(): void {
  }

  addUser(){
    this.service.addUser(this.user);
    alert(this.user.name+"is successfully registered");
    this.router.navigate(['home']);
  }
}
