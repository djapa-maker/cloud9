package tn.esprit.soulcare.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.soulcare.Services.PostService;
import tn.esprit.soulcare.entities.Post;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialBlob;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/retrieve-all-posts")
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/retrieve-post/{id}")
    public Post getPostById(@PathVariable("id") Long id) {
        return postService.getPostById(id);
    }

   /* @PostMapping("/add-post")
    public Post createPost(@RequestBody Post post) {
        return postService.saveOrUpdatePost(post);
    }*/


    @PostMapping(path="/add-post",consumes = "multipart/form-data")
    public Post createPost(@RequestPart("jsonData") String jsonData,
                           @RequestPart("image") MultipartFile image) throws IOException, SQLException {
        // Deserialize JSON string into Post object
        ObjectMapper objectMapper = new ObjectMapper();
        Post post = objectMapper.readValue(jsonData, Post.class);
        post.setDatePosted(LocalDateTime.now());
        // Process the image file
        byte[] fileBytes = image.getBytes();
        Blob blob = new SerialBlob(fileBytes);

        // Set the image in the Post object
        post.setImage(blob);

        // Save or update the post
        return postService.saveOrUpdatePost(post);
    }




    /*public Post updatePost(@PathVariable Long id, @RequestBody Post post) {
        post.setId(id); // Set the ID of the post to be updated
        return postService.saveOrUpdatePost(post);
    }*/
    @PutMapping(path="/modify-post/{id}",consumes = "multipart/form-data")
    public Post updatePost(@PathVariable Long id,
                           @RequestPart("jsonData") String jsonData,
                           @RequestPart("image") MultipartFile image) throws IOException, SQLException {
        ObjectMapper objectMapper = new ObjectMapper();
        Post post = objectMapper.readValue(jsonData, Post.class);

        post.setId(id);

        byte[] fileBytes = image.getBytes();
        Blob blob = new SerialBlob(fileBytes);

        post.setImage(blob);

        post.setDatePosted(LocalDateTime.now());

        return postService.saveOrUpdatePost(post);
    }



    @DeleteMapping("/remove-post/{id}")
    public void deletePost(@PathVariable Long id) {
        postService.deletePost(id);
    }

    @PostMapping("/upload-image")
    public String uploadImage(@RequestParam("file") MultipartFile file) throws IOException {
        return postService.saveImage(file);
    }

}
