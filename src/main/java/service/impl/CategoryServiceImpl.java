package service.impl;

import helper.ServiceHelper;
import model.entity.Category;
import model.enums.ExceptionEnums;
import model.exception.ApplicationException;
import repository.CategoryRepository;
import repository.impl.CategoryRepositoryImpl;
import service.CategoryService;
import util.InputUtil;

import java.util.Optional;

import static model.constant.Constant.*;

public class CategoryServiceImpl implements CategoryService {
    CategoryRepository categoryRepository = new CategoryRepositoryImpl();

    @Override
    public void saveCategory() {
        Category category = ServiceHelper.fillCategory();
        categoryRepository.saveCategory(category);
        System.out.println(SAVED_SUCCESSFULLY);
    }

    @Override
    public void showAllCategory() {
        categoryRepository.findAll().forEach(System.out::println);
    }

    @Override
    public Category findById() { // FIXME : sout olunub olunmayacagini bildir.
        long id = InputUtil.getInstance().inputLong("Enter the category id: ");
        return  categoryRepository.findById(id).orElseThrow(()->new ApplicationException(ExceptionEnums.CATEGORY_NOT_FOUND));
    }

    @Override
    public void findByName() {
        String name = InputUtil.getInstance().inputString("Enter the find name: ");
        categoryRepository.findByName(name);
    }

    @Override
    public void updateCategory() {
        showAllCategory();
        long id = InputUtil.getInstance().inputLong("Enter the id for update :");
        Category category = categoryRepository.findById(id).orElseThrow(()->new ApplicationException(ExceptionEnums.CATEGORY_NOT_FOUND));
        String description = InputUtil.getInstance().inputString("Enter the new description: ");
        category.setDescription(description);

        categoryRepository.updateCategory(category);
        System.out.println(UPDATE_SUCCESSFULLY);

    }

    @Override
    public void deleteCategory() {
        showAllCategory();
        long id = InputUtil.getInstance().inputLong("Enter the id for delete :");
        Category category = categoryRepository.findById(id).orElseThrow(()->new ApplicationException(ExceptionEnums.CATEGORY_NOT_FOUND));

        category.setStatus(false);
        categoryRepository.updateCategory(category);
        System.out.println(DELETE_SUCCESSFULLY);

    }
}
