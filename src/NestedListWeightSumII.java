/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
    
    public int depthSumInverse(List<NestedInteger> nestedList) {
        Queue<NestedInteger> q = new LinkedList<>();
        for(NestedInteger ni : nestedList) {
            q.add(ni);
        }
        int weighted = 0, unweighted = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            while(size > 0){
                NestedInteger tmp = q.poll();
                if(tmp.isInteger()) unweighted += tmp.getInteger();
                else {
                    q.addAll(tmp.getList());
                }
                size--;
            }
            weighted += unweighted;
        }
        return weighted;
    }
}
