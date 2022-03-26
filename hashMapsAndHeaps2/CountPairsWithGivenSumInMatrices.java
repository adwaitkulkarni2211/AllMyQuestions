package hashMapsAndHeaps2;

public class CountPairsWithGivenSumInMatrices {
	int countPairs(int mat1[][], int mat2[][], int n, int x) {
        int size = n * n;
        int lmat = 0, rmat = size - 1;
        
        int ans = 0;
        while(lmat < size && rmat >= 0) {
            int r1 = lmat / n;
            int c1 = lmat % n;
            
            int r2 = rmat / n;
            int c2 = rmat % n;
            
            if(mat1[r1][c1] + mat2[r2][c2] > x) {
                rmat--;
            } else if(mat1[r1][c1] + mat2[r2][c2] < x) {
                lmat++;
            } else {
                ans++;
                lmat++;
                rmat--;
            }
        }
        
        return ans;
    }
}
