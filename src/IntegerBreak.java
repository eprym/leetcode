public class Solution {
    public int integerBreak(int n) {
        if(n == 2)  return 1;
        int[] prod = new int[n+1];
        prod[1] = 1;
        prod[2] = 2;
        for(int i = 3; i <= n; i++) {
            int max = 0;
            for(int j = 1; j < i; j++) {
                max = Math.max(max, j * prod[i-j]);
            }
            if(i < n)   prod[i] = Math.max(max, i);
            else    prod[i] = max;
        }
        return prod[n];
    }
}
