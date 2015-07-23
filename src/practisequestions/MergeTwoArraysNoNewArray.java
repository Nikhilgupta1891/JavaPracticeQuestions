/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practisequestions;

import java.util.Arrays;

/**
 *
 * @author nikhil
 */
public class MergeTwoArraysNoNewArray {

    public static void main(String[] args) {

        String[] arr1 = new String[]{"c1", "a2", "a1", "c2"};
        String[] arr2 = new String[]{"a3", "a4", null, null, null, null};

        int count = 0;
        for (String i : arr2) {
            if (i != null) {
                count++;
            }
        }

        for (int i = count; i < arr2.length; i++) {
            arr2[i] = arr1[i - count];
        }

        Arrays.sort(arr2);

        for (String i : arr2) {
            System.out.print(i + " ");
        }
    }
}



