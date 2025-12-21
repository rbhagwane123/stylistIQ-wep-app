import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';

@Component({
  selector: 'app-recommendations',
  imports: [CommonModule],
  templateUrl: './recommendations.component.html',
  styleUrl: './recommendations.component.scss',
})
export class RecommendationsComponent {
  activeTab: 'text' | 'image' = 'text';
}
