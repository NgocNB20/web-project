//package com.web.webproject.util;
//
//import com.github.mervick.aes_everywhere.Aes256;
//import com.google.common.base.Strings;
//import com.google.gson.JsonArray;
//import com.google.gson.JsonObject;
//import org.apache.commons.codec.binary.Hex;
//import org.apache.commons.validator.UrlValidator;
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//import org.springframework.util.DigestUtils;
//import javax.crypto.Mac;
//import javax.crypto.spec.SecretKeySpec;
//import javax.servlet.http.HttpServletRequest;
//import java.lang.reflect.Field;
//import java.security.MessageDigest;
//import java.security.NoSuchAlgorithmException;
//import java.text.DateFormat;
//import java.text.NumberFormat;
//import java.text.SimpleDateFormat;
//import java.time.temporal.ChronoUnit;
//import java.util.*;
//import java.util.concurrent.ConcurrentHashMap;
//import java.util.function.Function;
//import java.util.function.Predicate;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//import java.util.stream.LongStream;
//
///**
// *
// * @author PhuongDT
// */
//public class TextUtils {
//
//    /**
//     * Thời gian giới hạn xuất excel
//     *
//     * @return
//     */
//    public static long getTimeDayLimit() {
//        return 2800800000l;//32 ngày
//    }
//
//    /**
//     * validate email nhap vao co dung dinh dang ko
//     *
//     * @param email email can check
//     * @return true/false
//     */
//    public static boolean validateEmailString(String email) {
//        String validEmail = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
//        Pattern pattern = Pattern.compile(validEmail);
//        Matcher matcher = pattern.matcher(email);
//        boolean result = matcher.matches();
//        if (result && (email.contains("gmail.con") || email.contains("gmail.com.vn") || email.contains("gmai.com"))) {
//            return false;
//        }
//        return result;
//    }
//
//    /**
//     * *
//     * validate text không có ký tự đặc biệt
//     *
//     * @param text
//     * @return
//     */
//    public static boolean validateText(String text) {
//        String validPhone = "[a-zA-Z0-9\\s]*";
//        Pattern pattern = Pattern.compile(validPhone);
//        String removeDiacritical = removeDiacritical(text);
//        Matcher matcher = pattern.matcher(removeDiacritical);
//        return matcher.matches();
//    }
//
//    /**
//     * validate so dien thoai nhap vao co dung dinh dang ko (bat dau bang so 0,
//     * dai tu 8-11 ki tu
//     *
//     * @param phone email can check
//     * @return true/false
//     */
//    public static boolean validatePhoneNumber(String phone) {
//        String validPhone = "^0\\d{7,10}$";
//        Pattern pattern = Pattern.compile(validPhone);
//        Matcher matcher = pattern.matcher(phone);
//        return matcher.matches();
//    }
//
//    /**
//     * Cắt hết dấu tiếng Việt
//     *
//     * @param str
//     * @return
//     */
//    public static String removeDiacritical(String str) {
//        if (str == null) {
//            return str;
//        }
//        str = str.replaceAll("(à|á|ạ|ả|ã|â|ầ|ấ|ậ|ẩ|ẫ|ă|ằ|ắ|ặ|ẳ|ẵ)", "a");
//        str = str.replaceAll("(è|é|ẹ|ẻ|ẽ|ê|ề|ế|ệ|ể|ễ)", "e");
//        str = str.replaceAll("(ì|í|ị|ỉ|ĩ)", "i");
//        str = str.replaceAll("(ò|ó|ọ|ỏ|õ|ô|ồ|ố|ộ|ổ|ỗ|ơ|ờ|ớ|ợ|ở|ỡ)", "o");
//        str = str.replaceAll("(ù|ú|ụ|ủ|ũ|ư|ừ|ứ|ự|ử|ữ)", "u");
//        str = str.replaceAll("(ỳ|ý|ỵ|ỷ|ỹ)", "y");
//        str = str.replaceAll("(đ)", "d");
//        str = str.replaceAll("(À|Á|Ạ|Ả|Ã|Â|Ầ|Ấ|Ậ|Ẩ|Ẫ|Ă|Ằ|Ắ|Ặ|Ẳ|Ẵ)", "A");
//        str = str.replaceAll("(È|É|Ẹ|Ẻ|Ẽ|Ê|Ề|Ế|Ệ|Ể|Ễ)", "E");
//        str = str.replaceAll("(Ì|Í|Ị|Ỉ|Ĩ)", "I");
//        str = str.replaceAll("(Ò|Ó|Ọ|Ỏ|Õ|Ô|Ồ|Ố|Ộ|Ổ|Ỗ|Ơ|Ờ|Ớ|Ợ|Ở|Ỡ)", "O");
//        str = str.replaceAll("(Ù|Ú|Ụ|Ủ|Ũ|Ư|Ừ|Ứ|Ự|Ử|Ữ)", "U");
//        str = str.replaceAll("(Ỳ|Ý|Ỵ|Ỷ|Ỹ)", "Y");
//        str = str.replaceAll("(Đ)", "D");
//        return str;
//    }
//
//    public static String getMD5(String input) {
//        try {
//            MessageDigest md = MessageDigest.getInstance("MD5");
//            md.update(input.getBytes());
//
//            byte byteData[] = md.digest();
//
//            //convert the byte to hex format method 1
//            StringBuilder sb = new StringBuilder();
//            for (int i = 0; i < byteData.length; i++) {
//                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
//            }
//
//            return sb.toString();
//        } catch (NoSuchAlgorithmException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    /**
//     * *
//     * convent ảnh áp dụng cho taobao,tmall, 1688
//     *
//     * @param img
//     * @param width
//     * @param height
//     * @return
//     */
//    public static String conventImage(String img, int width, int height) {
//        Pattern pattern = Pattern.compile("^\\/\\/");
//        Matcher matcher = pattern.matcher(img);
//        if (matcher.find()) {
//            img = "https:" + img;
//        }
//        if (width > 0 && width > 0) {
//            String size = "_" + width + "x" + height;
//            img = img.replaceAll("_[0-9]+(x)\\d{1,3}", size);
//        }
//        if (img.contains("_.webp")) {
//            img = img.replaceAll("_.webp", "");
//        }
//        if (img.startsWith("http:")) {
//            img = img.replaceAll("http:", "https:");
//        }
//        if (img.startsWith("//img.alicdn.com/imgextra/")) {
//            img = img.replaceAll("//img.alicdn.com/imgextra/", "");
//        }
//        return img;
//    }
//
//    /**
//     * *
//     * Convent số tiền VNĐ
//     *
//     * @param price
//     * @return
//     */
//    public static String numberFormat(Long price) {
//        String str = "0";
//        try {
//            NumberFormat nf = NumberFormat.getInstance(new Locale("vi", "VN"));
//            str = nf.format(price);
//        } catch (Exception ex) {
//        }
//        return str;
//    }
//
//    public static String getClientIpAddr(HttpServletRequest request) {
//        String ip = request.getHeader("X-Forwarded-For");
//        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//            ip = request.getHeader("Proxy-Client-IP");
//        }
//        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//            ip = request.getHeader("WL-Proxy-Client-IP");
//        }
//        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
//        }
//        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//            ip = request.getHeader("HTTP_X_FORWARDED");
//        }
//        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//            ip = request.getHeader("HTTP_X_CLUSTER_CLIENT_IP");
//        }
//        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//            ip = request.getHeader("HTTP_CLIENT_IP");
//        }
//        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//            ip = request.getHeader("HTTP_FORWARDED_FOR");
//        }
//        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//            ip = request.getHeader("HTTP_FORWARDED");
//        }
//        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//            ip = request.getHeader("HTTP_VIA");
//        }
//        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//            ip = request.getHeader("REMOTE_ADDR");
//        }
//        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//            ip = request.getRemoteAddr();
//        }
//        return ip;
//    }
//
//    /**
//     * **
//     *
//     *
//     * round(200.3456, 2); // returns 200.35
//     *
//     * @param value
//     * @param places
//     * @return
//     */
//    public static double round(double value, int places) {
//        if (places < 0) {
//            throw new IllegalArgumentException();
//        }
//
//        long factor = (long) Math.pow(10, places);
//        value = value * factor;
//        long tmp = Math.round(value);
//        return (double) tmp / factor;
//    }
//
//    public static float roundF(float value, int places) {
//        if (places < 0) {
//            throw new IllegalArgumentException();
//        }
//
//        long factor = (long) Math.pow(10, places);
//        value = value * factor;
//        long tmp = Math.round(value);
//        return (float) tmp / factor;
//    }
//
//    /**
//     * Giữ nguyên giá trị khi làm tròn
//     *
//     * @param value
//     * @param places
//     * @return
//     */
//    public static float roundF2(float value, int places) {
//        if (places < 0) {
//            throw new IllegalArgumentException();
//        }
//        int plus = 1;
//        long factor = (long) Math.pow(10, places + plus);
//        value = value * factor;
//        long tmp = Math.round(value);
//        Float f = (float) tmp / factor;
//        String toString = f.toString();
//        int length = toString.indexOf(".") + plus + places;
//        if (length > toString.length()) {
//            length = toString.length();
//        }
//        return Float.valueOf(toString.substring(0, length));
//    }
//
//    /**
//     *
//     * Lấy thời gian đầu ngày hoặc cuối ngày
//     *
//     * @param time
//     * @param endday
//     * @return
//     */
//    public static long getTime(long time, boolean endday) {
//        try {
//            TimeZone tz = TimeZone.getTimeZone("Asia/Ho_Chi_Minh");
//            Calendar cal = Calendar.getInstance(tz);
//            SimpleDateFormat sdfTime = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//            cal.setTime(new Date(time));
//            long time1 = sdfTime.parse(cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" + cal.get(Calendar.DAY_OF_MONTH) + (endday ? " 23:59" : " 00:00")).getTime();
//            //time1 += 3600000; //Không hiểu sao cứ bị chậm 1 giờ. sẽ check lại viết controller test
//            if (endday) {
//                time1 += 59000;
//            }
//            return time1;
//        } catch (Exception e) {
//            return 0;
//        }
//    }
//
//    /**
//     * *
//     * Lấy time convert sang tháng
//     *
//     * @param time
//     * @param lastDateOfMonth
//     * @return
//     */
//    public static long getTimeToMonth(long time, boolean lastDateOfMonth) {
//        try {
//            TimeZone tz = TimeZone.getTimeZone("Asia/Ho_Chi_Minh");
//            Calendar cal = Calendar.getInstance(tz);
//            SimpleDateFormat sdfTime = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//            cal.setTime(new Date(time));
//            long time1 = sdfTime.parse(cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1) + "-1 00:00").getTime();
//            if (lastDateOfMonth) {
//                time1 = sdfTime.parse(cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" + cal.getActualMaximum(Calendar.DAY_OF_MONTH) + " 23:59").getTime();
//            }
//            return time1;
//        } catch (Exception e) {
//            return 0;
//        }
//    }
//
//    /**
//     * *
//     *
//     * @param time
//     * @param endday
//     * @return
//     */
//    public static long getTimeFirstOfMonth(long time, boolean endday) {
//        try {
//            if (endday) {
//                Calendar calendar = Calendar.getInstance();
//                calendar.setTime(new Date(time));
//                calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
//                calendar.set(Calendar.HOUR_OF_DAY, 23);
//                calendar.set(Calendar.MINUTE, 59);
//                calendar.set(Calendar.SECOND, 59);
//                calendar.set(Calendar.MILLISECOND, 999);
//                return calendar.getTime().getTime();
////                return calendar.getTime().getTime()+3600000;
//            } else {
//                Calendar calendar = Calendar.getInstance();
//                calendar.setTime(new Date(time));
//                calendar.set(Calendar.DAY_OF_MONTH, 1);
//                calendar.set(Calendar.HOUR_OF_DAY, 0);
//                calendar.set(Calendar.MINUTE, 0);
//                calendar.set(Calendar.SECOND, 0);
//                calendar.set(Calendar.MILLISECOND, 0);
//                return calendar.getTime().getTime();
//                //return calendar.getTime().getTime()+3600000;
//            }
//        } catch (Exception e) {
//            return 0;
//        }
//    }
//
//    /**
//     * *
//     * Xóa khoảng trắng trong danh sách List string input: "1211 ","2323 2222"
//     * output: "1211","23232222"
//     *
//     * @param strs
//     * @return
//     */
//    public static List<String> removeSpacesInArray(List<String> strs) {
//        List<String> strNew = new ArrayList<>();
//        if (strs != null && !strs.isEmpty()) {
//            for (String str : strs) {
//                if (!Strings.isNullOrEmpty(str)) {
//                    strNew.add(str.replaceAll("\\s", ""));
//                }
//            }
//        }
//        return strNew;
//    }
//
//    /**
//     * *
//     * Chuyển đổi 11 số sang 10 số theo đúng quy định bộ công thương
//     *
//     * @param s
//     * @return String
//     */
//    public static String conventPhoneNumber(String s) {
//        if (s.length() == 11) {
//            if (s.startsWith("016")) {
//                String newPhone = "03" + s.substring(3);
//                s = newPhone;
//            } else if (s.startsWith("0120")) {
//                String newPhone = "070" + s.substring(4);
//                s = newPhone;
//            } else if (s.startsWith("0121")) {
//                String newPhone = "079" + s.substring(4);
//                s = newPhone;
//            } else if (s.startsWith("0122")) {
//                String newPhone = "077" + s.substring(4);
//                s = newPhone;
//            } else if (s.startsWith("0126")) {
//                String newPhone = "076" + s.substring(4);
//                s = newPhone;
//            } else if (s.startsWith("0128")) {
//                String newPhone = "078" + s.substring(4);
//                s = newPhone;
//            } else if (s.startsWith("0124")) {
//                String newPhone = "084" + s.substring(4);
//                s = newPhone;
//            } else if (s.startsWith("0127")) {
//                String newPhone = "081" + s.substring(4);
//                s = newPhone;
//            } else if (s.startsWith("0129")) {
//                String newPhone = "082" + s.substring(4);
//                s = newPhone;
//            } else if (s.startsWith("0123")) {
//                String newPhone = "083" + s.substring(4);
//                s = newPhone;
//            } else if (s.startsWith("0125")) {
//                String newPhone = "085" + s.substring(4);
//                s = newPhone;
//            } else if (s.startsWith("018") || s.startsWith("019")) {
//                String newPhone = "05" + s.substring(3);
//                s = newPhone;
//            }
//        }
//        return s;
//    }
//
//    /**
//     * Validate float, Double
//     *
//     * @param weight
//     * @return
//     */
//    public static boolean validateFloatAndDouble(String weight) {
//        String validEmail = "^([+-]?(\\d+\\.)?\\d+)$";
//        Pattern pattern = Pattern.compile(validEmail);
//        String removeDiacritical = removeDiacritical(weight);
//        Matcher matcher = pattern.matcher(removeDiacritical);
//        return matcher.matches();
//    }
//
//    /**
//     *
//     * Validate thể tích String volume.
//     *
//     * @param volume
//     * @return
//     */
//    public static boolean validateVolume(String volume) {
//        String validVolume = "\\b\\d{1,9}[x]\\d{1,9}[x]\\d{1,9}\\b";
//        Pattern pattern = Pattern.compile(validVolume);
//        String removeDiacritical = removeDiacritical(volume);
//        Matcher matcher = pattern.matcher(removeDiacritical);
//        return matcher.matches();
//    }
//
//    /**
//     *
//     * Validate Link ảnh String images.
//     *
//     * @param images
//     * @return
//     */
//    public static boolean validateImage(List<String> images) {
//        String[] schemes = {"http", "https"};
//        UrlValidator urlValidator = new UrlValidator(schemes);
//        List<String> imageError = new ArrayList();
//        for (String image : images) {
//            if (!urlValidator.isValid(image)) {
//                imageError.add(image);
//            }
//        }
//        if (imageError.size() > 0) {
//            return false;
//        } else {
//            return true;
//        }
//    }
//
//    /**
//     *
//     * Chuyển đổi link từ PC sang mobile hoặc ngược lại
//     *
//     *
//     * @param URL
//     * @param mobile
//     * @return
//     */
//    public static String alibabaConventLinkByType(String URL, boolean mobile) {
//        if (mobile) {
//            if (Pattern.compile(RegexLinkWebsite.TAOBAO_ITEM).matcher(URL).find()) {
//                URL = URL.replaceFirst(RegexLinkWebsite.TAOBAO_ITEM, "https://m.intl.taobao.com/detail/detail.html?$6");
//            } else if (Pattern.compile(RegexLinkWebsite.TAOBAO_WORLD).matcher(URL).find()) {
//                URL = URL.replaceFirst(RegexLinkWebsite.TAOBAO_WORLD, "https://m.intl.taobao.com/detail/detail.html?id=$3");
//            } else if (Pattern.compile(RegexLinkWebsite.TAOBAO_MOBILE_ANDROID).matcher(URL).find()) {
//                URL = URL.replaceFirst(RegexLinkWebsite.TAOBAO_MOBILE_ANDROID, "https://m.intl.taobao.com/detail/detail.html?id=$4");
//            } else if (Pattern.compile(RegexLinkWebsite.TAOBAO_MOBILE_ITEM).matcher(URL).find()) {
//                URL = URL.replaceFirst(RegexLinkWebsite.TAOBAO_MOBILE_ITEM, "https://m.intl.taobao.com/detail/detail.html?$5");
//            } else if (Pattern.compile(RegexLinkWebsite.TAOBAO_MOBILE_WORLD).matcher(URL).find()) {
//                URL = URL.replaceFirst(RegexLinkWebsite.TAOBAO_MOBILE_WORLD, "https://m.intl.taobao.com/detail/detail.html?id=$6");
//            } else if (Pattern.compile(RegexLinkWebsite.TMALL_MOBILE).matcher(URL).find()) {
//                URL = URL.replaceFirst(RegexLinkWebsite.TMALL_MOBILE, "https://detail.m.tmall.com/item.htm?$5&toSite=main");
//            } else if (Pattern.compile(RegexLinkWebsite.TMALL_DETAIL).matcher(URL).find()) {
//                URL = URL.replaceFirst(RegexLinkWebsite.TMALL_DETAIL, "https://detail.m.tmall.com/item.htm?$9&toSite=main");
//            } else if (Pattern.compile(RegexLinkWebsite.TMALL_DESKTOP_WORLD).matcher(URL).find()) {
//                URL = URL.replaceFirst(RegexLinkWebsite.TMALL_DESKTOP_WORLD, "https://detail.m.tmall.com/item.htm?id=$5&toSite=main");
//            } else if (Pattern.compile(RegexLinkWebsite.CN1688).matcher(URL).find()) {
//                URL = URL.replaceFirst(RegexLinkWebsite.CN1688, "$1m$4");
//            }
//        } else //Dành cho máy tính
//        if (Pattern.compile(RegexLinkWebsite.TAOBAO_ITEM).matcher(URL).find()) {
//            URL = URL.replaceFirst(RegexLinkWebsite.TAOBAO_ITEM, "https://item.taobao.com/item.htm?$6");
//        } else if (Pattern.compile(RegexLinkWebsite.TAOBAO_WORLD).matcher(URL).find()) {
//            URL = URL.replaceFirst(RegexLinkWebsite.TAOBAO_WORLD, "https://item.taobao.com/item.htm?id=$3");
//        } else if (Pattern.compile(RegexLinkWebsite.TAOBAO_MOBILE_ITEM).matcher(URL).find()) {
//            URL = URL.replaceFirst(RegexLinkWebsite.TAOBAO_MOBILE_ITEM, "https://item.taobao.com/item.htm?$5");
//        } else if (Pattern.compile(RegexLinkWebsite.TAOBAO_MOBILE_WORLD).matcher(URL).find()) {
//            URL = URL.replaceFirst(RegexLinkWebsite.TAOBAO_MOBILE_WORLD, "https://item.taobao.com/item.htm?id=$6$7");
//        } else if (Pattern.compile(RegexLinkWebsite.TMALL_MOBILE).matcher(URL).find()) {
//            URL = URL.replaceFirst(RegexLinkWebsite.TMALL_MOBILE, "https://detail.tmall.com/item.htm?$5&toSite=main$6");
//        } else if (Pattern.compile(RegexLinkWebsite.TMALL_DETAIL).matcher(URL).find()) {
//            URL = URL.replaceFirst(RegexLinkWebsite.TMALL_DETAIL, "https://detail.tmall.com/item.htm?$9&toSite=main$10");
//        } else if (Pattern.compile(RegexLinkWebsite.TMALL_DESKTOP_WORLD).matcher(URL).find()) {
//            URL = URL.replaceFirst(RegexLinkWebsite.TMALL_DESKTOP_WORLD, "https://detail.tmall.com/item.htm?id=$5&toSite=main");
//        } else if (Pattern.compile(RegexLinkWebsite.CN1688).matcher(URL).find()) {
//            URL = URL.replaceFirst(RegexLinkWebsite.CN1688, "$1detail$4");
//        }
//        return URL;
//    }
//
//    public static String convertTAOBAO_TMALL(String URL, WebsiteType websiteType) {
////        if (websiteType == WebsiteType.TAOBAO) {
////            if (Pattern.compile(RegexLinkWebsite.TAOBAO_ITEM).matcher(URL).find()) {
////                URL = URL.replaceFirst(RegexLinkWebsite.TAOBAO_ITEM, "https://item.taobao.com/item.html?$6");
////            } else if (Pattern.compile(RegexLinkWebsite.TAOBAO_WORLD).matcher(URL).find()) {
////                URL = URL.replaceFirst(RegexLinkWebsite.TAOBAO_WORLD, "https://item.taobao.com/item.html?id=$3");
////            } else if (Pattern.compile(RegexLinkWebsite.TAOBAO_MOBILE_ITEM).matcher(URL).find()) {
////                URL = URL.replaceFirst(RegexLinkWebsite.TAOBAO_MOBILE_ITEM, "https://item.taobao.com/item.html?$5");
////            } else if (Pattern.compile(RegexLinkWebsite.TAOBAO_MOBILE_WORLD).matcher(URL).find()) {
////                URL = URL.replaceFirst(RegexLinkWebsite.TAOBAO_MOBILE_WORLD, "https://item.taobao.com/item.html?id=$6$7");
////            }
////        }
//        if (websiteType == WebsiteType.TMALL) {
//            if (Pattern.compile(RegexLinkWebsite.TAOBAO_WORLD).matcher(URL).find()) {
//                URL = URL.replaceFirst(RegexLinkWebsite.TAOBAO_WORLD, "https://detail.tmall.com/item.htm?id=$3&toSite=main");
//            } else if (Pattern.compile(RegexLinkWebsite.TAOBAO_MOBILE_WORLD).matcher(URL).find()) {
//                URL = URL.replaceFirst(RegexLinkWebsite.TAOBAO_MOBILE_WORLD, "https://detail.tmall.com/item.htm?id=$6$7&toSite=main");
//            } else if (Pattern.compile(RegexLinkWebsite.TAOBAO_MOBILE_ITEM).matcher(URL).find()) {
//                URL = URL.replaceFirst(RegexLinkWebsite.TAOBAO_MOBILE_ITEM, "https://detail.tmall.com/item.htm?$5&toSite=main");
//            } else if (Pattern.compile(RegexLinkWebsite.TAOBAO_ITEM).matcher(URL).find()) {
//                URL = URL.replaceFirst(RegexLinkWebsite.TAOBAO_ITEM, "https://detail.tmall.com/item.htm?$6&toSite=main");
//            }
//        }
//        return URL;
//    }
//
//    /**
//     * Check ngày nghỉ cho riêng đơn hàng
//     *
//     * @param time
//     * @return
//     */
//    public static boolean checkDayOfForOrder(long time) {
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(new Date(time));
//        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
//        if (dayOfWeek == 7) {
//            if (time > TextUtils.getTime(time, false) + 36000000L) {
//                return true;
//            }
//        }
//        return dayOfWeek == 1;
//
//    }
//
//    /**
//     *
//     * Lấy ngày thứ 2 của tuần
//     *
//     *
//     * @param time
//     * @return
//     */
//    public static long getFirstDayOfWeek(long time) {
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(new Date(time));
//        while (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY) {
//            calendar.add(Calendar.DATE, -1);
//        }
//        return TextUtils.getTime(calendar.getTimeInMillis(), false);
//    }
//
//    public static String validateLinkImageAlicdn(String imageUrl) {
//        if (imageUrl.startsWith("//")) {
//            imageUrl = "https:" + imageUrl;
//        }
//        if (imageUrl.startsWith("http:")) {
//            imageUrl = imageUrl.replaceAll("http:", "https:");
//        }
//        return imageUrl;
//    }
//
//    /**
//     * Convert size image
//     *
//     * @param imageUrl
//     * @param size
//     * @return
//     */
//    public static String adjustImageSize(String imageUrl, int size) {
//        if (!Strings.isNullOrEmpty(imageUrl)) {
//            String newSize = size + "x" + size + ".jpg";
//            imageUrl = imageUrl.replaceAll("(\\d+x\\d+\\.jpg)", newSize);
//        }
//        return imageUrl;
//    }
//
//    public static List<DateFilterFormat> listDayForFilter(int day) {
//        long dateNow = System.currentTimeMillis();
//        DateFormat dateFormat = new SimpleDateFormat("dd/MM");
//        List<DateFilterFormat> dateFilterFormats = new ArrayList();
//        for (int i = 0; i < day; i++) {
//            DateFilterFormat dateFilterFormat = new DateFilterFormat();
//            long dateTimestamp = dateNow - (i * 24 * 60 * 60 * 1000);
//            dateFilterFormat.setDateTimestamp(dateTimestamp);
//            String date = dateFormat.format(dateTimestamp);
//            dateFilterFormat.setDate(date);
//            dateFilterFormats.add(dateFilterFormat);
//        }
//        return dateFilterFormats;
//    }
//
//    /**
//     * Loại bỏ ký tự dạng icon
//     *
//     * @param str
//     * @return
//     */
//    public static String removeIcon(String str) {
//        StringBuilder sb = new StringBuilder();
//        if (!Strings.isNullOrEmpty(str)) {
//            for (int i = 0; i < str.length(); i++) {
//                char ch = str.charAt(i);
//                if (!Character.isHighSurrogate(ch) && !Character.isLowSurrogate(ch)) {
//                    sb.append(ch);
//                }
//            }
//        }
//        return sb.toString();
//    }
//
//    public static long convertToOrderId(String orderId) {
//        long ID = 0;
//        try {
//            if (!Strings.isNullOrEmpty(orderId)) {
//                ID = Long.parseLong(orderId.replaceAll("\\D+", ""));
//            }
//        } catch (Exception e) {
//        }
//        return ID;
//    }
//
//    public static boolean checkNetsaleCustomer(long userId) {
//        long[] arrNetsales = {727544, 176654, 626471, 747309, 516545, 427598, 139658};
//        return LongStream.of(arrNetsales).anyMatch(x -> x == userId);
//    }
//
//    /**
//     * Check tk Netsale Thanh toán 100%
//     *
//     * @param userId
//     * @return 427598 139658
//     */
//    public static boolean checkNetsaleCustomerAllPayment(long userId) {
//        long[] arrNetsales = {727544, 176654, 626471, 747309, 516545};
//        return LongStream.of(arrNetsales).anyMatch(x -> x == userId);
//    }
//
//    /**
//     *
//     * Tính phí ứng vốn
//     *
//     * @param amount
//     * @param createTime
//     * @return
//     */
//    public static long calculatorLendMoneyFee(long amount, long createTime) {
//        double interestRate = 0.02; // lãi suất
//        if (createTime > 1572714000000L) {
//            interestRate = 0.03;
//        }
//        long fee = (long) (amount * interestRate);
//        return (fee < 50000) ? 50000 : fee;
//    }
//
//    public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
//        Map<Object, Boolean> map = new ConcurrentHashMap<>();
//        return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
//    }
//
//    public static long calculatorLendMoneyFeeV2(long amount, long createTime, double depositRatio, LendMoneyConfigOutput lendMoneyConfig) {
//        double interestRate = 0; // lãi suất
//        long fixedFee = 1000000; // Lãi cố định
//        int term = 0; // Kỳ hạn
//        for (LendMoneyConfigConditionOutput condition : lendMoneyConfig.getConditions()) {
//            if (condition.getDepositRatio() == depositRatio) {
//                interestRate = condition.getInterestRate();
//                fixedFee = (long) condition.getFixedFee();
//                term = condition.getTerm();
//                break;
//            }
//        }
////        if (createTime < 1572714000000L) {
////            interestRate = 0.02;
////        }
//        long fee = (long) (amount * ((interestRate / 100) * term));
//        return (fee < fixedFee) ? fixedFee : fee;
//    }
//
//    /**
//     *
//     * Lấy KEY để in nhãn kiện/ vận đơn
//     *
//     * @param object_code
//     * @return
//     */
//    public static String getAuthkeyPrint(String object_code) {
//        return DigestUtils.md5DigestAsHex((object_code + "csfZPr9W1uEj2v8C6mI").getBytes());
//    }
//
//    /**
//     * Crawl - Lấy loại thuộc tính phục vụ cho Crawl
//     *
//     * @param title
//     * @return
//     */
//    public static PropertyType getType(String title) {
//        switch (title) {
//            case "颜色分类":
//            case "颜色":
//                return PropertyType.COLOR;
//            case "image":
//                return PropertyType.IMAGE;
//            case "model":
//                return PropertyType.MODEL;
//            case "尺码":
//            case "尺寸":
//            case "适合身高":
//                return PropertyType.SIZE;
//            case "text":
//                return PropertyType.TEXT;
//            case "版本":
//                return PropertyType.VERSION;
//            case "入耳方式":
//            case "安装方式":
//                return PropertyType.METHOD;
//            case "规格":
//                return PropertyType.SPECIFICATIONS;
//            case "类目":
//                return PropertyType.TYPE;
//            default:
//                return PropertyType.OTHER;
//        }
//    }
//
//    /**
//     * Lấy danh sách trạng thái đơn hàng OrderStatus
//     *
//     * @param source
//     * @param target
//     * @return
//     */
//    public static List<OrderStatus> getOrderStatus(OrderStatus source, OrderStatus target) {
//        Map<Integer, OrderStatus> dataMap = new HashMap<>();
//        List<OrderStatus> dataResult = new ArrayList<>();
//        int sourceId = 0;
//        int targetId = 0;
//        dataMap.put(0, OrderStatus.DEPOSITED);//Đã đặt cọc
//        dataMap.put(1, OrderStatus.ARE_BUYING);//Đang mua hàng
//        dataMap.put(2, OrderStatus.PURCHASED);//Đã mua hàng
//        dataMap.put(3, OrderStatus.SELLER_DELIVERY);//Người bán giao hàng
//        dataMap.put(4, OrderStatus.WAREHOUSE_CHINA);//Kho Trung Quốc
//        dataMap.put(5, OrderStatus.DELIVERING_CHINA_VIETNAM);//Đang vận chuyển TRUNG QUỐC - VIỆT NAM
//        dataMap.put(6, OrderStatus.WAREHOUSE_VIETNAM);//Kho Việt Nam
//        dataMap.put(7, OrderStatus.DELIVERY_REQUIREMENTS);//Yêu cầu giao
//        dataMap.put(8, OrderStatus.DELIVERING_VIETNAM);//Đang giao hàng
//        dataMap.put(9, OrderStatus.DELIVERED);//Đã nhận hàng
//        for (Map.Entry<Integer, OrderStatus> entry : dataMap.entrySet()) {
//            if (entry.getValue().toString().equals(source.name())) {
//                sourceId = entry.getKey();
//            }
//            if (entry.getValue().toString().equals(target.name())) {
//                targetId = entry.getKey();
//            }
//        }
//        if (sourceId != targetId && sourceId < targetId) {
//            for (int i = sourceId + 1; i < targetId + 1; i++) {
//                dataResult.add(dataMap.get(i));
//            }
//        }
//        return dataResult;
//    }
//
//    /**
//     * validate so dien thoai thay doi dau so
//     *
//     * @author namtn@chipo.vn
//     * @param phone
//     * @return true/false
//     */
//    public static boolean validatePhoneNumberNew(String phone) {
//        String validPhone = "(09|08|03)+([0-9]{8})\\b";
//        Pattern pattern = Pattern.compile(validPhone);
//        Matcher matcher = pattern.matcher(phone);
//        return matcher.matches();
//    }
//
//    /**
//     * validate 1 chuỗi string có phải là kiểu số integer
//     *
//     * @author namtn@chipo.vn
//     * @param s
//     * @return true/false
//     */
//    public static boolean isInteger(String s) {
//        try {
//            Integer.parseInt(s);
//            return true;
//        } catch (Exception e) {
//
//        }
//        return false;
//    }
//
//    /**
//     * validate 1 chuỗi string có phải là kiểu số double
//     *
//     * @author namtn@chipo.vn
//     * @param s
//     * @return true/false
//     */
//    public static boolean isDouble(String s) {
//        try {
//            Double.parseDouble(s);
//            return true;
//        } catch (Exception e) {
//        }
//        return false;
//    }
//
//    /**
//     * replace escape string when query search
//     *
//     * @author namtn@chipo.vn
//     * @param s
//     * @return escaped s
//     */
//    public static String escapeStringSQL(String s) {
//        return s.toLowerCase().trim()
//                .replaceAll("%", "\\\\%")
//                .replaceAll("_", "\\\\_");
//    }
//
//    /**
//     * replace escape string when query search
//     *
//     * @author namtn@chipo.vn
//     * @param s
//     * @return escaped s
//     */
//    public static String escapeStringMongo(String s) {
//        return s.trim()
//                .replaceAll("\\*", "\\\\*").replaceAll("\\?", "\\\\?");
//    }
//
//    public static String throwCauseException(Throwable e) {
//        try {
//            if (e != null) {
//                Throwable cause = e.getCause();
//                if (cause != null) {
//                    Throwable causeNext = cause.getCause();
//                    if (causeNext != null) {
//                        return causeNext.getMessage();
//                    }
//                    return cause.getMessage();
//                }
//            }
//            return e.getMessage() == null ? e.toString() : e.getMessage();
//        } catch (Exception ex) {
//            return null;
//        }
//    }
//
//    public static boolean isNumeric(String s) {
//        return s.matches("[0-9]+");
//    }
//
//    /**
//     * Ẩn thông tin
//     *
//     * @param s
//     * @return
//     */
//    public static String hidendText(String s) {
//        if (s.isEmpty()) {
//            return null;
//        }
//        s = s.trim();
//        if (s.length() > 8) {
//            String str = s.substring(0, 4);
//            for (int i = 0; i < s.length() - 8; i++) {
//                str += "*";
//            }
//            str += s.substring(s.length() - 4, s.length());
//            return str;
//        } else {
//            String str = "";
//            if (s.length() < 4) {
//                str = "****";
//            } else {
//                for (int i = 0; i < s.length() - 3; i++) {
//                    str += "*";
//                }
//                str += s.substring(s.length() - 3, s.length());
//            }
//            return str;
//        }
//    }
//
//    /**
//     * Lấy thông tin cấu hình chung cho WEB
//     *
//     *
//     * @param PREFIX_ORDER
//     * @param configType
//     * @return
//     */
//    public static String getGeneralConfig(String PREFIX_ORDER, GeneralConfigType configType) {
//        if (PREFIX_ORDER.equals("NP")) {
//            switch (configType) {
//                case WAREHOUSE_POLICIES_LINK:
//                    return "https://naipot.com/ho-tro/quy-dinh-va-chinh-sach/quy-dinh-va-chinh-sach-luu-kho-hang-hoa/62856574";
//                default:
//                    return "";
//            }
//        } else if (PREFIX_ORDER.equals("PG")) {
//            switch (configType) {
//                case WAREHOUSE_POLICIES_LINK:
//                    return "https://pugo.vn/ho-tro/quy-dinh-va-chinh-sach/thong-bao-ve-quy-dinh-va-chinh-sach-luu-kho-hang-hoa/70312762";
//                default:
//                    return "";
//            }
//        } else if (PREFIX_ORDER.equals("FC")) {
//            switch (configType) {
//                case WAREHOUSE_POLICIES_LINK:
//                    return "https://1faco.com/ho-tro/quy-dinh-va-chinh-sach/quy-dinh-va-chinh-sach-luu-kho-hang-hoa/62856574";
//                default:
//                    return "";
//            }
//        } else if (PREFIX_ORDER.equals("NB")) {
//            switch (configType) {
//                case WAREHOUSE_POLICIES_LINK:
//                    return "https://nextbuy.asia/ho-tro/quy-dinh-va-chinh-sach/quy-dinh-va-chinh-sach-luu-kho-hang-hoa/62856574";
//                default:
//                    return "";
//            }
//        }
//        return "not_found_404";
//    }
//
//    /**
//     * So sánh 2 object, return true nếu bằng nhau theo giá trị trường và thuộc
//     * tính
//     *
//     * @param o1 source
//     * @param o2 target
//     * @return
//     * @throws IllegalAccessException
//     */
//    public static boolean compareTwoObject(Object o1, Object o2) throws IllegalAccessException {
//        if (o1 == null && o2 == null) {
//            return false;
//        }
//        if (o1 == null) {
//            return false;
//        }
//        if (o2 == null) {
//            return false;
//        }
//        Field[] fields = o1.getClass().getDeclaredFields();
//        if (o1.getClass().equals(o2.getClass())) {
//            for (Field field : fields) {
//                field.setAccessible(true);
//                Object source = field.get(o1);
//                Object target = field.get(o2);
//                if (!Objects.equals(source, target)) {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
//
//    public static String encryptAES256(String data, String secretKey) throws Exception {
//        String encrypted = Aes256.encrypt(data, secretKey);
//        return encrypted;
//    }
//
//    public static String encodeHttpBasicAuthentication(String username, String password) {
//        return Base64.getEncoder().encodeToString((username + ":" + password).getBytes());
//    }
//
//    public boolean isJSONValid(String strObject) {
//        try {
//            JSONObject jsonObject = new JSONObject(strObject);
//        } catch (JSONException e) {
//            return false;
//        }
//        return true;
//    }
//
//    /**
//     * Lấy giá trị 1 cookie theo regex trong 1 chuỗi cookie
//     *
//     * @param cookie
//     * @param regex
//     * @return
//     * @throws Exception
//     */
//    public static String getCookieValueFromCookies(String cookie, String regex) throws Exception {
//        Pattern pattern = Pattern.compile(regex);
//        Matcher matcher = pattern.matcher(cookie);
//        if (!matcher.find()) {
//            return null;
//        }
//        String match = matcher.group();
//        return match.substring(match.indexOf("=") + 1);
//    }
//
//    public static int randomRange(int min, int max) {
//        return min + (int) (Math.random() * ((max - min) + 1));
//    }
//
//    public static String escapeUnicodeText(String input) {
//        StringBuilder b = new StringBuilder(input.length());
//        Formatter f = new Formatter(b);
//        for (char c : input.toCharArray()) {
//            if (c < 128) {
//                b.append(c);
//            } else {
//                f.format("\\u%04x", (int) c);
//            }
//        }
//        return b.toString();
//    }
//
//    /**
//     * Lấy chi tiết exception
//     *
//     * @param e
//     * @return
//     */
//    public static String getDetailError(Exception e) {
//        try {
//            StackTraceElement[] stackTrace = e.getStackTrace();
//            StackTraceElement ste = stackTrace[0];
//            for (StackTraceElement stackTraceElement : stackTrace) {
//                if (stackTraceElement.getClassName().contains("vn.chipo") && !stackTraceElement.getClassName().contains("vn.chipo.entity")
//                        && stackTraceElement.getLineNumber() != -1
//                        && !stackTraceElement.getClassName().contains("BaseService")
//                        && !stackTraceElement.getClassName().contains("BaseRepository")
//                        && !stackTraceElement.getClassName().contains("BaseMongoRepository")) {
//                    ste = stackTraceElement;
//                    break;
//                }
//            }
//            String className = ste.getClassName();
//            String methodName = ste.getMethodName();
//            int lineNumber = ste.getLineNumber();
//            String error = "Error at CLASS: " + className + "; METHOD: " + methodName + "; LINE NUMBER: " + lineNumber;
////            error += "; MESSAGE: " + (e.getMessage() == null ? e.toString() : e.getMessage());
//            error += "; MESSAGE: " + throwCauseException(e);
//            return error;
//        } catch (Exception ex) {
//        }
//        return null;
//    }
//
//    public static String convertNameLocation(String locationName) {
//        String name = "";
//        if (locationName.toLowerCase().startsWith("quận")) {
//            name = locationName.substring("quận".length() + 1, locationName.length());
//        }
//        if (locationName.toLowerCase().startsWith("huyện")) {
//            name = locationName.substring("huyện".length() + 1, locationName.length());
//        }
//        if (locationName.toLowerCase().startsWith("thị xã")) {
//            name = locationName.substring("thị xã".length() + 1, locationName.length());
//        }
//        if (locationName.toLowerCase().startsWith("tp.")) {
//            name = locationName.substring("tp.".length() + 1, locationName.length());
//        }
//        if (locationName.toLowerCase().startsWith("phường")) {
//            name = locationName.substring("phường".length() + 1, locationName.length());
//        }
//        if (locationName.toLowerCase().startsWith("xã")) {
//            name = locationName.substring("xã".length() + 1, locationName.length());
//        }
//        if (locationName.toLowerCase().startsWith("thị trấn")) {
//            name = locationName.substring("thị trấn".length() + 1, locationName.length());
//        }
//        if (locationName.toLowerCase().startsWith("thành phố")) {
//            name = locationName.substring("thành phố".length() + 1, locationName.length());
//        }
//        return name;
//    }
//
//    public static boolean isJSONValidObject(String strObject) {
//        try {
//            JSONObject jsonObject = new JSONObject(strObject);
//        } catch (JSONException e) {
//            return false;
//        }
//        return true;
//    }
//
//    /**
//     * Validate a string by regex
//     *
//     * @param input
//     * @param regex
//     * @return
//     */
//    public static boolean validateRegex(String input, String regex) {
//        Pattern pattern = Pattern.compile(regex);
//        Matcher matcher = pattern.matcher(input);
//        return matcher.matches();
//    }
//
//    /**
//     * Trả ra số ngày, số giờ, số phút giữa 2 time
//     *
//     * @param start
//     * @param end
//     * @return
//     */
//    public static String[] getDateDiff(long start, long end) {
//        long diff = end - start;
//        long ddays = diff / (24 * 60 * 60 * 1000);
//        long rest = diff - (ddays * 24 * 60 * 60 * 1000);
//        long dhours = rest / (60 * 60 * 1000);
//        long rest1 = rest - (dhours * 60 * 60 * 1000);
//        long dminutes = rest1 / (60 * 1000);
//        String[] strArr = {ddays + "", dhours + "", dminutes + ""};
//        return strArr;
//    }
//
//    public static String removeSymbols(String text) {
//        text = text.replaceAll("&quot;", "\"");
//        return text;
//    }
//
//    private static final List<String> userAgentDesktopList = Arrays.asList(
//            "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/42.0.2311.135 Safari/537.36 Edge/12.246",
//            "Mozilla/5.0 (X11; CrOS x86_64 8172.45.0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.64 Safari/537.36",
//            "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/601.3.9 (KHTML, like Gecko) Version/9.0.2 Safari/601.3.9",
//            "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.111 Safari/537.36",
//            "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:15.0) Gecko/20100101 Firefox/15.0.1"
//    );
//
//    private static final List<String> userAgentMobileList = Arrays.asList(
//            "Mozilla/5.0 (iPhone; CPU iPhone OS 10_3_1 like Mac OS X) AppleWebKit/603.1.30 (KHTML, like Gecko) Version/10.0 Mobile/14E304 Safari/602.1",
//            "Mozilla/5.0 (Linux; Android 7.0; SM-G930V Build/NRD90M) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.125 Mobile Safari/537.36",
//            "Mozilla/5.0 (Linux; U; Android 4.4.2; en-us; SCH-I535 Build/KOT49H) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30",
//            "Mozilla/5.0 (Linux; Android 7.0; SM-A310F Build/NRD90M) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.91 Mobile Safari/537.36 OPR/42.7.2246.114996",
//            "Mozilla/5.0 (iPhone; CPU iPhone OS 10_3_2 like Mac OS X) AppleWebKit/603.2.4 (KHTML, like Gecko) FxiOS/7.5b3349 Mobile/14F89 Safari/603.2.4",
//            "Mozilla/5.0 (Linux; U; Android 7.0; en-US; SM-G935F Build/NRD90M) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 UCBrowser/11.3.8.976 U3/0.8.0 Mobile Safari/534.30"
//    );
//
//    public static String getRandomUserAgentMobile() {
//        return userAgentMobileList.get(new Random().nextInt(userAgentMobileList.size())) + randomRange(1, 999);
//    }
//
//    public static String getRandomUserAgentDesktop() {
//        return userAgentDesktopList.get(new Random().nextInt(userAgentDesktopList.size())) + randomRange(1, 999);
//    }
//
//    /**
//     * Ẩn thông tin user
//     *
//     * @param info
//     * @return
//     */
//    public static String hideUserInfo(String info) {
//        String hide = "";
//        if (!Strings.isNullOrEmpty(info)) {
//            try {
//                if (info.length() > 5) {
//                    hide = info.substring(0, 5) + "***";
//                } else {
//                    hide = "***";
//                }
//            } catch (Exception e) {
//                hide = "***";
//            }
//        }
//        return hide;
//    }
//
//    /**
//     * Distinct list đối tượng theo thuộc tính
//     *
//     * @param <T>
//     * @param keyExtractor
//     * @return
//     */
//    public static <T> Predicate<T> distinctByObjectProps(Function<? super T, ?> keyExtractor) {
//        Set<Object> seen = ConcurrentHashMap.newKeySet();
//        return t -> seen.add(keyExtractor.apply(t));
//    }
//
//    /**
//     * Mã hóa HMAC-256
//     *
//     * @param data
//     * @param appSecret
//     * @return
//     * @throws Exception
//     */
//    public static String encodeHmac256(String data, String appSecret) throws Exception {
//        String agorithym = "HmacSHA256";
//        Mac mac = Mac.getInstance(agorithym);
//        SecretKeySpec secret_key = new SecretKeySpec(appSecret.getBytes("UTF-8"), agorithym);
//        mac.init(secret_key);
//        String sign = Hex.encodeHexString(mac.doFinal(data.getBytes("UTF-8")));
//        return sign;
//    }
//
//    /**
//     * Sắp xếp thuộc tính Json Object theo thứ tự alphabelt
//     *
//     * @param js
//     * @return
//     */
//    public static JsonObject sortJsonObject(JSONObject js) {
//        Iterator<String> keys = js.keys();
//        List<String> lstKey = new ArrayList<>();
//        while (keys.hasNext()) {
//            String key = keys.next();
//            lstKey.add(key);
//        }
//        Collections.sort(lstKey);
//        JsonObject jsReturn = new JsonObject();
//        for (String string : lstKey) {
//            Object get = js.get(string);
//            if (get instanceof String) {
//                jsReturn.addProperty(string, get.toString());
//            } else if (get instanceof Number) {
//                jsReturn.addProperty(string, (Number) get);
//            } else if (get instanceof Boolean) {
//                jsReturn.addProperty(string, (Boolean) get);
//            } else if (get instanceof JSONObject) {
//                jsReturn.add(string, sortJsonObject((JSONObject) get));
//            } else if (get instanceof JSONArray) {
//                jsReturn.add(string, sortJsonArray((JSONArray) get));
//            }
//        }
//        return jsReturn;
//    }
//
//    /**
//     * Sắp xếp thuộc tính Json Object trong Json Array theo thứ tự alphabelt
//     *
//     * @param jsArr
//     * @return
//     */
//    public static JsonArray sortJsonArray(JSONArray jsArr) {
//        JsonArray arrReturn = new JsonArray();
//        jsArr.forEach(j -> {
//            JSONObject js = (JSONObject) j;
//            Iterator<String> keys = js.keys();
//            List<String> lstKey = new ArrayList<>();
//            while (keys.hasNext()) {
//                String key = keys.next();
//                lstKey.add(key);
//            }
//            Collections.sort(lstKey);
//            JsonObject jsReturn = new JsonObject();
//            for (String string : lstKey) {
//                Object get = js.get(string);
//                if (get instanceof String) {
//                    jsReturn.addProperty(string, get.toString());
//                } else if (get instanceof Number) {
//                    jsReturn.addProperty(string, (Number) get);
//                } else if (get instanceof Boolean) {
//                    jsReturn.addProperty(string, (Boolean) get);
//                } else if (get instanceof JSONObject) {
//                    jsReturn.add(string, sortJsonObject((JSONObject) get));
//                }
//            }
//            arrReturn.add(jsReturn);
//        });
//        return arrReturn;
//    }
//
//    /**
//     * Convert data obj sang 1 data obj khác class
//     *
//     * @param data dữ liệu
//     * @param classExport class cần lấy
//     * @param dateField
//     * @return
//     * @throws Exception
//     */
//    public static Object convertObjectToExportObject(Object data, Class classExport, String... dateField) throws Exception {
//        //lấy các trường trong class export
//        Field[] fields = classExport.getDeclaredFields();
//        //khởi tạo 1 object class export
//        Object e = classExport.newInstance();
//
//        //class của data gốc
//        Class clazz = data.getClass();
//
//        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm dd/MM/yyyy");
//
//        for (Field f : fields) {
//            f.setAccessible(true);
//            //lấy ra trường trong class data gốc
//            Field field = clazz.getDeclaredField(f.getName());
//            field.setAccessible(true);
//            //lấy ra valueclazz.getField(f.getName())
//            Object value = field.get(data);
//            //set vào object class export
//            boolean checkDate = false;
//            for (String date : dateField) {
//                if (date.equalsIgnoreCase(f.getName())) {
//                    checkDate = true;
//                    if (value != null) {
//                        long time = Long.valueOf(value.toString());
//                        if (time > 0) {
//                            String format = sdf.format(new Date(time));
//                            f.set(e, format);
//                        } else {
//                            f.set(e, null);
//                        }
//                    } else {
//                        f.set(e, null);
//                    }
//                    break;
//                }
//            }
//            if (f.get(e) == null && !checkDate) {
//                f.set(e, value == null ? null : value.toString());
//            }
//        }
//        return e;
//    }
//
//    /**
//     * Not support MONTHS AND YEARS
//     * @param from
//     * @param to
//     * @return
//     */
//    public static long calendarDiff(Calendar from, Calendar to) {
//        return ChronoUnit.DAYS.between(from.toInstant(), to.toInstant());
//    }
//}
