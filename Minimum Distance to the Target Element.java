//Approach-1 (Simple simulation)
//T.C : O(n)
//S.C : O(1)
class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int n = nums.length;

        int result = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (nums[i] == target) {
                result = Math.min(result, Math.abs(i - start));
            }
        }

        return result;
    }
}


//Approach-2 (Loop with Early Break)
//T.C : O(n)
//S.C : O(1)
class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int n = nums.length;

        int result = Integer.MAX_VALUE;

        // stop early if i go beyond the possible better distance
        for (int i = 0; i < n && result > Math.abs(i - start); i++) {
            if (nums[i] == target) {
                result = Math.min(result, Math.abs(i - start));
            }
        }

        return result;
    }
}
