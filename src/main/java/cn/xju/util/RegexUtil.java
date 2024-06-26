package cn.xju.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class RegexUtil {

    /**
     * 判断Email合法性
     *
     * @param email
     * @return
     */
    public static boolean isEmail(String email) {
        if (email == null) {
            return false;
        }
        String rule = "[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?";
        Pattern pattern = Pattern.compile(rule);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    /**
     * 是否为合法身份证号码
     * @param idCard
     * @return
     */
    public static boolean isIdCard(String idCard) {
        if(idCard == null) {
            return false;
        }
        return idCard.length() == 15 || idCard.length() == 18;
    }

    public static List<String> getImgSrc(String htmlStr) {
        String img = "";
        Pattern imgPattern;
        Matcher imgMatcher;
        List<String> pics = new ArrayList<>();
        String imgReg = "<img.*src\\s*=\\s*(.*?)[^>]*?>";
        imgPattern = Pattern.compile(imgReg, Pattern.CASE_INSENSITIVE);
        imgMatcher = imgPattern.matcher(htmlStr);
        while (imgMatcher.find()) {
            img = img + "," + imgMatcher.group();
            Matcher m = Pattern.compile("src\\s*=\\s*\"?(.*?)(\"|>|\\s+)").matcher(img);
            while (m.find()) {
                pics.add(m.group(1));
            }
        }
        return pics;
    }

    public static void main(String[] args) {
        String pattern = "\\.\\w*";
            Pattern r = Pattern.compile(pattern);  
            Matcher m = r.matcher("sadf.jpeg");  
            if(m.find()){
                String suffix= m.group();
                System.out.println(suffix);
    }
            }
            
            
}
