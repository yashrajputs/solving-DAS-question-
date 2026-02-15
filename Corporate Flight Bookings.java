/******************************************************************************* JAVA ************************************************************************************************/
//Approach (Using Line Sweep/Difference Array Technique)
//T.C : O(n)
//S.C : O(n)

class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] diff = new int[n + 2];

        for(int[] b : bookings) {
            int start = b[0];
            int end = b[1];
            int count = b[2];

            diff[start] += count;
            diff[end + 1] -= count;
        }
        // Prefix sum to build result
        int[] result = new int[n];
        int cumSum =0;

        for(int i = 1; i <= n; i++){
            cumSum += diff[i];
            result[i - 1] = cumSum; // shift because result is 0-based
        }
        return result;
    }
}
