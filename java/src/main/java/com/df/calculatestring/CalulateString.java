package com.df.calculatestring;

import sun.jvm.hotspot.debugger.linux.LinuxDebugger;

/**
 * @author dongfeng
 */
public class CalulateString {

    public static void reverseString (){
        String a = "hello";
        char[] c  =  a.toCharArray();
        char[] b = new char[c.length];
        int count = 0;
        for (int i = c.length-1;i>=0;i--) {
            b[count] = c[i];
            count++;
        }
        String string = new String(b);
        System.out.println(string);
    }

    public static String getLargePrefix (String[] strs){
        String[] a = new String[]{"flower","flow","flight"};

        String prefix = strs[0];
        int count = strs.length;
        for (int i = 1;i<count;i++) {
            prefix =  longestCommonPrefix(prefix,strs[i]);
        }
        return prefix;
    }

    /**
     * 获取公共的前缀
     * @param str1
     * @param str2
     * @return
     */
    public static String longestCommonPrefix (String str1,String str2) {
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0,index);
    }



    public  static String longestPalindrome (String s) {
        int start = 0;int end = 0;
        for (int i= 0;i<s.toCharArray().length;i++) {
           int len1 =  expandAroundCenter(s,i,i);
           int len2 = expandAroundCenter(s,i,i+1);
           int len = Math.max(len1,len2);
           // 如果之前的回文数大于之前的回文数
            if (len>end-start){
                start = i-(len-1)/2;
                end = i+len/2;
            }
        }
        return s.substring(start,end+1);
    }
    /**
     * 中心扩散获取某个回文树
     * @param str1
     * @param left
     * @param right
     * @return
     */
    public static int expandAroundCenter(String str1,int left,int right) {
        while (left > 0 && right < str1.toCharArray().length - 1 && str1.charAt(left) == str1.charAt(right)) {
            --left;
            ++right;
        }
        return right-left-1;
    }


    /**
     * 最长回文串
     * @param args
     */

    public static void main(String[] args) {
        // 反转字符串
        reverseString();

        //System.out.println( getLargePrefix(new String[]{"flower","flow","flight"}));

        System.out.println(longestPalindrome("abcdcbf"));
    }
}
