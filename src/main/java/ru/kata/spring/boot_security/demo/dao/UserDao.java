package ru.kata.spring.boot_security.demo.dao;
import org.apache.catalina.User;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.List;

public interface UserDao {
    List<ru.kata.spring.boot_security.demo.model.User> getAllUsers();

    void createUser(User user);

    void createUser(ru.kata.spring.boot_security.demo.model.User user);

    User get(int id);

    void update(User updatedUser);

    void update(ru.kata.spring.boot_security.demo.model.User updatedUser);

    void delete(int id);

    UserDetails loadUserByUsername(String username);

}
