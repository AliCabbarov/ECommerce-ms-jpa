package repository.impl;

import jakarta.persistence.TypedQuery;
import model.config.RepositoryConfig;
import model.entity.User;
import model.enums.ExceptionEnums;
import model.exception.ApplicationException;
import repository.UserRepository;

import java.util.List;

public class UserRepositoryImpl extends RepositoryConfig implements UserRepository {
    @Override
    public void saveUser(User user) {
        try {
           getEntityTransaction().begin();
           getEntityManager().persist(user);
           getEntityTransaction().commit();
        }catch (Exception e){
            getEntityTransaction().rollback();
            throw new ApplicationException(ExceptionEnums.COULD_NOT_BE_SAVED_EXCEPTION);
        }
    }

    @Override
    public List<User> findAll() {
        TypedQuery<User> typedQuery = getEntityManager().createQuery("select u from _user u", User.class);
        return typedQuery.getResultList();
    }

    @Override
    public void updateUser(User user) {
        try {
            getEntityTransaction().begin();
            getEntityManager().merge(user);
            getEntityTransaction().commit();
        }catch (Exception e){
            getEntityTransaction().rollback();
        }
    }
}
