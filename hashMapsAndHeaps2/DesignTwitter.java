package hashMapsAndHeaps2;
import java.util.*;

public class DesignTwitter {
	class Twitter {
	    class Tweet {
	        int userId, tweetId;
	        Tweet (int userId, int tweetId) {
	            this.userId = userId;
	            this.tweetId = tweetId;
	        }
	        public String toString() {
	            return "{" + userId + ", " + tweetId + "}";
	        }
	    }
	    List<Tweet> tweets;
	    HashMap<Integer, HashSet<Integer>> connections;
	    
	    public Twitter() {
	        tweets = new ArrayList<>();
	        connections = new HashMap<>();
	    }
	    
	    public void postTweet(int userId, int tweetId) {
	        tweets.add(new Tweet(userId, tweetId));
	    }
	    
	    public List<Integer> getNewsFeed(int userId) {
	        List<Integer> feed = new ArrayList<>();
	        
	        for(int i = tweets.size() - 1; i >= 0; i--) {
	            HashSet<Integer> connectionSet = connections.getOrDefault(userId, new HashSet<>());
	            
	            if(tweets.get(i).userId == userId || connectionSet.contains(tweets.get(i).userId)) {
	                feed.add(tweets.get(i).tweetId);
	            }
	            if(feed.size() == 10) {
	                return feed;
	            }
	        }
	        return feed;
	    }
	    
	    public void follow(int followerId, int followeeId) {
	        if(connections.containsKey(followerId)) {
	            connections.get(followerId).add(followeeId);
	        } else {
	            HashSet<Integer> connectionSet = new HashSet<>();
	            connectionSet.add(followeeId);
	            connections.put(followerId, connectionSet);
	        }
	    }
	    
	    public void unfollow(int followerId, int followeeId) {
	        if(connections.containsKey(followerId))
	            connections.get(followerId).remove(followeeId);
	    }
	}

	/**
	 * Your Twitter object will be instantiated and called as such:
	 * Twitter obj = new Twitter();
	 * obj.postTweet(userId,tweetId);
	 * List<Integer> param_2 = obj.getNewsFeed(userId);
	 * obj.follow(followerId,followeeId);
	 * obj.unfollow(followerId,followeeId);
	 */
}
