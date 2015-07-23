/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Root {

    public static void main(String args[]) {
        //fibo(6);
        rabbitFibo(3);
    }

    public static double rabbitFibo(int n) {
        double root13 = Math.sqrt(13);
      //  int n =6;

        double A = Math.pow((-1 - root13) / 2, n);
        double B = Math.pow((-1 + root13) / 2, n);

        double ans = (1 / root13) * (A - B);

        System.out.println(n + "----" + ans);
        return ans;
    }

    public static double fibo(int n) {
        double root5 = Math.sqrt(5);
       // int n =6;

        double A = Math.pow((1 + root5) / 2, n + 1);
        double B = Math.pow((-1 - root5) / 2, n + 1);

        double ans = (1 / root5) * (A - B);

        System.out.println(n + "----" + ans);
        return ans;
    }
}
