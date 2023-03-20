import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 *
 * Constraints:
 *
 * 1 <= s.length <= 104
 * s consists of parentheses only '()[]{}'.
 */

public class Solution {
    public static boolean isValid(String s) {
        int length = s.length();
        if (length % 2 != 0) return false;

        Set<Character> openBrackets = Set.of('(','{','[');
        Map<Character, Character> closeToOpen = new HashMap<>();
        closeToOpen.put(')','(');
        closeToOpen.put('}','{');
        closeToOpen.put(']','[');
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < length; i++) {
            char character = s.charAt(i);
            if (openBrackets.contains(character)){
                stack.push(character);
            } else{
                if( stack.isEmpty() || stack.pop() != closeToOpen.get(character)){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static boolean isValidWithoutMemmoryUsage(String s){
        int length = s.length();
        if (length % 2 != 0) return false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            char character = s.charAt(i);
            if (character == '(' || character == '{' || character == '['){
                stack.push(character);
            } else{
               if( stack.isEmpty()){
                   return false;
               }
                Character pop = stack.pop();
               if ((pop == '(' && character != ')') || (pop == '{' && character != '}') || (pop == '[' && character != ']')){
                   return false;
               }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println("isValid(\"()\") = " + isValid("(("));
        System.out.println("isValid(\"()[]{}\") = " + isValid("()[]{}"));
        System.out.println("isValid(\"(]\") = " + isValid("(]"));
    }
}
