package com.df.reflection;

import com.df.reflection.dto.SonDTO;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

/**
 * @author dongfeng
 */
public class ReflectionMethod {
    private static void testMethod(){
        Class sonDTOClass = SonDTO.class;
        Method[] methods = sonDTOClass.getMethods();
        for(Method method:methods) {
            // 获取并输出方法的访问权限（）
            int modify = sonDTOClass.getModifiers();
            System.out.println(Modifier.toString(modify));
            // 获取并输出返回方法的返回类型
            Class returnType = method.getReturnType();
            System.out.println(returnType.getName()+":"+method.getName());
            // 获取并输出方法的所有参数
            Parameter[] parameters = method.getParameters();
            for (Parameter parameter:parameters) {
                System.out.println(parameter.getType().getName()+":"+parameter.getName());
            }

            // 获取并输出方法抛出的异常
            Class[] exceptionTypes = method.getExceptionTypes();
            if (exceptionTypes.length==0) {
                continue;
            }else {
                for (Class class1:exceptionTypes) {
                    System.out.println("ex:"+class1);
                }
            }
        }

        // 返回一个包含{@code Method}对象的数组，这些对象反映了所有
        // 此{@code代表的类或接口的声明方法
        // Class}对象，包括public，protected，default（包）
        // 访问和私有方法，但不包括继承的方法。
        System.out.println( "AA:"+sonDTOClass.getDeclaredMethods().length);

    }

    /*public static void main(String[] args) {
        testMethod();
    }*/
    public static void main(String[] args) {
       StringBuffer stringBuffer = new StringBuffer();
       for (int i=0;i<1000000;i++){
           stringBuffer.append("111111111111").append(",");
       }
        try {
            System.out.println(stringBuffer.toString().getBytes("utf-8").length/(1024*1024));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
