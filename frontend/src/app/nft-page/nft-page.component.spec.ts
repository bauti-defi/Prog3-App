import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NftPageComponent } from './nft-page.component';

describe('NftPageComponent', () => {
  let component: NftPageComponent;
  let fixture: ComponentFixture<NftPageComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [NftPageComponent]
    });
    fixture = TestBed.createComponent(NftPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
