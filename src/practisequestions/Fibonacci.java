package practisequestions;

import java.util.Scanner;

/**
 * @author nikhil
 */

public class Fibonacci 
{
    
    public static void main(String args[])
    {
        Scanner scanInput = new Scanner(System.in);
        System.out.println("Enter the number you want to input: ");
        int inputNum = scanInput.nextInt();
        
        System.out.println("Fibonacci series using Recursion");
        for(int i=1;i<=inputNum;i++)
        {
            System.out.print(fibRec(i) + " ");
        }
        System.out.println();
        System.out.println("Fibonacci series using loop");
        
        fibLoop(10);
    }  
    
    //Recursive way 
    private static int fibRec(int i)
    {
        if (i==1)
        {
            return 0;
        }
        else if(i==2)
        {
            return 1;
        }
        else
        {
            return (fibRec(i-1) + fibRec(i-2));
        }
    }
    
    //Looping way
    private static void fibLoop(int inputNum) {
        int a = 0;
        int b = 1;
        int next;
        if (inputNum == 1) {
            System.out.print("0 ");
        }

        if (inputNum >= 2) {
            System.out.print("0 ");
            System.out.print("1 ");
        }

        if (inputNum >= 3) {
            for (int i = 3; i <= inputNum; i++) {
                next = a + b;
                System.out.print(next + " ");
                a = b;
                b = next;
            }
        }
    }
}
