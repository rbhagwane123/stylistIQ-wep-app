import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../../../environments/environment';
import { BG_REMOVE_API_URL } from '../../config/api';

@Injectable({
  providedIn: 'root',
})
export class BgRemoveService {
  constructor(private http: HttpClient) {}

  removeBackground(image_file: File) {
    const formData = new FormData();
    formData.append('image_file', image_file);
    const headers = new HttpHeaders({
      'X-Api-Key': environment.REMOVE_BG_API.API_KEY,
    });

    return this.http.post(BG_REMOVE_API_URL, formData, {
      headers,
      responseType: 'blob',
    });
  }
}
