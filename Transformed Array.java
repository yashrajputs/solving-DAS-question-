/*********************************************************** JAVA **************************************************/
//Approach (Iterate and find)
//T.C : O(n)
//S.C : O(1)
class Solution {
    public int[] constructTransformedArray(int[] nums) {
      int n = nums.length;
      int result[] = new int[n];
      for(int i = 0; i < n; i++){
        
        int shift  = nums[i] % n;// keep shift within array bounds
        
        int newIdx = ( i + shift) % n;

        //java can still give negative modulo, so fix it
        if(newIdx < 0){
          newIdx += n;
        }
        result[i] = nums[i];
      }
      return result;
    }
}
