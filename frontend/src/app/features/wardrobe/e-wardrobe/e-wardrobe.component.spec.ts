import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EWardrobeComponent } from './e-wardrobe.component';

describe('EWardrobeComponent', () => {
  let component: EWardrobeComponent;
  let fixture: ComponentFixture<EWardrobeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EWardrobeComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EWardrobeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
