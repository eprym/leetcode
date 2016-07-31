public class ValidWordAbbr {
    
    Set<String> dict = new HashSet<>();
    public ValidWordAbbr(String[] dictionary) {
        for(String d : dictionary) {
            dict.add(d);
        }
    }

    public boolean isUnique(String word) {
        for(String d : dict) {
            if(d.equals(word))   continue;
            if(d.length() != word.length())   continue;
            if(d.length() == 0) return false;
            if(d.charAt(0) != word.charAt(0) || d.charAt(d.length()-1) != word.charAt(word.length()-1))   continue;
            else    return false;
        }
        return true;
    }
}


// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");
