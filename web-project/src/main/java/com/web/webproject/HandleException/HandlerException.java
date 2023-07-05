package com.web.webproject.HandleException;

import com.web.webproject.constant.Constants;
import com.web.webproject.constant.SystemMessageCode;
import com.web.webproject.enums.ApiStatus;
import com.web.webproject.exception.*;
import com.web.webproject.model.response.BaseResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;
import javax.annotation.Resource;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Path;
import java.util.HashMap;
import java.util.Map;

/**
 * The type Handler exception.
 */
@RestControllerAdvice
public class HandlerException {

  /**
   * The constant LOGGER.
   */
  private static final Logger LOGGER = LoggerFactory.getLogger(HandlerException.class);

  /**
   * The Message source.
   */
  @Resource
  private MessageSource messageSource;

  /**
   * Gets message.
   *
   * @param key    the key
   * @param object the object
   * @return the message
   */
  protected String getMessage(String key, Object... object) {
    return messageSource.getMessage(key, object, LocaleContextHolder.getLocale());
  }

  /**
   * Handle resource not found response entity.
   *
   * @param e the e
   * @return the response entity
   */
  @ExceptionHandler(BadRequestException.class)
  public ResponseEntity<?> handleResourceNotFound(BadRequestException e) {
    LOGGER.error(e.getMessage());
    return ResponseEntity.ok(BaseResponse.builder().code(ApiStatus.BAD_REQUEST.getCode())
        .message(ApiStatus.BAD_REQUEST.getMessage()).build());
  }

  /**
   * Handle resource not found response entity.
   *
   * @param e the e
   * @return the response entity
   */
  @ExceptionHandler(ResourceNotFountException.class)
  public ResponseEntity<?> handleResourceNotFound(ResourceNotFountException e) {
    LOGGER.error(e.getMessage());
    return ResponseEntity.ok(BaseResponse.builder().code(ApiStatus.RESOURCE_NOT_FOUND.getCode())
        .message(ApiStatus.RESOURCE_NOT_FOUND.getMessage()).build());
  }

  /**
   * Handle resource not found response entity.
   *
   * @param e the e
   * @return the response entity
   */
  @ExceptionHandler({UnknownException.class, Exception.class, SqlException.class})
  public ResponseEntity<?> handleResourceNotFound(Exception e) {
    LOGGER.error(e.getMessage());
    return ResponseEntity.ok(BaseResponse.builder().code(ApiStatus.UNKNOWN.getCode())
        .message(getMessage("system.error")).build());
  }

  /**
   * Handle http request method not supported response entity.
   *
   * @param e the e
   * @return the response entity
   */
  @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
  protected ResponseEntity<?> handleHttpRequestMethodNotSupported(
      HttpRequestMethodNotSupportedException e) {
    LOGGER.error(e.getMessage());
    return ResponseEntity.ok(BaseResponse.builder().code(ApiStatus.BAD_REQUEST.getCode())
        .message(ApiStatus.BAD_REQUEST.getMessage()).build());
  }

  /**
   * Bad request response entity.
   *
   * @param e the e
   * @return the response entity
   */
  @ExceptionHandler(value = {NoHandlerFoundException.class})
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ResponseEntity<?> badRequest(NoHandlerFoundException e) {
    LOGGER.error(e.getMessage());
    return ResponseEntity.ok(BaseResponse.builder().code(ApiStatus.RESOURCE_NOT_FOUND.getCode())
        .message(ApiStatus.RESOURCE_NOT_FOUND.getMessage()).build());
  }

  /**
   * Handle validation exceptions response entity.
   *
   * @param e the e
   * @return the response entity
   */
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<?> handleValidationExceptions(MethodArgumentNotValidException e) {
    Map<String, String> errors = new HashMap<>();
    e.getBindingResult().getAllErrors().forEach(error -> {
      String errorMessage = messageSource.getMessage(error, LocaleContextHolder.getLocale());
      String fieldName = ((FieldError) error).getField();
      errors.put(fieldName, fieldName.concat(Constants.SPACE).concat(errorMessage));
    });
    return ResponseEntity.ok(BaseResponse.builder().code(ApiStatus.BAD_REQUEST.getCode())
        .message(ApiStatus.BAD_REQUEST.getMessage()).data(errors).build());
  }

  /**
   * Handle field validation exceptions response entity.
   *
   * @param e the e
   * @return the response entity
   */
  @ExceptionHandler(IllegalArgumentException.class)
  public ResponseEntity<?> handleFieldValidationExceptions(IllegalArgumentException e) {
    LOGGER.error(e.getMessage());
    return ResponseEntity.ok(BaseResponse.builder()
        .code(ApiStatus.INPUT_ERROR.getCode())
        .message(ApiStatus.INPUT_ERROR.getMessage())
        .build());
  }

  /**
   * Handle catch exceptions response entity.
   *
   * @param e the e
   * @return the response entity
   */
  @ExceptionHandler(CatchException.class)
  public ResponseEntity<?> handleCatchExceptions(CatchException e) {
    LOGGER.error(e.getMessage());
    return ResponseEntity.ok(BaseResponse.builder()
        .code(ApiStatus.INPUT_ERROR.getCode())
        .message(messageSource
            .getMessage(SystemMessageCode.ES201_WARNING, null, LocaleContextHolder.getLocale()))
        .data(e.getMessage())
        .build());
  }

  /**
   * Handle resource not exists in system response entity.
   *
   * @param e the e
   * @return the response entity
   */
  @ExceptionHandler(NotExistsInSystemException.class)
  public ResponseEntity<?> handleResourceNotExistsInSystem(NotExistsInSystemException e) {
    LOGGER.error(e.getMessage());
    return ResponseEntity.ok(BaseResponse.builder()
        .code(ApiStatus.INPUT_ERROR.getCode())
        .message(messageSource
            .getMessage(SystemMessageCode.ES201_WARNING, null, LocaleContextHolder.getLocale()))
        .data(e.getMessage())
        .build());
  }

  /**
   * Handle constraint violation exception response entity.
   *
   * @param e the e
   * @return the response entity
   */
  @ExceptionHandler(ConstraintViolationException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ResponseEntity<BaseResponse> handleConstraintViolationException(ConstraintViolationException e) {
    Map<String, Object> errors = new HashMap<>();
    if (!e.getConstraintViolations().isEmpty()) {
      for (ConstraintViolation constraintViolation : e.getConstraintViolations()) {
        String fieldName = null;
        for (Path.Node node : constraintViolation.getPropertyPath()) {
          fieldName =  node.getName();
        }
        errors.put(fieldName, constraintViolation.getMessage());
      }
    }
    return ResponseEntity.ok(BaseResponse.builder().code(ApiStatus.BAD_REQUEST.getCode())
        .message(ApiStatus.BAD_REQUEST.getMessage()).data(errors).build());
  }
}

