package africa.semicolon.BlogApplication.data.repository;


import africa.semicolon.BlogApplication.data.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepositoryImpl implements UserRepository {

private List<User> users = new ArrayList<>();
 private static int count = 0;
    @Override
    public User save(User user) {
        user.setId(count++ + "");
        users.add(user);
        return user;
    }
    private User findUserByEmail(String email) {
        for(User user: users){
            if(user.getEmail().equals(email));
            return user;
        }

        return  null;
    }


    @Override
    public void deleteById(String id) throws Exception {
         Optional<User> optionalUser = users.stream().filter(user -> user.getId().equals(id)).findFirst();
         User user = optionalUser.orElseThrow(()-> new Exception("user id does not exist"));
         users.remove(user);

//        for (User _user: users) {
//            if (_user.getId().equals(id)){
//                users.remove(_user);
//                break;
//            }
//        }

    }

    @Override
    public User findUserById(User id) {
        return null;
    }




    @Override

    public List<User> findAll() {

        return users;
    }
}
