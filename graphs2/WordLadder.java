package graphs2;
import java.util.*;
public class WordLadder {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //inserting all words into a hashset
        HashMap<String, Boolean> wordSet = new HashMap<>();
        for(String str: wordList) {
            wordSet.put(str, false);
        }
        
        if(!wordSet.containsKey(endWord)) {
            //System.out.println("word set doesn't contain endWord.");
            return 0;
        }
        
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(beginWord, 1));
        //bfs
        while(q.size() > 0) {
            Pair rem = q.remove();
            
            wordSet.put(rem.word, true);
            
            for(int i=0; i<beginWord.length(); i++) {
                char[] wordChars = rem.word.toCharArray();
                for(int j = 'a'; j <= 'z'; j++) {
                    if(j != wordChars[i])
                        wordChars[i] = (char) j;
                    
                    String newWord = String.valueOf(wordChars);
                    
                    if(newWord.equals(endWord)) {
                        return rem.count + 1;
                    }
                    
                    if(wordSet.containsKey(newWord) && wordSet.get(newWord) == false) {
                        q.add(new Pair(newWord, rem.count + 1));
                    }    
                }
            }
        }
        return 0;
    }
    
    class Pair {
        String word;
        int count;
        
        Pair(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }
}
