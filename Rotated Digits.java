//Approach-1 (Brute Force SImulation)
//T.C : O(n)
//S.C : O(n* log10(num))

class Solution {

    private boolean isGood(int num) {
        boolean changed = false;

        while (num > 0) {
            int digit  = num  % 10;

            if(digit ==  3 || digit == 4 || digit == 7) return false;
            if(digit ==  2 || digit == 5 || digit == 6 || digit == 9) changed = true;
            num /= 10;
            
        }
        return changed;
    }
    public int rotatedDigits(int n) {
        int count = 0;

        for(int i = 1; i <= n; i++) {
            if(isGood(i)) {
                count++;
            }
        }
        return count;
        
    }
}


//Approach-2 (Recursion Memo)
//T.C : O(n)
//S.C : O(n)

class Solution {

    int[] t;

    private int solve(int num) {
        if (t[num] != -1)
        return t[num];

        if (num == 0)
          return t[num] = 0;

          int remain = solve(num / 10);
          if(remain == 2)
             return t[num] = 2;

             int d = num % 10;
             int digitCheck;

            if(d ==  0 || d == 1 || d == 8)
            digitCheck = 0;

            else if(d ==  2 || d == 5 || d == 6 || d == 9)
            digitCheck = 1;
            
            else
            return t[num] = 2;

            if(remain == 0 && digitCheck == 0)
            return t[num] = 0;

            return t[num] = 1;
          
    }
    public int rotatedDigits(int n) {
        t = new int[n  + 1];
        java.util.Arrays.fill(t, -1);
        int count = 0;

        for(int i = 1; i <= n; i++) {
            if(solve(i) == 1) {
                count++;
            }
        }
        return count;
        
    }
}

//Approach-3 (Bottom Up)
//T.C : O(n)
//S.C : O(n)
class Solution {
    public int rotatedDigits(int n) {

        int[] t = new int[n + 1];
        java.util.Arrays.fill(t, -1);

        t[0] = 0;
        int count = 0;

        for (int i = 1; i <= n; i++) {

            int remain = t[i / 10];

            if (remain == 2) {
                t[i] = 2;
                continue;
            }

            int d = i % 10;
            int digitCheck;

            if (d == 0 || d == 1 || d == 8)
                digitCheck = 0;
            else if (d == 2 || d == 5 || d == 6 || d == 9)
                digitCheck = 1;
            else {
                t[i] = 2;
                continue;
            }

            if (remain == 0 && digitCheck == 0)
                t[i] = 0;
            else
                t[i] = 1;

            if (t[i] == 1) {
                count++;
            }
        }

        return count;
    }
}
