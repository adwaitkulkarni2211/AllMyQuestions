package linkedList2;

public class OddEvenLinkedList {
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
	public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        
        ListNode temp1 = head, temp2 = head.next, sdHead = head.next;
        
        while(temp2 != null && temp2.next != null) {
            temp1.next = temp1.next.next;
            temp2.next = temp2.next.next;
            
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        
        if(temp1.next == temp2) {
            temp1.next = null;
        }
        
        temp1.next = sdHead;
        
        return head;
    }
}
