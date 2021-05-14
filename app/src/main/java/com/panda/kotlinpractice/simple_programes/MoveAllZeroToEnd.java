package com.panda.kotlinpractice.simple_programes;

/*
Given an array of random numbers, Push all the zero’s of a given array to the end of the array.
Input :  arr[] = {1, 2, 0, 4, 3, 0, 5, 0};
Output : arr[] = {1, 2, 4, 3, 5, 0, 0};

 */
public class MoveAllZeroToEnd {
    private static int[] moveAllZeroToEnd(int arr[]){
        int nextNonZeroPosition =0;
        for (int i = 0; i < arr.length; i++){
            if (i != arr.length-1 && arr[i] == 0){
                nextNonZeroPosition = i+1;
                while (nextNonZeroPosition < arr.length && arr[nextNonZeroPosition] == 0){
                    nextNonZeroPosition++;
                    if (nextNonZeroPosition == arr.length -1 && arr[nextNonZeroPosition] != 0){
                        swap(arr,i,nextNonZeroPosition);
                        return arr;
                    }
                }
            if (nextNonZeroPosition != arr.length ) // if the nextNonZeroPosition reaches last then
                // there is no need to swap because there is no non zero element
                swap(arr,i,nextNonZeroPosition);

            }
        }

        return arr;
    }
    private static int[] moveAllZeroToEndOptimised(int arr[]){
        int nextNonZeroIndex = 0;
        for (int i=0 ; i < arr.length ; i++) {
            if (arr[i] != 0) {
                arr[nextNonZeroIndex++] = arr[i];
            }
        }
            while (nextNonZeroIndex < arr.length ){
                arr[nextNonZeroIndex++] = 0;
            }

        return arr;
    }


    public static void main(String[] args) {
        // 1, 2, 0, 0, 0, 3, 6
        int[] output = moveAllZeroToEndOptimised(new int[]{ 0,1,1,1,1,1,0});
        for (int i:output) {
            System.out.print(" "+i);
        }

    }
    private static void swap(int[] arr, int i, int nextNonZeroPosition) {
        int temp = arr[i];
        arr[i] = arr[nextNonZeroPosition];
        arr[nextNonZeroPosition] = temp;
    }
}
