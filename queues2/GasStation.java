package queues2;

public class GasStation {
	
	public static int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0, pos = 0;
        int tank = gas[start], ans = -1;
        while(true) {
            if(tank >= cost[pos]) {
                tank = tank - cost[pos];
                pos = (pos + 1) % gas.length;
                if(start == pos) {
                    ans = start;
                    break;
                }
                tank = tank + gas[pos];
            } else {
                if(pos < start) {
                    start = (start + 1) % gas.length;
                } else if(pos > start) {
                    pos = (pos + 1) % gas.length;
                    start = pos;
                    tank = gas[start];
                } else {
                    pos = (pos + 1) % gas.length;
                    start = pos;
                    tank = gas[start];
                }
                
                if(start == 0) {
                    break;
                }
            } 
        }
        return ans;
    }
	
	public static void main(String[] args) {
		int[] gas = {1, 2, 3, 4, 5};
		int[] cost = {3, 4, 5, 1, 2};
		System.out.println(canCompleteCircuit(gas, cost));
	}

}
