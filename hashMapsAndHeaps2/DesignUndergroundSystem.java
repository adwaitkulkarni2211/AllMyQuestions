package hashMapsAndHeaps2;
import java.util.*;

public class DesignUndergroundSystem {
	class UndergroundSystem {
	    class Pair {
	        String station;
	        int time;
	        Pair(String station, int time) {
	            this.station = station;
	            this.time = time;
	        }
	    }
	    HashMap<Integer, Pair> ids;
	    HashMap<String, List<Integer>> times;
	    public UndergroundSystem() {
	        ids = new HashMap<>();
	        times = new HashMap<>();
	    }
	    
	    public void checkIn(int id, String stationName, int t) {
	        ids.put(id, new Pair(stationName, t));
	    }
	    
	    public void checkOut(int id, String stationName, int t) {
	        Pair p = ids.get(id);
	        
	        String stations = p.station + "-" + stationName;
	        
	        if(times.containsKey(stations)) {
	            List<Integer> timesSums = times.get(stations);
	            timesSums.add(t - p.time);
	        } else {
	            List<Integer> timesSums = new ArrayList<>();
	            timesSums.add(t - p.time);
	            times.put(stations, timesSums);
	        }
	    }
	    
	    public double getAverageTime(String startStation, String endStation) {
	        List<Integer> timesSums = times.get(startStation + "-" + endStation);
	        
	        int sum = 0;
	        for(int num: timesSums) {
	            sum += num;
	        }
	        
	        return (sum * 1.0) / (timesSums.size() * 1.0);
	        
	    }
	}

	/**
	 * Your UndergroundSystem object will be instantiated and called as such:
	 * UndergroundSystem obj = new UndergroundSystem();
	 * obj.checkIn(id,stationName,t);
	 * obj.checkOut(id,stationName,t);
	 * double param_3 = obj.getAverageTime(startStation,endStation);
	 */

}
