import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListaLayoutComponent } from './lista-layout.component';

describe('ListaLayoutComponent', () => {
  let component: ListaLayoutComponent;
  let fixture: ComponentFixture<ListaLayoutComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListaLayoutComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ListaLayoutComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
