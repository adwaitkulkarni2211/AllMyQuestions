package linkedList2;

public class SwappingNodesInALinkedList {
	public class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
	public ListNode swapNodes(ListNode head, int k) {
        if(head == null || head.next == null) {
            return head;
        }
        
        front = head;
        back = new ListNode();
        back.next = head;
        
        solve(front, k);
        
        return head;
    }
    
    ListNode front, back;
    
    private int solve(ListNode front, int k) {
        if(front == null) {
            return 1;
        }
        
        int steps = solve(front.next, k);
        back = back.next;
        
        if(steps == k) {
            int temp = back.val;
            back.val = front.val;
            front.val = temp;
        }
        
        return steps + 1;
    }
}
