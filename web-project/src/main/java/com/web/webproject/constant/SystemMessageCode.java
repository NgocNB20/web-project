package com.web.webproject.constant;

/**
 * The type System message code.
 */
public class SystemMessageCode {
  private String code;
  private String message;
  public String getCode() {
    return this.code;
  }

  public String getMessage() {
    return this.message;
  }

  private SystemMessageCode(String code, String message) {
    this.code = code;
    this.message = message;
  }

  /**
   * Instantiates a new System message code.
   */
  private SystemMessageCode() {}

  /**
   * The constant ES600_UNEXPECTED_ERROR.
   */
  public static final String ES600_UNEXPECTED_ERROR = "ES600";

  /**
   * The constant UNAUTHORIZED.
   */
  public static final String UNAUTHORIZED = "401";

  /**
   * The constant ES601_REQUEST_INVALID.
   */
  public static final String ES601_REQUEST_INVALID = "ES601";

  /**
   * The constant ES200_SUCCESS.
   */
  public static final String ES404_NOTFOUND = "ES404";

  /**
   * The constant ES200_SUCCESS.
   */
  public static final String ES200_SUCCESS = "ES200";
  /**
   * The constant ES202_SUCCESS.
   */
  public static final String ES202_SUCCESS = "ES202";
  /**
   * The constant ES201_WARNING.
   */
  public static final String ES201_WARNING = "ES201";
  /**
   * The constant ES203_UPDATE_SUCCESS.
   */
  public static final String ES203_UPDATE_SUCCESS = "ES203";
  /**
   * The constant ES204_DATA_EMPTY.
   */
  public static final String ES204_DATA_EMPTY = "valid.data.request.empty";
  /**
   * The constant ES205_DATA_USED.
   */
  public static final String ES205_DATA_USED = "valid.data.request.data.used";
  /**
   * The constant ES400_INPUT_ERROR.
   */
  public static final String ES400_INPUT_ERROR = "valid.data.request.invalid";


  /**
   * The constant DATA_NOT_FOUND.
   */
  public static final String DATA_NOT_FOUND = "valid.data.not.found";

  /**
   * The constant EMAIL_SUBJECT_UPDATE_STATUS.
   */
  public static final String EMAIL_SUBJECT_UPDATE_STATUS = "mail.subject.update.status";
  /**
   * The constant ES400_DATA_INVALID.
   */
  public static final String ES400_DATA_INVALID = "INTERNAL_SERVER_ERROR";

  /**
   * The constant VALIDATE_START_DATE_MORE_THAN_END_DATE.
   */
  public static final String VALIDATE_START_DATE_MORE_THAN_END_DATE = "start.date.must.be.less.than.the.end.date";

  public static final String VALIDATE_START_TIME_AND_END_TIME = "validate.start.time.and.end.time";

  public static final String E400 = "400";
  public static final String E400_MSG = "err.msg";
  public static final String E200 = "200";
  public static final String DATA_INVALID = "Data Invalid";

}
