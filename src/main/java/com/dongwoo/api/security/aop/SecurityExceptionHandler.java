package com.dongwoo.api.security.aop;

import com.dongwoo.api.security.exception.ErrorCode;
import com.dongwoo.api.security.exception.LoginRunnerException;
import com.dongwoo.api.util.Messenger;
import java.nio.file.AccessDeniedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class SecurityExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    protected ResponseEntity<Messenger> handleRuntimeException(RuntimeException e) {
        log.info("HandleRuntimeException", e);

        Messenger response = Messenger.builder()
            .code("test")
            .message(e.getMessage())
            .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
            .build();
        return ResponseEntity.internalServerError().body(response);
    }

    @ExceptionHandler(SecurityException.class)
    protected ResponseEntity<Messenger> handleSecurityException(SecurityException e) {
        log.info("handleSecurityException", e);

        Messenger response = Messenger.builder()
            .code(ErrorCode.AUTHENTICATION_FAILED.getCode())
            .message(e.getMessage())
            .status(ErrorCode.AUTHENTICATION_FAILED.getStatus())
            .build();
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }

    @ExceptionHandler(LoginRunnerException.class)
    protected ResponseEntity<Messenger> handleLoginRunnerException(SecurityException e) {
        log.info("handleLoginRunnerException", e);

        Messenger response = Messenger.builder()
            .code(ErrorCode.LOGIN_FAILED.getCode())
            .message(e.getMessage())
            .status(ErrorCode.LOGIN_FAILED.getStatus())
            .build();
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }

    @ExceptionHandler(BadCredentialsException.class)
    protected ResponseEntity<Messenger> handleBadCredentialsException(SecurityException e) {
        log.info("handleBadCredentialsException", e);

        Messenger response = Messenger.builder()
            .code(ErrorCode.ACCESS_DENIED.getCode())
            .message(e.getMessage())
            .status(ErrorCode.ACCESS_DENIED.getStatus())
            .build();
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }

    @ExceptionHandler(AccessDeniedException.class)
    protected ResponseEntity<Messenger> handleAccessDeniedException(SecurityException e) {
        log.info("handleAccessDeniedException", e);

        Messenger response = Messenger.builder()
            .code(ErrorCode.ACCESS_DENIED.getCode())
            .message(e.getMessage())
            .status(ErrorCode.ACCESS_DENIED.getStatus())
            .build();
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }

    @ExceptionHandler(InsufficientAuthenticationException.class)
    protected ResponseEntity<Messenger> handleInsufficientAuthenticationException(
        SecurityException e) {
        log.info("handleInsufficientAuthenticationException", e);

        Messenger response = Messenger.builder()
            .code(ErrorCode.AUTHENTICATION_FAILED.getCode())
            .message(e.getMessage())
            .status(ErrorCode.AUTHENTICATION_FAILED.getStatus())
            .build();
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }
}
