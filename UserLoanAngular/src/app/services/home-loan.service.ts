import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { retry } from 'rxjs/operators';
import { AddUserModel } from 'src/adduser.module';
import { AdminLoginModel } from 'src/adminlogin.module';
import { CibilScoreModule } from 'src/cibilScore.module';
import { EMIChart } from 'src/emiChart.module';
import { LoanModule } from 'src/loan.module';
import { UserLoginModel } from 'src/userlogin.module';

@Injectable({
  providedIn: 'root'
})
export class HomeLoanService {

  userlist : UserLoginModel[] = [];
  baseUrl : string = "http://localhost:8880";

  constructor(private http : HttpClient) { }

  async getAdminLogin(){
    return await this.http.get<AdminLoginModel[]>(this.baseUrl + "/admin/find/").pipe(retry(1)).toPromise();
  }
  async getAllCibil(){
    return await this.http.get<CibilScoreModule[]>(this.baseUrl + "/cibil/find/").pipe(retry(1)).toPromise();
  }
  async getUserLogin(){
    return await this.http.get<UserLoginModel[]>(this.baseUrl + "/finduser/").pipe(retry(1)).toPromise();
  }
  async getAllUser(){
    return await this.http.get<AddUserModel[]>(this.baseUrl + "/finduser/").pipe(retry(1)).toPromise();
  }

  // addloan(loan : LoanModule, userid:number){
  //   return this.http.post<LoanStatus>(this.baseUrl+"/addloan/"+userid,loan);
  // } 
  addloan(loan : LoanModule, userid:number){
    return this.http.post(this.baseUrl+"/addloan/"+userid,loan).subscribe(data => data = loan);
  }
  async getAllLoanbyUserId(userid:number){
    return await this.http.get<LoanModule[]>(this.baseUrl + "/loanbyuserId/"+userid).pipe(retry(1)).toPromise();
  } 
  async findLoanById(loanId:number){
    return await this.http.get<LoanModule[]>(this.baseUrl + "/loanbyloanId/"+loanId).pipe(retry(1)).toPromise();
  } 
  async findLoanByName(name:String){
    return await this.http.get<LoanModule[]>(this.baseUrl + "/loanbyname/"+name).pipe(retry(1)).toPromise();
  }

  async getLoanbyPendingApproval(){
    return await this.http.get<LoanModule[]>(this.baseUrl + "/findloanbyPending/").pipe(retry(1)).toPromise();
  } 
  async getAllLoan(){
    return await this.http.get<LoanModule[]>(this.baseUrl + "/findallloan/").pipe(retry(1)).toPromise();
  } 

  addUser(user : AddUserModel){
    this.http.post(this.baseUrl+"/adduser/",user).subscribe(data => data = user);
  } 

  approvedLoan(loanId:number, AdminComment : String){  
    const body = {}
    this.http.put(this.baseUrl+"/approve/"+loanId+"/"+AdminComment,body).subscribe();
  }

  rejectLoan(loanId:number, AdminComment : String){
    const body = {}
    this.http.put(this.baseUrl+"/reject/"+loanId+"/"+AdminComment,body).subscribe();
  }
  EMICompleted(loanId:number){
    const body = {}
    this.http.put(this.baseUrl+"/emiPay/"+loanId,body).subscribe();
  } 
  editLoan(loan:LoanModule){
    this.http.put(this.baseUrl+"/edit",loan).subscribe();
  }
  getLoanById(loanId:number){
    return this.http.get<LoanModule>(this.baseUrl+"/loanbyid/"+loanId);
  }

  getUserById(userid:number) {
    return this.http.get<AddUserModel>(this.baseUrl+"/userbyid/"+userid);
  }

  upadateProfile(userProfile : AddUserModel){
    this.http.put(this.baseUrl+"/updateProfile",userProfile).subscribe();
  }

  sendOtp(otp: number,loanId:number){
    const body = {}
    this.http.post(this.baseUrl+"/OTP/"+loanId+"/"+otp,body).subscribe();
  }
  LoanCompletition(loanId:number){
    const body = {}
    this.http.post(this.baseUrl+"/loanComplete/"+loanId,body).subscribe();
  }

  forgetPassword(UserId:number, password:String){
    const body = {}
    this.http.post(this.baseUrl+"/forgetPassword/"+UserId+"/"+password,body).subscribe();
  }

  async getEmiChart(amount:number, duration:number, interest:number) {
    return await this.http.get<EMIChart[]>(this.baseUrl + "/emichart/"+amount+"/"+duration+"/"+interest).pipe(retry(1)).toPromise();
  }
}
