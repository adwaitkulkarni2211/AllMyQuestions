package linkedList2;

public class LinkedListCycle2 {
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
	public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        boolean isCycle = false;
        
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            
            if(fast == slow) {
                isCycle = true;
                break;
            }
        }
        
        if(isCycle) {
            ListNode temp1 = head, temp2 = fast;
            while(temp1 != temp2) {
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
            return temp1;
        } else {
            return null;
        }
    }
}
