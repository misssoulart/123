package ru.kata.spring.boot_security.demo.service;
import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.dao.RoleDao;
import ru.kata.spring.boot_security.demo.model.Role;
import java.util.Set;

@Service
public abstract class RoleServiceImpl implements RoleService {

    private final RoleDao roleDao;
    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public Set<Role> getAllRoles() {
        return roleDao.getAllRoles();
    }

    @Override
    public Role getRoleByName(String name) {
        return roleDao.getRoleByName(name);
    }

    @Override
    public Set<Role> getRolesByName(Set<Role> roles) {
        return roleDao.getRolesByName(roles);
    }

    @Override
    public void addRole(Role role) {
        roleDao.addRole(role);
    }
}