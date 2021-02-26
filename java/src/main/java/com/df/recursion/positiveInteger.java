package com.df.recursion;

/**
 * @author dongfeng
 */
public class positiveInteger {
    /**
     * 倒叙输出
     */
    public static void index(int count){
        System.out.print(count%10);
        if (count > 10){
            index(count/10);
        }
    }
    /**
     * 汉诺塔
     *      有柱子 x z y，最终将x上的n个圆盘借助z移动到y上
     *      递归思想：
     *          1.将x上的n-1个放入到z上，借助y
     *          2.将x上的n圆盘放到y上
     *          3.将z上的n-1个圆盘放入y
     */
    public static void hanoi(int n,char from,char tmp ,char to){
        if (n>0) {
            hanoi(n-1,from,to,tmp);
            System.out.println("从"+from+"移动"+to+"|n："+n);
            hanoi(n-1,tmp,from,to);
        }

    }

    public static void main(String[] args) {
        index(12345);
    }
}
