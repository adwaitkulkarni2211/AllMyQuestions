package linkedList2;

public class MergeKSortedLists {
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

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return solve(lists, 0, lists.length - 1);
    }

    private ListNode solve(ListNode[] lists, int lo, int hi) {
        if (hi == lo) {
            return lists[lo];
        }

        int mid = (lo + hi) / 2;

        ListNode l1 = solve(lists, lo, mid);
        ListNode l2 = solve(lists, mid + 1, hi);

        return mergeTwoLists(l1, l2);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode i = l1, j = l2, dummy = new ListNode(-1), prev = dummy;
        while (i != null && j != null) {
            if (j.val < i.val) {
                prev.next = j;
                j = j.next;
            } else {
                prev.next = i;
                i = i.next;
            }
            prev = prev.next;
        }

        prev.next = i != null ? i : j;

        ListNode head = dummy.next;
        dummy.next = null;

        return head;
    }
}