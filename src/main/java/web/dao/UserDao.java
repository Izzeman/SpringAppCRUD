package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    public void createUser(User user);
    public List<User> readUsers();
    public User readUser(Long id);
    public void updateUser(User user);
    public void deleteUser(Long id);
}
