package hashMapsAndHeaps2;

import java.util.HashMap;

public class XOfAKindInADeckOfCards {
	public boolean hasGroupsSizeX(int[] deck) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<deck.length; i++) {
            if(map.containsKey(deck[i])) {
                map.put(deck[i], map.get(deck[i]) + 1);
            } else {
                map.put(deck[i], 1);
            }
        }
        
        int prevFreq = 0, gcd = 1;
        
        for(int key: map.keySet()) {
            if(prevFreq == 0) {
                gcd = map.get(key);
            } else {
                gcd = getGCD(gcd, map.get(key));
            }
            prevFreq = map.get(key);
        }
        
        return gcd >= 2;
    }
    
    private int getGCD(int n1, int n2) {
        while(n1 % n2 != 0) {
            int rem = n1 % n2;
            n1 = n2;
            n2 = rem;
        }
        
        return n2;
    }
}
