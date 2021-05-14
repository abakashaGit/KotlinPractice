package com.panda.kotlinpractice.patterns.sliding_window;

public class PermutationInString {
    public static boolean findPermutation(String str, String pattern) {
        int sumOfAsciiValue = calculateSumOfAscii(pattern);
        int sumOfCurrentAsciiValue = 0;
        int startIndex = 0;
        for (int i = 0 ;i < str.length(); i++){
            char c = str.charAt(i); // get the current char
            if (!pattern.contains(String.valueOf(c))){ // check if the pattern does not contains the
                // char, if does not contain then increment the start index and re-initialize the current sum
                startIndex ++;
                sumOfCurrentAsciiValue = 0;
            }else{
                sumOfCurrentAsciiValue += (int)c; // add to the current sum
                if (i - startIndex +1 == pattern.length()){ // check if length of pattern elements are added
                    if (sumOfAsciiValue == sumOfCurrentAsciiValue){ // check if the sum is equal to actual sum
                        return true;
                    }else {
                        startIndex = i;
                        sumOfCurrentAsciiValue = (int)c;
                        // as the pattern is not found change the start index and assign the current
                        // sume to the current index char ascci or it will be neglected
                    }
                }
            }
        }
        return false;
    }

    /*
    Another solution can be done with hashmap
     */

    public static void main(String[] args) {
        //System.out.println(" oidbcaf , abc "+findPermutation("oidbcaf","abc"));
        //System.out.println(" odicf , dc "+findPermutation("odicf","dc"));
        //System.out.println(" bcdxabcdy , bcdxabcdy "+findPermutation("bcdxabcdy","bcdxabcdy"));
        System.out.println(" aaacb , abc "+findPermutation("aaacb","abc"));
    }
    private static int calculateSumOfAscii(String patternString){ // works
        int sum = 0;
        for (char c:patternString.toCharArray()) {
            sum += (int)c;
        }
        return sum;
    }
}


