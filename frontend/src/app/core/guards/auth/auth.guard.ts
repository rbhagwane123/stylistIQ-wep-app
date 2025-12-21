import { CanActivateFn } from '@angular/router';

import { LoginComponent } from '../../../features/auth/login/login.component';

export const authGuard: CanActivateFn = (route, state) => {
  return true;
};
