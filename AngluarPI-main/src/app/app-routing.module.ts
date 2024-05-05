import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FrontAllComponent } from './front-office/front-all/front-all.component';
import { BackAllComponent } from './BackOffice/back-all/back-all.component';
import { ProjetDetailComponent } from './BackOffice/back-all/content-back/projectManagement/projet-dtail/projet-dtail.component';
import { CommonModule } from '@angular/common';
import { ListdesreclamationComponent } from './BackOffice/back-all/Reclamation/listdesreclamation/listdesreclamation.component';
import { AjouterreclamationComponent } from './BackOffice/back-all/Reclamation/ajouterreclamation/ajouterreclamation.component';
import { ModifierreclamationComponent } from './BackOffice/back-all/Reclamation/modifierreclamation/modifierreclamation.component';
import { ReponseReclamationComponent } from './BackOffice/back-all/Reclamation/reponse-reclamation/reponse-reclamation.component';
import { ReclamationComponent } from './front-office/front-all/reclamation/reclamation.component';
import { ListReponseComponent } from './BackOffice/back-all/Reclamation/list-reponse/list-reponse.component';
import { ListCategoryComponent } from './BackOffice/back-all/Category/list-category/list-category.component';
import { ListRessouceComponent } from './BackOffice/back-all/Ressource/list-ressouce/list-ressouce.component';
import { AjoutRessouceComponent } from './BackOffice/back-all/Ressource/ajout-ressouce/ajout-ressouce.component';
import { ModifyRessourceComponent } from './BackOffice/back-all/Ressource/modify-ressource/modify-ressource.component';
import { CatgorieFrontComponent } from './front-office/front-all/catgorie-front/catgorie-front.component';
import { RessourcesFrontComponent } from './front-office/front-all/ressources-front/ressources-front.component';
import { HomeComponent } from './front-office/front-all/home/home.component';
import {authGuard} from "./front-office/front-all/serives/auth/auth.guard";
import {ActivateAccountComponent} from "./front-office/front-all/activate-account/activate-account.component";
import {LoginComponent} from "./front-office/front-all/login/login.component";
import {RegisterComponent} from "./front-office/front-all/register/register.component";
import {ListuserComponent} from "./BackOffice/back-all/content-back/user/listuser/listuser.component";
import { AdduserComponent } from './BackOffice/back-all/content-back/user/adduser/adduser.component';
import { UpdateuserComponent } from './BackOffice/back-all/content-back/user/updateuser/updateuser.component';
import { DeleteuserComponent } from './BackOffice/back-all/content-back/user/deleteuser/deleteuser.component';
import { EventListComponent } from './BackOffice/back-all/content-back/events/event-list/event-list.component';
import { CreateEventComponent } from './BackOffice/back-all/content-back/events/create-event/create-event.component';
import { UpdateEventComponent } from './BackOffice/back-all/content-back/events/update-event/update-event.component';
import { TicketForEventComponent } from './front-office/front-all/ticket-for-event/ticket-for-event.component';
import { CreateTicketComponent } from './front-office/front-all/create-ticket/create-ticket.component';

const routes: Routes = [
  {
    path: 'login',
    component: LoginComponent
  },
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  {
    path: 'register',
    component: RegisterComponent
  },
  {
    path: 'activate-account',
    component: ActivateAccountComponent
  },
{ path: '', component:FrontAllComponent, canActivate: [authGuard] ,children:[

  { path: 'home', component: HomeComponent  },
  { path: 'reclamationfront', component: ReclamationComponent  },
  {path:'categoriFront', component:CatgorieFrontComponent},
  {path:'ressources/:id', component:RessourcesFrontComponent},
  {path:'tickets', component:TicketForEventComponent},
  {path:'create-ticket/:id', component:CreateTicketComponent},

    ]},
{ path: "admin", component:BackAllComponent, canActivate: [authGuard] ,children:[
  //project paths
  { path: 'reclamation', component: ListdesreclamationComponent  },
  { path: 'listreponse', component: ListReponseComponent  },
  { path: 'ajoutereclamaton', component: AjouterreclamationComponent  },
  {path:'reponse/:id',component:ReponseReclamationComponent},
  {path:'modifierreclamation/:id',component:ModifierreclamationComponent},
    { path: 'user', component: ListuserComponent  },

  {path:'listCategory',component:ListCategoryComponent},
  {path:'listRessource',component:ListRessouceComponent},
  {path:'ajoutRessource',component:AjoutRessouceComponent},
  { path: 'modifyRessource/:id', component: ModifyRessourceComponent },
    { path: 'adduser', component: AdduserComponent  },
    { path: 'updateuser/:id', component: UpdateuserComponent  },
    { path: 'deleteuser', component: DeleteuserComponent  },
    { path: 'events', component: EventListComponent  },
    {path: 'create-event', component: CreateEventComponent},
    {path: 'update-event/:id', component: UpdateEventComponent}
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
    ProjetDetailComponent
  ],
  imports: [
    CommonModule,
  ]
})
export class VotreModule { }
