package linkedList2;

public class SegregateOddEvenNodes {
	class Node {
		int data;
		Node next;
		Node(int data) {
			this.data = data;
			next = null;
		}
	}
	Node divide(int n, Node head){
        Node ePrev = new Node(-1), oPrev = new Node(-1);
        Node curr = head, eDummy = ePrev, oDummy = oPrev;
        
        while(curr != null) {
            if(curr.data % 2 == 0) {
                ePrev.next = curr;
                ePrev = curr;
            } else {
                oPrev.next = curr;
                oPrev = curr;
            }
            curr = curr.next;
        }
        
        oPrev.next = null;
        
        ePrev.next = oDummy.next;
        
        return eDummy.next;
    }
}
