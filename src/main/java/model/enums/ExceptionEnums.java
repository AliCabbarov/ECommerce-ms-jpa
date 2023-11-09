package model.enums;

import jakarta.persistence.GeneratedValue;
import lombok.Getter;

@Getter
public enum ExceptionEnums {
    WRONG_FIN_EXCEPTION("wrong fin number"),
    WRONG_EMAIL_FORMAT_EXCEPTION("wrong email format"),
    WEAK_PASSWORD_EXCEPTION("weak password"),
    LOW_BIRTHDATE_EXCEPTION("low birthdate"),
    COULD_NOT_BE_SAVED_EXCEPTION("could not be saved"),
    COULD_NOT_BE_UPDATED_EXCEPTION("could be not updated"),
    PRODUCT_HAS_NOT_BEEN_SELECTED("product has not been selected"),
    FORMAT_EXCEPTION("format exception: "),
    PRODUCT_NOT_FOUND("product not found"),
    BRAND_NOT_FOUND("brand not found"),
    CATEGORY_NOT_FOUND("category not found"),
    USER_NOT_FOUND("user not found"),
    WRONG_USERNAME_OR_PASSWORD_EXCEPTION("wrong username or password"),
    INVALID_OPTION_EXCEPTION("invalid option"),
    LOW_MONEY_EXCEPTION("low money");
    private final String message;

    ExceptionEnums(String message) {
        this.message = message;
    }
}
