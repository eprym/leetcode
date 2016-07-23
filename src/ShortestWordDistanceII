public class WordDistance {
    
    Map<String, List<Integer>> map = new HashMap<>();
    
    public WordDistance(String[] words) {
        for(int i=0; i<words.length; i++) {
            if(map.containsKey(words[i])) {
                map.get(words[i]).add(i);
            }
            else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(words[i], list);
            }
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        
        int i=0, j=0;
        int distance = Math.abs(list1.get(i) - list2.get(j));
        while(i < list1.size() && j < list2.size()) {
            distance = Math.min(distance, Math.abs(list1.get(i) - list2.get(j)));
            if(i < list1.size()-1 && j < list2.size()-1){
                if(list1.get(i+1) < list2.get(j+1)) i++;
                else    j++;
            }
            else if(i < list1.size()-1) j++;
            else    i++;
        }
        while(i < list1.size()) {
            distance = Math.min(distance, Math.abs(list1.get(i++) - list2.get(list2.size()-1)));
        }
        while(j < list2.size()) {
            distance = Math.min(distance, Math.abs(list1.get(list1.size()-1) - list2.get(j++)));
        }
        return distance;
    }
}

// Your WordDistance object will be instantiated and called as such:
// WordDistance wordDistance = new WordDistance(words);
// wordDistance.shortest("word1", "word2");
// wordDistance.shortest("anotherWord1", "anotherWord2");
