/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class SummaryRanges {

    TreeMap<Integer, Interval> treemap;
    /** Initialize your data structure here. */
    public SummaryRanges() {
        treemap = new TreeMap<>();
    }
    
    public void addNum(int val) {
        if(treemap.containsKey(val))    return;
        Integer low = treemap.lowerKey(val);
        Integer high = treemap.higherKey(val);
        if(low != null && high != null && treemap.get(low).end + 1 == val && val + 1 == high) {
            treemap.get(low).end = treemap.get(high).end;
            treemap.remove(high);
        }
        else if(low != null && treemap.get(low).end + 1 >= val) {
            treemap.get(low).end = Math.max(val, treemap.get(low).end);
        }
        else if(high != null && val + 1 == high) {
            treemap.put(val, new Interval(val, treemap.get(high).end));
            treemap.remove(high);
        }
        else treemap.put(val, new Interval(val, val));
    }
    
    public List<Interval> getIntervals() {
        return new ArrayList<>(treemap.values());
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * List<Interval> param_2 = obj.getIntervals();
 */
