import java.util.Arrays;

/**
 * Given an integer array nums sorted in non-decreasing order,
 * remove the duplicates in-place such that each unique element appears only once.
 * The relative order of the elements should be kept the same.
 *
 * Since it is impossible to change the length of the array in some languages,
 * you must instead have the result be placed in the first part of the array nums.
 * More formally, if there are k elements after removing the duplicates,
 * then the first k elements of nums should hold the final result.
 * It does not matter what you leave beyond the first k elements.
 *
 * Return k after placing the final result in the first k slots of nums.
 *
 * Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
 */

public class Solution {


    private static int removeDuplicates(int[] nums) {

        if (nums.length ==0) return 0;
        int count =1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] < nums[j]){
                    nums[i+1] = nums[j];
                    count++;
                    break;
                }
                if (j == nums.length-1){
                    return count;
                }
            }
        }
        return count;
    }
    private static int removeDuplicates(int[] nums, boolean wantChatGpt){
        if (!wantChatGpt){
            return removeDuplicates(nums);
        }
        if (nums.length == 0) {
            return 0;
        }
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                j++;
                nums[j] = nums[i];
            }
        }
        return j+1;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1,2,2,3,3,4,4,5}; // Input array
        int[] nums1 = new int[]{1,1,2}; // Input array
        int[] nums2 = new int[]{0,0,1,1,1,2,2,3,3,4}; // Input array

//        int[] expectedNums = new int[]{1,2,3,4,5,-99,-99,-99} ;// The expected answer with correct length -99 because it doesnt matter after k

//
//        int k = removeDuplicates(nums); // Calls your implementation
//
//        assert k == expectedNums.length;
//        for (int i = 0; i < k; i++) {
//            assert nums[i] == expectedNums[i];
//        }

//        System.out.println("removeDuplicates(nums) = " + removeDuplicates(nums));
        System.out.println("removeDuplicates(nums) = " + removeDuplicates(nums2, true));
        Arrays.stream(nums2).forEach(System.out::println);
    }



}
