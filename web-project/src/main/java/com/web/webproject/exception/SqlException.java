package com.web.webproject.exception;

/**
 * The type Sql exception.
 */
public class SqlException extends RuntimeException {

  /**
   * The constant serialVersionUID.
   */
  private static final long serialVersionUID = 6620520008237236930L;

  /**
   * Instantiates a new Sql exception.
   *
   * @param message the message
   */
  public SqlException(String message) {
    super(message);
  }
}
