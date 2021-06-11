import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddUserComponent } from './add-user/add-user.component';
import { AddLoanComponent } from './add-loan/add-loan.component';
import { LoginUserComponent } from './login-user/login-user.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { UserDashboardComponent } from './user-dashboard/user-dashboard.component';
import { HomePageComponent } from './home-page/home-page.component';
import { LoginAdminComponent } from './login-admin/login-admin.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { EditUserComponent } from './edit-user/edit-user.component';


@NgModule({
  declarations: [
    AppComponent,
    AddUserComponent,
    AddLoanComponent,
    LoginUserComponent,
    UserDashboardComponent,
    HomePageComponent,
    LoginAdminComponent,
    AdminDashboardComponent,
    EditUserComponent,
  
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
