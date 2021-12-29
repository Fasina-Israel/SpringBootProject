package africa.semicolon.BlogApplication.data.repository;

import africa.semicolon.BlogApplication.data.model.Post;
import lombok.Data;
import org.apache.catalina.LifecycleState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository


public interface PostRepository {
    Post save(Post post);
    void deleteById(Long along);
    Post findPostById(Post entity);
    List<Post> findAll();
}
