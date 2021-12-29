package africa.semicolon.BlogApplication.data.repository;

import africa.semicolon.BlogApplication.data.model.Gender;
import africa.semicolon.BlogApplication.data.model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryImplTest {
    UserRepository repository;

    @BeforeEach
    void setUp() {
        repository = new UserRepositoryImpl();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void save() {
        User user = new User();
        user.setEmail("ajayi@Wemabank.com");
        user.setGender(Gender.MALE);
        user.setPassword("fash");
        user.setId("001");
        repository.save(user);
        repository.save(user);
        repository.save(user);
        assertEquals(3, repository.findAll().size());

    }

    @Test
    void deleteById() throws Exception {
        User user = new User();
        user.setEmail("ajayi@Wemabank.com");
        user.setGender(Gender.MALE);
        user.setPassword("fash");
        user.setId("001");
        repository.save(user);
        repository.save(user);
        repository.save(user);
        repository.deleteById(user.getId());
        assertEquals(2,repository.findAll().size());
    }

    @Test
    void findUserById() {
    }

    @Test
    void findAll() {
    }
}