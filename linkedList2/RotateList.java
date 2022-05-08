package linkedList2;

public class RotateList {
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
	private int size(ListNode head) {
        ListNode temp = head;
        int count = 0;
        while(temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) {
            return head;
        }
        
        k %= size(head);
        
        if(k == 0) return head;
        
        ListNode slow = head, fast = head;
        
        for(int i=0; i < k; i++) {
            fast = fast.next;
        }
        
        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        
        ListNode newHead = slow.next;
        
        slow.next = null;
        fast.next = head;
        
        return newHead;
    }
}
