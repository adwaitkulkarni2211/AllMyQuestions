package graphs;
import java.util.*;

public class GenerateInput {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt(), E = sc.nextInt();
		
		List<List<Integer>> adj = new ArrayList<>();
		for(int i = 0; i < V; i++) {
			adj.add(new ArrayList<>());
		}
		
		for(int i = 0; i < E; i++) {
			int u = sc.nextInt(), v = sc.nextInt();
			adj.get(u).add(v);
			adj.get(v).add(u);
		}
		sc.close();
		
		String ans = "[";
		
		for(int i = 0; i < V; i++) {
			ans += "[";
			for(int j = 0; j < adj.get(i).size(); j++) {
				if(j == adj.get(i).size() - 1) {
					ans += adj.get(i).get(j);
				} else {
					ans += adj.get(i).get(j) + ",";
				}
			}
			
			if(i == V - 1) {
				ans += "]";
			} else {
				ans += "],";
			}
		}
		
		ans += "]";
		System.out.println(ans);
	}
}
