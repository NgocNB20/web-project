package com.web.webproject.constant;

/**
 * The type Constants.
 */
public class Constants {

  /**
   * The constant UN_ROLE.
   */
  public static final String UN_ROLE = "UN_ROLE";

  /**
   * The constant EMPTY.
   */
  public static final String EMPTY = "";

  /**
   * The constant UNDERSCORE.
   */
  public static final String UNDERSCORE = "_";

  /**
   * The constant DOT.
   */
  public static final String DOT = ".";

  /**
   * The constant SPACE.
   */
  public static final String SPACE = " ";

  /**
   * The constant SLASH.
   */
  public static final String SLASH = "/";

  /**
   * The constant BRACKETS.
   */
  public static final String BRACKETS = ")";

  /**
   * The constant FORMAT_DATE.
   */
  public static final String FORMAT_DATE = "yyyy-MM-dd";

  /**
   * The constant MM_DD_YYYY_SLASH_FORMAT.
   */
  public static final String MM_DD_YYYY_SLASH_FORMAT = "yyyy/MM/dd";

  /**
   * The constant YYYY_M_MDD_H_HMMSS_SSS.
   */
  public static final String YYYY_M_MDD_H_HMMSS_SSS = "yyyyMMddHHmmssSSS";

  public static final String YYYY_MM_DD_T_HH_MM_SS_SSS = "yyyy-MM-dd'T'HH:mm:ss.SSS";

  /**
   * The constant YYYY_M_MDD__H_HMMSS.
   */
  public static final String YYYY_M_MDD__H_HMMSS = "yyyyMMdd-HHmmss";

  /**
   * The constant YYYYMMDD.
   */
  public static final String YYYYMMDD = "yyyyMMdd";


  /**
   * The constant CONSUMER_FIELD.
   */
  public static final String CONSUMER_FIELD = "Id";


  /**
   * The constant REQUEST_ERROR.
   */
  public static final String REQUEST_ERROR = "Request error";

  /**
   * The constant EN.
   */
  public static final String EN = "EN";
  /**
   * The constant JP.
   */
  public static final String JP = "JP";
  /**
   * The constant BALANCE_TYPE1.
   */
  public static final String BALANCE_TYPE = "需給調整市場 一次調整力";
  /**
   * The constant BALANCE_TYPE1.
   */
  public static final String BALANCE_TYPE1 = "需給調整市場 二次調整力1";
  /**
   * The constant BALANCE_TYPE2.
   */
  public static final String BALANCE_TYPE2 = "需給調整市場 二次調整力2";
  /**
   * The constant BALANCE_TYPE3.
   */
  public static final String BALANCE_TYPE3 = "需給調整市場 三次調整力1";
  /**
   * The constant BALANCE_TYPE4.
   */
  public static final String BALANCE_TYPE4 = "需給調整市場 三次調整力2";
  /**
   * The constant CAPACITY.
   */
  public static final String CAPACITY = "容量市場";

  /**
   * The constant SORT_AC_ID.
   */
  public static final String SORT_AC_ID = "ac_id";

  /**
   * The constant BID_PREPARATION_FAILURE.
   */
  public static final String BID_PREPARATION_FAILURE = "入札準備失敗";

  /**
   * The constant COMPLETION_OF_BIDDING_PREPARATIONS.
   */
  public static final String COMPLETION_OF_BIDDING_PREPARATIONS = "入札準備完了";

  public static final String SIGN = "約定";

  public static final String NO_BID_OPENING = "不調";

  public static final String GET_RESULT_OF_FAILED = "約定結果取得失敗";

  /**
   * The constant SUCCESS.
   */
  public static final String SUCCESS = "入札済み";

  /**
   * The constant FAIL.
   */
  public static final String FAIL = "入札失敗";


  /**
   * The constant FROM_DATE_COLUMN.
   */
  public static final String FROM_DATE_COLUMN = "FromDate";
  public static final String AUTHORIZATION_HEADER = "Authorization";
  public static final String PREFIX_TOKEN = "Bearer ";
  public static final String JWT_SECRET_KEY = "obys-003-secret-jwt-key";
  public static final String JWT_DEVICE_SECRET_KEY = "obys-003-M20-secret-jwt-key";
  public static final String ADMIN_ROLE = "ADMIN_ROLE";
  public static final String SUB_ADMIN_ROLE = "SUB_ADMIN_ROLE";
  public static final String CUSTOMER_ROLE = "CUSTOMER_ROLE";
  public static final String USER_ROLE = "USER_ROLE";
  public static final String JWT_USERNAME_KEY = "username";
  public static final String JWT_NAME_KEY = "name";
  public static final String JWT_ADDRESS_KEY = "address";
  public static final String JWT_PHONE_KEY = "phone";
  public static final String JWT_EMAIL_KEY = "email";
  public static final String JWT_STATUS_KEY = "status";
  public static final long JWT_TOKEN_FIVE_MINUTE_TERM = 18000000L;
  public static final long JWT_TOKEN_SEVEN_DAY_TERM = 604800000L;
  public static final long JWT_TOKEN_ONE_DAY_TERM = 86400000L;
  public static final long JWT_TOKEN_ONE_YEAR_TERM = 31536000000L;
  public static final long JWT_TOKEN_ONE_TEN_YEAR_TERM = 315360000000L;
  public static final Integer PAGE_NUM_DEFAULT = 0;
  public static final Integer PAGE_SIZE_DEFAULT = 50;
  public static final int KIT_SUCCESS_STATUS = 0;
  public static final String DRIVING_LICENSE_TYPE_FIELD = "driving.license.type";
  public static final String LICENSE_TYPE_FIELD = "license.type";
  public static final String VEHICLE_TYPE_WEIGHT_FIELD = "vehicle-type.and.weight";
  public static final String DRIVER_INFORMATION_FIELD = "driver.information";
  public static final String DRIVING_LICENSE_FIELD = "driving.license";
  public static final String DRIVING_LICENSE_NUMBER = "driving.license.number";
  public static final String DRIVING_LICENSE_NUMBER_INVALID = "driving.license.number.invalid";
  public static final String DRIVER_CODE = "driver.code";
  public static final String DRIVER_NAME_FIELD = "driver.name.field";
  public static final String VEHICLE_TYPE = "vehicle.type";
  public static final String VEHICLE = "vehicle";
  public static final String VEHICLE_CODE = "vehicle.code";
  public static final String SERIAL_NO = "serial.no";
  public static final String SERIAL_NO_INVALID = "serial.no.invalid";
  public static final String INSTALLED_DATE = "install.date";
  public static final String REMOVE_DATE = "remove.date";
  public static final String RECEIVED_DATE = "received.date";
  public static final String TRANSPORT_DATE = "transport.date";
  public static final String KIT_SET = "kit.set";
  public static final String DRIVER_FIELD = "driver.field";
  public static final String VERSION = "version";
  public static final String VERSION_NAME = "version.name";
  public static final String SEARCH_DRIVING_LICENSE_TYPE_REQUEST = "SearchDrivingLicenseTypeRequest";
  public static final String SEARCH_DRIVER_REQUEST = "SearchDriverRequest";
  public static final String SEARCH_KIT_SET_REQUEST = "SearchKitSetRequest";
  public static final String SEARCH_SCAN_FACE_TRAINING_HISTORY = "SearchScanFaceTrainingHistory";
  public static final String SEARCH_SYNC_FACE_TRAINING_HISTORY = "SearchSyncFaceTrainingHistory";
  public static final String SEARCH_VERSION = "SearchVersion";
  public static final String FILE = "file.download";
  public static final String DATA_EMPTY = "valid.data.request.empty";

  private Constants() {
    throw new IllegalStateException("Utility class");
  }

  /**
   * Instantiates a new Constants.
   */



}
