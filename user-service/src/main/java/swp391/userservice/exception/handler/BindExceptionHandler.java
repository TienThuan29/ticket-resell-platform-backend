package swp391.userservice.exception.handler;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import swp391.userservice.exception.def.BindException;
import swp391.userservice.exception.def.ErrorResponse;

/**
 * Author: Nguyen Tien Thuan
 */
@RestControllerAdvice
public class BindExceptionHandler {

    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponse handle(BindException e) {
        String errorMessage = e.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        return new ErrorResponse(HttpStatus.NOT_FOUND, errorMessage);
    }

}
