package collegeQuestions;
import java.util.*;
public class BooleanFunctions {
	
	public static List<Integer> union(List<Integer> a, List<Integer> b) { //Union Fuction
		List<Integer> uni = new ArrayList<>();
		for(int i=0;i<a.size();i++) {                                     //adding all elements of set A
			uni.add(a.get(i));
		}
		
		for(int i=0;i<b.size();i++) {									  //adding elements of set B 
																		  //while comparing with A
			boolean isPresent = false;
			for(int j=0;j<uni.size();j++) {
				if(uni.get(j)==b.get(i)) {
					isPresent = true;
					break;
				}
			}
			if(!isPresent)
				uni.add(b.get(i));
		}
		Collections.sort(uni);											//sorting elements
		  return uni;
	}
	
	public static List<Integer> intersection(List<Integer> a, List<Integer> b) { //function for Intersection
		List<Integer> inter = new ArrayList<>();
		
		for(int i=0;i<a.size();i++) {					//cheking for common elements and adding if found
			for(int j=0;j<b.size();j++) {
				if(a.get(i)==b.get(j)) {
					inter.add(a.get(i));
					break;
				}
			}
		}
		return inter;
	}
	
	public static List<Integer> difference(List<Integer> a, List<Integer> b) { //function for difference 
		List<Integer> diff = new ArrayList<>();
		
		for(int i=0;i<a.size();i++) {					//if common element is found it is not added 
			boolean present = false;
			for(int j=0;j<b.size();j++) {
				if(a.get(i)==b.get(j)) {
					present = true;
					break;
				}
			}
			if(!present)
				diff.add(a.get(i));
		}
		return diff;
	}
	
	public static List<Integer> symDifference(List<Integer> a, List<Integer> b) { //function for symmetric difference 
		List<Integer> diff1 = new ArrayList<>();
		List<Integer> diff2 = new ArrayList<>();
		List<Integer> symDiff = new ArrayList<>();
		diff1 = difference(a,b);					//difference (A-B)
		diff2 = difference(b,a);				    //difference (B-A)
		symDiff = union(diff1,diff2);				//(A-B) U (B-A)
		return symDiff;
	}
	public static void display(List<Integer> a) { //Display function
		System.out.print(a);
		System.out.println();
	}
	public static void main(String[] args) {	//main function
		Scanner sc = new Scanner(System.in);
		List<Integer> a = new ArrayList<>();
		List<Integer> b = new ArrayList<>();
		List<Integer> ans = new ArrayList<>();
		System.out.println("Enter the number of elements in Set A:"); //taking input from user
		int n = sc.nextInt();
		System.out.println("Enter the number of elements in Set B:");
		int m = sc.nextInt();
		System.out.println("Enter the elements in Set A:");	//entering elements
		for(int i=0;i<n;i++) {
			int x = sc.nextInt();
			a.add(x);
		}
		System.out.println("Enter the elements in Set A:");
		for(int i=0;i<m;i++) {
			int x = sc.nextInt();
			b.add(x);
		}
		sc.close();
		ans = union(a,b); 			//performing union on a and b
		System.out.println("Union of A and B is:");
		display(ans);
		ans = intersection(a,b);	//performing intersection on a and b
		System.out.println("Intersection of A and B is:");
		display(ans);
		ans = difference(a,b);		//performing difference on a and b
		System.out.println("Differnce of A and B is:");
		display(ans);
		ans = symDifference(a,b);	//performing symmetric difference on a and b
		System.out.println("Symmetric Difference of A and B is:");
		display(ans);
	}
}
