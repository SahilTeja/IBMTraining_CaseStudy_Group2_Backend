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
<<<<<<< HEAD
import { EditUserComponent } from './edit-user/edit-user.component';

=======
import { PaymentGatewayComponent } from './payment-gateway/payment-gateway.component';
<<<<<<< HEAD
import { AdminLoanDashboardComponent } from './admin-loan-dashboard/admin-loan-dashboard.component';
=======
>>>>>>> 339eae746b37e9c9acbad0a433ddfd8f1f1b417a
>>>>>>> 9871d3482aff2cfd8d2baa586eea70abb9a41444

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
<<<<<<< HEAD
    PaymentGatewayComponent,
    AdminLoanDashboardComponent
=======
<<<<<<< HEAD
    EditUserComponent,
  
=======
    PaymentGatewayComponent
>>>>>>> 339eae746b37e9c9acbad0a433ddfd8f1f1b417a
>>>>>>> 9871d3482aff2cfd8d2baa586eea70abb9a41444
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
