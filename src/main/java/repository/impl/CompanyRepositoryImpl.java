package repository.impl;

import model.config.RepositoryConfig;
import model.entity.Company;
import model.enums.ExceptionEnums;
import model.exception.ApplicationException;
import repository.CompanyRepository;

public class CompanyRepositoryImpl extends RepositoryConfig implements CompanyRepository {
    @Override
    public Company findCompanyById(long id) {
        return getEntityManager().find(Company.class,id);
    }

    @Override
    public void updateCompany(Company company) {
        try {
            getEntityTransaction().begin();
            getEntityManager().merge(company);
            getEntityTransaction().commit();
        }catch (Exception e){
            getEntityTransaction().rollback();
            throw new ApplicationException(ExceptionEnums.COULD_NOT_BE_UPDATED_EXCEPTION);
        }
    }
}
