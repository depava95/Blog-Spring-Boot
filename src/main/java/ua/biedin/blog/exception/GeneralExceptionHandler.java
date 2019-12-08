package ua.biedin.blog.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GeneralExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(ThereIsNoSuchUserException.class)
    protected ResponseEntity<GeneralException> handleThereIsNoSuchUserException() {
        return new ResponseEntity<>(new GeneralException("There is no such user. Please choose right 'id'"), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoUsersAvailableException.class)
    protected ResponseEntity<GeneralException> handleBadRequestException() {
        return new ResponseEntity<>(new GeneralException(("There are no available users")), HttpStatus.NOT_FOUND);
    }




    @Data
    @AllArgsConstructor
    private static class GeneralException {
        private String message;
    }
}
