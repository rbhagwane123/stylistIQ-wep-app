import { HttpClient } from '@angular/common/http';
import { Injectable, OnInit } from '@angular/core';
import { WARDROBE_API_URL } from '../../config/api';
import { BehaviorSubject, catchError, map } from 'rxjs';
import { WardrobeItem } from '../../../shared/models/wardrobe.model';

@Injectable({
  providedIn: 'root',
})
export class WardrobeService {
  private wardrobeSubject = new BehaviorSubject<WardrobeItem[]>([]);
  wardrobeCountSubject = new BehaviorSubject<number>(0);
  wardrobe$ = this.wardrobeSubject.asObservable();
  wardrobeCount$ = this.wardrobeCountSubject.asObservable();

  constructor(private http: HttpClient) {}

  setWardrobe(items: WardrobeItem[]) {
    this.wardrobeSubject.next(items);
  }

  addWardrobeItem(item: WardrobeItem) {
    const current = this.wardrobeSubject.value;
    this.wardrobeSubject.next([item, ...current]);
  }

  loadWardrobe() {
    this.http.get<WardrobeItem[]>(WARDROBE_API_URL).subscribe({
      next: (data) => {
        console.log('loading Wardrobe data : ', data);
        this.setWardrobe(data);
        this.wardrobeCountSubject.next(data.length);
      },
      error: (err) => {
        console.error('Failed to load wardrobe', err);
      },
    });
  }

  getWardrobeItemCount() {
    return this.http.get<number>(`${WARDROBE_API_URL}/count`);
  }
}
