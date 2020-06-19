package linkedList;

public class ReversePrint {
	static void reversePrint(SinglyLinkedListNode head) {
        if(head==null) {
            return; 
        } else {
            reversePrint(head.next);
        }
        System.out.println(head.data);
    }
}
