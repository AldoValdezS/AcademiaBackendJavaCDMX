package com.aldo.javatest.reto2;

public class FizzBuzz {
    public String fizzBuzz(int i) {
        boolean dividido=false;
        String result ="";

        if(i%3==0){
            result+= "Fizz";
            dividido=true;
        }
        if (i%5==0){
            result+="Buzz";
            dividido=true;
        }
        if (!dividido){
            result+=i;
        }
        return result;
    }
}
