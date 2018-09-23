package com.store.OnlineStore.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
  
  @ExceptionHandler(value = Exception.class)
  public ResponseEntity<ErrorMessage> handelException(Exception e){
    ErrorMessage message = new ErrorMessage();
    message.setError("500");
    message.setErrorDescription(e.getMessage());
    return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
  }
  
  /**
   * Handles MethodArgumentNotValidException.
   */
  @ExceptionHandler(value = MethodArgumentNotValidException.class)
  public ResponseEntity<ErrorMessage> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
    ErrorMessage message = new ErrorMessage();
    FieldError firstError = (FieldError) exception.getBindingResult().getAllErrors().iterator().next();
    String field = firstError.getField();
    message.setError(firstError.getCode());
    message.setErrorDescription(field + " " + firstError.getDefaultMessage());
    return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
  }

}
