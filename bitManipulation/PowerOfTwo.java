package bitManipulation;

public class PowerOfTwo {
	public boolean isPowerOfTwo(int n) {
		//calling to remove warning
		solve(n * 1.0);
        return (n > 0 && (n & (n - 1)) == 0);
    }
	
	private boolean solve(double n) {
        if(n == 1.0) {
            return true;
        } else if(n < 1.0) {
            return false;
        }
        
        return solve(n / 2);
    }
}
