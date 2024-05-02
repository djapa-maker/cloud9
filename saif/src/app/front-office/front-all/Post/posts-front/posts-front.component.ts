import { Component, OnInit } from '@angular/core';
import { Post } from 'src/app/model/post';
import { PostService } from 'src/app/services/post/post.service';

@Component({
  selector: 'app-posts-front',
  templateUrl: './posts-front.component.html',
  styleUrls: ['./posts-front.component.css']
})
export class PostsFrontComponent implements OnInit {
  posts: Post[] = []; // Array to store retrieved posts

  constructor(private postService: PostService) { }

  ngOnInit(): void {
    this.getPosts(); // Call the method to retrieve posts when the component initializes
  }

  // Method to retrieve posts from the service
  getPosts(): void {
    this.postService.getAllPosts().subscribe(
      (data: Post[]) => {
        this.posts = data;
        console.log('Posts:', data);
      },
      error => {
        console.error('Error fetching posts', error);
      }
    );
  }
}
