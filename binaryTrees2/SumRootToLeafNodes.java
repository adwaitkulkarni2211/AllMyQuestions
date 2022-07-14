package binaryTrees2;
import java.util.*;

public class SumRootToLeafNodes {
	class TreeNode {
		TreeNode left, right;
		int val;
	}
	public int sumNumbers(TreeNode root) {
        List<StringBuilder> paths = solve(root);
        
        int sum = 0;
        for(StringBuilder sb: paths) {
            sb.reverse();
            sum += Integer.parseInt(sb.toString());
        }
        
        return sum;
    }
    
    private List<StringBuilder> solve(TreeNode root) {
        if(root == null) {
            return new LinkedList<>();
        }
        
        List<StringBuilder> lpaths = solve(root.left);
        List<StringBuilder> rpaths = solve(root.right);
        
        if(lpaths.size() == 0 && rpaths.size() == 0) {
            lpaths.add(new StringBuilder(root.val + ""));
            return lpaths;
        }
        
        for(StringBuilder sb: lpaths) {
            sb.append(root.val + "");
        }
        for(StringBuilder sb: rpaths) {
            sb.append(root.val + "");
        }
        
        lpaths.addAll(rpaths);
        //System.out.println("root: " + root.val + " list: " + lpaths);
        
        return lpaths;
    }
}
