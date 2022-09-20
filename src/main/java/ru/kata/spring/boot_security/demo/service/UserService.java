package ru.kata.spring.boot_security.demo.service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.model.User;
import java.util.List;

public interface UserService {

    void addUser(User user);
    User getUserById(Long id);
    void updateUserById(User user);
    void deleteUserById(Long id);
    List<User> getAllUsers();
    User getUserByName(String name);

    @Transactional
    void createUser(User user);

    @Transactional(readOnly = true)
    User get(int id);

    @Transactional
    void update(User updatedUser);

    @Transactional
    void delete(int id);

    @Transactional
    User createUser();
}