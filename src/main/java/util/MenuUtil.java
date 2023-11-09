package util;

public class MenuUtil {
    public static byte adminMenu(){
        System.out.println("[0] - > Exit \n" +
                "[1] - > Category \n" +
                "[2] - > Brand\n" +
                "[3] - > Product\n" +
                "[4] - > Order\n" +
                "[5] - > Back");

        return InputUtil.getInstance().inputByte("choose option: ");

    }
    public static byte entryMenu(){
        System.out.println("[0] - > Exit \n" +
                "[1] - > Admin \n" +
                "[2] - > Customer\n");

        return InputUtil.getInstance().inputByte("choose option: ");

    }

    public static byte categoryMenu(){
        System.out.println("[0] - > Exit \n" +
                "[1] - > Save category \n" +
                "[2] - > Show all category\n" +
                "[3] - > Find by id \n" +
                "[4] - > Find by name\n" +
                "[5] - > update category \n" +
                "[6] - > delete category (status = 0 or false)\n" +
                "[7] - > back\n");

        return InputUtil.getInstance().inputByte("choose option: ");

    }
    public static byte productMenu(){
        System.out.println("[0] - > Exit \n" +
                "[1] - > Save product \n" +
                "[2] - > Show all product\n" +
                "[3] - > Find by id \n" +
                "[4] - > Find by name\n" +
                "[5] - > Update product \n" +
                "[6] -> delete product (status = 0 or false)\n" +
                "[7] -> back\n");

        return InputUtil.getInstance().inputByte("choose option: ");

    }
    public static byte brandMenu(){
        System.out.println("[0] - > Exit \n" +
                "[1] - > Save brand \n" +
                "[2] - > Show all brand\n" +
                "[3] - > Find by id \n" +
                "[4] - > Find by name\n" +
                "[5] - > Update brand \n" +
                "[6] - > delete brand (status = 0 or false) \n" +
                "[7] - > back\n");

        return InputUtil.getInstance().inputByte("choose option: ");
    }
    public static byte userMenu(){
        System.out.println("[0] - > Exit \n" +
                "[1] - > Show all product \n" +
                "[2] - > add product to cart\n" +
                "[3] - > delete product to cart\n" +
                "[4] - > buy product in cart\n" +
                "[5] - > increase balance \n" +
                "[6] - > back\n");
        return InputUtil.getInstance().inputByte("choose option: ");

    }

    public static byte orderMenu() {
        System.out.println("[0] - > Exit \n" +
                "[1] - > Show all Order \n" +
                "[2] - > Back");
        return InputUtil.getInstance().inputByte("choose option: ");

    }

    public static byte loginMenu() {
        System.out.println("[0] - > Exit \n" +
                "[1] - > login \n" +
                "[2] - > sign in\n" +
                "[3] - > back");
        return InputUtil.getInstance().inputByte("choose option: ");
    }
}
