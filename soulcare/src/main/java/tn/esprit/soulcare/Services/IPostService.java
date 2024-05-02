package tn.esprit.soulcare.Services;

import tn.esprit.soulcare.entities.Post;

import java.util.List;

public interface IPostService {
    public List<Post> getAllPosts();
    public Post getPostById(Long id);
    public Post saveOrUpdatePost(Post post);
    public void deletePost(Long id);
}
