package linkedList2;

public class SortList {
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
	private ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(-100001), prev = dummy;
        ListNode i = head1, j = head2;
        
        while(i != null && j != null) {
            if(i.val < j.val) {
                prev.next = i;
                i = i.next;
            } else {
                prev.next = j;
                j = j.next;
            }
            prev = prev.next;
        }
        
        prev.next = (i != null) ? i : j;
        
        return dummy.next;
    }
    private ListNode midNode(ListNode head) {
        ListNode slow = head, fast = head;

        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        
        ListNode mid = midNode(head);
        
        ListNode midNext = mid.next;
        mid.next = null;

        ListNode half1 = sortList(head);
        ListNode half2 = sortList(midNext);

        ListNode sorted = mergeTwoLists(half1, half2);

        return sorted;
    }
}
