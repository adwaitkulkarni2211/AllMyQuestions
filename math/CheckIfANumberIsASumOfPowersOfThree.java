package math;

public class CheckIfANumberIsASumOfPowersOfThree {
	public boolean checkPowersOfThree(int n) {
        return solve(n, Integer.MAX_VALUE);
    }
    
    private boolean solve(int n, int prevPow) {
        if(n == 0) {
            return true;
        }
        
        int temp = 1;
        while(temp <= prevPow && temp <= n) {
            temp *= 3;
        }
        
        if(temp > prevPow) {
            return false;
        }
        
        return solve(n - (temp / 3), temp / 3);
    }
}
