import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Router, RouterModule, RouterOutlet } from '@angular/router';
import { UserService } from '../../services/User/user.service';
import { Store } from '@ngrx/store';
import {
  getUserProfile,
  getUserProfileSuccess,
} from '../../store/user/user.actions';

@Component({
  selector: 'app-main-layout',
  imports: [RouterModule, CommonModule],
  templateUrl: './main-layout.component.html',
  styleUrl: './main-layout.component.scss',
})
export class MainLayoutComponent implements OnInit {
  showMenu = false;
  user: any;

  constructor(
    private router: Router,
    private userService: UserService,
    private store: Store
  ) {}

  ngOnInit(): void {
    this.userService.getUserProfile().subscribe({
      next: (user) => {
        this.user = user;
        this.store.dispatch(getUserProfileSuccess({ userProfile: user }));
        console.log('User profile loaded:', user);
      },
      error: (err) => {
        console.error('Error loading user profile:', err);
      },
    });
  }

  toggleMenu() {
    this.showMenu = !this.showMenu;
  }

  logOut() {
    this.userService.logout();
    this.router.navigate(['/home']);
  }
}
