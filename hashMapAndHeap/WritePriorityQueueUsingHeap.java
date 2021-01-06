package hashMapAndHeap;
import java.io.*;
import java.util.*;

import hashMapAndHeap.GenericHeap_ComparatorAndComparable.Student;
public class WritePriorityQueueUsingHeap {
	public static class PriorityQueue<T> {
        ArrayList<T> data;
        Comparator comp;

        public PriorityQueue() {
            data = new ArrayList<>();
            comp = null;
        }
        
        public PriorityQueue(Comparator comp) {
            data = new ArrayList<>();
            this.comp = comp;
        }
        
        private boolean isSmaller(int i, int j) {
        	if(comp == null) {
        		Comparable ith = (Comparable)data.get(i);
            	Comparable jth = (Comparable)data.get(j);
            	if(ith.compareTo(jth) < 0) {
            		return true;
            	} else {
            		return false;
            	}
        	} else {
        		T ith = data.get(i);
            	T jth = data.get(j);
        		if(comp.compare(ith, jth) < 0) {
            		return true;
            	} else {
            		return false;
            	}
        	}
        	
        }
        
        public void add(T val) {
            data.add(val);
            
            int i = data.size() - 1;
            upheapify(i);
        }
        private void upheapify(int i) {
            if(i == 0) {
                return;
            }
            
            int pi = (i - 1) / 2;
            if(isSmaller(i, pi)) {
                swap(pi, i);
                upheapify(pi);
            }
        }
        private void swap(int i, int j) {
            T ith = data.get(i);
            T jth = data.get(j);
            data.set(i, jth);
            data.set(j, ith);
        }

        public T remove() {
            if(this.size() == 0) {
                System.out.println("Underflow");
                return null;
            }
            swap(0, data.size() - 1);
            T val = data.remove(data.size() - 1);
            downheapify(0);
            return val;
        }
        private void downheapify(int pi) {
            int min = pi;
            
            int li = (2 * pi) + 1;
            if(li < data.size() && isSmaller(li, min) == true) {
                min = li;
            }
            
            int ri = (2 * pi) + 2;
            if(ri < data.size() && isSmaller(ri, min) == true) {
                min = ri;
            }
            
            if(min != pi) {
                swap(pi, min);
                downheapify(min);
            }
        }

        public T peek() {
            if(this.size() == 0) {
                System.out.println("Underflow");
                return null;
            }
            return data.get(0);
        }

        public int size() {
            return data.size();
        }
    }
	
	static class StudentHtComparator implements Comparator<Student> {
		public int compare(Student s1, Student s2) {
			return s1.ht - s2.ht;
		}
	}
	
	static class StudentWtComparator implements Comparator<Student> {
		public int compare(Student s1, Student s2) {
			return s1.wt - s2.wt;
		}
	}

    public static void main(String[] args) throws Exception {
    	int[] a = {10, 2, 17, 3, 18, 9, 22};
		System.out.println(a);
		//comparing on the basis of weight using StudentWtComparator
		PriorityQueue<Student> pq = new PriorityQueue<>(new StudentWtComparator());
		pq.add(new Student(10, 190, 89));
		pq.add(new Student(20, 165, 65));
		pq.add(new Student(1, 170, 73));
		pq.add(new Student(40, 160, 55));
		pq.add(new Student(16, 169, 67));
		
		while(pq.size() > 0) {
			System.out.println(pq.peek());
			pq.remove();
		}
    }
}
