import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InfoProjetoComponent } from './info-projeto.component';

describe('InfoProjetoComponent', () => {
  let component: InfoProjetoComponent;
  let fixture: ComponentFixture<InfoProjetoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [InfoProjetoComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InfoProjetoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
