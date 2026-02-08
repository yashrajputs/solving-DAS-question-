/******************************************************************************* JAVA ************************************************************************************************/
//Approach (Using Line Sweep/Difference Array Technique)
//T.C : O(n * logn)
//S.C : O(n)

class Solution {
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        int n = nums.length;

        int MOD = 1_000_000_007;

        int[] events = new int[n];

        for(int[] req : requests) {
            int start = req[0];
            int end = req[1];

            events[start] += 1;
            if(end + 1 < n) {
                events[end + 1] -= 1;
            }
        }
        for(int i = 1; i < n; i++) {
             events[i] += events[i - 1];
        }

        Arrays.sort(nums);
        Arrays.sort(events);

        long result = 0;

        for(int i = n - 1; i >= 0; i--) {
            long contrib = (long) nums[i] * events[i];
            result = (result + contrib) % MOD;
        }
        return (int) result;
        
    }
}
