package service.impl;

import model.entity.Company;
import repository.CompanyRepository;
import repository.impl.CompanyRepositoryImpl;
import service.CompanyService;

import java.math.BigDecimal;

public class CompanyServiceImpl implements CompanyService {
    CompanyRepository companyRepository = new CompanyRepositoryImpl();
    @Override
    public Company findCompany() {
        return companyRepository.findCompanyById(1);
    }

    @Override
    public void updateAccountCompany(BigDecimal price) {

        Company company = findCompany();
        BigDecimal newPrice = company.getTotalAmount().add(price);
        company.setTotalAmount(newPrice);
        companyRepository.updateCompany(company);

    }
}
