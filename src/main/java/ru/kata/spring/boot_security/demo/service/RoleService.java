package ru.kata.spring.boot_security.demo.service;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.Set;

public interface RoleService {

    Set<Role> getAllRoles();
    Role getRoleByName(String name);
    Set<Role> getRolesByName(Set<Role> roles);
    void addRole(Role role);
    Object getAllUsers();
    Object createUser();
    void createUser(User user);
    Object get(int id);
    Object loadUserByUsername(String name);
    void update(User user);
    void delete(int id);
}