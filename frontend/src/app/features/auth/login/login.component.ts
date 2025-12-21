import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import {
  FormBuilder,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { Router, RouterModule } from '@angular/router';
import { MatSnackBar } from '@angular/material/snack-bar';
import { LoginToastComponent } from './login-toast/login-toast.component';

@Component({
  selector: 'app-login',
  imports: [ReactiveFormsModule, CommonModule, RouterModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css',
})
export class LoginComponent {
  loginForm!: FormGroup;
  private router: Router = new Router();

  constructor(
    router: Router,
    private formBuilder: FormBuilder,
    private snackBar: MatSnackBar
  ) {
    this.router = router;
    this.loginForm = this.formBuilder.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(8)]],
    });
  }

  onLogin() {
    if (this.loginForm.valid) {
      console.log('Login req data, ', this.loginForm.value);
      this.snackBar.openFromComponent(LoginToastComponent, {
        duration: 3000,
        horizontalPosition: 'right',
        verticalPosition: 'bottom',
        panelClass: ['login-toast'],
      });
      this.router.navigate(['/dashboard']);
    } else {
      this.loginForm.markAllAsTouched();
      return;
    }
  }

  get email() {
    return this.loginForm.get('email');
  }

  get password() {
    return this.loginForm.get('password');
  }
}
