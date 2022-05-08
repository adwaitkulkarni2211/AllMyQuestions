package linkedList2;

public class CopyListWithRandomPointer {
	public class Node {
        int val;
        Node next, random;
        Node() {}
        Node(int val) {
            this.val = val;
        }
        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
    public Node copyRandomList(Node head) {
        Node curr = head, dummy = new Node(0), prev = dummy;
        
        while(curr != null) {
            Node nn = new Node(curr.val);
            
            Node currNext = curr.next;
            curr.next = nn;
            nn.next = currNext;
            
            curr = currNext;
        }
        
        curr = head;        
        while(curr != null) {
            Node random = curr.random;
            Node curr2 = curr.next;
            
            if(random == null) {
                curr2.random = null;
            } else {
                curr2.random = curr.random.next;
            }
            
            curr = curr.next.next;
        }
        
        curr = head;
        while(curr != null) {
            Node curr2 = curr.next;
            
            prev.next = curr2;
            prev = curr2;
            
            curr.next = curr.next.next;
            
            curr = curr.next;
        }
        
        return dummy.next;
        
    }
}
