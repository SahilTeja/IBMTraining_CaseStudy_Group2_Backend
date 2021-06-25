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
import { PaymentGatewayComponent } from './payment-gateway/payment-gateway.component';
import { AdminLoanDashboardComponent } from './admin-loan-dashboard/admin-loan-dashboard.component';
import { EditUserComponent } from './edit-user/edit-user.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

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
    PaymentGatewayComponent,
    AdminLoanDashboardComponent,
    EditUserComponent,
    UserProfileComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    NgbModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
