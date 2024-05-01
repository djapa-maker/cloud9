package tn.esprit.spring.services;

import tn.esprit.spring.entities.Post;
import tn.esprit.spring.entities.User;

import java.util.List;

public interface IPostService {
    public List<Post> getAllPosts();
    public Post getPostById(Long id);
    public Post saveOrUpdatePost(Post post);
    public void deletePost(Long id);
}
