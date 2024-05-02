import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ReclamationService } from 'src/app/services/reclamation/reclamation.service';
import { Reclamation } from 'src/app/model/reclamation';
import { User } from 'src/app/model/User';
import { Location } from '@angular/common';

@Component({
  selector: 'app-reclamation',
  templateUrl: './reclamation.component.html',
  styleUrls: ['./reclamation.component.css']
})
export class ReclamationComponent {

  reclamations: Reclamation[] = []; 
  users: User[] = [];
  successNotification: boolean = false;
  successNotificationMessage: string = '';
  notification: boolean = false; // Ajout de la propriété notification
  notificationMessage: string = ''; // Ajout de la propriété notificationMessage
  
  showNameField: boolean = false;
  showDateField: boolean = false;
  showDescriptionField: boolean = false;

  constructor(private service: ReclamationService, private router: Router, private location: Location) { }

  
  ngOnInit(){
    this.showNameField = false;
    this.showDateField = false;
    this.showDescriptionField = false;  }



  onCategoryChange(event: Event) {
    const target = event.target as HTMLSelectElement;
    const category = target.value;

    if (category) {
     
      this.showNameField = false;
      this.showDateField = false;
      this.showDescriptionField = false;
  
     
      switch (category) {
        case 'FONCTIONNALITES_MANQUANTES':
          this.showNameField = true;
          this.showDateField = true;
          this.showDescriptionField = true;

          break;
        case 'PROBLEMES_TECHNIQUES':
          this.showNameField = true;
          this.showDateField = true;
          this.showDescriptionField = true;
          break;
        case 'SECURITE':
          this.showNameField = true;
          this.showDateField = true;
          this.showDescriptionField = true;
          break;
          case 'ASSISTANCE_ET_SUPPORT':
            this.showNameField = true;
            this.showDateField = true;
            this.showDescriptionField = true;
            break;
          case 'PERFORMANCES':
            this.showNameField = true;
            this.showDateField = true;
            this.showDescriptionField = true;
            break;
        default:
          break;
      }
    }
  }

  persistreclamation(formData: any) {
    const userAmal = this.users.find(user => user.firstName === 'amal');

    const reclamationData: Reclamation = {
      categorie: formData.categorie,
      name: formData.name,
      dateSoumission: new Date(),
      descriptionReclamation: formData.descriptionReclamation,
      user: userAmal,
      status: 'NonTraité',
    };

    this.service.ajouterreclamation(reclamationData).subscribe((response) => {
      console.log('Réclamation ajoutée avec succès :', response);
      
      // Activer la notification de succès
      this.successNotificationMessage = 'Réclamation envoyée avec succès!';
      this.successNotification = true;

      this.ngOnInit();
    }, (error) => {
      console.error('Erreur lors de l\'ajout de la réclamation :', error);
    });
  }
}
 
  

