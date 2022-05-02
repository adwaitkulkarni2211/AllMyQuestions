package linkedList2;

public class AddTwoLinkedLists {
	  public class ListNode {
	      int val;
	      ListNode next;
	      ListNode() {}
	      ListNode(int val) { this.val = val; }
	      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	  }
	class Solution {
	    int carry = 0;
	    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	        ListNode node = new ListNode();
	        if(l1 == null && l2 == null) {
	            if(carry != 0) {
	                node.val = carry;
	                return node;
	            }
	            return null;
	        }
	        if(l1 == null) {
	            int sum = l2.val + carry;
	            node.val = sum % 10;
	            carry = sum / 10;
	            node.next = addTwoNumbers(l1, l2.next);
	            return node;
	        }
	        if(l2 == null) {
	            int sum = l1.val + carry;
	            node.val = sum % 10;
	            carry = sum / 10;
	            node.next = addTwoNumbers(l1.next, l2);
	            return node;
	        }
	        
	        int sum = l1.val + l2.val + carry;
	        node.val = sum % 10;
	        carry = sum / 10;
	        
	        node.next = addTwoNumbers(l1.next, l2.next);
	        
	        return node;
	    }
	}
}
