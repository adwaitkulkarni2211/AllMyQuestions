package linkedList2;
public class ReverseLinkedList2 {
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
	public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || head.next == null) {
            return head;
        }
        int i = 1;
        ListNode prev = null, curr = head, lb = null, rb = null, rbNext = null;
        
        while(curr != null) {
            if(i >= left && i <= right) {
                if(i == left) {
                    lb = curr;
                }
                if(i == right) {
                    rb = curr;
                    rbNext = rb.next;
                }
                ListNode currNext = curr.next;
                
                curr.next = prev;
                prev = curr;
                curr = currNext;
            } else {
                prev = curr;
                curr = curr.next;
            }
            i++;
        }
        
        //lb = 2, rb = 4, rbNext = 5
        ListNode lbPrev = lb.next;  //lb.next will be pointing to its previous node
        lb.next = rbNext;
        if(lbPrev != null) {
            lbPrev.next = rb;
        }
        
        if(left == 1) {
            return rb;
        } else {
            return head;
        }
    }
}
