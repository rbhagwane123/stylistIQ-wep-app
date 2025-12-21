import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './features/components/home/home.component';
import { LoginComponent } from './features/auth/login/login.component';
import { NgModule } from '@angular/core';
import { RegisterComponent } from './features/auth/register/register.component';
import { DashboardComponent } from './features/dashboard/dashboard.component';
import { authGuard } from './core/guards/auth/auth.guard';
import { EWardrobeComponent } from './features/wardrobe/e-wardrobe/e-wardrobe.component';
import { RecommendationsComponent } from './features/recommendations/recommendations.component';
import { WeatherComponent } from './features/weather/weather.component';
import { MainLayoutComponent } from './core/layouts/main-layout/main-layout.component';
import { FeatureComponent } from './features/components/home/feature/feature.component';

export const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'home', component: HomeComponent },
  { path: 'register', component: RegisterComponent },
  {
    path: '',
    component: MainLayoutComponent,
    children: [
      {
        path: 'dashboard',
        loadComponent: () =>
          import('./features/dashboard/dashboard.component').then(
            (m) => m.DashboardComponent
          ),
      },
      {
        path: 'wardrobe',
        loadComponent: () =>
          import('./features/wardrobe/e-wardrobe/e-wardrobe.component').then(
            (m) => m.EWardrobeComponent
          ),
      },
      {
        path: 'recommendations',
        loadComponent: () =>
          import('./features/recommendations/recommendations.component').then(
            (m) => m.RecommendationsComponent
          ),
      },
      {
        path: 'weather',
        loadComponent: () =>
          import('./features/weather/weather.component').then(
            (m) => m.WeatherComponent
          ),
      },
      { path: '', redirectTo: 'dashboard', pathMatch: 'full' },
    ],
  },
];
