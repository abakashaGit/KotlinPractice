package com.panda.kotlinpractice.leetcode;

public class LongestPalindromeSubstring {

    private static String longestPalindrome(String s) {
        String maxSubString = "";
        int maxStringLength = 0;
        if (s == null) return "";
        int length = s.length();
        if (length < 1) return s;
        if (length == 2 && s.charAt(0) != s.charAt(1)){
            return String.valueOf(s.charAt(0));
        }
        for (int i = 0; i < length; i++) {
            if (length%2 != 0 ) { //implementation for odd length
                int l = i, r = i;
                while (l >= 0 && r < length && s.charAt(l) == s.charAt(r)) {
                    if (r - l + 1 > maxStringLength) {
                        maxStringLength = r - l + 1;
                        maxSubString = s.substring(l, r + 1);
                    }
                    l--;
                    r++;
                }

            }else{ // implementation for even length
                int l = i, r = i+1;
                while (l >= 0 && r < length && s.charAt(l) == s.charAt(r)) {
                    if (r - l + 1 > maxStringLength) {
                        maxStringLength = r - l + 1;
                        maxSubString = s.substring(l, r + 1);
                    }
                    l--;
                    r++;
                }
            }

        }
        return maxSubString;
    }


    // The code will not work without analysing I tried to apply two pointer pattern
    // ----Not Work---
//    private static String longestPalindrome(String s) {
//        int length = s.length();
//        if(length <= 1 || isPalindrom(s)) return s;
//
//        int p1 = 0, p2 = 0;
//        String longestPalString = "";
//        while(p2 < length-1){
//            String subString = s.substring(p1,p2);
//            if(isPalindrom(subString)) {
//                longestPalString = (longestPalString.length() > subString.length()) ? longestPalString : subString;
//            }
//            if (p2 == length-1){
//                p1++;
//                continue;
//            }
//            p2++;
//
//        }
//        return longestPalString;
//
//    }
//    private static boolean isPalindrom(String str){
//        StringBuilder sb = new StringBuilder(str);
//        sb.reverse();
//        return str.contentEquals(sb.toString());
//    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("dff"));
    }
}
