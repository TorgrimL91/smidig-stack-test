package no.smidig.test.testrepo.repositories;

import no.smidig.test.testrepo.entity.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Long> {
    Comment getById(String username);

    Iterable<Comment> findAll();
}
