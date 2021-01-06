package hashMapAndHeap;
import java.util.*;
public class GenericHeap_ComparatorAndComparable {
	static class Student implements Comparable<Student> {
		int rno, ht, wt;
		Student(int rno, int ht, int wt) {
			this.rno = rno;
			this.ht = ht;
			this.wt = wt;
		}
		
		public int compareTo(Student o) {
			return this.rno - o.rno;
			//while adding child's roll number is compared to
			//paren's roll number and then add
			//return o.rno - this.rno //so that larger element
			//has greater priority.
		}
		
		public String toString() {
			return "rno: " + this.rno + " ht: " + this.ht + " wt: " + this.wt;
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
	
	public static void main(String[] args) {
		int[] a = {10, 2, 17, 3, 18, 9, 22};
		System.out.println(a);
		PriorityQueue<Student> pq = new PriorityQueue<>(new StudentHtComparator());
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
