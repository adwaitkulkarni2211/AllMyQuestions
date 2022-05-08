package linkedList2;

public class SwapNodesInPairs {
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
	public ListNode swapPairs(ListNode head) {
	        if(head == null || head.next == null) {
	            return head;
	        }
	        
	        ListNode dummy = new ListNode(-1);
	        ListNode prev = dummy, curr1 = head, curr2 = head.next;
	        
	        while(curr2 != null) {
	            ListNode curr2Next = curr2.next;
	            
	            curr2.next = curr1;
	            curr1.next = curr2Next;
	            prev.next = curr2;
	            
	            if(curr2Next == null) break;
	            
	            prev = curr1;
	            curr1 = curr2Next;
	            curr2 = curr2Next.next;
	        }
	        
	        return dummy.next;
	    }
}
