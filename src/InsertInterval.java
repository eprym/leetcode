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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();
        int start = newInterval.start;
        int end = newInterval.end;
        for(Interval iv : intervals) {
            if(iv.end < start)  res.add(iv);
            else if(end < iv.start) {
                if(start != -1) res.add(new Interval(start, end));
                res.add(iv);
                start = -1;
            }
            else {
                start = Math.min(start, iv.start);
                end = Math.max(end, iv.end);
            }
        }
        int size = intervals.size();
        if(size == 0 || intervals.get(size-1).end < start || end >= intervals.get(size-1).start) {
            res.add(new Interval(start, end));
        }
        return res;
    }
}
