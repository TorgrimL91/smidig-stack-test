package no.smidig.test.testrepo.repositories;


import no.smidig.test.testrepo.entity.PostEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostRepository extends CrudRepository<PostEntity, Long> {

    PostEntity findByid(String username);

    Optional<PostEntity> findById(Long id);

    Iterable<PostEntity> findAll();
}
