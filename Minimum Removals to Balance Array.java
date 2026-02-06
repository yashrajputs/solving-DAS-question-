/******************************************************************************* JAVA ************************************************************************************************/
//Approach (Sliding window)
//T.C : O(n * logn),
//S.C : O(1) 

class Solution {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int left = 0, right = 0;
        int ans = n;
        
        while(left < n) {
            // Expand window while valid: max <= k * min
            while(right < n && nums[right] <= (long)k * nums[left]) {
                right++;
            }
            
            // Track minimum removals: total - elements kept in window
            ans = Math.min(ans, n - (right - left));
            
            // Right pointer doesn't reset due to sorted array property
            left++;
        }

        return ans;
    }
}


/******************************************************************************* JAVA ************************************************************************************************/
//Approach (Sliding window)


import java.util.Arrays;

class Solution {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums); // Sort array to maintain order
        int n = nums.length;
        int maxSize = 0;
        int left = 0;

        // Use sliding window to find longest valid subarray
        for (int right = 0; right < n; right++) {
            // While condition is violated, shrink window from left
            while (nums[right] > (long) k * nums[left]) left++;
            maxSize = Math.max(maxSize, right - left + 1);
        }
        // Return number of elements to remove
        return n - maxSize;
    }
}
