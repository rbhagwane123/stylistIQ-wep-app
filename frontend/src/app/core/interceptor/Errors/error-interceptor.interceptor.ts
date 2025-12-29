import { HttpInterceptorFn } from '@angular/common/http';
import { catchError, throwError } from 'rxjs';

export const errorInterceptorInterceptor: HttpInterceptorFn = (req, next) => {
  return next(req).pipe(
    catchError((err) => {
      if (err.status === 401) {
        // auto logout if 401 response returned from api
        localStorage.removeItem('jwt');
        alert(err.error.message);
      }
      if (err.status === 403) {
        alert('You are not authorized to access this page');
      }
      return throwError(() => err);
    })
  );
};
