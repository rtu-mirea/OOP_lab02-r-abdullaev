package com.company;

import java.security.PublicKey;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressions {
    private String text;
    private String REPLACE = ".рус";
    private Pattern pattern1 = Pattern.compile("\\w+\\.(com|ru)");
    private Pattern pattern2 = Pattern.compile("\\.ru");

    public void inputText(String line){ text = line; }
    public String getText(){return text.toString();}

    private String change(String str){
        Matcher m = pattern2.matcher(str);
        str =  m.replaceAll(REPLACE);
        return str;
    }
    public void changDomen(){
        Matcher m = pattern1.matcher(text);
        String buf = "";
        while (m.find()) {
            buf = m.group();
            text = m.replaceFirst(change(buf));
            m = pattern1.matcher(text);
        }
    }
}
