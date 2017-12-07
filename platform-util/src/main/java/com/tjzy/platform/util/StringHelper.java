package com.tjzy.platform.util;

import org.apache.commons.lang3.StringUtils;

import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by lizhe on 2017/12/6 0006.
 * 目标定在月亮之上，即使失败，也可以落在众星之间。
 */
public class StringHelper extends StringUtils{

    /**
     * 字符连接符
     */
    private static final char SEPARATOR = '_';
    /**
     * 默认编码
     */
    private static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");

    /**
     * 转换为字节数组
     *
     * @param str 字符串
     * @return byte[] byte [ ]
     */
    public static byte[] getBytes(String str) {
        if (str == null) {
            throw new NullPointerException("str cannot be null");
        }
        return str.getBytes(DEFAULT_CHARSET);
    }

    /**
     * 转换为字节数组
     *
     * @param bytes 字节数组
     * @return String string
     */
    public static String toString(byte[] bytes) {
        return new String(bytes, DEFAULT_CHARSET);
    }

    /**
     * 是否包含字符串
     *
     * @param str  验证字符串
     * @param strs 字符串组
     * @return 包含返回true boolean
     */
    public static boolean inString(String str, String... strs) {
        if (str != null) {
            for (String s : strs) {
                if (str.equals(trim(s))) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 替换掉HTML标签方法
     *
     * @param html the html
     * @return the string
     */
    public static String replaceHtml(String html) {
        if (isBlank(html)) {
            return "";
        }
        String regEx = "<.+?>";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(html);
        return m.replaceAll("");
    }

    /**
     * 驼峰命名法工具
     *
     * @param s the s
     * @return String  toCamelCase("hello_world") == "helloWorld" toCapitalizeCamelCase("hello_world") == "HelloWorld" toUnderScoreCase("helloWorld") = "hello_world"
     */
    public static String toCamelCase(String s) {
        if (s == null) {
            return null;
        }

        String ls = s.toLowerCase();

        StringBuilder sb = new StringBuilder(ls.length());
        boolean upperCase = false;
        for (int i = 0; i < ls.length(); i++) {
            char c = ls.charAt(i);

            if (c == SEPARATOR) {
                upperCase = true;
            } else if (upperCase) {
                sb.append(Character.toUpperCase(c));
                upperCase = false;
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    /**
     * 驼峰命名法工具
     *
     * @param s the s
     * @return String  toCamelCase("hello_world") == "helloWorld" toCapitalizeCamelCase("hello_world") == "HelloWorld" toUnderScoreCase("helloWorld") = "hello_world"
     */
    public static String toCapitalizeCamelCase(String s) {
        if (s == null) {
            return null;
        }
        String cs = toCamelCase(s);
        return cs.substring(0, 1).toUpperCase() + cs.substring(1);
    }

    /**
     * 驼峰命名法工具
     *
     * @param s the s
     * @return String  toCamelCase("hello_world") == "helloWorld" toCapitalizeCamelCase("hello_world") == "HelloWorld" toUnderScoreCase("helloWorld") = "hello_world"
     */
    public static String toUnderScoreCase(String s) {
        if (s == null) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        boolean upperCase = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            boolean nextUpperCase = true;

            if (i < (s.length() - 1)) {
                nextUpperCase = Character.isUpperCase(s.charAt(i + 1));
            }

            if ((i > 0) && Character.isUpperCase(c)) {
                if (!upperCase || !nextUpperCase) {
                    sb.append(SEPARATOR);
                }
                upperCase = true;
            } else {
                upperCase = false;
            }

            sb.append(Character.toLowerCase(c));
        }

        return sb.toString();
    }

    /**
     * Trim to default string.
     *
     * @param str          字符串
     * @param defaultValue 默认值
     * @return String string
     */
    public static String trimToDefault(final String str, String defaultValue) {
        final String ts = trim(str);
        return isEmpty(ts) ? defaultValue : ts;
    }

    /**
     * 一次性判断多个或单个对象为空。
     *
     * @param objects
     * @author ztt
     * @return 只要有一个元素为Blank，则返回true
     */
    public static boolean isBlank(Object... objects) {
        Boolean result = false;
        for (Object object : objects) {
            if (null == object || "".equals(object.toString().trim()) || "null".equals(object.toString().trim())) {
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * 一次性判断多个或单个对象不为空。
     *
     * @param objects
     * @author ztt
     * @return 只要有一个元素不为Blank，则返回true
     */
    public static boolean isNotBlank(Object... objects) {
        return !isBlank(objects);
    }

    public static boolean isBlank(String... objects) {
        Object[] object = objects;
        return isBlank(object);
    }

    public static boolean isNotBlank(String... objects) {
        Object[] object = objects;
        return !isBlank(object);
    }

    public static boolean isBlank(String str) {
        Object object = str;
        return isBlank(object);
    }

    public static boolean isNotBlank(String str) {
        Object object = str;
        return !isBlank(object);
    }

    /**
     * 对象是否为无效值
     * @param obj 要判断的对象
     * @return 是否为有效值(不为null 和 ""字符串)
     */
    public static boolean isNullOrEmpty(Object obj) {
        return obj == null || "".equals(obj.toString());
    }

    /**
     * 将字符串的第一位转为小写
     * @param str 需要转换的字符串
     * @return 转换后的字符串
     */
    public static String toLowerCaseFirstOne(String str) {
        if (Character.isLowerCase(str.charAt(0))) {
            return str;
        } else {
            char[] chars = str.toCharArray();
            chars[0] = Character.toLowerCase(chars[0]);
            return new String(chars);
        }
    }

    /**
     * 将字符串的第一位转为大写
     * @param str 需要转换的字符串
     * @return 转换后的字符串
     */
    public static String toUpperCaseFirstOne(String str) {
        if (Character.isUpperCase(str.charAt(0))) {
            return str;
        } else {
            char[] chars = str.toCharArray();
            chars[0] = Character.toUpperCase(chars[0]);
            return new String(chars);
        }
    }

    /**
     * 下划线命名转为驼峰命名
     * @param str 下划线命名格式
     * @return 驼峰命名格式
     */
    public static String underScoreCase2CamelCase(String str) {
        if (!str.contains("_")) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        char[] chars = str.toCharArray();
        boolean flag = false;
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (ch == '_') {
                flag = true;
            } else {
                if (flag) {
                    sb.append(Character.toUpperCase(ch));
                    flag = false;
                } else {
                    sb.append(ch);
                }
            }
        }
        return sb.toString();
    }

    /**
     * 驼峰命名转为下划线命名
     * @param str 驼峰命名格式
     * @return 下划线命名格式
     */
    public static String camelCase2UnderScoreCase(String str) {
        StringBuilder sb = new StringBuilder();
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (Character.isUpperCase(ch)) {
                sb.append("_").append(Character.toLowerCase(ch));
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
