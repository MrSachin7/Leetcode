
import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    private Map<Character, Integer> romanToNumberMap;

    public RomanToInteger() {
        romanToNumberMap = new HashMap<>();
        romanToNumberMap.put('I', 1);
        romanToNumberMap.put('V', 5);
        romanToNumberMap.put('X', 10);
        romanToNumberMap.put('L', 50);
        romanToNumberMap.put('C', 100);
        romanToNumberMap.put('D', 500);
        romanToNumberMap.put('M', 1000);


    }

    public int romanToInt(String s) {

        int totalValue =0;
        for (int i = 0; i < s.length(); i++) {
            Character character =s.charAt(i);

            Integer characterValue = romanToNumberMap.get(character);
            if (characterValue == null){
                throw new IllegalArgumentException("Invalid s number / Provided number has at least one invalid s character");
            }

            if (s.length() > i+1 && characterValue < romanToNumberMap.get(s.charAt(i+1))){
                totalValue = totalValue - characterValue;
            }else {
                totalValue = totalValue + characterValue;
            }

        }
        return totalValue;
    }


    public static void main(String[] args) {
        RomanToInteger romanToInteger = new RomanToInteger();
        System.out.println("romanToInteger.romanToInt(\"IX\") = " + romanToInteger.romanToInt("IX"));
        System.out.println("romanToInteger.romanToInt(\"XI\") = " + romanToInteger.romanToInt("XI"));
        System.out.println("romanToInteger.romanToInt(\"BG\") = " + romanToInteger.romanToInt("BG"));
    }
}
