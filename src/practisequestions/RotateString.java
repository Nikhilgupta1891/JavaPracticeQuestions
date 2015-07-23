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
public class RotateString 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string you want to rotate: " ) ;
        String str= sc.next();
        
        System.out.println("Number of rotations: ");        
        int numberOfTime = sc.nextInt();
        
        for(int i=0;i<numberOfTime;i++)
        {
            str = rotateStringToRight(str);
        }
        System.out.println(str);
    }

    private static String rotateStringToRight(String str) 
    {        
        StringBuilder sbc = new StringBuilder();
        sbc.append(str.charAt(str.length()-1));
        for(int i=0;i<str.length()-1;i++)
        {
            sbc.append(str.charAt(i));
        }   
        return sbc.toString();
    }
}
