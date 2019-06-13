package no.smidig.test.testrepo.service;


import no.smidig.test.testrepo.entity.Comment;
import no.smidig.test.testrepo.entity.PostEntity;
import no.smidig.test.testrepo.repositories.CommentRepository;
import no.smidig.test.testrepo.repositories.PostRepository;
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

    @PersistenceContext
    EntityManager entityManager;


    public Comment addComment(String comments, Comment comment){
        PostEntity post = postRepository.findByid(comments);
        comment.setPost(post);
        return  commentRepository.save(comment);
    }

    public Comment saveOrUpdateComment(Comment comment){
        entityManager.refresh(comment);
        comment.setId(comment.getId());

        return commentRepository.save(comment);
    }

    public Comment findCommentByIdentifier(Long id){
        Comment comment = commentRepository.getById(id);
        return comment;
    }

    public Iterable<Comment> findAllComment(){
        return commentRepository.findAll();
    }


    public void deleteCommentByCommentIdentifier(Long id){
        Comment comment1 = commentRepository.getById(id);

        commentRepository.deleteById(comment.getId());
    }

}
