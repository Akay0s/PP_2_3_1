package entry1.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import entry1.model.User;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public User findById(Long userId) {
        return entityManager.find(User.class, userId);
    }

    @Override
    public List<User> findAll() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public void update(Long id, User updateUser) {
        User user = entityManager.find(User.class, id); // по id определили, какой именно юзер был изменен и передан в аргумент
        user.setName(updateUser.getName()); //этому найденному юзеру устанавливаем значения того юзера, который пришел из формы
        user.setLastName(updateUser.getLastName());
        user.setAge(updateUser.getAge());
        entityManager.persist(user);
    }

    @Override
    public void delete(Long userId) {
        User user = findById(userId);
        if (user != null) {
            entityManager.remove(user);
        }
    }
}
