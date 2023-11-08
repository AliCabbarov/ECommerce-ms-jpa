package controller.impl;

import controller.AdminManagement;
import controller.CategoryManagement;
import model.enums.ExceptionEnums;
import model.exception.ApplicationException;
import service.CategoryService;
import service.impl.CategoryServiceImpl;
import util.MenuUtil;

public class CategoryManagementImpl implements CategoryManagement {

    @Override
    public void manage() {
        CategoryService categoryService = new CategoryServiceImpl();
        AdminManagement adminManagement = new AdminManagementImpl();
        while (true){
            try {
                byte option = MenuUtil.categoryMenu();
                switch (option){
                    case 0:
                        System.exit(-1);
                    case 1:
                        categoryService.saveCategory();
                        break;
                    case 2:
                        categoryService.showAllCategory();
                        break;
                    case 3:
                        categoryService.findById();
                        break;
                    case 4:
                        categoryService.findByName();
                        break;
                    case 5:
                        categoryService.updateCategory();
                        break;
                    case 6:
                        categoryService.deleteCategory();
                        break;
                    case 7:
                        adminManagement.manage();
                        break;
                    default:throw new ApplicationException(ExceptionEnums.INVALID_OPTION_EXCEPTION);
                }
            }catch (RuntimeException e){
                e.printStackTrace();
            }
        }
    }
}
