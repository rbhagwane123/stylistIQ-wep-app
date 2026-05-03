import { HttpClient, HttpRequest } from '@angular/common/http';
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

    const req = new HttpRequest(
      'POST',
      `${CLOTHES_UPLOAD_API_URL}/upload`,
      formData,
      {
        reportProgress: true,
        responseType: 'json',
      }
    );
    return this.http.request(req);
  }
}
