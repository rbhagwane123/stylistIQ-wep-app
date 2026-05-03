import { CommonModule } from '@angular/common';
import { Component, EventEmitter, Output } from '@angular/core';
import { HttpEvent, HttpEventType } from '@angular/common/http';
import { NgxSpinnerModule } from 'ngx-spinner';
import { BgRemoveService } from '../../../../core/services/bg-remove/bg-remove.service';
import { UploadImgService } from '../../../../core/services/upload/upload-img.service';
import { WardrobeService } from '../../../../core/services/wardrobe/wardrobe.service';

@Component({
  selector: 'app-upload-modal',
  imports: [CommonModule, NgxSpinnerModule],
  templateUrl: './upload-modal.component.html',
  styleUrl: './upload-modal.component.scss',
})
export class UploadModalComponent {
  @Output() close = new EventEmitter<void>();

  selectedFile!: File;
  previewUrl: string | null = null;
  uploadProgress = 0;
  isProcessing = false;
  isUploading = false;

  constructor(
    private removeBgService: BgRemoveService,
    private uploadImgService: UploadImgService,
    private wardrobeService: WardrobeService,
  ) {}

  ngOnInit(): void {
    // Any initialization logic can go here
    this.wardrobeService.getWardrobeItemCount().subscribe((count) => {
      this.wardrobeService.wardrobeCountSubject.next(count);
    });
  }

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

  uploadImage() {
    this.isProcessing = true;
    this.uploadProgress = 0;

    const formData = new FormData();
    formData.append('image', this.selectedFile);
    formData.append('size', 'auto');

    this.removeBgService.removeBackground(this.selectedFile).subscribe({
      next: (blob) => {
        this.isProcessing = false;
        this.startUpload(blob);
      },
      error: (err) => {
        this.isProcessing = false;
        alert('Failed to process image');
      },
    });
  }

  startUpload(blob: Blob) {
    this.isUploading = true;

    this.uploadImgService.uploadClothingImage(blob).subscribe({
      next: (event: HttpEvent<any>) => {
        if (event.type === HttpEventType.UploadProgress && event.total) {
          this.uploadProgress = Math.round((100 * event.loaded) / event.total);
        }

        if (event.type === HttpEventType.Response) {
          this.uploadProgress = 100;
          this.isUploading = false;
          const uploadedItem = event.body; // backend should return saved wardrobe item
          console.log('Upload Item : ', uploadedItem);
          this.wardrobeService.addWardrobeItem(uploadedItem);
          alert('Image uploaded successfully');
          this.close.emit();
        }
      },
      error: () => {
        this.isUploading = false;
        this.uploadProgress = 0;
        alert('Upload failed');
      },
    });
  }
}
