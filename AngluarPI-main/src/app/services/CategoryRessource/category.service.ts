import { Injectable } from '@angular/core';
import {HttpClient,HttpHeaders, HttpErrorResponse} from "@angular/common/http";
import { Observable } from 'rxjs';
import { Category } from 'src/app/model/Category';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' ,'Access-Control-Allow-Origin': 'http://localhost:4200'})
};
@Injectable({
  providedIn: 'root'
})
export class CategoryService {
  private baseUrl = 'http://localhost:8085/mindCare/category'; 

  constructor(private http: HttpClient) { }


  addCategory(category: Category): Observable<Category> {
    return this.http.post<Category>(`${this.baseUrl}/addcategory`, category);
  }

  getCategoryById(id: number): Observable<Category> {
    return this.http.get<Category>(`${this.baseUrl}/getcategory/${id}`);
  }

  getAllCategories(): Observable<Category[]> {
    return this.http.get<Category[]>(`${this.baseUrl}/getall`);
  }

  deleteCategory(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/delete/${id}`);
  }

  updateCategory(category: Category): Observable<Category> {
    return this.http.put<Category>(`${this.baseUrl}/updatecategorys`, category);
  }

  searchCategory(keyword: string): Observable<Category[]> {
    const url = `${this.baseUrl}/searchCategory?keyword=${keyword}`;
    return this.http.get<Category[]>(url);
  }
}
