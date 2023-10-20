package com.web.webproject.util;

import com.google.common.base.CaseFormat;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Helper {
    public static boolean isDateValid(String text, String format) {
        boolean result = true;

        try {
            DateUtils.parseDateStrictly(text, new String[]{format});
        } catch (IllegalArgumentException | ParseException var4) {
            result = false;
        }

        return result;
    }

    public static String dateToString(Date date, String format) {
        if (date == null) {
            return "";
        } else {
            SimpleDateFormat formatter = new SimpleDateFormat(format);
            return formatter.format(date);
        }
    }

    public static String dateToString(Date date) {
        return date == null ? null : date.toString();
    }

    public static Date stringToDate(String s, String format) {
        if (StringUtils.isEmpty(s)) {
            return null;
        } else {
            try {
                return (new SimpleDateFormat(format)).parse(s);
            } catch (ParseException var3) {
                return null;
            }
        }
    }

    public static String formatLongTime(long time, String fileNameFormat) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(fileNameFormat);
        Date date = new Date(time);
        return simpleDateFormat.format(date);
    }
    private static final String EXTENSION_CSV = ".csv";
    private static final String EXTENSION_PDF = ".pdf";
    private static final String REGEX_TEXT_VALID = "[a-zA-Z0-9]+";

    public Helper() {
    }

    public static String upperCamelToLowerUnderScore(String s) {
        if (StringUtils.isEmpty(s)) {
            return null;
        } else {
            String regex = "([aA-zZ]+)(\\d+)";
            Pattern r = Pattern.compile(regex);
            Matcher m = r.matcher(s);
            if (m.find()) {
                CaseFormat var10000 = CaseFormat.UPPER_CAMEL;
                CaseFormat var10001 = CaseFormat.LOWER_UNDERSCORE;
                String var10002 = m.group(1);
                return var10000.to(var10001, var10002 + "_" + m.group(2));
            } else {
                return CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, s);
            }
        }
    }

    public static String capitalizeFirstLetter(String original) {
        if (original != null && original.length() != 0) {
            String var10000 = original.substring(0, 1).toUpperCase();
            return var10000 + original.substring(1);
        } else {
            return original;
        }
    }



    public static boolean checkValueFullSize(String value) {
        Pattern pattern = Pattern.compile("[a-zA-Z0-9]+");
        Matcher matcher = pattern.matcher(value);
        return !matcher.matches();
    }
}
