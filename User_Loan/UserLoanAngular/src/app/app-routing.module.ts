import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddLoanComponent } from './add-loan/add-loan.component';
import { AddUserComponent } from './add-user/add-user.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { AdminLoanDashboardComponent } from './admin-loan-dashboard/admin-loan-dashboard.component';
import { EditUserComponent } from './edit-user/edit-user.component';
import { HomePageComponent } from './home-page/home-page.component';
import { LoginAdminComponent } from './login-admin/login-admin.component';
import { LoginUserComponent } from './login-user/login-user.component';
import { PaymentGatewayComponent } from './payment-gateway/payment-gateway.component';
import { UserDashboardComponent } from './user-dashboard/user-dashboard.component';
import { UserProfileComponent } from './user-profile/user-profile.component';

const routes: Routes = [
  {path:'', component: HomePageComponent},
  {path:'home', component: HomePageComponent},
  {path:'loginadmin', component: LoginAdminComponent},
  {path:'loginuser', component: LoginUserComponent},
  {path:'addloan', component: AddLoanComponent},
  {path:'adduser', component: AddUserComponent},
  {path:'user', component: UserDashboardComponent},
  {path:'admin', component: AdminDashboardComponent},
  {path:'adminloan', component: AdminLoanDashboardComponent},
  {path:'profile', component: UserProfileComponent},
  {path:'payment', component: PaymentGatewayComponent},
  {path:'edit', component: EditUserComponent},
  {path:'**', redirectTo: '/home', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
