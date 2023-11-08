package controller.impl;

import controller.AdminManagement;
import controller.ProductManagement;
import model.enums.ExceptionEnums;
import model.exception.ApplicationException;
import service.ProductService;
import service.impl.ProductServiceImpl;
import util.MenuUtil;

import static model.constant.Constant.SPACE;

public class ProductManagementImpl implements ProductManagement {

    @Override
    public void manage() {
        ProductService productService = new ProductServiceImpl();
        AdminManagement adminManagement = new AdminManagementImpl();
        while (true){
            try {
                byte option = MenuUtil.productMenu();
                switch (option){
                    case 0:
                        System.exit(-1);
                    case 1:
                        productService.saveProduct();
                        break;
                    case 2:
                        productService.showAllProduct();
                        break;
                    case 3:
                        productService.findById(SPACE,true);
                        break;
                    case 4:
                        productService.findByName();
                        break;
                    case 5:
                        productService.updateProductForAdmin();
                        break;
                    case 6:
                        productService.deleteProduct();
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
