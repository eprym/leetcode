public class ZigzagIterator {

    Queue<Iterator> q = new LinkedList<>();
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        if(!v1.isEmpty())   q.add(v1.iterator());
        if(!v2.isEmpty())   q.add(v2.iterator());
    }

    public int next() {
        Iterator itr = q.poll();
        int result = (Integer)itr.next();
        if(itr.hasNext())   q.add(itr);
        return result;
    }

    public boolean hasNext() {
        if(q.isEmpty()) return false;
        else return true;
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
