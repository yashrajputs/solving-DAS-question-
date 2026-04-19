//Approach (Two pointers)
//T.C : O(m+n)
//S.C : O(1)

class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {

        int m =  nums1.length;
        int n = nums2.length;

        int i = 0;
        int j = 0;

        int result = 0;

        while(i < m && j < n) {
            if(nums1[i] > nums2[j]) {
                i++;
            }
            else{
                result = Math.max(result, j - i);
                j++;
            }
        }
        return result;
        
    }
}
