package repository;

import model.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    void saveProduct(Product product);
    List<Product> findAllProducts();
    Optional<Product> findById(long id);
    void updateProduct(Product product);
    List<Product> findByName(String name);
}
