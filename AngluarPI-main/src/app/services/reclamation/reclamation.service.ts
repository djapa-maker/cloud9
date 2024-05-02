import { Injectable } from '@angular/core';
import {HttpClient,HttpHeaders, HttpErrorResponse} from "@angular/common/http";
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Reclamation } from 'src/app/model/reclamation';
import { ReponseReclamation } from 'src/app/model/ReponseReclamation';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' ,'Access-Control-Allow-Origin': 'http://localhost:4200'})
};
@Injectable({
  providedIn: 'root'
})
export class ReclamationService {
  private ajouterurl ='http://localhost:8085/mindCare/addReclamation';
  private listurl ='http://localhost:8085/mindCare/retrieveAllReclamations';
  private modifierurl = 'http://localhost:8085/mindCare/update_reclamation';
  private userUrl='http://localhost:8085/mindCare/retrieveAllUsers';
  private Url='http://localhost:8085/mindCare';
  private apiUrl = 'http://localhost:8085/mindCare/reclamationStats';
  private apiReponseAjout ='http://localhost:8085/mindCare/addReponse';
  private apiReponseaffiche='http://localhost:8085/mindCare/retrieveAllReponse';
  constructor(private http: HttpClient) { }
  
 

   ajouterreclamation(reclamation: Reclamation): Observable<Reclamation> {
    return this.http.post<Reclamation>(this.ajouterurl, reclamation, httpOptions);
  }


  ajoutReponseToReclamation(id: number, reponseReclamation: ReponseReclamation): Observable<ReponseReclamation> {
    const url = `${this.Url}/reclamations/${id}/reponses`;
    return this.http.post<ReponseReclamation>(url, reponseReclamation, httpOptions);
}

 
 listreclamation() {
    
   return this.http.get(this.listurl);
  }

  listreponse() {
    
    return this.http.get(this.apiReponseaffiche);
   }
 

   deleteReclamation(id: number): Observable<void> {
    const url = `${this.Url}/${id}`;
    return this.http.delete<void>(url);
  }
   modifierreclamation(id:number,reclamation: Reclamation) {
    const url = `${this.modifierurl}/${id}`;
    return this.http.put<Reclamation>(url, reclamation);

   }
 
   getReclamation(id: any) {
     return this.http.get('http://localhost:8085/mindCare/get_reclamation/' + id)
   }

   

   getReponse(id: any) {
    return this.http.get('http://localhost:8085/mindCare/getReponse/' + id)
  }
  

   getUsers() {
    
    return this.http.get(this.userUrl);
   }


   searchReclamations(keyword: string): Observable<Reclamation[]> {
    const url = `${this.Url}/searchReclamation?keyword=${keyword}`;
    return this.http.get<Reclamation[]>(url);
  }
  searchReponse(keyword: string): Observable<Reclamation[]> {
    const url = `${this.Url}/searchReponse?keyword=${keyword}`;
    return this.http.get<ReponseReclamation[]>(url);
  }

  getReclamationStats(): Observable<any> {
    return this.http.get<any>(this.apiUrl);
  }

  getReclamationByName(name: string): Observable<Reclamation> {
    const url = `${this.Url}/getReclamationByName/${name}`;
    return this.http.get<Reclamation>(url);
}

}
