package arrays;
import java.util.*;
public class Maze2DArray {
	public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int a[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        sc.close();
        int minc = 0, maxc = a[0].length - 1;
        int minr = 0, maxr = a.length - 1;
        int i = minr, j = minc;
        boolean isOut = false;
        long start = System.currentTimeMillis();
        if (a[i][j] == 0) {
            while (true) {
                while (a[i][j] == 0) {
                    System.out.println("To right: i = " + i + " j: " + j);
                    
                    if (j == maxc) {
                        isOut = true;
                        System.out.println("right i: " + i);
                        System.out.println("right j: " + j);
                        break;
                    }
                    j++;
                }
                i++;
                if (isOut == true) {
                    break;
                }
                while (a[i][j] == 0) {
                    System.out.println("To down: i = " + i + " j: " + j);
                    
                    if (i == maxr) {
                        isOut = true;
                        System.out.println("down i: " + i);
                        System.out.println("down j: " + j);
                        break;
                    }
                    i++;
                }
                j--;
                if (isOut == true) {
                    break;
                }
                while (a[i][j] == 0) {
                    System.out.println("To left: i = " + i + " j: " + j);
                    
                    if (j == minc) {
                        isOut = true;
                        System.out.println("left i: " + i);
                        System.out.println("left j: " + j);
                        break;
                    }
                    j--;
                }
                i--;
                if (isOut == true) {
                    break;
                }
                while (a[i][j] == 0) {
                    System.out.println("To up: i = " + i + " j: " + j);
                    
                    if (i == minr) {
                        isOut = true;
                        System.out.println("up i: " + i);
                        System.out.println("up j: " + j);
                        break;
                    }
                    i--;
                }
                j++;
                if (isOut == true) {
                    break;
                }
            }
        } else {
            System.out.println("shiz i" + i);
            System.out.println("shiz j " + j);
        }
        long end = System.currentTimeMillis();
        System.out.println("My method: "+ (end - start));
        
        //Sumeet's method
        i = 0; j = 0; int dir = 0;
        start = System.currentTimeMillis();
        while(true) {
        	dir = (dir + a[i][j]) % 4;
        	if(dir == 0) 
        		j++;
        	else if(dir == 1)
        		i++;
        	else if(dir == 2)
        		j--;
        	else if(dir == 3)
        		i--;
        	
        	if(i < 0) {
        		i++;
        		break;
        	} else if(j < 0) {
        		j++;
        		break;
        	} else if(i == a.length) {
        		i--;
        		break;
        	} else if(j == a[0].length) {
        		j--;
        		break;
        	}
        }
        System.out.println(i);
        System.out.println(j);
        end = System.currentTimeMillis();
        System.out.println("Sumeet's method: "+ (end - start));
    }
}






















