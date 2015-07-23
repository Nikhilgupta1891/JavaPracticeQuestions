/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practisequestions;

import java.util.Arrays;

/**
 * @author nikhil
 */
public class MergeTwoStringArrays {
    public static void main(String[] args) {
        String[] arr1 = {"a1", "c4", "a3"};
        String[] arr2 = {"b1", "b2", "b3", "d4", "b5"};
        
        //OTHER CASE
        // String[] arr2 = {"b1", "b2", "b3", "d4", "b5", null, null, null,null};
        
        String[] finalArray = new String[arr1.length + arr2.length];
        
        for(int i=0;i<arr1.length;i++)
        {
            finalArray[i] = arr1[i];
        }
        
        for(int i=arr1.length;i<finalArray.length;i++)
        {
            finalArray[i] = arr2[i-arr1.length];
        }
        
        //Sort two input Arrays
        finalArray = sortArrays(finalArray);
        
       // Arrays.sort(finalArray);
        
        for(String i: finalArray)
        {
            System.out.print(i + " ");
        }
    }

    private static String[] sortArrays(String[] finalArray) {
        for(int i=0;i<finalArray.length-1; i++)
        {
            for(int j=0;j<finalArray.length-1;j++)
            {
                if( finalArray[j].compareTo(finalArray[j+1]) > 0)
                {
                    String temp = finalArray[j];
                    finalArray[j] = finalArray[j+1];
                    finalArray[j+1] = temp;
                }
            }
        }
        return finalArray;
    }
}

