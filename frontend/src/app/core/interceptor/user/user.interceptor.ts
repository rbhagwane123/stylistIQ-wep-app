import { HttpInterceptorFn } from '@angular/common/http';

export const userInterceptor: HttpInterceptorFn = (req, next) => {
  if (req.url.includes('remove.bg')) {
    return next(req);
  }

  const token = localStorage.getItem('jwt');
  if (!token) {
    return next(req);
  }
  const newReq = req.clone({
    setHeaders: {
      Authorization: `Bearer ${token}`,
    },
  });

  return next(newReq);
};
