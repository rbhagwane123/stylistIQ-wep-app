import { Injectable } from '@angular/core';
import { catchError, map, mergeMap, of } from 'rxjs';
import { loginFailure, loginSuccess } from './auth.actions';
import { AuthService } from '../../services/auth/auth.service';
import { ActionsSubject } from '@ngrx/store';
import { Action } from 'rxjs/internal/scheduler/Action';

@Injectable()
export class AuthEffects {
  
}
