package web.service;

import web.model.User;

import java.util.List;
import java.util.Optional;

//@Service
public interface UserService {
    public boolean createUser(User user);
    public List<User> readUsers();
    public User readUser(Long id);
    public User updateUser(long id);
    public boolean deleteUser(long id);


}
