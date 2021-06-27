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

  allUser : AddUserModel[] = [];
  allAadhar : String[] = [];
  statusAadhar : Boolean = false;
  allPancard : String[] = [];
  statusPan : Boolean = false;
  allEmail : String[] = [];
  statusEmail : Boolean = false;
  tempUserbyId : AddUserModel = new AddUserModel();

  statusProfile : Boolean = true;

  constructor(private service:HomeLoanService, private router:Router) { }

  ngOnInit(): void {
    if(localStorage.getItem('UserId')!=null){
      this.userid = JSON.parse(localStorage.getItem("UserId") || '{}');
      this.service.getAllUser().then(data=>this.allUser=data);
      this.service.getUserById(this.userid).subscribe(data => this.userbyId = data);
      this.service.getUserById(this.userid).subscribe(data => this.tempUserbyId = data);
    }
    
  }

  deletedetailsofCurrentUser(aadhar:String[], removeElement:string) {
    const index: number = aadhar.indexOf(removeElement);
    if (index !== -1) {
      aadhar.splice(index, 1);
    }        
  }

  checkProfile() {
    for(var index in this.allUser) {
      this.allAadhar.push(this.allUser[index].aadhar);
      this.allPancard.push(this.allUser[index].panCard);
      this.allEmail.push(this.allUser[index].email);
    }
    //if value is null in database then it not store in allAadhar......etc
    this.allAadhar = this.allAadhar.filter(function (e) {return e != null;});
    this.allPancard = this.allPancard.filter(function (e) {return e != null;});
    this.allEmail = this.allEmail.filter(function (e) {return e != null;});

    this.deletedetailsofCurrentUser(this.allAadhar,this.tempUserbyId.aadhar);
    this.deletedetailsofCurrentUser(this.allPancard,this.tempUserbyId.panCard);
    this.deletedetailsofCurrentUser(this.allEmail,this.tempUserbyId.email);

    if(this.allAadhar.includes(this.userbyId.aadhar)){
      alert("Aadhar card already registered");
      this.statusAadhar=true;
      location.reload();
    }
    if(this.allPancard.includes(this.userbyId.panCard.toUpperCase())){
      alert("Pan card already registered");
      this.statusPan=true;
      location.reload();
    }
    if(this.allEmail.includes(this.userbyId.email)){
      alert("Email already registered");
      this.statusEmail=true;
      location.reload();
    }
    
  }

  updateProfile() {
    this.checkProfile();
    // if(this.userbyId.salary==0 || this.userbyId.aadress=='' || this.userbyId.name=='' || this.userbyId.email=='' || this.userbyId.aadhar=='' || this.userbyId.panCard=='' || this.userbyId.state=='' || this.userbyId.dateofbirth==''){
    //   alert("You have not completed Profile");
    //   this.statusProfile=false;
    //   location.reload();
    // }
    if(this.statusAadhar==false && this.statusPan==false && this.statusEmail==false && this.statusProfile==true){
      alert("Profile is Updated");
      this.service.upadateProfile(this.userbyId);
      this.router.navigate(['user']);
    }
  }

}
