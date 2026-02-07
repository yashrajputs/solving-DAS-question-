/******************************************************************************* JAVA ************************************************************************************************/
//Approach-1 (Using Stack)
//T.C : O(n)
//S.C :  O(n)

class Solution {
    public int minimumDeletions(String s) {
        int n  = s.length();
// using stack
        Stack<Character> st = new Stack<>();
        int ans = 0;

        for(char ch : s.toCharArray()) {
            if(ch == 'b'){
                st.push('b');
            }else{
                //ch =='a'

                if(!st.isEmpty()) {
                    ans++;
                    st.pop();
                }
            }
        }
        return ans;
    }
}
