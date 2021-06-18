package com.panda.kotlinpractice.company;

import java.lang.reflect.Array;
import java.util.Arrays;

public class TestJava {
    public static void main(String[] args) {
        int x = 20;
        String sup = (x<15) ?"small":(x<22)?"tiny":"large";
        System.out.println(sup);

        int result = 0;
        Boolean b1 = new Boolean("TRUE");
        Boolean b2 = new Boolean("true");
        Boolean b3 = new Boolean("tRue");
        Boolean b4 = new Boolean("false");
        if (b1 == b2) result = 1;
        if (b1.equals(b2)) result = result+10;  // true
        if (b2 == b4) result = result+100;//  false
        if (b2.equals(b4)) result = result+1000;//  false
        if (b2.equals(b3)) result = result+10000;  // true
        System.out.println(result);

        /*
        == checks reference
        equals - checks value
        so output is 10010
         */
        int arr1[] = {1,2,3,4};
        int arr2[] = {1,2,3,4};
        System.out.println("arr1.equals(arr2) :"+arr1.equals(arr2)); // checks references so false
        System.out.println("Arrays.equals(arr1,arr2) :"+Arrays.equals(arr1,arr2)); // checks values so true

        System.out.println(check());
    }

    private static int check(){
        try {
            System.out.println("try");
            return 1;
        }catch (Exception e){
            System.out.println("catch");
            return 2;
        }finally { // when final statement executes the return statement from the try and catch overrides
            System.exit(0); // this will exit the execution
            System.out.println("finally");
            return 3;
        }
    }

}


