package com.df.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jifeng
 * 二分法
 * 时间复杂度为O(logn)
 */
public class Dichotomy {

    public static List<Integer> find(int[] a, int low, int high, int value) {
        List<Integer> list = new ArrayList<>();
         findMid(a,low,high,value,list);
        return list;
    }
    /**
     * 支持有重复数字存在的数组
     * @param a
     * @param low
     * @param high
     * @param value
     * @return
     */
    public static int findMid(int[] a, int low, int high, int value,List<Integer> list) {
        if (low > high) {
            return -1;
        }
        int mid = (low + high) >> 1;
        if (a[mid] == value) {
            list.add(mid);
            findMid(a, mid+1, high, value,list);
           return findMid(a, low, mid - 1, value,list);
        }
        if (a[mid] < value) {
            return findMid(a, mid+1, high, value,list);
        }
        if (a[mid] > value) {
            return findMid(a, low, mid - 1, value,list);
        }
        return -1;
    }

    /**
     * 支持有不重复数字存在的数组
     * @param a
     * @param low
     * @param high
     * @param value
     * @return
     */
    public static int findNoRepeat(int[] a, int low, int high, int value) {
        return findMid(a,low,high,value);
    }
    public static int findMid(int[] a, int low, int high, int value) {
        if (low > high) {
            return -1;
        }
        int mid = (low + high) >> 1;
        if (a[mid] == value) {
            return mid;
        }
        if (a[mid] < value) {
            return findMid(a, mid+1, high, value);
        }
        if (a[mid] > value) {
            return findMid(a, low, mid - 1, value);
        }
        return -1;
    }

    /**
     * 查找第一个值等于给定值的元素
     * @param a
     * @param low
     * @param high
     * @param value
     * @return
     */
    public static int findFirstValue(int[] a, int low, int high, int value) {
        if (low > high) {
            return -1;
        }
        int mid = (low + high) >> 1;
        if (a[mid] < value) {
            return findFirstValue(a, mid+1, high, value);
        }
        if (a[mid] > value) {
            return findFirstValue(a, low, mid - 1, value);
        }
        // 第一个是指定值，那肯定是，中间值前一个不是指定值，那肯定就是值
        if (mid==0|| a[mid-1]!=value) {
            return mid;
        } else {
            return findFirstValue(a, low, mid - 1, value);
        }
    }


    /**
     * 查找最后一个值等于给定值的元素
     * @param a
     * @param low
     * @param high
     * @param value
     * @return
     */
    public static int findLastValue(int[] a, int low, int high, int value) {
        if (low > high) {
            return -1;
        }
        int mid = (low + high) >> 1;
        if (a[mid] < value) {
            return findFirstValue(a, mid+1, high, value);
        }
        if (a[mid] > value) {
            return findFirstValue(a, low, mid - 1, value);
        }
        // 最后一个是指定值，那肯定是，中间值后一个不是指定值，那肯定就是值
        if (mid==high-1||a[mid+1]!=value) {
            return mid;
        } else {
            return findLastValue(a, mid+1, high, value);
        }
    }

    /**
     * 查找第一个大于等于给定值的元素
     * @param a
     * @param low
     * @param high
     * @param value
     * @return
     */
   /* public static int findFristMoreThanValue(int[] a, int low, int high, int value) {
       while (low<=high) {
           int mid = (low + high) >> 1;
           if (a[mid]>value) {

           }
       }
    }
*/
    public static void main(String[] args) {
        // 支持有重复数字存在的数组
        //int[] a = {1,2,2,2,2,2,2,2,9,10,11,12,13,14,15,16};
      /*  System.out.println( find(a,0,a.length-1,2));

        // 支持有不重复数字存在的数组
        int[] b = {1,2,9,10,11,12,13,14,15,16};
        System.out.println( findNoRepeat(b,0,b.length-1,2));*/

        // 查找第一个值等于给定值的元素
        //System.out.println(findFirstValue(a,0,a.length-1,2));

        // 查找最后一个值等于给定值的元素
        //System.out.println(findLastValue(a,0,a.length-1,2));
        int[] c = {1,2,3,3,3,3,3,3,9,10,11,12,13,14,15,16};
        // 查找第一个大于等于给定值的元素
        //System.out.println(findFristMoreThanValue(c,0,c.length-1,2));
    }
}
