public class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String>  res = new ArrayList<>();
        String cur = "";
        bt(word, res, cur, 0, false);
        return res;
    }
    
    private void bt(String word, List<String> res, String cur, int start, boolean isAbbr) {
        if(start == word.length()){
            res.add(cur);
            return;
        }
        if(!isAbbr) {
            for(int i = start+1; i <= word.length(); i++) {
                String ncur = cur + String.valueOf(i-start);
                bt(word, res, ncur, i, true);
            }
        }
        bt(word, res, cur + word.charAt(start), start + 1, false);
    }
}
