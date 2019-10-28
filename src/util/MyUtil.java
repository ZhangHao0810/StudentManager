package util;

/**
 * @author ZhangHao
 * @date 2019/10/28 14:35
 * @Description： 学着自己制作工具类.
 */
public class MyUtil {

    /**
     * 判断一个字符串是不是为空.
     *
     * @param s
     * @return  是空,返回true
     */
    public static boolean isEmpty(String s) {
        return s == null || s.length() == 0;
    }
}
