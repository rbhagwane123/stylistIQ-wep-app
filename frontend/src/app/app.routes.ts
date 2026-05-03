import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './features/components/home/home.component';
import { LoginComponent } from './features/auth/login/login.component';

import { RegisterComponent } from './features/auth/register/register.component';
import { MainLayoutComponent } from './core/layouts/main-layout/main-layout.component';
import { authGuard } from './core/guards/auth/auth.guard';

export const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: '', component: HomeComponent },
  { path: 'home', component: HomeComponent },
  { path: 'register', component: RegisterComponent },
  {
    path: 'main-layout',
    component: MainLayoutComponent,
    canActivate: [authGuard],
    children: [
      {
        path: 'dashboard',
        loadComponent: () =>
          import('./features/components/dashboard/dashboard.component').then(
            (m) => m.DashboardComponent,
          ),
      },
      {
        path: 'wardrobe',
        loadComponent: () =>
          import('./features/components/wardrobe/e-wardrobe/e-wardrobe.component').then(
            (m) => m.EWardrobeComponent,
          ),
      },
      {
        path: 'recommendations',
        loadComponent: () =>
          import('./features/components/recommendations/recommendations.component').then(
            (m) => m.RecommendationsComponent,
          ),
      },
      {
        path: 'weather',
        loadComponent: () =>
          import('./features/components/weather/weather.component').then(
            (m) => m.WeatherComponent,
          ),
      },
    ],
  },
];
