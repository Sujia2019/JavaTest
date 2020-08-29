package Homework;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
        String a="love23next234csdn3423javaeye99992312aaaaaa3124";
        String ax = a.substring(0,10);
        String regEx="[^0-9]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(ax);
        System.out.println( m.replaceAll("").trim());

    }
}
