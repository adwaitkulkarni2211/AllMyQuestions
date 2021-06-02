package recursionAndBacktracking;
import java.util.*;
public class JosephusProblem {
	public int findTheWinner(int n, int k) {
        ans = 0;
        ArrayList<Integer> friends = new ArrayList<>();
        for(int i=1; i<=n; i++) {
            friends.add(i);
        }
        solve(friends, k, 0);
        return ans;
    }
    int ans;
    private void solve(ArrayList<Integer> friends, int k, int idx) {
        if(friends.size() == 1) {
            ans = friends.get(0);
            return;
        }
        
        idx = (idx + (k - 1)) % friends.size();
        friends.remove(idx);

        solve(friends, k, idx);
    }
}
