public class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] step = new int[m+1][n+1];
        for(int i = 0; i < step.length; i++) {
            step[i][0] = i;
        }
        for(int j = 0; j < step[0].length; j++) {
            step[0][j] = j;
        }
        for(int i = 1; i < step.length; i++) {
            for(int j = 1; j < step[0].length; j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1)) {
                    step[i][j] = step[i-1][j-1];
                }
                else {
                    step[i][j] = Math.min(step[i-1][j-1], Math.min(step[i-1][j], step[i][j-1])) + 1;
                }
            }
        }
        return step[m][n];
    }
}
