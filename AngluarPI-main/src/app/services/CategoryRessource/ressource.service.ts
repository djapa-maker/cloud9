import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Ressource } from 'src/app/model/Ressource';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' ,'Access-Control-Allow-Origin': 'http://localhost:4200'})
};
@Injectable({
  providedIn: 'root'
})

export class RessourceService {

  private baseUrl = 'http://localhost:8085/mindCare/ressource'; 

  constructor(private http: HttpClient) { }

  /*createResourceAndAssociateCategory(ressource: Ressource, categoryId: number): Observable<void> {
    return this.http.put<void>(`${this.baseUrl}/createResourceAndAssociateCategory/${categoryId}`, ressource);
  }*/
  createResourceAndAssociateCategory(ressource: Ressource, categoryId: number, file: File): Observable<void> {
    const formData: FormData = new FormData();
    formData.append('titleR', ressource.titleR);
    formData.append('descriptionR', ressource.descriptionR);
    formData.append('file', file);

    return this.http.put<void>(`${this.baseUrl}/createResourceAndAssociateCategory/${categoryId}`, formData);
  }
 
  

  getRessourceById(id: number): Observable<Ressource> {
    return this.http.get<Ressource>(`${this.baseUrl}/getressource/${id}`);
  }

  getAllRessources(): Observable<Ressource[]> {
    return this.http.get<Ressource[]>(`${this.baseUrl}/getall`);
  }

  deleteRessource(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/delete/${id}`);
  }

  updateRessource(ressource: Ressource): Observable<Ressource> {
    return this.http.put<Ressource>(`${this.baseUrl}/updateIdressources`, ressource);
  }

  unassignResourceFromCategory(id: number): Observable<void> {
    return this.http.put<void>(`${this.baseUrl}/desaffecter-ressource/${id}`, {});
  }

  findRessourcesByTitleR(titleR: string): Observable<Ressource[]> {
    return this.http.get<Ressource[]>(`${this.baseUrl}/findRessourcesByTitleR/${titleR}`);
  }

  findRessourcesByCategoryId(id: number): Observable<Ressource[]> {
    return this.http.get<Ressource[]>(`${this.baseUrl}/findRessourcesByCategoryId/${id}`);
  }

  searchRessource(keyword: string): Observable<Ressource[]> {
    const url = `${this.baseUrl}/searchRessource?keyword=${keyword}`;
    return this.http.get<Ressource[]>(url);
  }

  getRessourceStatsByCategory(): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}/statsByCategory`);
  }


getResourcesByCategoryId(categoryId: number): Observable<Ressource[]> {
  return this.http.get<Ressource[]>(`${this.baseUrl}/getResourcesByCategoryId/${categoryId}`);
}


likeRessource(idR: number): Observable<any> {
  return this.http.post<any>(`${this.baseUrl}/ressources/${idR}/like`, {});
}

dislikeRessource(idR: number): Observable<any> {
  return this.http.post<any>(`${this.baseUrl}/ressources/${idR}/dislike`, {});
}

loadUrl(idRessource: number): Observable<Blob> {
  const headers = new HttpHeaders().set('Accept', 'application/avif');
  return this.http.get(`${this.baseUrl}/loadurl/${idRessource}`, { headers,responseType: 'blob' });
}

desaffecterRessource(ressourceId: number): Observable<any> {
  const url = `${this.baseUrl}/desaffecter-ressource/${ressourceId}`;
  return this.http.put(url, null);
}

}
