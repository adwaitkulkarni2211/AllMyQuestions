package misc;
import java.util.*;
import java.io.*;
public class ClimbingTheLeaderboard {
	static int[] climbingLeaderboard(int[] scores, int[] alice) {
        int ranks[] = new int[scores.length]; int rank=1;
        int aliceRanks[] = new int[alice.length];
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        for(int i=0;i<scores.length;i++) {
            ad.addLast(scores[i]);
        }
        ranks[0] = 1; 
        for(int i=0;i<scores.length-1;i++) {
            if(scores[i]>scores[i+1]) {
                ranks[i+1] = (++rank);
            } else if(scores[i]==scores[i+1]) {
                ranks[i+1] = rank;
            }
        }
        for(int i=0;i<alice.length;i++) {
            for(int j=ad.size()-1;j>=0;j--) {
                if(alice[i]<scores[j]) {
                    aliceRanks[i] = ranks[j] + 1;
                    break;
                } else if(alice[i]==scores[j]) {
                    aliceRanks[i] = ranks[j];
                     if(j!=0) { 
                    ad.removeLast();
                    }
                } else if(alice[i]>scores[j]){
                    aliceRanks[i] = ranks[j];
                    if(j!=0) { 
                    ad.removeLast();
                    }
                }
            }
        }
        return aliceRanks;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int scoresCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[scoresCount];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < scoresCount; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int aliceCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] alice = new int[aliceCount];

        String[] aliceItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < aliceCount; i++) {
            int aliceItem = Integer.parseInt(aliceItems[i]);
            alice[i] = aliceItem;
        }

        int[] result = climbingLeaderboard(scores, alice);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

}
