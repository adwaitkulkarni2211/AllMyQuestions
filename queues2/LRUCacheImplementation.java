package queues2;
import java.util.*;
public class LRUCacheImplementation {
	
	class LRUCache {
	    class Node {
	        Node next, prev;
	        int key, val;
	        
	        Node() {
	            next = prev = null;
	            key = val = -1;
	        }
	    }
	    
	    void add(Node node) {
	        Node head_next = head.next;
	        head.next = node;
	        node.next = head_next;
	        node.prev = head;
	        head_next.prev = node;
	    }
	    
	    void remove(Node node) {
	        Node node_prev = node.prev;
	        Node node_next = node.next;
	        
	        node_prev.next = node_next;
	        node_next.prev = node_prev;
	    }
	    
	    final Node head = new Node();
	    final Node tail = new Node();
	    int capacity;
	    HashMap<Integer, Node> node_map;
	    
	    public LRUCache(int capacity) {
	        head.next = tail;
	        tail.prev = head;
	        this.capacity = capacity;
	        node_map = new HashMap<>(capacity);
	    }
	    
	    public int get(int key) {
	        
	        if(node_map.containsKey(key)) {
	            Node node = node_map.get(key);
	            remove(node);
	            add(node);
	            return node.val;
	        } else {
	            return -1;
	        }
	    }
	    
	    public void put(int key, int value) {
	        Node node = node_map.get(key);
	        if(node != null) {
	            remove(node);
	            node.val = value;
	            add(node);
	        } else {
	            if(node_map.size() == capacity) {
	                node_map.remove(tail.prev.key);
	                remove(tail.prev);
	            }
	            Node nn = new Node();
	            nn.key = key;
	            nn.val = value;
	            
	            add(nn);
	            node_map.put(key, nn);
	        }        
	    }
	}

	public static void main(String[] args) {

	}

}
