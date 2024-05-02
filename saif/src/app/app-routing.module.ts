import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FrontAllComponent } from './front-office/front-all/front-all.component';
import { BackAllComponent } from './BackOffice/back-all/back-all.component';

import { CommonModule } from '@angular/common';


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



const routes: Routes = [
{ path: '', component:FrontAllComponent,children:[
  { path: 'reclamationfront', component: ReclamationComponent  },
  { path: 'posts-front', component: PostsFrontComponent  },
  { path: 'post-detail/:id', component: PostsDetailComponent}
    ]},
{ path: "admin", component:BackAllComponent,children:[
  //project paths
  { path: 'reclamation', component: ListdesreclamationComponent  },
  { path: 'listreponse', component: ListReponseComponent  },
  { path: 'ajoutereclamaton', component: AjouterreclamationComponent  },
  {path:'reponse/:id',component:ReponseReclamationComponent},
  {path:'modifierreclamation/:id',component:ModifierreclamationComponent},

  {path:'post', component: ListePostsComponent },
  { path: 'add-post', component: AddPostComponent },
  { path: 'modify-post/:id', component: ModifyPostComponent }   

  ]
},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
@NgModule({
  declarations: [
   // ProjetDetailComponent 
  ],
  imports: [
    CommonModule, 
  ]
})
export class VotreModule { }
