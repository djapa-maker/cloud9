import { User } from "./User";

export enum CategorieType {
    FONCTIONNALITES_MANQUANTES,
    PROBLEMES_TECHNIQUES,
    SECURITE,
    ASSISTANCE_ET_SUPPORT,
    PERFORMANCES
    // Ajoutez plus de catégories ici si nécessaire
}
export class Reclamation {
    constructor(

        public id?: number,
        public descriptionReclamation?: string,
        public name?: string,
        public dateSoumission?: Date,
        public categorie?: CategorieType,
        public user?: User,
        public status?: string 

    ) {}
    }
  
    