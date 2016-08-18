public class Solution {
    public int maxProduct(String[] words) {
        int[] set = new int[words.length];
        for(int i = 0; i < words.length; i++) {
            for(char c : words[i].toCharArray()) {
                set[i] |= (1 << (c-'a'));
            }
        }
        
        int max = 0;
        for(int i = 0; i < words.length; i++) {
            for(int j = i+1; j < words.length; j++) {
                if((set[i] & set[j]) == 0)  max = Math.max(max, words[i].length() * words[j].length());
            }
        }
        return max;
    }
}
