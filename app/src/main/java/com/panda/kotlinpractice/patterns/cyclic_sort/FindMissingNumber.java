package com.panda.kotlinpractice.patterns.cyclic_sort;

public class FindMissingNumber {
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(FindMissingNumber.findMissingNumber(new int[] { 4, 0, 3, 1 }));
        System.out.println(FindMissingNumber.findMissingNumber(new int[] { 8, 3, 5, 2, 4, 6, 0, 1 }));
    }

    private static int findMissingNumber(int[] arr){
        int i = 0;
        while (i < arr.length){
            if (arr[i] < arr.length && arr[i] != i){
                swap(arr,i,arr[i]);
            }else {
                i++;
            }
        }
        for (int j=0; j<arr.length; j++){
            if (arr[j] != j)
                return j;
        }
        return -1;
    }


}


