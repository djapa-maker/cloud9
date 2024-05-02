import { ComponentFixture, TestBed } from '@angular/core/testing';

// Importez ListePostsComponent à la place de ListPostComponent
import { ListePostsComponent } from './list-post.component';

describe('ListePostsComponent', () => {
  let component: ListePostsComponent; // Mettez à jour la référence du composant
  let fixture: ComponentFixture<ListePostsComponent>; // Mettez à jour la référence du composant

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListePostsComponent ] // Mettez à jour la déclaration du composant
    })
    .compileComponents();

    // Mettez à jour la création du composant
    fixture = TestBed.createComponent(ListePostsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
