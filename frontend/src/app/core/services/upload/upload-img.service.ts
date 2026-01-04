import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { CLOTHES_UPLOAD_API_URL } from '../../config/api';
import { catchError, map } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class UploadImgService {
  constructor(private http: HttpClient) {}

  uploadClothingImage(file: Blob) {
    const formData = new FormData();
    formData.append('file', file);
    // Implement the API call to upload the clothing image
    return this.http.post(`${CLOTHES_UPLOAD_API_URL}/upload`, formData).pipe(
      map((response: any) => {
        if (!response) {
          throw new Error('Invalid response from server');
        }
        return response;
      }),
      catchError((error) => {
        console.error('Upload failed', error);
        throw error;
      })
    );
  }
}
