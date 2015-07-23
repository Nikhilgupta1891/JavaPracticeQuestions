/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.List;

public class HackerRank {

    public static void main(String[] args) {
        long n = 4, p = 94, x = 8, max, temp;

        List<Long> input = new ArrayList<>();
        int maxIndex;
        input.add(8L);
        input.add(6L);
        input.add(4L);
        input.add(6L);
        maxIndex = 1;
        max = input.get(0) * p;
        for (int i = 1; i < input.size(); i++) {
            p -= x;
            if (p * input.get(i) > max) {
                max = p * input.get(i);
                maxIndex = i + 1;
            }
        }
        System.out.println(maxIndex);
    }

}
