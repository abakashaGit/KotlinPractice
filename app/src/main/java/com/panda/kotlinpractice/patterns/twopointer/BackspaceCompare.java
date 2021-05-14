package com.panda.kotlinpractice.patterns.twopointer;

/*
Given two strings containing backspaces (identified by the character ‘#’), check if the two strings are equal.

Example 1:

Input: str1="xy#z", str2="xzz#"
Output: true
Explanation: After applying backspaces the strings become "xz" and "xz" respectively.
Example 2:

Input: str1="xy#z", str2="xyz#"
Output: false
Explanation: After applying backspaces the strings become "xz" and "xy" respectively.
Example 3:

Input: str1="xp#", str2="xyz##"
Output: true
Explanation: After applying backspaces the strings become "x" and "x" respectively.
In "xyz##", the first '#' removes the character 'z' and the second '#' removes the character 'y'.
 */
public class BackspaceCompare {

    public static boolean compare(String str1, String str2) {
        String str1final = getFinalString(str1);
        String str2final = getFinalString(str2);
        System.out.println(" first String "+str1final+" second String "+str2final);
        if (str1final.equals(str2final)) {
            System.out.println("  true");
            return true;
        }
        System.out.println("  false");
        return false;
    }

    private static String getFinalString(String str){
        if (str.contains("#")){
            int startOfHash = -1;
            int countOfHash = 0;
            for (int i=0; i < str.length(); i++){
                if (str.charAt(i) == '#'){
                    if (startOfHash == -1) startOfHash = i;
                    countOfHash++;
                }
            }
            String finalStr = str.substring(0,startOfHash - countOfHash) + str.substring(startOfHash+countOfHash);
            return finalStr;
        }else {
            return str;
        }
    }

    public static void main(String[] args) {
        compare("xy##z","xzz#");
        compare("xy#z", "xyz#");
        compare("xp#", "xyz##");
        compare("xywrrmp", "xywrrmu#p");
    }
}
