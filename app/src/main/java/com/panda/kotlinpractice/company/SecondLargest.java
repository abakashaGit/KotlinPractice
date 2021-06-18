package com.panda.kotlinpractice.company;

public class SecondLargest {
    public static void main(String[] args) {
        printSecondLarge(new int[]{6,9,1,3,2});
    }
    private static void printSecondLarge(int[] arr){
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for (int element:arr) {
            if (element > first){
                second = first;
                first = element;
            }else if(element > second && element != first)
                second = element;

        }
        System.out.println(" "+second);
    }
}
