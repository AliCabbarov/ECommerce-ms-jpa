package service;

import model.entity.Company;

import java.math.BigDecimal;

public interface CompanyService {
    Company findCompany();
    void updateAccountCompany(BigDecimal price);
}
