package com.web.webproject.exception;

/**
 * The type Application exception.
 */
public class ApplicationException extends RuntimeException {

  /**
   * The constant serialVersionUID.
   */
  private static final long serialVersionUID = 1L;

  /**
   * The Error code.
   */
  private String errorCode;

  /**
   * Instantiates a new Application exception.
   *
   * @param errorCode the error code
   */
  public ApplicationException(String errorCode) {
    this.errorCode = errorCode;
  }

  /**
   * Instantiates a new Application exception.
   *
   * @param message   the message
   * @param errorCode the error code
   */
  public ApplicationException(String message, String errorCode) {
    super(message);
    this.errorCode = errorCode;
  }

  /**
   * Instantiates a new Application exception.
   *
   * @param message   the message
   * @param cause     the cause
   * @param errorCode the error code
   */
  public ApplicationException(String message, Throwable cause, String errorCode) {
    super(message, cause);
    this.errorCode = errorCode;
  }

  /**
   * Instantiates a new Application exception.
   *
   * @param cause     the cause
   * @param errorCode the error code
   */
  public ApplicationException(Throwable cause, String errorCode) {
    super(cause);
    this.errorCode = errorCode;
  }

  /**
   * Instantiates a new Application exception.
   *
   * @param message            the message
   * @param cause              the cause
   * @param enableSuppression  the enable suppression
   * @param writableStackTrace the writable stack trace
   * @param errorCode          the error code
   */
  public ApplicationException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace, String errorCode) {
    super(message, cause, enableSuppression, writableStackTrace);
    this.errorCode = errorCode;
  }

  /**
   * Gets error code.
   *
   * @return the error code
   */
  public String getErrorCode() {
    return errorCode;
  }

  /**
   * Sets error code.
   *
   * @param errorCode the error code
   */
  public void setErrorCode(String errorCode) {
    this.errorCode = errorCode;
  }
}
