import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AUTH_API_URL, BASE_API_URL } from '../../config/api';
import { catchError, map, of } from 'rxjs';
import {
  loginFailure,
  loginSuccess,
  registerFailure,
  registerSuccess,
} from '../../store/auth/auth.actions';
import { Store } from '@ngrx/store';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  constructor(private http: HttpClient, private store: Store) {}

  login(loginData: any) {
    return this.http.post(`${AUTH_API_URL}/signin`, loginData).pipe(
      map((user: any) => {
        if (user && user.jwt) {
          localStorage.setItem('jwt', user.jwt);
        }
        return user; // just return response
      })
    );
  }

  register(registerData: any) {
    return this.http
      .post(`${AUTH_API_URL}/signup`, registerData)
      .pipe(
        map((user: any) => {
          console.log('register user ', user);
          if (user.jwt) {
            localStorage.setItem('jwt', user.jwt);
          }
          return registerSuccess({ user });
        }),
        catchError((error) => {
          localStorage.removeItem('jwt');
          return of(
            registerFailure(
              error.response && error.response.data.message
                ? error.response.data.message
                : error.message
            )
          );
        })
      )
      .subscribe((action) => this.store.dispatch(action));
  }
}
