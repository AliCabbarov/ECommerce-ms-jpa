package helper;

import model.entity.*;
import model.enums.ExceptionEnums;
import model.exception.ApplicationException;
import service.BrandService;
import service.CategoryService;
import service.impl.BrandServiceImpl;
import service.impl.CategoryServiceImpl;
import util.InputUtil;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

public class ServiceHelper {
    static BrandService brandService = new BrandServiceImpl();
    static CategoryService categoryService = new CategoryServiceImpl();

    public static Product fillProduct() {
        brandService.findAll();

        Brand brand = brandService.findById();

        categoryService.showAllCategory();

        Category category = categoryService.findById();

        String name = InputUtil.getInstance().inputString("Enter the name: ");
        String description = InputUtil.getInstance().inputString("Enter the description: ");
        BigDecimal amount = BigDecimal.valueOf(Double.parseDouble(InputUtil.getInstance().inputString("Enter the amount: ")));
        int remainCount = InputUtil.getInstance().inputInt("Enter the product stock count: ");
        String color = InputUtil.getInstance().inputString("Enter the color: ");
        String weight = InputUtil.getInstance().inputString("Enter the weight: ");

        Product product = Product.builder()
                .name(name)
                .description(description)
                .amount(amount)
                .brand(brand)
                .category(category)
                .comment(new ArrayList<>())
                .remainCount(remainCount)
                .productDetails(ProductDetails.builder()
                        .color(color)
                        .weight(weight)
                        .build())
                .build();

        return product;


    }

    public static Product updateProduct(Product product) {
        String description = InputUtil.getInstance().inputString("enter the new description: ");
        BigDecimal amount = BigDecimal.valueOf(Double.parseDouble(InputUtil.getInstance().inputString("Enter the new amount: ")));
        int remainCount = InputUtil.getInstance().inputInt("Enter the product new  stock count: ");
        product.setDescription(description);
        product.setAmount(amount);
        product.setRemainCount(remainCount);
        return product;
    }

    public static Category fillCategory() {
        String name = InputUtil.getInstance().inputString("Enter the category name: ");
        String description = InputUtil.getInstance().inputString("Enter the description: ");

        Category category = Category.builder()
                .name(name)
                .description(description)
                .build();
        return category;
    }

    public static Brand fillBrand() {
        String name = InputUtil.getInstance().inputString("Enter the bran name: ");
        String description = InputUtil.getInstance().inputString("Enter the description: ");
        categoryService.showAllCategory();


        Brand brand = Brand.builder()
                .name(name)
                .description(description)
                .build();
        return brand;

    }


    public static User fillUser() {
        String name = InputUtil.getInstance().inputString("Enter the name: ");
        String surname = InputUtil.getInstance().inputString("Enter the surname: ");
        LocalDate birthdate = LocalDate.parse(InputUtil.getInstance().inputString("Enter the birthdate: "));
        String fin = InputUtil.getInstance().inputString("Enter the fin: ");
        String address = InputUtil.getInstance().inputString("address: ");
        String email = InputUtil.getInstance().inputString("Enter the email: ");
        String password = InputUtil.getInstance().inputString("Enter the password: ");
        String phoneNumber = InputUtil.getInstance().inputString("Enter the phone number: ");

        User user = User.builder()
                .name(name)
                .surname(surname)
                .account(BigDecimal.valueOf(5000))
                .address(address)
                .email(email)
                .phoneNumber(phoneNumber)
                .password(password)
                .fin(fin)
                .birthdate(birthdate)
                .cart(Cart.builder().products(new ArrayList<>()).build())
                .build();

        return user;



    }

    public static void checkUserAccount(User user, BigDecimal totalAmount) {
        if (user.getAccount().doubleValue() < totalAmount.doubleValue()){
            throw new ApplicationException(ExceptionEnums.LOW_MONEY_EXCEPTION);
        }
    }
}
