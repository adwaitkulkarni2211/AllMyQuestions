package recursionAndBacktracking;
import java.util.*;
public class MaxScoreWordsFormedByLetters {
	public int maxScoreWords(String[] words, char[] letters, int[] scores) {
        maxScore = Integer.MIN_VALUE;
        HashMap<Character, Integer> freq = new HashMap<>();
        for(char ch: letters) {
            if(freq.containsKey(ch)) {
                freq.put(ch, freq.get(ch) + 1);
            } else {
                freq.put(ch, 1);
            }
        }
        solve(words, new ArrayList<>(), 0, freq, scores);
        return maxScore;
    }
    
    int maxScore;
    
    private void solve(String[] words, List<String> set, int idx, HashMap<Character, Integer> freq, int[] scores) {
        if(idx == words.length) {
            HashMap<Character, Integer> temp = new HashMap<>(freq);
            int flag = 0, score = 0;
            for(String str: set) {
                for(int i=0; i<str.length(); i++) {
                    char ch = str.charAt(i);
                    
                    if(temp.containsKey(ch)) {
                        if(temp.get(ch) == 1) {
                            temp.remove(ch);
                        } else {
                            temp.put(ch, temp.get(ch) - 1);
                        }
                        score += scores[(int)ch - 97];
                    } else {
                        flag = 1;
                        break;
                    }
                }
                if(flag == 1) break;
            }
            if(flag == 0) {
                maxScore = Math.max(maxScore, score);
            }
            return;
        }
        
        set.add(words[idx]);
        solve(words, set, idx + 1, freq, scores);
        set.remove(set.size() - 1);
        solve(words, set, idx + 1, freq, scores);
    }
}
