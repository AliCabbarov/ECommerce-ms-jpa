package controller.impl;

import controller.LoginManagement;
import controller.Management;
import helper.LoginHelperService;
import model.enums.ExceptionEnums;
import model.exception.ApplicationException;
import util.MenuUtil;

public class ManagementImpl implements Management {
    @Override
    public void manage() {
        LoginManagement loginManagement = new LoginManagementImpl();

        while (true){
            try {
                byte option = MenuUtil.entryMenu();
                switch (option){
                    case 0:
                        System.exit(-1);
                    case 1:
                        LoginHelperService.adminLogin();
                        break;
                    case 2:
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
