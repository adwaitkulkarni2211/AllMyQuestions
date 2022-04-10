package hashMapsAndHeaps2;

import java.util.Arrays;

public class SortCharactersByFrequency {
	class Pair implements Comparable<Pair>{
        int origIdx, freq;
        Pair(int origIdx, int freq) {
            this.origIdx = origIdx;
            this.freq = freq;
        }
        public int compareTo(Pair o) {
            return this.freq - o.freq;
        }
    }
    public String frequencySort(String s) {
        Pair[] charFreq = new Pair[62];
        for(int i=0; i<charFreq.length; i++) {
            charFreq[i] = new Pair(i, 0);
        }
        
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(ch >= 'A' && ch <= 'Z') {
                charFreq[(int)(ch - 'A') + 26].freq++;
            } else if(ch >= 'a' && ch <= 'z'){
                charFreq[(int)(ch - 'a')].freq++;    
            } else {
                charFreq[(int)(ch - '0') + 52].freq++;
            }
        }
        
        Arrays.sort(charFreq);
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = charFreq.length - 1; i >= 0; i--) {
            int freq = charFreq[i].freq, origIdx = charFreq[i].origIdx;
            if(freq == 0) {
                break;
            }
            
            while(freq-- > 0) {
                if(origIdx > 51) {
                    sb.append((char)(origIdx - 52 + '0'));
                } else if(origIdx > 25) {
                    sb.append((char)(origIdx - 26 + 'A'));
                } else {
                    sb.append((char)(origIdx + 'a'));
                }
            }
        }
        
        return sb.toString();
    }
}
