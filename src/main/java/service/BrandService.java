package service;

import model.entity.Brand;

public interface BrandService {
    void findAll();
    Brand findById();
    void saveBrand();
    void findByName();
    void updateBrand();
    void deleteBrand();
}
