package graphs2;
import java.util.*;
public class WordLadder {
	class Solution {
	    private int getDiff(String s1, String s2) {
	        int ans = 0;
	        for(int i = 0; i < s1.length(); i++) {
	            if(s1.charAt(i) != s2.charAt(i))
	                ans++;
	        }
	        
	        return ans;
	    }
	    
	    private HashMap<String, List<String>> constructAdj(String beginWord, String endWord, List<String> wordList) {
	        HashMap<String, List<String>> adj = new HashMap<>();
	        adj.put(beginWord, new LinkedList<>());
	        for(String word: wordList)
	            adj.put(word, new LinkedList<>());
	        
	        for(int i = 0; i < wordList.size(); i++) {
	            String word = wordList.get(i);
	            if(getDiff(beginWord, word) == 1) {
	                adj.get(beginWord).add(word);
	                adj.get(word).add(beginWord);
	            }
	        }
	        
	        for(int i = 0; i < wordList.size(); i++) {
	            for(int j = i + 1; j < wordList.size(); j++) {
	                String word1 = wordList.get(i), word2 = wordList.get(j);
	                if(getDiff(word1, word2) == 1) {
	                    adj.get(word1).add(word2);
	                    adj.get(word2).add(word1);
	                }
	            }
	        }
	        
	        return adj;
	    }
	    
	    class Pair {
	        String word;
	        int steps;
	        Pair(String word, int steps) {
	            this.word = word;
	            this.steps = steps;
	        }
	    }
	    
	    private int bfs(HashMap<String, List<String>> adj, String beginWord, String endWord) {
	        Queue<Pair> q = new ArrayDeque<>();
	        q.add(new Pair(beginWord, 1));
	        
	        HashSet<String> visited = new HashSet<>();
	        
	        while(!q.isEmpty()) {
	            Pair rem = q.remove();
	            
	            if(rem.word.equals(endWord))
	                return rem.steps;
	            
	            if(visited.contains(rem.word))
	                continue;
	            visited.add(rem.word);
	            
	            for(String nbr: adj.get(rem.word)) {
	                if(!visited.contains(nbr))
	                    q.add(new Pair(nbr, rem.steps + 1));
	            }
	        }
	        
	        return 0;
	        
	    }
	    
	    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
	        HashMap<String, List<String>> adj = constructAdj(beginWord, endWord, wordList);
	        
	        return bfs(adj, beginWord, endWord);
	    }
	}
}
