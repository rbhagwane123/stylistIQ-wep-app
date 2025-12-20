import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LoginToastComponent } from './login-toast.component';

describe('LoginToastComponent', () => {
  let component: LoginToastComponent;
  let fixture: ComponentFixture<LoginToastComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [LoginToastComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LoginToastComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
