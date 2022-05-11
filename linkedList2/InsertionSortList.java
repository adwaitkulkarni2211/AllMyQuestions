package linkedList2;

public class InsertionSortList {
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
	
	public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(-5001), prev = head, curr = head.next;
        dummy.next = head;
        
        while(curr != null) {
            if(prev.val < curr.val) {
                prev = curr;
                curr = curr.next;
                continue;
            }
            ListNode currNext = curr.next;
            boolean didInsert = insert(head, curr, prev);
            if(!didInsert) {
                prev.next = currNext;
                
                dummy.next = curr;
                curr.next = head;
                head = curr;
                
                curr = currNext;
            } else {
                curr = currNext;
            }
            
        }
        return dummy.next;
    }
    
    private boolean insert(ListNode head, ListNode end, ListNode endPrev) {
        if(head == end) {
            return false;
        }
        
        boolean didInsert = insert(head.next, end, endPrev);
        if(didInsert) return true;
        
        if(head.val < end.val) {
            if(head.next == end) {
                return true;
            }
            endPrev.next = end.next;
            
            ListNode headNext = head.next;
            head.next = end;
            end.next = headNext;
            return true;
        } else {
            return false;
        }
    }
}
