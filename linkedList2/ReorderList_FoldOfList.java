package linkedList2;

public class ReorderList_FoldOfList {
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

    public ListNode middleNode(ListNode head) {
        ListNode fast = head, slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode currNext = curr.next;

            curr.next = prev;
            prev = curr;
            curr = currNext;
        }

        return prev;
    }
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode mid = middleNode(head);
        ListNode nHead = mid.next;
        //break the list in half
        mid.next = null;

        //reverse 2nd half
        nHead = reverseList(nHead);

        //merge 
        ListNode c1 = head, c2 = nHead;
        while (c2 != null) {
            ListNode f1 = c1.next, f2 = c2.next;

            c1.next = c2;
            c2.next = f1;

            c1 = f1;
            c2 = f2;
        }
    }
    
    //recursive, faster
    class Solution {
        ListNode left;
        public void reorderList(ListNode head) {
            toStop = false;
            left = head;
            ListNode right = head;
            solve(right, head);
        }
        boolean toStop;
        public void solve(ListNode right, ListNode head) {
            if(right == null) {
                return;
            }
            
            solve(right.next, head);
            
            //odd -> left = right
            //even -> left.next = right;
            if(toStop == true) {
                return;
            }

            if(toStop == false && (left == right || left.next == right)) {
                right.next = null;
                toStop = true;
                return;
            }
        
            ListNode temp = left.next;
            left.next = right;
            right.next = temp;
            left = temp;
        }
    }
}