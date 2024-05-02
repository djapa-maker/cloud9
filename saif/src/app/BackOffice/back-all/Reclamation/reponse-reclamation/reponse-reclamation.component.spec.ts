import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReponseReclamationComponent } from './reponse-reclamation.component';

describe('ReponseReclamationComponent', () => {
  let component: ReponseReclamationComponent;
  let fixture: ComponentFixture<ReponseReclamationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ReponseReclamationComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ReponseReclamationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
