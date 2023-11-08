package controller.impl;

import controller.*;
import model.enums.ExceptionEnums;
import model.exception.ApplicationException;
import util.MenuUtil;

public class AdminManagementImpl implements AdminManagement {


    @Override
    public void manage() {
        BrandManagement brandManagement = new BrandManagementImpl();
        CategoryManagement categoryManagement = new CategoryManagementImpl();
        ProductManagement productManagement = new ProductManagementImpl();
        OrderManagement orderManagement = new OrderManagementImpl();
        Management management = new ManagementImpl();
        while (true){
            try {
                byte option = MenuUtil.adminMenu();
                switch (option){
                    case 0:
                        System.exit(-1);
                    case 1:
                        categoryManagement.manage();
                        break;
                    case 2:
                        brandManagement.manage();
                        break;
                    case 3:
                        productManagement.manage();
                        break;
                    case 4:
                        orderManagement.manage();
                        break;
                    case 5:
                        management.manage();
                        break;
                    default:throw new ApplicationException(ExceptionEnums.INVALID_OPTION_EXCEPTION);
                }
            }catch (RuntimeException e){
                e.printStackTrace();
            }
        }
    }
}
