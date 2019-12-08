package ua.biedin.blog.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class BadRequestBodyException extends RuntimeException {
}
