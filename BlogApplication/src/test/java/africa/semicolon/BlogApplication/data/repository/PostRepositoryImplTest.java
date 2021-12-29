package africa.semicolon.BlogApplication.data.repository;

import africa.semicolon.BlogApplication.data.model.Post;
import africa.semicolon.BlogApplication.data.model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostRepositoryImplTest {

    PostRepository repository;
    @BeforeEach
    void setUp() {
       repository = new PostRepositoryImpl();
       User user = new User();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void save() {
        Post post = new Post();
        post.setText("ABC");
        post.setOwner(User.builder().build());
        repository.save(post);
        assertEquals("ABC",post.getText());
        assertEquals(1,repository.findAll().size());
    }

    @Test
    void deleteById() {
        Post post = new Post();
        post.setText("ABC");
        post.setOwner(User.builder().build());
        repository.save(post);
        repository.save(post);
        assertEquals(2, repository.findAll().size());
    }

    @Test
    void findPostById() {
        Post post = new Post();
        post.setId("123456");
        assertEquals("123456", post.getId());
    }

    @Test
    void findAll() {
        Post post = new Post();
        post.setText("ABC");
        post.setOwner(User.builder().build());
        repository.save(post);
        repository.save(post);
        repository.save(post);
        repository.save(post);
        repository.save(post);
        assertEquals(5,repository.findAll().size());
    }
}