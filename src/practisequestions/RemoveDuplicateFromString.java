/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practisequestions;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author nikhil
 */
public class RemoveDuplicateFromString {
    public static void main(String[] args) {
        Scanner scanInput = new Scanner(System.in);
        System.out.println("Enter the string you want to remove duplicates from");
        String str = scanInput.next();
        System.out.println(reverseString(sortString(removeDuplicates(str))));
    }

    private static String removeDuplicates(String inputStr) {
        StringBuilder sbString = new StringBuilder();
        for (int i = 0; i < inputStr.length(); i++) {
            if (sbString.indexOf(inputStr.substring(i, i + 1)) == -1) {
                sbString.append(inputStr.substring(i, i + 1));
            }
        }
        System.out.println("Final String : " + sbString.toString());
        return sbString.toString();
    }

    private static String sortString(String inputStr) {
        char[] inputChar = inputStr.toCharArray();
        Arrays.sort(inputChar);
        return new String(inputChar);
    }

    private static String reverseString(String inputStr) {
        StringBuilder sc = new StringBuilder(inputStr);
        return (sc.reverse().toString());
    }
}
