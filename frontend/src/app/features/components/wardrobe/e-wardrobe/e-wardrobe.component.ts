import { Component, OnInit } from '@angular/core';
import { UploadModalComponent } from '../upload-modal/upload-modal.component';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { WardrobeItem } from '../../../../shared/models/wardrobe.model';
import { WardrobeService } from '../../../../core/services/wardrobe/wardrobe.service';

@Component({
  selector: 'app-e-wardrobe',
  imports: [CommonModule, UploadModalComponent],
  templateUrl: './e-wardrobe.component.html',
  styleUrl: './e-wardrobe.component.scss',
})
export class EWardrobeComponent implements OnInit {
  showUploadModal: boolean = false;
  wardrobeItems: WardrobeItem[] = []; // This will hold the wardrobe items

  constructor(
    private router: Router,
    private wardrobeService: WardrobeService,
  ) {}

  ngOnInit(): void {
    // 1. Subscribe to reactive state
    this.wardrobeService.wardrobe$.subscribe((data) => {
      this.wardrobeItems = data;
      console.log('Wardrobe updated:', data);
    });

    // 2. Trigger initial load
    this.wardrobeService.loadWardrobe();
  }

  handleUplaodModal() {
    this.showUploadModal = !this.showUploadModal;
  }
}
