package controller.impl;

import controller.AdminManagement;
import controller.OrderManagement;
import model.enums.ExceptionEnums;
import model.exception.ApplicationException;
import service.OrderService;
import service.impl.OrderServiceImpl;
import util.MenuUtil;

public class OrderManagementImpl implements OrderManagement {


    @Override
    public void manage() {
        AdminManagement adminManagement = new AdminManagementImpl();
        OrderService orderService = new OrderServiceImpl();
        while (true) {
            try {
                byte option = MenuUtil.orderMenu();
                switch (option) {
                    case 0:
                        System.exit(-1);
                    case 1:
                        orderService.findAll();
                        break;
                    case 2:
                        adminManagement.manage();
                        break;
                    default:
                        throw new ApplicationException(ExceptionEnums.INVALID_OPTION_EXCEPTION);
                }
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
        }
    }
}
