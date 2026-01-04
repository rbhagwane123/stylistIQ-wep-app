import { CommonModule } from '@angular/common';
import { Component, EventEmitter, Output } from '@angular/core';
import { BgRemoveService } from '../../../core/services/bg-remove/bg-remove.service';
import { UploadImgService } from '../../../core/services/upload/upload-img.service';

@Component({
  selector: 'app-upload-modal',
  imports: [CommonModule],
  templateUrl: './upload-modal.component.html',
  styleUrl: './upload-modal.component.scss',
})
export class UploadModalComponent {
  @Output() close = new EventEmitter<void>();

  selectedFile!: File;
  previewUrl: string | null = null;

  constructor(
    private removeBgService: BgRemoveService,
    private uploadImgService: UploadImgService
  ) {}

  onFileSelected(event: Event) {
    const input = event.target as HTMLInputElement;

    if (!input.files || input.files.length === 0) return;

    if (input.files && input.files.length > 0) {
      this.selectedFile = input.files[0];
    }

    const reader = new FileReader();
    reader.onload = () => (this.previewUrl = reader.result as string);
    reader.readAsDataURL(this.selectedFile);
    console.log('Selected file:', this.selectedFile);
  }

  removeImage() {
    this.previewUrl = null;
    this.selectedFile = undefined!;
  }

  removeBackground() {
    const formData = new FormData();
    formData.append('image', this.selectedFile);
    formData.append('size', 'auto');
    this.removeBgService.removeBackground(this.selectedFile).subscribe({
      next: (blob) => {
        const objectUrl = URL.createObjectURL(blob);
        this.previewUrl = objectUrl;
        this.uploadImgService.uploadClothingImage(blob).subscribe({
          next: (response) => {
            console.log('Upload successful:', response);
            alert('Image uploaded successfully');
          },
          error: (err) => {
            console.error('Upload failed:', err);
            alert('Failed to upload image');
          },
        });
      },
      error: (err) => {
        console.error(err);
        alert('Failed to remove background');
      },
    });
  }
}
