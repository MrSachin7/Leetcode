/**
 * Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The relative order of the elements may be changed.
 * <p>
 * Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.
 * <p>
 * Return k after placing the final result in the first k slots of nums.
 * <p>
 * Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
 * <p>
 * <p>
 * https://leetcode.com/problems/remove-element/
 */
public class Solution {

    public static int removeElement(int[] nums, int val) {

        if (nums.length == 0) return 0;

        int counter = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                counter++;
                continue;
            }

            for (int j = i; j < nums.length; j++) {
                if (nums[j] != val) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    counter++;
                    break;
                }
            }
        }
        return counter;
    }

    public static int removeElement(int[] nums, int val, boolean wantChatGPT) {

        if (!wantChatGPT) {
            return removeElement(nums, val);
        }
        int i = 0;
        int j = 0;
        while (i < nums.length) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
            i++;
        }
        return j;
    }

    public static void main(String[] args) {

        int array[] = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        System.out.println("removeElement(array, 2) = " + removeElement(array, 2));
        for (int i : array) {
            System.out.println(i);
        }
    }
}
