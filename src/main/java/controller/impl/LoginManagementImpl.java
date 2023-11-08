package controller.impl;

import controller.AdminManagement;
import controller.LoginManagement;
import helper.LoginHelperService;
import model.enums.ExceptionEnums;
import model.exception.ApplicationException;
import util.MenuUtil;

public class LoginManagementImpl implements LoginManagement {
    @Override
    public void manage() {
        AdminManagement adminManagement = new AdminManagementImpl();

        while (true){
            try {
                byte option = MenuUtil.loginMenu();
                switch (option){
                    case 0:
                        System.exit(-1);
                    case 1:
                        LoginHelperService.login();
                        break;
                    case 2:
                        LoginHelperService.signIn();
                        break;
                    case 3:
                        adminManagement.manage();
                    default:throw new ApplicationException(ExceptionEnums.INVALID_OPTION_EXCEPTION);

                }
            }catch (RuntimeException e){
                e.printStackTrace();
            }
        }
    }
}
