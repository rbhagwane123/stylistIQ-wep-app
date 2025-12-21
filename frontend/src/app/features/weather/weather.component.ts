import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';

@Component({
  selector: 'app-weather',
  imports: [CommonModule],
  templateUrl: './weather.component.html',
  styleUrl: './weather.component.scss',
})
export class WeatherComponent {
  outfits = [
    {
      title: 'White Blouse & Blue Jeans',
      score: 92,
      image: 'https://images.unsplash.com/photo-1520975867597-0f7f1baf8a4b',
    },
    {
      title: 'Striped Sweater & Black Skirt',
      score: 88,
      image: 'https://images.unsplash.com/photo-1503341455253-b2e723bb3dbb',
    },
    {
      title: 'Leather Jacket & Ripped Jeans',
      score: 95,
      image: 'https://images.unsplash.com/photo-1526170375885-4d8ecf77b99f',
    },
  ];
}
