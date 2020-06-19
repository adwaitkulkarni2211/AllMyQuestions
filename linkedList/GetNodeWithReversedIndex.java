package linkedList;

public class GetNodeWithReversedIndex {
    static int getNode(SinglyLinkedListNode head, int positionFromTail) {
        SinglyLinkedListNode temp1 = head;
        SinglyLinkedListNode temp2 = head;
        for(int i=0;i<positionFromTail;i++) {
            temp2=temp2.next;
        }
        while(temp2.next!=null) {
            temp2=temp2.next;
            temp1=temp1.next;
        }
        return temp1.data;
    }
}
