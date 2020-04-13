package com.df.reflection;

import com.df.reflection.dto.SonDTO;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @author dongfeng
 */
public class ReflectionClass {

    private static void getField(){
        // 获取并输出类的名称
        Class sonClass = SonDTO.class;
        System.out.println("类的名称:"+sonClass.getName());

        // 获取所有 public 访问权限的变量 (只能获取属性修饰范围是public的，set和public的暴露是没有用)
        Field[] fields = sonClass.getFields();
        for (Field field:fields) {
            // 获取field的访问类型:public ,protect,private,defalut
            System.out.println(Modifier.toString(field.getModifiers()));

            //
            System.out.println(field.getType().getName()+":"+field.getName());
        }

    }

    public static void main(String[] args) {
        getField();

        System.out.println(aa(0));
       /* long[] a = new long[0];
        System.out.println(a.length);*/
    }

    private static String aa(int count){
        count++;
        if (count==5){
            return "bb";
        }
        aa(count);
        return "aaa";
    }
}
