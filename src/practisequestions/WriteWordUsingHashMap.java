/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practisequestions;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nikhil
 */
public class WriteWordUsingHashMap {
    public static void main(String[] args) {
        List<Character> cernerName = new ArrayList<>();
        cernerName.add('c');
        cernerName.add('e');
        cernerName.add('r');
        cernerName.add('n');
        cernerName.add('e');
        cernerName.add('r');
        System.out.println("LIST: " + cernerName);
        char[] cernerArray = new char[6];
        int i=0;
        System.out.print("CHARACTERS: ");
        for(Character eachChar : cernerName)
        {
            System.out.print(eachChar);
            cernerArray[i] = eachChar;
            i++;
        }
        System.out.println();
        String cernerString = new String(cernerArray);
        System.out.println("STRING: " + cernerString);        
    }
}
