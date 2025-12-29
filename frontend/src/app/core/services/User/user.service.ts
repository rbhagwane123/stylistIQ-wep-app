import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Store } from '@ngrx/store';
import { logoutSuccess } from '../../store/user/user.actions';
import { USER_PROFILE_URL } from '../../config/api';
import { catchError, map } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  constructor(private HttpClient: HttpClient, private store: Store) {}

  getUserProfile() {
    return this.HttpClient.get(`${USER_PROFILE_URL}/profile`).pipe(
      map((user: any) => {
        if (user) {
          return user;
        }
      }),
      catchError((error) => {
        throw error;
      })
    );
  }

  logout() {
    localStorage.removeItem('jwt');
    this.store.dispatch(logoutSuccess());
  }
}
