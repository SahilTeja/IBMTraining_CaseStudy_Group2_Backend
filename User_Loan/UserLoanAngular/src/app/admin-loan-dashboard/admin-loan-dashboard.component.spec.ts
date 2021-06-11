import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminLoanDashboardComponent } from './admin-loan-dashboard.component';

describe('AdminLoanDashboardComponent', () => {
  let component: AdminLoanDashboardComponent;
  let fixture: ComponentFixture<AdminLoanDashboardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminLoanDashboardComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminLoanDashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
