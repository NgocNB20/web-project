package com.web.webproject.constant;

/**
 * The enum Date format.
 */
public enum DateFormat {

  /**
   * The Dd mm yyyy no separator.
   */
  DD_MM_YYYY_NO_SEPARATOR("ddMMyyyy"),

  /**
   * The Dd mm yyyy hh mm ss no separator.
   */
  DD_MM_YYYY_HH_MM_SS_NO_SEPARATOR("ddMMyyyyHHmmss"),

  /**
   * The Dd mm yyyy hh mm no separator.
   */
  DD_MM_YYYY_HH_MM_NO_SEPARATOR("ddMMyyyyHHmm"),

  /**
   * The Dd mm yyyy separator.
   */
  DD_MM_YYYY_SEPARATOR("dd-MM-yyyy"),

  /**
   * The Yyyy mm dd dot.
   */
  YYYY_MM_DD_DOT("yyyy.MM.dd"),

  /**
   * The Yyyy mm.
   */
  YYYY_MM("yyyy.MM"),

  /**
   * The Dd mm yyyy hh mm separator.
   */
  DD_MM_YYYY_HH_MM_SEPARATOR("dd-MM-yyyy HH:mm"),

  /**
   * The Dd mm yyyy hh mm ss separator.
   */
  DD_MM_YYYY_HH_MM_SS_SEPARATOR("dd-MM-yyyy HH:mm:ss"),

  /**
   * The Yyyy mm dd hh mm ss separator.
   */
  YYYY_MM_DD_HH_MM_SS_SEPARATOR("yyyy-MM-dd HH:mm:ss"),

  /**
   * The Yyyy mm dd hh mm ss dot.
   */
  YYYY_MM_DD_HH_MM_SS_DOT("yyyy.MM.dd-HH:mm:ss"),

  /**
   * The Yyyy mm dd hh mm ss dot no dash.
   */
  YYYY_MM_DD_HH_MM_SS_DOT_NO_DASH("yyyy.MM.dd HH:mm:ss"),

  /**
   * The Yyyymmdd.
   */
  YYYYMMDD("yyyyMMdd"),

  /**
   * The Yyyymmdd hhmmss.
   */
  YYYYMMDD_HHMMSS("yyyyMMdd-HHmmss"),

  /**
   * The Yyyy mm dd.
   */
  YYYY_MM_DD("yyyy-MM-dd"),

  /**
   * The Yyyy mm dd hhmm.
   */
  YYYY_MM_DD_HHMM("yyyy.MM.dd HH:mm");

  /**
   * The Format.
   */
  private String format;

  /**
   * Instantiates a new Date format.
   *
   * @param format the format
   */
  DateFormat(String format) {
    this.format = format;
  }

  /**
   * Gets format.
   *
   * @return the format
   */
  public String getFormat() {
    return format;
  }
}
