package repository;

import model.entity.User;

import java.util.List;

public interface UserRepository {
    void saveUser(User user);
    List<User> findAll();
    void updateUser(User user);
}
