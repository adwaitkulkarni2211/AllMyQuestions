package linkedList2;

public class RemoveLinkedListElements {
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
	
	public ListNode removeElements(ListNode head, int val) {
        if(head == null) {
            return head;
        }
        
        ListNode temp = head, prev = null;
        
        while(temp != null) {
            if(temp.val == val) {
                if(prev != null) {
                    prev.next = prev.next.next;
                } else {
                    head = head.next;
                }
            } else {
                prev = temp;    
            }
            temp = temp.next;
        }
        
        return head;
    }
}
