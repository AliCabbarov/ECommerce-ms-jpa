package repository.impl;

import jakarta.persistence.TypedQuery;
import model.config.RepositoryConfig;
import model.entity.Category;
import model.enums.ExceptionEnums;
import model.exception.ApplicationException;
import repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

public class CategoryRepositoryImpl extends RepositoryConfig implements CategoryRepository {
    @Override
    public void saveCategory(Category category) {
        try {
            getEntityTransaction().begin();
            getEntityManager().persist(category);
            getEntityTransaction().commit();
        } catch (Exception e) {
            getEntityTransaction().rollback();
            throw new ApplicationException(ExceptionEnums.COULD_NOT_BE_SAVED_EXCEPTION);
        }
    }

    @Override
    public List<Category> findAll() {
        TypedQuery<Category> typedQuery = getEntityManager().createQuery("select c from _category c where status = true ", Category.class);
        return typedQuery.getResultList();
    }

    @Override
    public Optional<Category> findById(long id) {
        return Optional.ofNullable(getEntityManager().find(Category.class, id));
    }

    @Override
    public Optional<Category> findByName(String name) {
        TypedQuery<Category> typedQuery = getEntityManager().createQuery("select c from _category c where status = true and name =: name ", Category.class);
        typedQuery.setParameter("name", name);

        return Optional.ofNullable(typedQuery.getSingleResult());
    }

    @Override
    public void updateCategory(Category category) {
        try {
            getEntityTransaction().begin();
            getEntityManager().merge(category);
            getEntityTransaction().commit();
        } catch (Exception e) {
            getEntityTransaction().rollback();
            throw new ApplicationException(ExceptionEnums.COULD_NOT_BE_SAVED_EXCEPTION);
        }
    }
}
