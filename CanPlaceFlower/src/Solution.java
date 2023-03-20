/**
 * You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.
 * <p>
 * Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n,
 * return if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule.
 * <p>
 * Constraints:
 * <p>
 * 1 <= flowerbed.length <= 2 * 104
 * flowerbed[i] is 0 or 1.
 * There are no two adjacent flowers in flowerbed.
 * 0 <= n <= flowerbed.length
 */


public class Solution {

    public static boolean canPlaceFlowersByMe(int[] flowerbed, int n) {


            // If only [0] provided
        if (flowerbed.length ==1 && flowerbed[0] ==0){
            return 1 >=n;
        }


        int currentIndex = 0;
        while (flowerbed.length >= currentIndex+1) {
            if (n<= 0) return true;

            // If the current index has 1 , skip the next
            if (flowerbed[currentIndex] == 1) {
                currentIndex += 2;
            } else {
                // If its a first element, check the 2nd one only
                if (currentIndex == 0) {
                    if (flowerbed.length <= currentIndex+1) {
                        return false;
                    }
                    if (flowerbed[++currentIndex] == 0) {
                        n--;
                        currentIndex ++;
                    }

                    // If its a last element check the 2nd last only
                } else if (currentIndex == flowerbed.length - 1) {
                    if (flowerbed[currentIndex - 1] == 0) {
                        n--;
                    }
                    return n <= 0;

                    // Else check adjacent elements.
                } else {
                    if (flowerbed[currentIndex - 1] == 0 && flowerbed[currentIndex + 1] == 0) {
                        n--;
                        currentIndex += 2;
                    } else {
                        currentIndex++;
                    }
                }

            }
        }
        return n<=0;
    }

    public static void main(String[] args) {
        int[] flowerbed = new int[]{1, 0, 0, 0, 0, 1};
        int[] flowerbed1 = new int[]{0, 0, 0, 0,1};
        int[] flowerbed2 = new int[]{0};
        int[] flowerbed3 = new int[]{1,0};
        System.out.println("canPlaceFlowers(flowerbed , 2) = " + canPlaceFlowersByMe(flowerbed1, 2));
        System.out.println("canPlaceFlowers(flowerbed1, 1) = " + canPlaceFlowersByMe(flowerbed1, 1));

    }
}
