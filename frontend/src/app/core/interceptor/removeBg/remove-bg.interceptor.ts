import { HttpInterceptorFn } from '@angular/common/http';

export const removeBgInterceptor: HttpInterceptorFn = (req, next) => {
  return next(req);
};
