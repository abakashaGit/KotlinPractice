package com.panda.kotlinpractice.patterns.twopointer;

public class DutchNationalFlag {

    public static void sort(int[] arr) {
       int pos=0;
       for (int i = 0; i < arr.length; i++){ // loop is to find all zeros and swap it with the pos.
           if (arr[i] == 0){
               if (pos == i){
               }else{
                   swap(arr,pos,i);
               }
               pos++;
           }
       }
        for (int j = pos; j < arr.length; j++){// find all ones and swap it with position
            if (arr[j] == 1){
                if (pos == j){
                }else{
                    swap(arr,pos,j);
                }
                pos++;
            }
        }
        for (int e:arr) {
            System.out.print(" "+e);
        }
    }
    private static void swap(int[] arr,int p1,int p2){
        int temp = arr[p1];
        arr[p1] = arr[p2];
        arr[p2] = temp;
    }

    public static void main(String[] args) {
        sort(new int[]{1, 0, 2, 1, 0});
        System.out.println("");
        sort(new int[]{2, 2, 0, 1, 2, 0});
        System.out.println("");
        sort(new int[]{0,0,0,2, 2, 0, 1, 2, 0});
        System.out.println("");
        sort(new int[]{2, 2, 0, 1, 2, 0,0,0,0});
        System.out.println("");
        sort(new int[]{0,0,0,1,2,2,2});
    }
}
