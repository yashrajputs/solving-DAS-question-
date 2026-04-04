//Approach-1 (Simple simulation with extra space)
//T.C : O(l), l = encodedText.length()
//S.C : O(l), all characters of encodedText in matrix
// T.C : O(l)
// S.C : O(l)

class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        if(rows == 1) return encodedText;

        int l = encodedText.length();
        int columns = l / rows;

        char[][] mat = new char[rows][columns];

        int idx = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                mat[i][j] = encodedText.charAt(idx++);
            }
        }
        StringBuilder originalText = new StringBuilder();

        for(int col = 0; col < columns; col++){
            int i = 0, j = col;

            while(i < rows && j < columns){
                originalText.append(mat[i][j]);
                i++;
                j++;
            } 
        }
        while(originalText.length() > 0 && originalText.charAt(originalText.length() - 1) == ' '){
            originalText.deleteCharAt(originalText.length() - 1);
        }
        return originalText.toString();
        
    }
}



//Approach-2 (Without extra space)
//T.C : O(l), l = encodedText.length()
//S.C : O(1)
// T.C : O(l)
// S.C : O(1)

class Solution {
    public String decodeCiphertext(String encodedText, int rows) {

        int l = encodedText.length();
        int columns = l / rows;

        StringBuilder originalText = new StringBuilder();

        for (int col = 0; col < columns; col++) {
            for (int j = col; j < l; j += (columns + 1)){
                originalText.append(encodedText.charAt(j));
            }
        }
        
        while(originalText.length() > 0 && originalText.charAt(originalText.length() - 1) == ' '){
            originalText.deleteCharAt(originalText.length() - 1);
        }
        return originalText.toString();
        
    }
}
