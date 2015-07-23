/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practisequestions;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author nikhil
 */
public class Anagram {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first string: ");
        String inputStr = sc.next();
        System.out.println("Enter second string: ");
        String secondStr = sc.next();
        anagramMethod1(inputStr, secondStr);
        anagramMethod2(inputStr, secondStr);
    }

    private static void anagramMethod1(String str1, String str2) {
        if (str1.length() == str2.length()) {
            if (sortString(str1).equals(sortString(str2))) {
                System.out.println("Strings " + str1 + " and " + str2 + " are Anagrams");
            } else {
                System.out.println("Strings are not Anagrams");
            }
        } else {
            System.out.println("Strings are not Anagrams");
        }
    }

    private static void anagramMethod2(String str1, String str2) {
        if ((countCharacterOccourance(str1).entrySet()).equals((countCharacterOccourance(str2).entrySet()))) {
            System.out.println("Strings " + str1 + " and " + str2 + " are Anagrams");
        } else {
            System.out.println("Strings are not Anagrams");
        }
    }

    private static HashMap<Character, Integer> countCharacterOccourance(String inputStr) {
        char[] charArray = inputStr.toCharArray();

        HashMap<Character, Integer> hm = new HashMap<>();

        for (char charInString : charArray) {
            if (!hm.containsKey(charInString)) {
                hm.put(charInString, 1);
            } else {
                hm.put(charInString, hm.get(charInString) + 1);
            }
        }
        return hm;
    }

    private static String sortString(String str1) {
        char[] char1 = str1.toCharArray();
        java.util.Arrays.sort(char1);
        return new String(char1);
    }

}
