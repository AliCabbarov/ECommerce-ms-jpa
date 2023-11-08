package helper;

import controller.AdminManagement;
import controller.UserManagement;
import controller.impl.AdminManagementImpl;
import controller.impl.UserManagementImpl;
import model.constant.Constant;
import model.entity.User;
import model.enums.ExceptionEnums;
import model.exception.ApplicationException;
import service.UserService;
import service.impl.UserServiceImpl;
import util.InputUtil;

import java.util.List;

public class LoginHelperService {
    static UserService userService = new UserServiceImpl();
    static UserManagement userManagement = new UserManagementImpl();
    static AdminManagement adminManagement = new AdminManagementImpl();



    public static void login() {
        System.out.println("-------------| Welcome to Login Menu |--------------");
        String email = InputUtil.getInstance().inputString("Enter the email: ");
        String password = InputUtil.getInstance().inputString("Enter the password: ");

        List<User> users = userService.findAll();

        User hasUser = users.stream()
                .filter(user -> user.getEmail().equals(email))
                .filter(user -> user.getPassword().equals(password))
                .findFirst().orElseThrow(() -> new ApplicationException(ExceptionEnums.USER_NOT_FOUND));

        userManagement.manage(hasUser);

    }

    public static void signIn() {
        System.out.println("-------------| Welcome to Sign Up Menu |--------------");
        User user = ServiceHelper.fillUser();

        userService.createUser(user);
        userManagement.manage(user);
    }

    public static void adminLogin() {
        String username = InputUtil.getInstance().inputString("Enter the username: ");
        String password = InputUtil.getInstance().inputString("Enter the password: ");
        if(username.equals(Constant.ADMIN_USERNAME) && password.equals(Constant.ADMIN_PASSWORD)){
            adminManagement.manage();
        }else {
            throw new ApplicationException(ExceptionEnums.WRONG_USERNAME_OR_PASSWORD_EXCEPTION);
        }
    }
}
