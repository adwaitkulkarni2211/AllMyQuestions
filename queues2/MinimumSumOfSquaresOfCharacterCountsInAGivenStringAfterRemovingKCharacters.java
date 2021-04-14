package queues2;
import java.util.*;
public class MinimumSumOfSquaresOfCharacterCountsInAGivenStringAfterRemovingKCharacters {
	
	static class Pair implements Comparable<Pair>{
        char key;
        int freq;
        
        Pair(char key, int freq) {
            this.key = key;
            this.freq = freq;
        }
        
        public int compareTo (Pair other) {
            return other.freq - this.freq;
        }
    }
    
    static int minValue(String str, int k){
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        HashMap<Character, Integer> charFreq = new HashMap<>();
        
        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            if(charFreq.containsKey(ch)) {
                charFreq.put(ch, charFreq.get(ch) + 1);
            } else {
                charFreq.put(ch, 1);
            }
        }
        
        for(Character ch: charFreq.keySet()) {
            Pair p = new Pair(ch, charFreq.get(ch));
            pq.add(p);
        }
        // for(Pair p: pq) {
        //     System.out.println("key: " + p.key + " freq: " + p.freq);
        // }
        for(int i=0; i<k; i++) {
            Pair rem = pq.remove();
            rem.freq--;
            charFreq.put(rem.key, rem.freq);
            pq.add(rem);
        }
        int ans = 0;
        for(Character ch: charFreq.keySet()) {
            ans += Math.pow(charFreq.get(ch), 2);
        }
        return ans;
    }
	
	public static void main(String[] args) {
		String str1 = "adwaitkulkarni";
		String str2 = "tobethegreatesthokagethatismydreamandthensomedayiamgoingtoberespectedbyeverybodyintheentirevillage";
		System.out.println(minValue(str1, 5));
		System.out.println(minValue(str2, 10));
	}

}
