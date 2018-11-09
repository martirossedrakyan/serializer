package com.company;

import java.lang.reflect.Field;
import java.util.ArrayList;


public class Main {

    public static void main(String[] args) throws Exception {
        A a = new A();
        serializer(a);
    }

    public static String serializer(Object obj) throws Exception {

        Class c = obj.getClass();
        Field[] fields = c.getDeclaredFields();
        ArrayList<Object> arr = new ArrayList<>();
        for (Field field : fields) {
            if (!field.isAnnotationPresent(Annotation.class)) {
                field.setAccessible(true);
                Object value = field.get(obj);
                arr.add(value);
            }
        }
        String str = "";


        System.out.println("{");
        for (int i = 0; i < arr.size(); i++) {
            str = i+1 + ": "  +arr.get(i)+ ",";
            System.out.println(str);
        }
        System.out.println("}");



        return "S";


    }
}