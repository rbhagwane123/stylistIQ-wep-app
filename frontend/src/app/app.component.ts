import { Component, OnInit } from '@angular/core';
import { NavbarComponent } from './shared/components/navbar/navbar.component';
import { FooterComponent } from './shared/components/footer/footer.component';
import { NavigationEnd, Router, RouterOutlet } from '@angular/router';
import { CommonModule } from '@angular/common';
import { LoginComponent } from './features/auth/login/login.component';
@Component({
  selector: 'app-root',
  imports: [NavbarComponent, FooterComponent, RouterOutlet, CommonModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss',
})
export class AppComponent implements OnInit {
  title = 'stylistiq-ui';
  isAuthPage = true;
  routesUrl: string[] = ['/login', '/register', '/dashboard', '/wardrobe', '/recommendations', '/weather'];



  constructor(private router: Router) {
    this.router.events.subscribe((event) => {
      if (event instanceof NavigationEnd) {
        if (this.routesUrl.some((route) => event.url.includes(route))) {
          this.isAuthPage = true;
        } else {
          this.isAuthPage = false;
        }
      }
    });
  }
  ngOnInit(): void {
    
  }
}
  