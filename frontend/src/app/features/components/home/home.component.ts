import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FeatureComponent } from "./feature/feature.component";

@Component({
  selector: 'app-home',
  imports: [CommonModule, FeatureComponent],
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss',
})
export class HomeComponent {
  heroImage: string = 'assets/images/hero_img.jpg';
}
