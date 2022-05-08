package stacks2;

import java.util.Stack;

public class DesignBrowserHistory {
	class BrowserHistory {
	    Stack<String> backHist;
	    Stack<String> fwdHist;
	    public BrowserHistory(String homepage) {
	        backHist = new Stack<>();
	        fwdHist = new Stack<>();
	        
	        backHist.push(homepage);
	    }
	    
	    public void visit(String url) {
	        backHist.push(url);
	        fwdHist = new Stack<>();
	    }
	    
	    public String back(int steps) {
	        while(backHist.size() > 1 && steps > 0) {
	            fwdHist.push(backHist.pop());
	            steps--;
	        }
	        return backHist.peek();
	    }
	    
	    public String forward(int steps) {
	        while(fwdHist.size() > 0 && steps > 0) {
	            backHist.push(fwdHist.pop());
	            steps--;
	        }
	        
	        return backHist.peek();
	    }
	}
}
