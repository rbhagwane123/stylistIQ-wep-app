import { inject, Inject } from '@angular/core';
import { CanActivateFn, Router } from '@angular/router';

export const authGuard: CanActivateFn = (route, state) => {
  const token = localStorage.getItem('jwt');
  const router = inject(Router);

  if (token == null) {
    router.navigate(['/login']);
    return false;
  } else {
    return true;
  }
  return true;
};
