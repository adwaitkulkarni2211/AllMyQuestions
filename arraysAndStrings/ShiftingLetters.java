package arraysAndStrings;

public class ShiftingLetters {
	public String shiftingLetters(String s, int[] shifts) {
        long suffixSum = 0;
        
        //can also use string builder
        char[] ans = new char[s.length()];
        
        for(int i = shifts.length - 1; i >= 0; i--) {
            suffixSum += shifts[i];
            char ch = s.charAt(i);
            
            char newChar = (char)(((ch - 'a' + suffixSum) % 26) + 'a');
            
            ans[i] = newChar;
        }
        
        return String.valueOf(ans);
    }
}
