package com.aldo.javatest.reto1;

public class StringUtil {
    public static boolean isEmpty(String str){
        boolean vacio=true;
        if (str==null){
           return true;
        }
        if(!str.isEmpty()){
           vacio = false;
        }
        if(str.equals("")){
            vacio = true;
        }
        if (str.trim().length() == 0){
            vacio= true;
        }
        return vacio;
    }
}
