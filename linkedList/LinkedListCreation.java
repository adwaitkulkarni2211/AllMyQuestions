package linkedList;
import java.util.*;
public class LinkedListCreation {
	public static class Node {
        int data;
        Node next;
    }

    public static class LinkedList {
        Node head;
        Node tail;
        int size;

        void addLast(int val) {
            // Write your code here
            Node n = new Node();
            if (size == 0) {
                n.data = val;
                n.next = null;
                tail = n;
                head = n;
                size++;
            } else {
                n.data = val;
                n.next = null;
                tail.next = n;
                tail = n;
                size++;
            }
        }
        
        public int size() {
            // write code here
            return size;
        }

        public void display() {
            // write code here
            if (size == 0) {
                System.out.println();
                return;
            }
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }
        
        public void removeFirst() {
            // write your code here
            if(size == 0) {
                System.out.println("List is empty");
                return;
            } else if(size == 1) {
                head = null;
                tail = null;
                size--;
                return;
            }
            Node temp = head;
            head = head.next;
            temp = null;
            System.out.println(temp + " is now disconnected from the LinkedList.");
            size--;
        }
        
        public int getFirst() {
            // write your code here
            if (size == 0) {
                System.out.println("List is empty");
                return -1;
            }
            return head.data;
        }

        public int getLast() {
            // write your code here
            if (size == 0) {
                System.out.println("List is empty");
                return -1;
            }
            return tail.data;
        }

        public int getAt(int idx) {
            // write your code here
            if (size == 0) {
                System.out.println("List is empty");
                return -1;
            } else if (idx >= size || idx < 0) {
                System.out.println("Invalid arguments");
                return -1;
            }
            Node temp = head;
            int i = 0;
            while (i < idx) {
                temp = temp.next;
                i++;
            }
            return temp.data;
        }
        
        public void addFirst(int val) {
            // write your code here
            Node n = new Node();
            n.data = val;
            if(size == 0) {
                n.next = null;
                head = n;
                tail = n;
                size++;
                return;
            }
            n.next = head;
            head = n;
            size++;
        }
        
        public void addAt(int idx, int val) {
            // write your code here
            if (idx > size || idx < 0) {
                System.out.println("Invalid arguments");
            } else if (idx == 0) {
                addFirst(val);
            } else if (idx == size) {
                addLast(val);
            } else {
                Node n = new Node(), temp = head;
                int i = 0;
                n.data = val;
                while (i < idx - 1) {
                    temp = temp.next;
                    i++;
                }
                n.next = temp.next;
                temp.next = n;
                size++;
            }
        }
        
        public void removeLast() {
            // write your code here
            if(size == 0) {
                System.out.println("List is empty");
            } else if(size == 1) {
                head = tail = null;
                size--;
            } else {
                int i = 0;
                Node temp = head;
                while(i < size - 2) {
                    temp = temp.next;
                    i++;
                }
                tail = temp;
                temp.next = null;
                size--;
            }
        }
        
        public void removeAt(int idx) {
            // write your code here
            if (size == 0) {
                System.out.println("List is empty");
            } else if(idx == 0) {
                removeFirst();
            } else if(idx < 0 || idx >= size) {
                System.out.println("Invalid arguments");
            } else if(idx == size - 1) {
                removeLast();
            } else {
                Node temp = head;
                int i = 0;
                while(i < idx - 1) {
                    temp = temp.next;
                    i++;
                }
                temp.next = temp.next.next;
                size--;
            }
        }
        
        public void reverseDI() {
            // write your code here
            int i = 0, j = size - 1; 
            while( i <= j) {
                int last = getAt(j);
                int first = getAt(i);
                removeAt(i);
                addAt(i, last);
                removeAt(j);
                addAt(j, first);
                i++;
                j--;
            }
        }
        
        public Node getNodeAt(int idx) {
            if (size == 0) {
              return null;
            } else if (idx < 0 || idx >= size) {
              return null;
            } else {
              Node temp = head;
              for (int i = 0; i < idx; i++) {
                temp = temp.next;
              }
              return temp;
            }
          }
        
        public void reverseDIBetter() {
            int i = 0, j = size - 1;
            
            while(i < j) {
                Node n1 = getNodeAt(i);
                Node n2 = getNodeAt(j);
                
                int temp = n1.data;
                n1.data = n2.data;
                n2.data = temp;
                
                i++;
                j--;
            }
        }
        
        public void reversePI() {
            // write your code here
            Node cur = head.next, prev = head;
            head.next = null;
            while(cur != null) {
                Node next = cur.next;
                cur.next = prev;
                
                prev = cur;
                cur = next;
            }
            Node temp = head;
            head = tail;
            tail = temp;
        }
        
        public int kthFromLast(int k) {
            // My initial approach
            // reversePI();
            // Node temp = head;
            // for(int i=0; i<k; i++) {
            //     temp = temp.next;
            // }
            // reversePI();
            // return temp.data;
        	
        	//Better and recommended approach:
            Node fast = head, slow = head;
            for(int i=0; i<k; i++) {
                fast = fast.next;
            }
            while(fast != tail) {
                slow = slow.next;
                fast = fast.next;
            }
            return slow.data;
        }
        
        public int mid() {
            Node fast = head;
            Node slow = head;

            while (fast.next != tail && fast != tail) {
                fast = fast.next.next;
                slow = slow.next;
            }

            return slow.data;
        }
        
        public static LinkedList mergeTwoSortedLists(LinkedList l1, LinkedList l2) {
            Node temp1 = l1.head, temp2 = l2.head;
            LinkedList ans = new LinkedList();
            while(temp1 != null && temp2 != null) {
                if(temp1.data <= temp2.data) {
                    ans.addLast(temp1.data);
                    temp1 = temp1.next;
                } else if(temp2.data <= temp1.data) {
                    ans.addLast(temp2.data);
                    temp2 = temp2.next;
                }
            }
            
            if(temp1 == null) {
                while(temp2 != null) {
                    ans.addLast(temp2.data);
                    temp2 = temp2.next;
                }
            } else if(temp2 == null) {
                while(temp1 != null) {
                    ans.addLast(temp1.data);
                    temp1 = temp1.next;
                }
            }
            return ans;
        }
        
        private static Node mergeTwoSortedListsBetter(Node one, Node two) {
        	Node i = one, j = two, dummy = new Node(), prev = dummy;
            while(i != null && j != null) {
                if(j.data < i.data) {
                    prev.next = j;
                    j = j.next;
                } else {
                    prev.next = i;
                    i = i.next;
                }
                prev = prev.next;
            }
            
            prev.next = i != null ? i : j;
            
            Node head = dummy.next;
            dummy.next = null;
            
            return head;
        }
        
        public static Node midNode(Node head, Node tail) {
            Node f = head;
            Node s = head;

            while (f != tail && f.next != tail) {
                f = f.next.next;
                s = s.next;
            }

            return s;
        }

        public static LinkedList mergeSort(Node head, Node tail) {
            if (head == tail) {
                LinkedList toReturn = new LinkedList();
                toReturn.addLast(head.data);
                return toReturn;
            }

            LinkedList l1 = mergeSort(head, midNode(head, tail));
            LinkedList l2 = mergeSort(midNode(head, tail).next, tail);
            LinkedList ans = LinkedList.mergeTwoSortedLists(l1, l2);
            
            //ignore the next 2 lines, it's written just to to remove a warning
            Node shit = mergeTwoSortedListsBetter(null, null);
            System.out.println(shit);
            
            return ans;
        }
        
        public void removeDuplicates() {
            // write your code here
            LinkedList ans = new LinkedList();
            while(this.size() > 0) {
                int val = this.getFirst();
                this.removeFirst();
                
                if(ans.size() == 0 || ans.getLast() != val) {
                    ans.addLast(val);
                }
            }
            this.head = ans.head;
            this.tail = ans.tail;
            this.size = ans.size; 
        }
        
        //Different Approach
        public void removeDuplicates2(){
            Node temp = head;
            
            while(temp != null) {
                while(temp.next != null && temp.data == temp.next.data) {
                    temp.next = temp.next.next;
                }
                temp = temp.next;
            }
            
            Node slow = head, fast = head.next;
            while(fast != null) {
                fast = fast.next;
                slow = slow.next;
            }
            tail = slow;
        }
        
        //Remove Duplicates from unsorted list
        public Node removeDuplicatesUnsorted(Node head) {
            HashSet<Integer> set = new HashSet<>();
            
            Node curr = head, prev = null;
            while(curr != null) {
                if(set.contains(curr.data)) {
                    prev.next = curr.next;
                } else {
                    set.add(curr.data);
                    prev = curr;
                }
                curr = curr.next;
            }
            
            return head;
        }
        
        public void oddEven() {
            // My Approach O(n^2):
            LinkedList ans = new LinkedList();
            int i = 0;
            while(this.size() > 0) {
                int val = this.getFirst();
                this.removeFirst();
                
                if(val % 2 == 0) {
                    ans.addLast(val);
                } else {
                    ans.addAt(i, val);
                    i++;
                }
            }
            this.head = ans.head;
            this.tail = ans.tail;
            this.size = ans.size;
            
            //Recommended O(n):
            
            LinkedList odd = new LinkedList();
            LinkedList even = new LinkedList();
            while(this.size() > 0) {
                int val = this.getFirst();
                this.removeFirst();
                
                if(val % 2 == 0) {
                    even.addLast(val);
                } else {
                    odd.addLast(val);
                }
            }
            if(even.size() > 0 && odd.size() > 0) {
                odd.tail.next = even.head;
                this.head = odd.head;
                this.tail = even.tail;
                this.size = odd.size() + even.size();    
            } else if(odd.size == 0) {
                this.head = even.head;
                this.tail = even.tail;
                this.size = even.size();
            } else if(even.size == 0) {
                this.head = odd.head;
                this.tail = odd.tail;
                this.size = odd.size();
            }
        }
        
        public void kReverse(int k) {
            LinkedList prev = null;
            
            while (this.size() > 0) {
                LinkedList cur = new LinkedList();

                if (this.size >= k) {
                    for (int i = 0; i < k; i++) {
                        int val = this.getFirst();
                        this.removeFirst();
                        cur.addFirst(val);
                    }
                } else {
                    int s = this.size();
                    for (int i = 0; i < s; i++) {
                        int val = this.getFirst();
                        this.removeFirst();
                        cur.addLast(val);
                    }
                }

                if (prev == null) {
                    prev = cur;
                } else {
                    prev.tail.next = cur.head;
                    prev.tail = cur.tail;
                    prev.size = prev.size + cur.size;
                }
            }
            this.head = prev.head;
            this.tail = prev.tail;
            this.size = prev.size;
        }
        
        private void displayReverseHelper(Node node) {
            // write your code here
            if(node == null) {
                return;
            }
            displayReverseHelper(node.next);
            System.out.print(node.data + " ");
        }

        public void displayReverse() {
            displayReverseHelper(head);
            System.out.println();
        }
        
        //My approach:
        private void reversePRHelper(Node prev, Node cur) {
            if(cur == null) {
                return;
            }
            
            Node next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            reversePRHelper(prev, cur);
        }
        
        //Pepcoding's approach:
        private void reversePRHelper(Node node) {
            if(node == null) {
                return;
            }
            
            reversePRHelper(node.next);
            
            if(node == tail) {
            	//nothing to do as there's nothing ahead of tail to point to it.
            } else {
            	//from the 2nd last node, it's next node's next will point to it.
            	node.next.next = node;
            }
        }

        public void reversePR() {
            reversePRHelper(head, head.next);
            reversePRHelper(head);
            head.next = null;
            Node temp = head;
            head = tail;
            tail = temp;
        }
        
        private boolean isPalHelper(Node right) {
            if (right == null) {
                return true;
            }

            boolean rres = isPalHelper(right.next);

            if (rres == false) {
                return false;
            } else if (pLeft.data != right.data) {
                return false;
            } else {
                pLeft = pLeft.next;
                return true;
            }
        }

        Node pLeft;
        public boolean IsPalindrome() {
            pLeft = head;
            return isPalHelper(pLeft);
        }
        
        //Fold a linked List my method using an extra linkedlist:
        private LinkedList foldHelper(Node right) {
            if(right == null) {
                return new LinkedList();
            }
            
            LinkedList ll = foldHelper(right.next);
            if(right == left) {
                ll.addLast(left.data);
                left = right = null;
                return ll;
            } else if(this.size == ll.size) {
                return ll;
            } else {
                ll.addLast(left.data);
                ll.addLast(right.data);
                left = left.next;
                return ll;
            }            
        }
        Node left;
        public void fold() {
            left = head;
            LinkedList fold = foldHelper(head);
            this.head = fold.head;
            this.tail = fold.tail;
            this.size = fold.size;
        }
        
        //Recommended method without using any extra space:
        private void foldHelper(Node right, int floor) {
            if(right == null) {
                return;
            }
            
            foldHelper(right.next, floor + 1);
            if(floor > size / 2) {
                Node next = left2.next;
                left2.next = right;
                right.next = next;
                left2 = next;    
            } else if(floor == size/2) {
                tail = right;
                tail.next = null;
            }
            
        }
        Node left2;
        public void fold2() {
            left2 = head;
            foldHelper(head, 0);
        }
        
      //pv stands for Place Value
        public static int addListHelper(Node one, int pv1, Node two, int pv2, LinkedList res) {
            if(one == null && two == null) {
                //Returning carry
                return 0;
            }
            
            int data = 0;
            if(pv1 > pv2) {
                int oldCarry = addListHelper(one.next, pv1 - 1, two, pv2, res);
                data = one.data + oldCarry;
            } else if (pv2 > pv1) {
                int oldCarry = addListHelper(one, pv1, two.next, pv2 - 1, res);
                data = two.data + oldCarry;
            } else {
                int oldCarry = addListHelper(one.next, pv1 - 1, two.next, pv2 - 1, res);
                data = one.data + two.data + oldCarry;
            }
            int newData = data % 10;
            int newCarry = data / 10;
            
            res.addFirst(newData);
            return newCarry;
        }

        public static LinkedList addTwoLists(LinkedList one, LinkedList two) {
            LinkedList res = new LinkedList();
            
            int oc = addListHelper(one.head, one.size, two.head, two.size, res);
            
            if(oc > 0) {
                res.addFirst(oc);
            }
            return res;
        }
        
        public static int findIntersection(LinkedList one, LinkedList two) {
            Node t1 = one.head, t2 = two.head;
            int delta = Math.abs(one.size - two.size);
            if(one.size > two.size) {
                for(int i=0; i<delta; i++) {
                    t1 = t1.next;
                }
            } else {
                for(int i=0; i<delta; i++) {
                    t2 = t2.next;
                }
            }
            while(t1 != t2) {
                t1 = t1.next;
                t2 = t2.next;
            }
            
            return t1.data;
        }
        
    }
    public static void main(String[] args) {
		
	}
}
