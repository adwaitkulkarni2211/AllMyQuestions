package binaryTrees2;

import java.util.*;

public class CheckIfBTContainsDuplicateTreesOfSize2OrMore {
	static class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
	
	int dupSub(Node root) {
        sbt = new HashMap<>();
        ans = new ArrayList<>();
        
        String sb = solve(root);
        System.out.println(sb);
        //System.out.println(sbt);
        //System.out.println(ans);

        if(ans.size() == 0) {
            return 0;
        } else {
            return 1;
        }
    }
    
    HashMap<String, Integer> sbt;
    List<Integer> ans;
    
    String solve(Node node) {
        if(node == null) {
            return "*";
        }
        
        String ls = solve(node.left);
        String rs = solve(node.right);
        
        if(ls.length() == 1 && rs.length() == 1) {
            return "";
        }
        
        String ms = node.data + "," + ls + "," + rs;
        
        if(sbt.containsKey(ms)) {
            if(sbt.get(ms) == 1) {
                ans.add(node.data);
            }
            sbt.put(ms, sbt.get(ms) + 1);
        } else {
            sbt.put(ms, 1);
        }
        return ms;
    }
}
