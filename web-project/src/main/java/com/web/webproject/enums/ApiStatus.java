package com.web.webproject.enums;

/**
 * The enum Api status.
 */
public enum ApiStatus {

  /**
   * The Success.
   */
  SUCCESS("ES200", "Success"),

  /**
   * The Input error.
   */
  INPUT_ERROR("01", "Data invalid"),

  /**
   * The Resource not found.
   */
  RESOURCE_NOT_FOUND("02", "Resource not found"),

  /**
   * The Unknown.
   */
  UNKNOWN("03", "System error"),

  /**
   * The Bad credentials.
   */
  BAD_CREDENTIALS("04", "Error username or password"),

  /**
   * The Bad request.
   */
  BAD_REQUEST("05", "Bad request"),

  /**
   * The Access denied.
   */
  ACCESS_DENIED("06", "Access denied");

  /**
   * The Code.
   */
  private String code;

  /**
   * The Message.
   */
  private String message;

  /**
   * Instantiates a new Api status.
   *
   * @param code    the code
   * @param message the message
   */
  ApiStatus(String code, String message) {
    this.code = code;
    this.message = message;
  }

  /**
   * Gets message.
   *
   * @return the message
   */
  public String getMessage() {
    return message;
  }

  /**
   * Gets code.
   *
   * @return the code
   */
  public String getCode() {
    return code;
  }
}
