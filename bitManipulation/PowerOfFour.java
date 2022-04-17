package bitManipulation;

public class PowerOfFour {
	public boolean isPowerOfFour(int n) {
		boolean ans1 = solve(n * 1.0);
		boolean ans2 = solve(n);
        System.out.println("ans1: " + ans1 + " ans2: " + ans2);
        return ans1;
    }
	
	private boolean solve(int n) {
		if(!isPowerOfTwo(n)) {
			return false;
		}
		
		int count = 0;
		while(n != 0) {
			if((n & 1) == 0) {
				count++;
			}
			n >>>= 1;
		}
		
		return (count & 1) == 0;
	}
	
	public boolean isPowerOfTwo(int n) {
        return (n > 0 && (n & (n - 1)) == 0);
    }
    
    private boolean solve(double n) {
        if(n == 1.0) {
            return true;
        } else if(n < 1.0) {
            return false;
        }
        return solve(n / 4);
    }
}
