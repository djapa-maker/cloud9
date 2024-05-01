package tn.esprit.spring.controllers;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.spring.entities.Post;
import tn.esprit.spring.services.PostService;

@RestController
@RequestMapping({"/posts"})

public class  PostController {

    PostService postService;

    @GetMapping({"/retrieve-all-posts"})
    public List<Post> getAllPosts() {
        List<Post> posts = this.postService.getAllPosts();
        return posts;
    }

    @GetMapping({"/retrieve-post/{id}"})
    public Post getPostById(@PathVariable("id") Long id) {
        return this.postService.getPostById(id);
    }

    @PostMapping({"/add-post"})
    public Post createPost(@RequestBody Post post) {
        return this.postService.saveOrUpdatePost(post);
    }

    @PutMapping({"/modify-post/{id}"})
    public Post updatePost(@PathVariable Long id, @RequestBody Post post) {
        post.setId(id);
        return this.postService.saveOrUpdatePost(post);
    }

    @DeleteMapping({"/remove-post/{id}"})
    public void deletePost(@PathVariable Long id) {
        this.postService.deletePost(id);
    }

    public PostController(final PostService postService) {
        this.postService = postService;
    }

}
