public class Solution {

    public static String longestCommonPrefixByMe(String[] strs) {

        if (strs == null || strs.length==0) return "";

        String longestPrefix = "";
        String temp ="";
        int currentIndex = 0;
        do {
            for (String s : strs) {
                if (s.length() <= currentIndex) return longestPrefix;
                temp = String.valueOf(strs[0].charAt(currentIndex));
                if (String.valueOf(s.charAt(currentIndex)).equals(temp)) {
                    continue;
                }
                return longestPrefix;
            }
            longestPrefix = longestPrefix + temp;
            currentIndex++;

        } while (true);
    }

    public static String longestCommonPrefixByChatGPT(String[] array){
        if (array == null || array.length == 0) {
            return "";
        }
        // Initialize prefix as a first word
        String prefix = array[0];
        for (int i = 1; i < array.length; i++) {
            while (array[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;

    }


    public static void main(String[] args) {

        String[] arrays = new String[]{"flower","flow","flight"};
        String[] arrays1 = new String[]{"a","abc","aa"};
        String[] arrays2 = new String[]{"","abc","aa"};

        System.out.println("longestCommonPrefix(arrays) = " + longestCommonPrefixByMe(arrays));
        System.out.println("longestCommonPrefix(arrays1) = " + longestCommonPrefixByMe(arrays1));
        System.out.println("longestCommonPrefix(arrays2) = " + longestCommonPrefixByMe(arrays2));

        System.out.println("longestCommonPrefixByChatGPT(arrays) = " + longestCommonPrefixByChatGPT(arrays));
        System.out.println("longestCommonPrefixByChatGPT(arrays1) = " + longestCommonPrefixByChatGPT(arrays1));
        System.out.println("longestCommonPrefixByChatGPT(arrays2) = " + longestCommonPrefixByChatGPT(arrays2));

    }
}
