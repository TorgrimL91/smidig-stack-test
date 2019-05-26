package no.smidig.test.testrepo.repositories;


import no.smidig.test.testrepo.entity.PostEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends CrudRepository<PostEntity, Long> {

    PostEntity findByPostContent(String postContent);

    Iterable<PostEntity> findAll();
}
