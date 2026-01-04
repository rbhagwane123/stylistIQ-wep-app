import { Component } from '@angular/core';
import { UploadModalComponent } from '../upload-modal/upload-modal.component';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-e-wardrobe',
  imports: [UploadModalComponent, CommonModule],
  templateUrl: './e-wardrobe.component.html',
  styleUrl: './e-wardrobe.component.scss',
})
export class EWardrobeComponent {
  showUploadModal: boolean = false;

  constructor(private router: Router) {}

  handleUplaodModal() {
    this.showUploadModal = !this.showUploadModal;
  }
}
