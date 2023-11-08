package repository;

import model.entity.Cart;
import model.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository {
    void saveCategory(Category category);
    List<Category> findAll();
    Optional<Category> findById(long id);
    Optional<Category> findByName(String name);
    void updateCategory(Category category);
}
