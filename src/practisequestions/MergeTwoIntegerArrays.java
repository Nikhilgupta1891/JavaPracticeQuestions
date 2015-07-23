package practisequestions;
import java.util.Arrays;

public class MergeTwoIntegerArrays {
    public static void main(String[] args) {
        Integer[] arr1 = {1, 2, 5, 3};
        Integer[] arr2 = {6, 2, 7, null, null, null, null};

        if (arr2.length > arr1.length) {
            mixTwoArrays(arr2, arr1);
            Arrays.sort(arr2);
            for (Integer each : arr2) {
                System.out.print(each + " ");
            }
        } else {
            mixTwoArrays(arr1, arr2);
            Arrays.sort(arr1);
            for (Integer each : arr1) {
                System.out.print(each + " ");
            }
        }
    }

    private static void mixTwoArrays(Integer[] bigArray, Integer[] smallArray) {
        int count = 0;
        for (int i = 0; i < bigArray.length; i++) {
            if (bigArray[i] == null) {
                bigArray[i] = smallArray[count];
                count++;
            }
        }
    }
    
}
