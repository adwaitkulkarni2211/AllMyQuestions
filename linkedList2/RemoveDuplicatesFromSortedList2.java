package linkedList2;

public class RemoveDuplicatesFromSortedList2 {
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
	public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(-101);
        dummy.next = head;
        ListNode prev = dummy, curr1 = head, curr2 = head.next;
        
        while(true) {
            while(curr2 != null && curr1.val != curr2.val) {
                prev = curr1;
                curr1 = curr2;
                curr2 = curr2.next;
            }
            
            if(curr2 == null) break;
            
            while(curr2 != null && curr1.val == curr2.val) {
                curr2 = curr2.next;
            }
            
            prev.next = curr2;
            
            if(curr2 == null) break;
            
            curr1 = curr2;
            curr2 = curr2.next;
        }
        
        return dummy.next;
    }
}
