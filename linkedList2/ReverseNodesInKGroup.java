package linkedList2;

public class ReverseNodesInKGroup {
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
	
	ListNode ansHead, ansTail, tempHead, tempTail;
    
    private void addFirst(ListNode node) {
        if(tempHead == null && tempTail == null) {
            tempHead = tempTail = node;
            node.next = null;
        } else {
            node.next = tempHead;
            tempHead = node;
        }
    }
    
    private int size(ListNode head) {
        ListNode temp = head;
        int size = 0;
        while(temp != null) {
            temp = temp.next;
            size++;
        }
        return size;
    }
    
    public ListNode reverseKGroup(ListNode head, int k) {
        ansHead = ansTail = tempHead = tempTail = null;
        
        if(head == null || head.next == null) {
            return head;
        }
        
        ListNode curr = head;
        int size = size(head), i = 0;
        
        while(i < size) {
            ListNode currNext = curr.next;
            
            if(i % k != 0) {
                addFirst(curr);
            } else {                
                if(ansHead == null && ansTail == null){
                    ansHead = tempHead;
                    ansTail = tempTail;
                } else {
                    ansTail.next = tempHead;
                    ansTail = tempTail;
                }
                
                if(size - i < k) {
                    break;
                }
                
                tempHead = tempTail = null;
                
                addFirst(curr);
            }
            i++;
            curr = currNext;
        }
        
        if(ansTail != tempTail) {
            if(ansHead == null && ansTail == null){
                ansHead = tempHead;
                ansTail = tempTail;
            } else {
                ansTail.next = tempHead;
                ansTail = tempTail;
            }
        }
        
        if(curr != null) {
            ansTail.next = curr;
        }
        
        return ansHead;
    }
}
