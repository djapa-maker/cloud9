import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FrontAllComponent } from './front-office/front-all/front-all.component';
import { FooterFrontComponent } from './front-office/front-all/footer-front/footer-front.component';
import { ContentFrontComponent } from './front-office/front-all/content-front/content-front.component';
import { HeaderFrontComponent } from './front-office/front-all/header-front/header-front.component';
import { FormsModule } from '@angular/forms';
import { BackAllComponent } from './BackOffice/back-all/back-all.component';
import { NavbarComponent } from './BackOffice/back-all/navbar/navbar.component';
import { SidebarComponent } from './BackOffice/back-all/sidebar/sidebar.component';
import { FooterBackComponent } from './BackOffice/back-all/footer-back/footer-back.component';
import { ContentBackComponent } from './BackOffice/back-all/content-back/content-back.component';

import { HttpClientModule } from '@angular/common/http';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { ReactiveFormsModule } from '@angular/forms';

import { DatePipe } from '@angular/common';
import { DragDropModule } from '@angular/cdk/drag-drop';
import { NgbPaginationModule } from '@ng-bootstrap/ng-bootstrap';
import { NgxPaginationModule } from 'ngx-pagination';
import { ListdesreclamationComponent } from './BackOffice/back-all/Reclamation/listdesreclamation/listdesreclamation.component';
import { AjouterreclamationComponent } from './BackOffice/back-all/Reclamation/ajouterreclamation/ajouterreclamation.component';
import { ModifierreclamationComponent } from './BackOffice/back-all/Reclamation/modifierreclamation/modifierreclamation.component';
import { ReponseReclamationComponent } from './BackOffice/back-all/Reclamation/reponse-reclamation/reponse-reclamation.component';
import { ReclamationComponent } from './front-office/front-all/reclamation/reclamation.component';
import { ListReponseComponent } from './BackOffice/back-all/Reclamation/list-reponse/list-reponse.component';
import { ListePostsComponent } from './BackOffice/back-all/Post/list-post/list-post.component';
import { AddPostComponent } from './BackOffice/back-all/Post/add-post/add-post.component';
import { ModifyPostComponent } from './BackOffice/back-all/Post/modify-post/modify-post.component';
import { PostsFrontComponent } from './front-office/front-all/Post/posts-front/posts-front.component';
import { PostsDetailComponent } from './front-office/front-all/Post/posts-detail/posts-detail.component';
@NgModule({
  declarations: [
    AppComponent,
    FrontAllComponent,
    FooterFrontComponent,
    ContentFrontComponent,
    HeaderFrontComponent,
    BackAllComponent,
    NavbarComponent,
    SidebarComponent,
    FooterBackComponent,
    ContentBackComponent,
   
   
    ListdesreclamationComponent,
    AjouterreclamationComponent,
    ModifierreclamationComponent,
    ReponseReclamationComponent,
    ReclamationComponent,
    ListReponseComponent,
    ListePostsComponent,
    AddPostComponent,
    ModifyPostComponent,
    PostsFrontComponent,
    PostsDetailComponent,

 
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    ReactiveFormsModule,
    AppRoutingModule,
    FormsModule,
    NgbModule,
    DragDropModule,
    NgbPaginationModule,
    NgxPaginationModule 

  ],
  providers: [
    DatePipe 
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
