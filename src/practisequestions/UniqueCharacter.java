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
public class UniqueCharacter {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter input string: ");
        
        String inputStr = sc.next();
        //Method 1
        checkUniqueCharacter(inputStr);
        
        //Method 2
        if(hasUniqueCharacter(inputStr))
            System.out.println("Unique");
        else
            System.out.println("Not Unique");
    }
    
    private static boolean hasUniqueCharacter(String str) 
    {
        HashMap<Character, Integer> hash = new HashMap<>(); 
        Boolean isUnique;
        isUnique = true;
        for(int i=0;i<str.length();i++)
        {
            if(hash.keySet().contains(str.charAt(i)))
            {
                isUnique = false;
                return isUnique;
            }
            else
            {
                hash.put(str.charAt(i), 1);
            }
        }
        return isUnique;
   }
    
    private static boolean checkUniqueCharacter(String inputStr) {
        if (inputStr.length() > 256) {
            return false;
        } else {
            boolean[] characterSet = new boolean[256];
            for (int i = 0; i < characterSet.length; i++) {
             //   System.out.println(characterSet[i]);  //All false in the beginning
            }

            for (int i = 0; i < inputStr.length(); i++) {
                char valAtIndex = inputStr.charAt(i);
                if (characterSet[valAtIndex] == true) {
                    //If already true, then break the loop. It's a repeat.
                    System.out.println("Not Unique");
                    return false;
                } else {
                    characterSet[valAtIndex] = true;
                }
            }
            System.out.println("Unique");
            return true;
        }
    }
}
