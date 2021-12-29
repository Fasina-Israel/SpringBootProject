package africa.semicolon.BlogApplication.data.repository;

import africa.semicolon.BlogApplication.data.model.User;

import java.util.List;

public interface UserRepository  {


    User save(User user);

    void deleteById(String id) throws Exception;

    User findUserById(User id);

    List<User> findAll();
}
