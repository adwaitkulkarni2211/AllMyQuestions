package linkedList2;

import java.util.HashMap;

public class RemoveZeroSumConsecutiveNodesFromLinkedList {
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
	
	public ListNode removeZeroSumSublists(ListNode head) {
        //Prefix Sum at Node vs Prev of Node
        HashMap<Integer, ListNode> map = new HashMap<>();
        
        ListNode dummy = new ListNode(-1001);
        dummy.next = head;
        
        map.put(0, dummy);
        
        ListNode curr = head, prev = dummy;
        int sum = 0;
        
        while(curr != null) {
            sum += curr.val;

            if(curr.val == 0) {
                prev.next = curr.next;
                curr = curr.next;
                continue;
            }
            
            if(map.containsKey(sum)) {
                ListNode prevOcc = map.get(sum);
                
                //remove the entries of deleted nodes from hashmap
                int pSum = sum;
                ListNode temp = prevOcc.next;
                while(temp != curr) {
                    pSum += temp.val;
                    map.remove(pSum);
                    temp = temp.next;
                }
                
                prevOcc.next = curr.next;
                prev = prevOcc;
            } else {
                map.put(sum, curr);  
                prev = curr;
            }
            
            curr = curr.next;
        }
        
        return dummy.next;
    }
}
