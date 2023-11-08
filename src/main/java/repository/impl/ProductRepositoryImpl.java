package repository.impl;

import jakarta.persistence.TypedQuery;
import model.config.RepositoryConfig;
import model.entity.Product;
import model.enums.ExceptionEnums;
import model.exception.ApplicationException;
import repository.ProductRepository;

import java.util.List;
import java.util.Optional;

public class ProductRepositoryImpl extends RepositoryConfig implements ProductRepository {
    @Override
    public void saveProduct(Product product) {
        try {
            getEntityTransaction().begin();
            getEntityManager().persist(product);
            getEntityTransaction().commit();
        }catch (Exception e){
            getEntityTransaction().rollback();
            throw new ApplicationException(ExceptionEnums.COULD_NOT_BE_SAVED_EXCEPTION);
        }
    }

    @Override
    public List<Product> findAllProducts() {
        TypedQuery<Product> productTypedQuery = getEntityManager().createQuery("select p from _product p where status = true and remainCount > 0 ", Product.class);
        return productTypedQuery.getResultList();
    }

    @Override
    public Optional<Product> findById(long id) {
        return Optional.ofNullable(getEntityManager().find(Product.class,id));
    }

    @Override
    public void updateProduct(Product product) {
        try {
            getEntityTransaction().begin();
            getEntityManager().merge(product);
            getEntityTransaction().commit();
        }catch (Exception e){
            getEntityTransaction().rollback();
            throw new ApplicationException(ExceptionEnums.COULD_NOT_BE_UPDATED_EXCEPTION);
        }
    }

    @Override
    public List<Product> findByName(String name) {
        TypedQuery<Product> typedQuery = getEntityManager().createQuery("select p from _product p where name =:name and status = true ", Product.class);
        typedQuery.setParameter("name",name);
        return typedQuery.getResultList();
    }
}
