package ru.kata.spring.boot_security.demo.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.dao.RoleDao;
import ru.kata.spring.boot_security.demo.dao.UserDao;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private UserDao userDao;
    private final RoleDao roleDao;

    public UserServiceImpl(UserDao userDao, RoleDao roleDao) {
        this.userDao = userDao;
        this.roleDao = roleDao;
    }

    @Override
    public void addUser(User user) {

    }

    @Override
    public User getUserById(Long id) {
        return null;
    }

    @Override
    public void deleteUserById(Long id) {

    }

    @Override
    public void updateUserById(User user) {

    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public User getUserByName(String name) {
        return null;
    }

    @Override
    @Transactional
    public void createUser(User user) {
        user.setRoles(roleDao.getRolesByName(user.getRoles()));
        userDao.createUser(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User get(int id) {
        return (User) userDao.get(id);
    }

    @Override
    @Transactional
    public void update(User updatedUser) {
        updatedUser.setRoles(roleDao.getRolesByName(updatedUser.getRoles()));
        userDao.update(updatedUser);
    }

    @Override
    @Transactional
    public void delete(int id) {
        userDao.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userDao.loadUserByUsername(username);
    }

    @Override
    @Transactional
    public User createUser() {
        User user = new User();
        Role roleUser = roleDao.getRoleByName("ROLE_USER");
        user.addRole(roleUser);
        return user;
    }

}