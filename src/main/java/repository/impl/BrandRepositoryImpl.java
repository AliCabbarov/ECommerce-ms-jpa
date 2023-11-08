package repository.impl;

import jakarta.persistence.TypedQuery;
import model.config.RepositoryConfig;
import model.entity.Brand;
import model.enums.ExceptionEnums;
import model.exception.ApplicationException;
import repository.BrandRepository;

import java.util.List;
import java.util.Optional;

public class BrandRepositoryImpl extends RepositoryConfig implements BrandRepository {
    @Override
    public void saveBrand(Brand brand) {
        try {
            getEntityTransaction().begin();
            getEntityManager().persist(brand);
            getEntityTransaction().commit();
        } catch (Exception e) {
            getEntityTransaction().rollback();
            throw new ApplicationException(ExceptionEnums.COULD_NOT_BE_SAVED_EXCEPTION);
        }
    }

    @Override
    public List<Brand> findAll() {
        TypedQuery<Brand> brandTypedQuery = getEntityManager().createQuery("select  b from _brand b where status = true ", Brand.class);
        return brandTypedQuery.getResultList();
    }

    @Override
    public Optional<Brand> findById(long id) {
        return Optional.ofNullable(getEntityManager().find(Brand.class, id));
    }

    @Override
    public Optional<Brand> findByName(String name) {
        TypedQuery<Brand> brandTypedQuery = getEntityManager().createQuery("select  b from _brand b where status = true and  name =: name", Brand.class);
        brandTypedQuery.setParameter("name", name);
        return Optional.ofNullable(brandTypedQuery.getSingleResult());
    }

    @Override
    public void updateBrand(Brand brand) {
        try {
            getEntityTransaction().begin();
            getEntityManager().merge(brand);
            getEntityTransaction().commit();
        } catch (Exception e) {
            getEntityTransaction().rollback();
            throw new ApplicationException(ExceptionEnums.COULD_NOT_BE_UPDATED_EXCEPTION);
        }
    }
}
