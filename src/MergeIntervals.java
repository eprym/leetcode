/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size() <= 1)   return intervals;
        Collections.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        List<Interval> res = new ArrayList<>();
        for(Interval iv : intervals) {
            if(iv.start <= end) {
                end = Math.max(end, iv.end);
            }
            else {
                res.add(new Interval(start, end));
                start = iv.start;
                end = iv.end;
            }
        }
        res.add(new Interval(start, end));
        return res;
    }
}
