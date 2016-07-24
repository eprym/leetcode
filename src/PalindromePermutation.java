public class Solution {
    public boolean canPermutePalindrome(String s) {
        if(s.length() <= 1) return true;
        Map<Character, Integer> freq = new HashMap<>();
        for(char c : s.toCharArray()) {
            if(freq.containsKey(c)) freq.put(c, freq.get(c)+1);
            else    freq.put(c, 1);
        }
        int count = 0;
        for(Character key : freq.keySet()) {
            if(freq.get(key) % 2 != 0)  count++;
        }
        if(s.length() % 2 == 0) return count == 0;
        else    return count == 1;
    }
}
