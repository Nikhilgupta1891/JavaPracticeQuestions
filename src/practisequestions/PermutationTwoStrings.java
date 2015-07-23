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
public class PermutationTwoStrings {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1st String: ");
        String str1 =  sc.next();
        System.out.println("2nd String: ");
        String str2 =  sc.next();
        if(isPermutationViaHashMaps(str1, str2))
            System.out.println("True(via HashMaps)");    
        else
            System.out.println("False(via HashMaps)");
        
        if (sortArray(str1).equals(sortArray(str2))) 
        {
            System.out.println("True(via Arrays)");
        } 
        else 
        {
            System.out.println("False(via Arrays)");
        }
    }

    private static boolean isPermutationViaHashMaps(String str1, String str2) 
    {
        if(str1.length()!=str2.length())
        {
            return false;
        }
        
        HashMap<Character, Integer> hash1 = createHashMapFromString(str1);
        HashMap<Character, Integer> hash2 = createHashMapFromString(str2);
        
        if(hash1.equals(hash2))
        {
            return true;
        }
        else
        {
             return false;
        }
    }

    private static HashMap<Character, Integer> createHashMapFromString(String str) 
    {
        HashMap<Character, Integer> hash = new HashMap<>();
        for(int i=0;i<str.length();i++)
        {
           if(!hash.isEmpty() && hash.keySet().contains(str.charAt(i)))
           {
               Integer count = hash.get(str.charAt(i));
               hash.put(str.charAt(i), count+1);
           }
           else
           {
               hash.put(str.charAt(i), 1);
           }
        }
        return hash;
    }
    
    private static String sortArray(String str)
    {
        char[] inputChar = str.toCharArray();
        java.util.Arrays.sort(inputChar);
        return new String(inputChar);
    }

    
}
