import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { WardrobeService } from '../../../core/services/wardrobe/wardrobe.service';

@Component({
  selector: 'app-dashboard',
  imports: [],
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.scss',
})
export class DashboardComponent {
  itemCount: number = 0; // This will hold the count of wardrobe items

  constructor(
    private router: Router,
    private wardrobeService: WardrobeService,
  ) {}

  ngOnInit() {
    this.wardrobeService.getWardrobeItemCount().subscribe((count) => {
      this.wardrobeService.wardrobeCountSubject.next(count);
    });

    this.wardrobeService.wardrobeCount$.subscribe((count) => {
      this.itemCount = count;
    });
  }
}
