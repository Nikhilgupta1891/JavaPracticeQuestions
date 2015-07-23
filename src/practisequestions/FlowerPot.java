/*
Given a list of flower bed positions represented by boolean (true/false) as input 
(true represents a flower plant already placed in that position and false representing an empty spot), 
and also given the number of additional flower plants to be placed, design & write the program to
return either a true or false where true is when all the passed additional flower plants can be placed 
in the flower bed and false when 1 or more are left not placed.  Constraint is - No two flower plants 
can be next to each other.

Example: Input List : {T, F, F, T, F, T, F}, Input Number: 1 --> True
Example: Input List : {T, F, T, F, F}, Input Number: 1 --> True
Example: Input List : {F, T, F, T, F, F}, Input Number: 2 --> False
*/
package practisequestions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FlowerPot {
    public static void main(String[] args) {
        Boolean[] arrayOfInputValues = new Boolean[]{true, false, true, false, false};
        
        List<Boolean> listOfPots = new ArrayList<>();
        for(boolean eachVal: arrayOfInputValues)
        {
            listOfPots.add(eachVal);
        }
        
        int numberOfPots;
        
        System.out.println("Enter the number of pots: ");

        Scanner sc = new Scanner(System.in);
        numberOfPots = sc.nextInt();
        
        System.out.println(canPotBeInserted(listOfPots, numberOfPots));
    }

    private static boolean canPotBeInserted(List<Boolean> listOfPotsInRow, int numberOfPotsToFill) {
        int counter = 0;
        if (listOfPotsInRow.isEmpty()) {
            return false;
        } else if (listOfPotsInRow.size() == 1) {
            if (listOfPotsInRow.get(0) == false) {
                if (numberOfPotsToFill == 1) {
                    return true;
                } else {
                    return false;
                }
            }
        } else {            
            for (int i = 0; i < listOfPotsInRow.size(); i++) {
                if (i == 0) {
                    if (listOfPotsInRow.get(i) == false && listOfPotsInRow.get(i + 1) == false) {
                        counter++;
                    }
                } else if (i != listOfPotsInRow.size() - 1) {
                    if (listOfPotsInRow.get(i) == false && listOfPotsInRow.get(i + 1) == false && listOfPotsInRow.get(i - 1) == false) {
                        counter++;
                    }
                } else {
                    if (listOfPotsInRow.get(i) == false && listOfPotsInRow.get(i - 1) == false) {
                        counter++;
                    }
                }
            }
        }
        if(counter>=numberOfPotsToFill)
            return true;
        else
            return false;
    }
}
