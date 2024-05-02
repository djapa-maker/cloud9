import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Post } from 'src/app/model/post'; 

@Injectable({
  providedIn: 'root'
})
export class PostService {
  private apiUrl = 'http://localhost:8081/posts';

  constructor(private http: HttpClient) {}

  getAllPosts(): Observable<Post[]> {
    return this.http.get<Post[]>(`${this.apiUrl}/retrieve-all-posts`);
  }

  deletePost(id: number): Observable<any> {
    return this.http.delete(`${this.apiUrl}/remove-post/${id}`);
  }

  searchPosts(keyword: string): Observable<Post[]> {
    return this.http.get<Post[]>(`${this.apiUrl}/search-posts?keyword=${keyword}`);
  }




  addPost(formData: FormData): Observable<Post> {

    const headers = new HttpHeaders();
    // Set the Content-Type header to 'multipart/form-data'
    headers.append('Content-Type', 'multipart/form-data');
  
    // Pass the headers in the request options
    const options = {
      headers: headers
    };

  return this.http.post<Post>(`${this.apiUrl}/add-post`, formData, options);
}

getPostById(id: number): Observable<Post> {
  return this.http.get<Post>(`${this.apiUrl}/retrieve-post/${id}`);
}

modifyPost(id: number, formData: FormData): Observable<Post> {
  return this.http.put<Post>(`${this.apiUrl}/modify-post/${id}`, formData);
}
  
}
