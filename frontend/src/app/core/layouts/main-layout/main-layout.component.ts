import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { Router, RouterModule, RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-main-layout',
  imports: [RouterModule, CommonModule],
  templateUrl: './main-layout.component.html',
  styleUrl: './main-layout.component.scss',
})
export class MainLayoutComponent {
  showMenu = false;

  constructor(router: Router) {}

  toggleMenu() {
    this.showMenu = !this.showMenu;
  }
}
