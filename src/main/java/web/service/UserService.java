package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    public boolean createUser(User user);
    public List<User> readUser();
    public User updateUser(long id);
    public boolean deleteUser(long id);
}
