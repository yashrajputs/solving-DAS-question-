 //Space Optimized Bottom Up | Knapsack Series | DP Concepts

//Approach (Bottom Up)
//T.C : O(n*W)
//S.C : O(n*W)
class Solution {
    public int knapsack(int W, int val[], int wt[]) {
        int n = val.length;
        
        // prev → t[i-1][...]
        // curr → t[i][...]
        int[] prev = new int[W + 1];
        int[] curr = new int[W + 1];
        
        for(int i = 1; i < n + 1; i++) {
            
            for(int j = 1; j < W + 1; j++) {
                
                int take = 0;
                int skip = 0;
                
                // take → t[i-1][j - wt[i-1]]
                if(wt[i - 1] <= j) {
                    take = val[i - 1] + prev[j - wt[i - 1]];
                }
                
                // skip → t[i-1][j]
                skip = prev[j];
                
                // t[i][j]
                curr[j] = Math.max(take, skip);
            }
            
            // move current row → previous row
            prev = curr.clone();  // IMPORTANT: create new copy
        }
        
        return prev[W]; // same as t[n][W]
    }
}
