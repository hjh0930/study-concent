package com.df.thread;

import com.sun.deploy.util.StringUtils;

import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test  {
   /* public static void main(String[] args) {
        String a = "caa1bbb";
        String prefix = "a";
        String suffix = "b";
        if (a.startsWith(prefix)) {
            String s = a.substring(prefix.length());
            System.out.println(s);
        }
        if (a.endsWith(suffix)) {
            String c = a.substring(0,a.length()-suffix.length());
            System.out.println(c);
        }
        Calendar cal = Calendar.getInstance();
        int month = cal.get(Calendar.MONTH )+1;
        System.out.println(month);
    }*/
   public static void main(String[] args) {
/*
       StringBuilder str = new StringBuilder("Tutorial");
       System.out.println("string = " + str);

       // insert character value at offset 8
       str.insert(str.length()-1, 's');

       // prints StringBuilder after insertion
       System.out.print("After insertion = ");
       System.out.println(str.toString());*/


      String[] aaa = new String[]{"1","2","3"};
      List<String> ids = Stream.of(aaa).collect(Collectors.toList());
      ids.add("4");
      System.out.println(ids);
   }
}
