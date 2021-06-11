import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddLoanComponent } from './add-loan/add-loan.component';
import { AddUserComponent } from './add-user/add-user.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
<<<<<<< HEAD
import { AdminLoanDashboardComponent } from './admin-loan-dashboard/admin-loan-dashboard.component';
=======
import { EditUserComponent } from './edit-user/edit-user.component';
>>>>>>> 9871d3482aff2cfd8d2baa586eea70abb9a41444
import { HomePageComponent } from './home-page/home-page.component';
import { LoginAdminComponent } from './login-admin/login-admin.component';
import { LoginUserComponent } from './login-user/login-user.component';
import { PaymentGatewayComponent } from './payment-gateway/payment-gateway.component';
import { UserDashboardComponent } from './user-dashboard/user-dashboard.component';

const routes: Routes = [
  {path:'', component: HomePageComponent},
  {path:'home', component: HomePageComponent},
  {path:'loginadmin', component: LoginAdminComponent},
  {path:'loginuser', component: LoginUserComponent},
  {path:'addloan', component: AddLoanComponent},
  {path:'adduser', component: AddUserComponent},
  {path:'user', component: UserDashboardComponent},
  {path:'admin', component: AdminDashboardComponent},
<<<<<<< HEAD
  {path:'adminloan', component: AdminLoanDashboardComponent},
=======
<<<<<<< HEAD
  {path:'edit', component: EditUserComponent},
=======
  {path:'payment', component: PaymentGatewayComponent},
>>>>>>> 339eae746b37e9c9acbad0a433ddfd8f1f1b417a
>>>>>>> 9871d3482aff2cfd8d2baa586eea70abb9a41444
  {path:'**', redirectTo: '/home', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
