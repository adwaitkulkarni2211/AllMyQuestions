package linkedList2;

import java.util.HashSet;

public class LinkedListComponents {
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
	public int numComponents(ListNode head, int[] nums) {
        if(head == null || nums.length == 0) {
            return 0;
        }
        
        HashSet<Integer> set = new HashSet<>();
        for(int num: nums) {
            set.add(num);
        }
        
        ListNode temp = head;
        int count = 0;
        
        while(temp != null) {
            if(set.contains(temp.val) && (temp.next == null || !set.contains(temp.next.val))) {
                count++;
            }
            temp = temp.next;
        }
        
        return count;
    }
}
