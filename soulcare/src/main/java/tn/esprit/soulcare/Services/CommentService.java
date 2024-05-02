package tn.esprit.soulcare.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.soulcare.entities.Comment;
import tn.esprit.soulcare.Repositories.PostRepository;
import tn.esprit.soulcare.Repositories.CommentRepository;
import tn.esprit.soulcare.entities.Post;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    public Comment getCommentById(Long id) {
        Optional<Comment> comment = commentRepository.findById(id);
        return comment.orElse(null);
    }

    public Comment addComment(Long postId, String content) {
        Optional<Post> postOptional = postRepository.findById(postId);
        if (postOptional.isPresent()) {
            Post post = postOptional.get();
            Comment comment = new Comment();
            comment.setContent(content);
            comment.setDate(LocalDateTime.now());
            comment.setPost(post);
            return commentRepository.save(comment);
        }
        return null; // Handle case where post with given ID is not found
    }

    public Comment updateComment(Long id, String content) {
        Optional<Comment> commentOptional = commentRepository.findById(id);
        if (commentOptional.isPresent()) {
            Comment comment = commentOptional.get();
            comment.setContent(content);
            comment.setDate(LocalDateTime.now());
            return commentRepository.save(comment);
        }
        return null; // Handle case where comment with given ID is not found
    }

    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }
}
