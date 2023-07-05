//package com.web.webproject.util;
//
//import com.google.common.base.Strings;
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.safety.Whitelist;
//import javax.servlet.ReadListener;
//import javax.servlet.ServletInputStream;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletRequestWrapper;
//import java.io.*;
//import java.nio.charset.Charset;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.Map;
//
///**
// *
// * @author PhuongDT
// */
//public class XssHttpServletRequestWrapper extends HttpServletRequestWrapper {
//
//    private HttpServletRequest orgRequest = null;
//    private static final Whitelist whitelist = Whitelist.basic();
//
//    private static final Document.OutputSettings outputSettings = new Document.OutputSettings().prettyPrint(false);
//
//    public XssHttpServletRequestWrapper(HttpServletRequest request) {
//        super(request);
//        orgRequest = request;
//
//    }
//
//    @Override
//    public ServletInputStream getInputStream() throws IOException {
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(orgRequest.getInputStream(), "UTF8"));
//        String result = "";
//        String sb = "";
//        String line = "";
//        while ((line = br.readLine()) != null) {
//            sb += line;
//        }
//        if (!Strings.isNullOrEmpty(sb)) {
//            result += clean(sb);
//            result = result.replace("&amp;", "&");
//            result = TextUtils.removeIcon(result);
//
//        }
//        return new WrappedServletInputStream(new ByteArrayInputStream(result.getBytes(Charset.forName("UTF-8"))));
//    }
//
//    @Override
//    public String getParameter(String name) {
//        if (("content".equals(name) || name.endsWith("WithHtml"))) {
//            return super.getParameter(name);
//        }
//        name = clean(name);
//        String value = super.getParameter(name);
//        if (!Strings.isNullOrEmpty(value)) {
//            value = clean(value);
//        }
//        return value;
//    }
//
//    @Override
//    public Map getParameterMap() {
//        Map map = super.getParameterMap();
//        Map<String, String> returnMap = new HashMap<String, String>();
//        Iterator entries = map.entrySet().iterator();
//        Map.Entry entry;
//        String name = "";
//        String value = "";
//        while (entries.hasNext()) {
//            entry = (Map.Entry) entries.next();
//            name = (String) entry.getKey();
//            Object valueObj = entry.getValue();
//            if (null == valueObj) {
//                value = "";
//            } else if (valueObj instanceof String[]) {
//                String[] values = (String[]) valueObj;
//                for (int i = 0; i < values.length; i++) {
//                    value = values[i] + ",";
//                }
//                value = value.substring(0, value.length() - 1);
//            } else {
//                value = valueObj.toString();
//            }
//            returnMap.put(name, clean(value).trim());
//        }
//        return returnMap;
//    }
//
//    @Override
//    public String[] getParameterValues(String name) {
//        String[] arr = super.getParameterValues(name);
//        if (arr != null) {
//            for (int i = 0; i < arr.length; i++) {
//                arr[i] = clean(arr[i]);
//            }
//        }
//        return arr;
//    }
//
//    @Override
//    public String getHeader(String name) {
//
//        name = clean(name);
//        String value = super.getHeader(name);
//        if (!Strings.isNullOrEmpty(value)) {
//            value = clean(value);
//        }
//        return value;
//    }
//
//    public HttpServletRequest getOrgRequest() {
//        return orgRequest;
//    }
//
//    public static HttpServletRequest getOrgRequest(HttpServletRequest req) {
//        if (req instanceof XssHttpServletRequestWrapper) {
//            return ((XssHttpServletRequestWrapper) req).getOrgRequest();
//        }
//
//        return req;
//    }
//
//    public String clean(String content) {
//        String result = Jsoup.clean(content, "", whitelist, outputSettings);
//        return result;
//    }
//
//    private class WrappedServletInputStream extends ServletInputStream {
//
//        public void setStream(InputStream stream) {
//            this.stream = stream;
//        }
//
//        private InputStream stream;
//
//        public WrappedServletInputStream(InputStream stream) {
//            this.stream = stream;
//        }
//
//        @Override
//        public int read() throws IOException {
//            return stream.read();
//        }
//
//        @Override
//        public boolean isFinished() {
//            return true;
//        }
//
//        @Override
//        public boolean isReady() {
//            return true;
//        }
//
//        @Override
//        public void setReadListener(ReadListener readListener) {
//
//        }
//    }
//}
