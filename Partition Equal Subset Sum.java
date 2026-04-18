//Approach-1 (Recursion + Memoization)
//T.C : O(n*sum)
//S.C : O(n*sum)

class Solution {
    int[][] t;
     
     public boolean isSubsetSum(int n, int sum, int[] arr){
        if(sum == 0)
         return true;
        
        if(n == 0 )
         return false;

         if(t[n][sum] != -1) {
            return t[n][sum] == 1;
         }
         boolean skip = isSubsetSum(n - 1, sum, arr);
         boolean take = false;

         if(arr[n - 1] <= sum) {
            take = isSubsetSum(n -1, sum - arr[n - 1], arr);
         }
         t[n][sum] = (take || skip) ? 1 : 0;
         return take || skip;
     }
    public boolean canPartition(int[] nums) {
        int n = nums.length;

        int SUM = 0;

        for(int num : nums)
        SUM += num;
        if(SUM % 2 != 0)
        return false;

        int S = SUM / 2;

        t = new int[n + 1][S + 1];
        for(int i = 0; i <= n; i++) {
            Arrays.fill(t[i], -1);
        }
        return isSubsetSum(n, S, nums);
    }
}


//Approach-2 (Bottom Up)
//T.C : O(n*sum)
//S.C : O(n*sum)

class Solution {
    public boolean isSubsetSum(int[] arr, int sum) {
        int n = arr.length;

        boolean[][] t = new boolean[n + 1][sum + 1];

        for (int i = 0; i <= n; i++) {
            t[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {

                boolean skip = t[i - 1][j];

                boolean take = false;
                if (arr[i - 1] <= j) {
                    take = t[i - 1][j - arr[i - 1]];
                }

                t[i][j] = take || skip;
            }
        }

        return t[n][sum];
    }

    public boolean canPartition(int[] nums) {
        int n = nums.length;

        int SUM = 0;
        for (int num : nums)
            SUM += num;

        if (SUM % 2 != 0)
            return false;

        int S = SUM / 2;

        return isSubsetSum(nums, S);
    }
}



