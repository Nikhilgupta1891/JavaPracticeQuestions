/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practisequestions;

import java.util.Scanner;

/**
 *
 * @author nikhil
 */
public class ShifStringToRight {   
    
    public static void main(String[] args) {
        int[] inputArray = new int[]{8,2,0,4,1,4,2,1,0,6,6};
        Scanner sc = new Scanner(System.in);
        System.out.println("Number of rotations: ");
        int numOfRotations = sc.nextInt();
        rotate(inputArray, numOfRotations);
    }

    public static void rotate(int[] nums, int k) {
        for (int noOfTimeRotated = 1; noOfTimeRotated <= k; noOfTimeRotated++) {
            int temp = nums[0];
            nums[0] = nums[nums.length-1];
            int tempVal;
            for (int i = 1; i < nums.length; i++) {
                tempVal = nums[i];
                nums[i] = temp;
                temp = tempVal;
            }
        }
        for (int eachValueInArr : nums) {
            System.out.print(eachValueInArr);
        }
    }
}
