package com.my.demo.arithmetic_topic;

/**
 * @author: ZhangZhiLe
 * @date: Created in 2018/11/13 16:49
 */
public class EmptyReplace {

    public static String relpace(String str,String replace){
        int index=0;
        StringBuilder stringBuilder=new StringBuilder();
        while (index<str.length()){
            String substring = str.substring(index, index+1);
            if (substring.equals(" ")){
                stringBuilder.append(replace);
            }else{
                stringBuilder.append(substring);
            }
            index++;
        }
        return stringBuilder.toString();
    }

    public static String replaceSpace(StringBuffer str){
        String replace = "%20";
        int index=0;
        StringBuilder stringBuilder=new StringBuilder();
        while (index<str.length()){
            String substring = str.substring(index, index+1);
            if (substring.equals(" ")){
                stringBuilder.append(replace);
            }else{
                stringBuilder.append(substring);
            }
            index++;
        }
        return stringBuilder.toString();
    }

  /*  public static void main(String[] args) {
        System.out.println(relpace("My name is  zzl","##"));
        System.out.println(replaceSpace(new StringBuffer("hello world")));
    }*/

    public static void main(String[] args) {
        Singleton singleton = Singleton.getSingleton();
        System.out.println(singleton);
    }
}
