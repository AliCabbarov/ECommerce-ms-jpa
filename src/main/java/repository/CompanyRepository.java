package repository;

import model.entity.Company;

public interface CompanyRepository {

    Company findCompanyById(long id);
    void updateCompany(Company company);
}
