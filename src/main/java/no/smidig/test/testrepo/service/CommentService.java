package no.smidig.test.testrepo.service;


import no.smidig.test.testrepo.entity.Comment;
import no.smidig.test.testrepo.entity.PostEntity;
import no.smidig.test.testrepo.entity.User;
import no.smidig.test.testrepo.repositories.CommentRepository;
import no.smidig.test.testrepo.repositories.PostRepository;
import no.smidig.test.testrepo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class CommentService {

    private Comment comment;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @PersistenceContext
    EntityManager entityManager;


    public Comment addComment(String username, Comment comment){
        User user = userRepository.findByUserName(username);
        comment.setUser(user);
        return  commentRepository.save(comment);
    }

    public Comment saveOrUpdateComment(Comment comment){
        entityManager.refresh(comment);
        comment.setId(comment.getId());

        return commentRepository.save(comment);
    }

    public Comment findCommentByIdentifier(String username){
        Comment comment = commentRepository.getById(username);
        return comment;
    }

    public Iterable<Comment> findAllComment(){
        return commentRepository.findAll();
    }


    public void deleteCommentByCommentIdentifier(String username){
        Comment comment1 = commentRepository.getById(username);

        commentRepository.deleteById(comment.getId());
    }

}
