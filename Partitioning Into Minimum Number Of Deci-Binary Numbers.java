//1689. Partitioning Into Minimum Number Of Deci-Binary Numbers.java
/******************************************************* JAVA *******************************************************/
//Approach (Greedy)
//T.C : O(n)
//S.C : O(1)
class Solution {
    public int minPartitions(String n) {
        int ans = 0; 
        for(char c : n.toCharArray()){
            ans = Math.max(ans, c - '0'); // converts character digit to integer and find max
        }
        return ans;
        
    }
}
