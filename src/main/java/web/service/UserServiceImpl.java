package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.model.User;
import web.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl() {

    }

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public boolean createUser(User user) {
        try {
            userRepository.save(user);
            return true;
        }catch(Exception ex) {
            return false;
        }
    }

    @Override
    public List<User> readUser() {
        List list = new ArrayList();
        userRepository.findAll().forEach(e -> list.add(e));
        return list;
    }

    @Override
    public User updateUser(long id) {
        User user = userRepository.findById(id).get();
        return user;
    }

    @Override
    public boolean deleteUser(long id) {
        try {
            userRepository.deleteById(id);
            return true;
        }catch(Exception ex) {
            return false;
    }
    }
}




