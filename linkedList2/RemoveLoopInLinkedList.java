package linkedList2;

public class RemoveLoopInLinkedList {
	public class Node {
        int val;
        Node next;
        Node() {}
        Node(int val) {
            this.val = val;
        }
        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
	public static void removeLoop(Node head){
        // code here
        // remove the loop without losing any nodes
        Node cycleStart = detectCycle(head);
        System.out.println(cycleStart);
    }
    private static Node detectCycle(Node head) {
        Node fast = head, slow = head, prev = null;
        boolean isCycle = false;
        
        while(fast != null && fast.next != null) {
            prev = fast.next;
            fast = fast.next.next;
            slow = slow.next;
            
            if(fast == slow) {
                isCycle = true;
                break;
            }
        }
        
        if(isCycle) {
            Node temp1 = head, temp2 = fast, temp2Prev = prev;
            while(temp1 != temp2) {
                temp1 = temp1.next;
                temp2Prev = temp2Prev.next;
                temp2 = temp2.next;
            }
            temp2Prev.next = null;
            return temp1;
        } else {
            return null;
        }
    }
}
