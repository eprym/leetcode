public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if(Math.abs(s.length() - t.length()) > 1)   return false;
        int length = Math.min(s.length(), t.length());
        for(int i = 0; i < length; i++) {
            if(s.charAt(i) != t.charAt(i)) {
                if(s.length() > t.length()) {
                    return s.substring(i+1).equals(t.substring(i));
                }
                else if(s.length() < t.length()) {
                    return t.substring(i+1).equals(s.substring(i));
                }
                else if(i < length - 1) {
                    return s.substring(i+1).equals(t.substring(i+1));
                }
                else    return true;
            }
        }
        return s.length() != t.length();
    }
}
