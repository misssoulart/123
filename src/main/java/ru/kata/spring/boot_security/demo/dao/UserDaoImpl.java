package ru.kata.spring.boot_security.demo.dao;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.model.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public abstract class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;

    public UserDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("FROM User", User.class)
                .getResultList();
    }

    @Override
    public void createUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public org.apache.catalina.User get(int id) {
        return (org.apache.catalina.User) entityManager.find(User.class, id);
    }

    @Override
    public void update(User updatedUser) {
        entityManager.merge(updatedUser);
    }

    @Override
    public void delete(int id) {
        entityManager.remove(get(id));
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        return entityManager.createQuery("SELECT u FROM User u JOIN fetch u.roles where u.username = :name", User.class)
                .setMaxResults(1)
                .setParameter("name", username)
                .getSingleResult();
    }
}