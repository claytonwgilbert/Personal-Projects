package com.cg.functionalprogramming.challenges;

import java.util.function.Function;
import java.util.function.Supplier;

public class Challenges {
    public static void main(String[] args) {

        //1
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                String myString = "Let's split this up into an array.";
                String[] parts = myString.split(" ");
                for (String s : parts) {
                    System.out.println(s);
                }
            }
        };

        //1 - Converted to a Lambda
        Runnable runnableLambda = () -> {
            String myString = "Let's split this up into an array.";
            String[] parts = myString.split(" ");
            for (String s : parts) {
                System.out.println(s);
            }
        };

        //2A - Converted to Lambda
/*        s -> {
            StringBuilder returnVal = new StringBuilder();
            for(int i = 0; i < s.length(); i++){
                if(i % 2 == 0){
                    returnVal.append(s.charAt(i));
                }
            }
            return returnVal.toString();
        };*/

        //2A - Taking 2 further to get code to run right
        Function<String, String> lambdaFunction = s -> {
            StringBuilder returnVal = new StringBuilder();
            for(int i = 0; i < s.length(); i++){
                if(i % 2 == 0){
                    returnVal.append(s.charAt(i));
                }
            }
            return returnVal.toString();
        };

        //2A - Call lambda and pass in appropriate value
        System.out.println(lambdaFunction.apply("1234567890"));

        //2B - Create method that accepts lambda as parameter and String that returns executed result for display
        String text = "1234567890";
        String result = everySecondChar(lambdaFunction, text);
        System.out.println(result);

        //3 Supplier example
        Supplier<String> iLoveJava = () -> "I Love Java";
        String supplierResult = iLoveJava.get();
        System.out.println(supplierResult);


    }

    //2A
    public static String everySecondChar(String source) {
        StringBuilder returnVal = new StringBuilder();
        for(int i = 0; i < source.length(); i++){
            if(i % 2 == 0){
                returnVal.append(source.charAt(i));
            }
        }
        return returnVal.toString();
    }

    //2B
    public static String everySecondChar(Function<String, String> lambda, String text) {
        return lambda.apply(text);
    }



}
