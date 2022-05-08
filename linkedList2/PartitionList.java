package linkedList2;

public class PartitionList {
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
	
	public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) {
            return head;
        }
        
        ListNode dummy1 = new ListNode(-101), dummy2 = new ListNode(-101), prev1 = dummy1, prev2 = dummy2, curr = head;
        
        while(curr != null) {
            if(curr.val >= x) {
                prev2.next = curr;
                prev2 = curr;
            } else {
                prev1.next = curr;
                prev1 = curr;
            }
            curr = curr.next;
        }
        
        prev1.next = prev2.next = null;
        
        prev1.next = dummy2.next;
        
        return dummy1.next;
    }
}
