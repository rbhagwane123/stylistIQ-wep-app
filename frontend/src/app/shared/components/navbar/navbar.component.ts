import { CommonModule } from '@angular/common';
import { Component, HostListener, signal } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { routes } from '../../../app.routes';

@Component({
  selector: 'app-navbar',
  imports: [CommonModule],
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.scss',
})
export class NavbarComponent {
  isScrolled = signal(false);
  mobileMenuOpen = signal(false);
  private router: Router = new Router();

  constructor(router: Router) {
    this.router = router;
  }

  @HostListener('window:scroll', [])
  onWindowScroll() {
    this.isScrolled.set(window.scrollY > 20);
  }

  toggleMobileMenu() {
    this.mobileMenuOpen.update((v) => !v);
  }

  openPage(page: string) {
    if (page === 'register') {
      this.router.navigate(['/register']);
      return;
    } else if (page === 'login') {
      this.router.navigate(['/login']);
      return;
    }
  }
}
