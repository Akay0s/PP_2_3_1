package entry1.service;

import entry1.model.User;

import java.util.List;

public interface UserService {
    void save(User user);

    User findById(Long userId);

    List<User> findAll();

    void update(Long id, User updateUser);

    void delete(Long userId);
}
