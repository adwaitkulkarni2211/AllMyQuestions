package linkedList2;
import java.util.*;

public class UnfoldALinkedList {
	public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void unfold(ListNode head) {
        if(head == null || head.next == null) {
            return;
        }

        ListNode temp1 = head, temp2 = head.next, head2 = head.next;

        while(temp2 != null && temp2.next != null) {
            temp1.next = temp1.next.next;
            temp2.next = temp2.next.next;

            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        if(temp2 != null &&  temp1.next == temp2) {
            temp1.next = null;
        }

        head2 = reverse(head2);

        temp1.next = head2;
    }

    static ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head;

        while(curr != null) {
            ListNode currNext = curr.next;

            curr.next = prev;
            prev = curr;
            curr = currNext;
        }

        return prev;
    }

    static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        scn.close();
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        ListNode head = dummy.next;
        unfold(head);
        printList(head);
    }
}
