package graphs2;
import java.util.*;
public class CourseSchedule_Leetcode210 {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        for(int i=0; i<prerequisites.length; i++) {
            indegree[prerequisites[i][0]]++;
        }
        Queue<Integer> q = new ArrayDeque<>();
        for(int i=0; i<indegree.length; i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }

        int count = 0;
        int ans[] = new int[numCourses];
        while(q.size() > 0) {
            int rem = q.remove();
            ans[count] = rem;
            count++;
            
            for(int i=0; i<prerequisites.length; i++) {
                if(prerequisites[i][1] == rem) {
                    indegree[prerequisites[i][0]]--;
                    if(indegree[prerequisites[i][0]] == 0) {
                        q.add(prerequisites[i][0]);
                    }
                }
            }
        }
        if(count == numCourses) {
            return ans;
        } else {
            return new int[0];
        }
    }
}
