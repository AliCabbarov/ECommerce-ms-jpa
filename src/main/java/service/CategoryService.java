package service;

import model.entity.Category;

public interface CategoryService {
    void saveCategory();
    void showAllCategory();
    Category findById();
    void findByName();
    void updateCategory();
    void deleteCategory();

}
