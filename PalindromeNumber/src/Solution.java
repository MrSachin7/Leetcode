public class Solution {

    public static boolean isPalindromeNumber(int number){
        String reversed = new StringBuilder(String.valueOf(number)).reverse().toString();
        return String.valueOf(number).equals(reversed);
    }

    public static boolean isPalindromeNumberNoConversion(int number){

        if (number <0) return false;
        int temp = number;
        int reversed = 0;

        while (temp !=0){
            reversed = (reversed*10) +temp % 10;
            temp = temp / 10;

        }
        return reversed==number;

    }


    public static void main(String[] args) {
        System.out.println("isPalindromeNumberNoConversion(12321) = " + isPalindromeNumber(121));
    }
}
