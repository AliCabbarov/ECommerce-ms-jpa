package repository;

import model.entity.Brand;
import model.entity.Category;

import java.util.List;
import java.util.Optional;

public interface BrandRepository {
    void saveBrand(Brand brand);
    List<Brand> findAll();
    Optional<Brand> findById(long id);
    Optional<Brand> findByName(String name);
    void updateBrand(Brand brand);
}
