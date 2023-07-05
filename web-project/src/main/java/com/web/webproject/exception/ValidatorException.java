package com.web.webproject.exception;

import com.web.webproject.enums.ApiStatus;

/**
 * The type Validator exception.
 */
public class ValidatorException extends Exception {

  /**
   * The constant serialVersionUID.
   */
  private static final long serialVersionUID = -5004623428446901275L;

  /**
   * The Api code.
   */
  private ApiStatus apiCode;

  /**
   * Instantiates a new Validator exception.
   *
   * @param message the message
   * @param apiCode the api code
   */
  public ValidatorException(String message, ApiStatus apiCode) {
    super(message);
    this.apiCode = apiCode;
  }

  /**
   * Instantiates a new Validator exception.
   */
  public ValidatorException() {
    super();
  }

  /**
   * Instantiates a new Validator exception.
   *
   * @param message the message
   */
  public ValidatorException(String message) {
    super(message);
  }

  /**
   * Gets api code.
   *
   * @return the api code
   */
  public ApiStatus getApiCode() {
    return apiCode;
  }

  /**
   * Sets api code.
   *
   * @param apiCode the api code
   */
  public void setApiCode(ApiStatus apiCode) {
    this.apiCode = apiCode;
  }
}
