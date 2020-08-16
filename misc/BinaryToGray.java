package misc;
import java.util.*;
public class BinaryToGray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a bunary number: ");
		int n = sc.nextInt();
		int temp = n, r;
		List<Integer> binary = new ArrayList<>();
		List<Integer> gray = new ArrayList<>();
		while(temp != 0) {
			r = temp % 10;
			binary.add(0, r);
			temp = temp / 10;
		}
		gray.add(binary.get(0));
		for(int i=1; i<binary.size(); i++) {
			System.out.println(binary.get(i));
			if(binary.get(i) == binary.get(i-1)) {
				gray.add(0);
			}
			else {
				gray.add(1);
			}
		}
		System.out.println("The graycode is: " + gray);
	}

}
