package controller.impl;

import controller.UserManagement;
import model.entity.User;
import model.enums.ExceptionEnums;
import model.exception.ApplicationException;
import service.UserService;
import service.impl.UserServiceImpl;
import util.MenuUtil;

public class UserManagementImpl implements UserManagement {

    @Override
    public void manage(User user) {
        LoginManagementImpl loginManagement = new LoginManagementImpl();
        UserService userService = new UserServiceImpl();
        while (true){
            try {
                byte option = MenuUtil.userMenu();
                switch (option){
                    case 0:
                        System.exit(-1);
                    case 1:
                        userService.showAllProduct();
                        break;
                    case 2:
                        userService.addProductToCart(user);
                        break;
                    case 3:
                        userService.deleteProductToCart(user);
                        break;
                    case 4:
                        userService.buyProductToCart(user);
                        break;
                    case 5:
                        userService.increaseBalance(user);
                        break;
                    case 6:
                        loginManagement.manage();
                        break;
                    default:throw new ApplicationException(ExceptionEnums.INVALID_OPTION_EXCEPTION);
                }
            }catch (RuntimeException e){
                e.printStackTrace();
            }
        }
    }
}
