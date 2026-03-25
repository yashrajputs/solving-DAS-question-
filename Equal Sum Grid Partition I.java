//Approach (Using prefix sum)
//T.C : O(m*n)
//S.C : O(m+n)

class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n =  grid[0].length;


        long[] rowSum = new long[m];
        long[] colSum = new long[n];

        long total = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                total += grid[i][j];
                rowSum[i] += grid[i][j];     
                colSum[j] += grid[i][j];       
            }
        }
        if(total % 2 != 0){
            return false;
        }
        long upper = 0;
        for(int i = 0; i < m; i++) {
            upper += rowSum[i];
            if(upper == total - upper){
                return true;
            }
        }
        long left = 0;
        for(int j = 0; j < n; j++){
            left += colSum[j];
            if(left == total - left){
                return true;
            }
        }
        return false;
    }
}
