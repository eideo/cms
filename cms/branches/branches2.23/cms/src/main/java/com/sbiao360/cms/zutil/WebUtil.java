package com.sbiao360.cms.zutil;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sbiao360.cms.base.cons.SystemConstants;

/**
 *
 * @author Lucy Jin Jul 9, 2010
 *
 */
public final class WebUtil {
    private WebUtil(){
    }
    /**
     * get int cookie value.
     * @param cookies cookies
     * @param cookieName cookie name
     * @return
     */

    public static int string2Int(String tmp) {
        int rtn = 0;
        try {
            rtn = Integer.parseInt(tmp);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return rtn;
    }

    public static int getIntCookieValue(Cookie[] cookies, String cookieName){
        int value = 0;
        if (cookies != null && cookies.length > 0) {
            for (int i = 0; i < cookies.length; i++) {
                Cookie c = cookies[i];
                //log.info("expire page cookie===============" + c.getName() + "," + c.getValue());
                if (c.getName().equals(cookieName)) {
                    value = string2Int(c.getValue());
                    break;
                }
            }
        }
        return value;
    }
    /**
     * add cookie to response.
     * @param response http servlet response.
     * @param cookieName cookie name.
     * @param value cookie value.
     * @param path cookie path.
     */
    public static void addCookie(HttpServletResponse response, String cookieName, String value, String path){
        Cookie cookie = new Cookie(cookieName, value);
        cookie.setMaxAge(SystemConstants.COOKIE_MAX_AGE);
        /**
         * Lucy Jin 6/21/2010 add cookie path otherwise it will be lost when switch pages.
         */
        cookie.setPath(path);
        response.addCookie(cookie);
    }
    /**
     * remove cookie from response.
     * @param response http servlet response.
     * @param cookieName cookie name.
     * @param path cookie path.
     */
    public static void removeCookie(HttpServletResponse response, String cookieName, String path){
        Cookie cookie = new Cookie(cookieName, null);
        cookie.setMaxAge(SystemConstants.COOKIE_MIN_AGE);
        cookie.setPath(path);
        response.addCookie(cookie);
    }
    /**
     * Method getFullURL.
     * @param request
     * @param targetURL
     * @return String
     */
    public static String getFullURL(HttpServletRequest request, String targetURL) {
        if (targetURL == null || targetURL.trim().equals("")) {
            return "";
        }
        String s = targetURL.toLowerCase();
        if (s.startsWith("http://")) {
            targetURL = targetURL.substring(7);
        } else if (s.startsWith("https://")) {
            targetURL = targetURL.substring(8);
        }
        String http_prefix = request.isSecure() ? "https://" : "http://";
        String resultURL = http_prefix + targetURL;
        return resultURL;
    }

    public static String EncryptPassword(String password) {
        return MD5.MD5Encode(String.valueOf(hashEncrypt(password)));
    }

    private static int hashEncrypt(String str) {
        int h = 0;
        int offset = 0;
        char val[];
        int len = str.length();

        val = new char[len];
        str.getChars(0, len, val, 0);

        for (int i = 0; i < len; i++) {
            h = 31 * h + val[offset++];
        }
        return h;
    }

    public static NumberFormat getCurrencyFormat(Locale locale) {
        NumberFormat nf = NumberFormat.getCurrencyInstance(locale);
        return nf;
    }

    public static DateFormat getDateTimeFormat(Locale locale) {
        return DateFormat.getDateTimeInstance(
            DateFormat.MEDIUM,
            DateFormat.MEDIUM,
            locale.getCountry().equals(SystemConstants.COUNTRY_CA)
            ? new Locale(locale.getLanguage(), SystemConstants.COUNTRY_US)
            : locale
           );
    }

    public static DateFormat getDateFormat(Locale locale) {
        return DateFormat.getDateInstance(
            DateFormat.LONG,
            locale.getCountry().equals(SystemConstants.COUNTRY_CA)
                ? new Locale(locale.getLanguage(), SystemConstants.COUNTRY_US)
                : locale);
    }

    public static String getFreightValue(BigDecimal freight, Locale locale){
        String value="";
        if ( freight == null ){
            value = SystemConstants.SHIP_FREIGHT_TBD;
        } else {
            value = getCurrencyFormat(locale).format(freight);
        }
        return value;
    }

    public static String getFreightValue(BigDecimal freight, NumberFormat currencyFormat){
        String value="";
        if ( freight == null ){
            value = SystemConstants.SHIP_FREIGHT_TBD;
        } else {
            value = currencyFormat.format(freight);
        }
        return value;
    }

    public static String trimSpecialString(String value) {
        if (value == null) {
            value = "";
        } else {
            value = value.replaceAll("(?<=,^|\\s+)([\\?\\*]+)(?=$|\\s+)", " ").trim();
            String[] keywordParse = parserKeywords(value);
            value = convertArrayToSinglekeyword(keywordParse);
        }
        return value;
    }

    public static String[] parserKeywords(String keyword) {
        if (keyword == null || keyword.trim().length() == 0) {
            return null;
        }
        Matcher m = Pattern.compile("(?<=(?:[\\s\\r\\t\\n,;]+)|(?:^))(-*\"[^\"]*\")(?=(?:[\\s\\r\\t\\n,;]+)|(?:$))")
                .matcher(keyword);
        //The result list
        List<String> result = new ArrayList<String>();
        //The next start index
        int index = 0;
        while (m.find()) {
            int start = m.start();
            String beforeString = keyword.substring(index, start).trim();
            if (beforeString.length() > 0) {
                addKeywordsToResult(beforeString, result);
            }
            String groupStr = m.group(1);
            groupStr = groupStr.replaceAll("\\s+-", " ");
            if (!result.contains(groupStr)) {
                result.add(groupStr);
            }
            index = m.end();
        }
        //Add the other string to list
        if (index < keyword.length()) {
            String lastString = keyword.substring(index, keyword.length()).trim();
            addKeywordsToResult(lastString, result);
        }
        String[] resultArray = new String[result.size()];
        return (String[]) result.toArray(resultArray);
    }

    public static void addKeywordsToResult(String sourceString, List<String> result) {
        String[] splitString = sourceString.split("[\\s\\r\\t\\n,;]+");
        for (int i = 0; i < splitString.length; i++) {
            String str = splitString[i];
            if (!"".equals(str) && !result.contains(str)) {
                result.add(str);
            }
        }
    }

    public static String convertArrayToSinglekeyword(String[] keywordArray) {
        if (keywordArray == null || keywordArray.length == 0) {
            return null;
        } else {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < keywordArray.length; i++) {
                sb.append(keywordArray[i]).append(" ");
            }
            return sb.toString().trim();
        }
    }

    public static String[] splitStr(String parentStr, String delimiter){
		if(parentStr == null || parentStr.trim().equals("") || delimiter == null)
			return null;
		StringTokenizer token= new StringTokenizer(parentStr.trim(), delimiter);
		ArrayList list = new ArrayList();
		for(int i=0; token.hasMoreTokens();i++){
			list.add(i, (String)token.nextToken().trim());
		}
		String[]  array = new String[list.size()];
		for(int i=0; i<list.size(); i++) {
			array[i] = (String) list.get(i);
		}
		return array;
	}


    public static String getLoginSecureURL(HttpServletRequest request, String internalIP){
        StringBuilder result = new StringBuilder();
        result.append("https://");
        String serverName = request.getServerName();
        boolean isPort = false;
        String[] ipList = splitStr(internalIP, ";");
        for ( int i=0; i<ipList.length; i++ ){
            if (serverName.startsWith(ipList[i])){
                isPort = true;
                break;
            }
        }

        result.append(request.getServerName());

        if (isPort) {
            result.append(":");
            result.append("8443");
        }

        String requestURI = request.getRequestURI();
        requestURI = requestURI.replace("home", "login");

        result.append(requestURI);
        return result.toString();
    }

    public static String getExtName(String filePath) {
        String extName = "";
        if (!"".equals(filePath)){
            int i = filePath.lastIndexOf(".");
            if (i >= 0) {
                extName = filePath.substring(i + 1);
            }
        }
        return extName;
    }

    public static String getExternalRedirectURL(HttpServletRequest request, String internalIP, String className, int storeNo){
        StringBuilder result = new StringBuilder();
        result.append("http://");
        String serverName = request.getServerName();
        boolean isPort = false;
        String[] ipList = splitStr(internalIP, ";");
        for ( int i=0; i<ipList.length; i++ ){
            if (serverName.startsWith(ipList[i])){
                isPort = true;
                break;
            }
        }
        result.append(request.getServerName());

        if (isPort) {
            result.append(":");
            result.append("8080");
        }

        String requestURI = request.getRequestURI();
        requestURI = requestURI.replace("external", className);
        result.append(requestURI);
        result.append(SystemConstants.STORE_ID_PREFIX + storeNo);
        return result.toString();
    }
}
