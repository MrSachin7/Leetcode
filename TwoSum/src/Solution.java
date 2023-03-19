import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public static int[] twoSumByMe(int[] nums, int target) {
        Map<Integer, Integer> valueToIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
           int difference = target- nums[i];

           if (valueToIndex.containsKey(difference)){
               return new int[]{i, valueToIndex.get(difference)};
           }
           valueToIndex.put(nums[i], i);
        }
        throw new IllegalArgumentException("No such elements found");
    }

    public static void main(String[] args) {

        int[] array1 = new int[]{3,3};
        int[] ints = twoSumByMe(array1, 6);
        for (int anInt : ints) {
            System.out.println(anInt);
        }

    }
}
