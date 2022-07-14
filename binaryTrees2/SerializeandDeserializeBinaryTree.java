package binaryTrees2;
import java.util.*;

public class SerializeandDeserializeBinaryTree {
	class TreeNode {
		TreeNode left, right;
		int val;
		TreeNode(int val) {
			this.val = val;
		}
	}
	private String bfs(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                TreeNode rem = q.remove();
                
                if(rem.val == -1001) {
                    sb.append("N ");
                    continue;
                }
                
                sb.append(rem.val + " ");
                
                if(rem.left != null) { 
                    q.add(rem.left);
                } else {
                    q.add(new TreeNode(-1001));
                }
                if(rem.right != null) {
                    q.add(rem.right);
                } else {
                    q.add(new TreeNode(-1001));
                }
            }
        }
        return sb.toString();
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        return bfs(root);
    }
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0) return null;
        
        String[] nodes = data.split(" ");
        
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        
        
        for(int i = 1; i < nodes.length; i++) {
            TreeNode rem = q.poll();
            
            if(!nodes[i].equals("N")) {
                TreeNode left = new TreeNode(Integer.parseInt(nodes[i]));
                rem.left = left;
                q.add(left);
            }
            if(!nodes[++i].equals("N")) {
                TreeNode right = new TreeNode(Integer.parseInt(nodes[i]));
                rem.right = right;
                q.add(right);
            }
        }
        
        
        return root;
    }
}
