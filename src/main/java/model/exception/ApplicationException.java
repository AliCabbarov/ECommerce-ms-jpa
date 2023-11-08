package model.exception;

import lombok.Getter;
import model.enums.ExceptionEnums;
@Getter
public class ApplicationException extends RuntimeException{
    private final String message;

    public ApplicationException(ExceptionEnums e) {
        super(e.getMessage());
        message = e.getMessage();
    }
}
