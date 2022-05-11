package linkedList2;
public class SplitLinkedListInParts {
	public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
	class Solution {
	    private int size(ListNode head) {
	        ListNode temp = head;
	        int size = 0;
	        while(temp != null) {
	            size++;
	            temp = temp.next;
	        }
	        
	        return size;
	    }
	    
	    public ListNode[] splitListToParts(ListNode head, int k) {
	        ListNode[] ans = new ListNode[k];
	        
	        int size = size(head);
	        int q = size / k;
	        int rem = size % k;
	        
	        ListNode curr = head, prev = null;
	        int i = 0;
	        while(curr != null) {
	            ans[i] = curr;
	            
	            int j = 0;
	            if(i < rem) {
	                while(curr != null && j < q + 1) {
	                    prev = curr;
	                    curr = curr.next;
	                    j++;
	                }    
	            } else {
	                while(curr != null && j < q) {
	                    prev = curr;
	                    curr = curr.next;
	                    j++;
	                }
	            }
	            i++;
	            
	            prev.next = null;
	        }
	        
	        return ans;
	    }
	}
}
