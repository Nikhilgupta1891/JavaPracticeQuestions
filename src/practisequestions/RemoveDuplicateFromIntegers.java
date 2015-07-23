package practisequestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author nikhil
 */
public class RemoveDuplicateFromIntegers {

    public static void main(String[] args) {
        Integer[] intArray = new Integer[]{9, 2, 3, 2, 1, 4, 2};
        
        removeDuplicateUsingSet(intArray);
        
        removeDuplicateUsingList(intArray);

        //removeDuplicatesUsingArray
        int[] intArrayToSort = new int[]{9, 1, 6, 3};
        int maximumElementInArray = findMaxInArray(intArrayToSort);
        Integer[] finalArray = removeDuplicatesUsingArray(intArrayToSort, maximumElementInArray);
        for (int i : finalArray) {
            System.out.print(i + " ");
        }
        System.out.println("");

        System.out.println("Sorted Array: ");
        //Sort the array
        Arrays.sort(finalArray);
        for (int i : finalArray) {
            System.out.print(i + " ");
        }

        System.out.println("");

        //Reverse the array
        List<Integer> reverseList = new ArrayList<>();
        for (int i = finalArray.length - 1; i >= 0; i--) {
            reverseList.add(finalArray[i]);
        }

        System.out.println(reverseList);
    }

    public static Integer[] removeDuplicatesUsingArray(int[] arr, int maxValue) {
        boolean[] booleanSet = new boolean[maxValue + 1];
        int totalCount = 0;

        for (int i = 0; i < arr.length; i++) {
            if (booleanSet[arr[i]] != true) {
                booleanSet[arr[i]] = true;
                totalCount++;
            }
        }

        Integer[] finalArray = new Integer[totalCount];
        int c = 0;
        for (int i = 0; i < booleanSet.length; i++) {
            if (booleanSet[i] == true) {
                finalArray[c] = i;
                c++;
            }
        }
        return finalArray;
    }

    private static void removeDuplicateUsingSet(Integer[] inputArray) {
        Set<Integer> integerSet = new LinkedHashSet<>();
        for (int i = 0; i < inputArray.length; i++) {
            integerSet.add(inputArray[i]);
        }
        System.out.println(integerSet);
    }

    private static void removeDuplicateUsingList(Integer[] intArray) {
        List<Integer> removeDupList = Arrays.asList(intArray);
        List<Integer> newList = new ArrayList<>();
        for (int i = 0; i < removeDupList.size(); i++) {
            if (removeDupList.lastIndexOf(removeDupList.get(i)) == i) {
                newList.add(removeDupList.get(i));
            }
        }
        System.out.println(newList);
    }

    private static int findMaxInArray(int[] intArr) {
        int max = intArr[0];
        for (int i = 0; i < intArr.length; i++) {
            if (intArr[i] > max) {
                max = intArr[i];
            }
        }
        return max;
    }
}
