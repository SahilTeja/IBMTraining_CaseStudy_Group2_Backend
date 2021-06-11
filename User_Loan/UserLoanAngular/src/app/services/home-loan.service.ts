import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { retry } from 'rxjs/operators';
import { AddUserModel } from 'src/adduser.module';
import { AdminLoginModel } from 'src/adminlogin.module';
import { LoanModule } from 'src/loan.module';
import { LoanStatus } from 'src/loanStatus.module';
import { UserLoginModel } from 'src/userlogin.module';
/**
 * 
 * @author Harsh Anand
 *
 */
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
  async getUserLogin(){
    return await this.http.get<UserLoginModel[]>(this.baseUrl + "/finduser/").pipe(retry(1)).toPromise();
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

  async getAllLoan(){
    return await this.http.get<LoanModule[]>(this.baseUrl + "/findallloan/").pipe(retry(1)).toPromise();
  } 

  addUser(user : AddUserModel){
    this.http.post(this.baseUrl+"/adduser/",user).subscribe(data => data = user);
  } 

  approvedLoan(loanId:number){  
    const body = {}
    this.http.put(this.baseUrl+"/approve/"+loanId,body).subscribe();
  }

  rejectLoan(loanId:number){
    const body = {}
    this.http.put(this.baseUrl+"/reject/"+loanId,body).subscribe();
  }

  getLoanById(loanId:number){
    return this.http.get<LoanModule>(this.baseUrl+"/loanbyid/"+loanId);

  }
  editLoan(loan:LoanModule){
    this.http.put(this.baseUrl+"/edit",loan).subscribe();
  }
}
