import java.util.List;

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
public class NestedIterator implements Iterator<Integer> {

    // first idea flatten the list first 
    List<Integer> data;
    int ptr;
    public NestedIterator(List<NestedInteger> nestedList) {
        data = new ArrayList<>();
        ptr = 0;
        for(NestedInteger cur: nestedList) {
            recur(cur);
        }
    }

    public void recur(NestedInteger cur) {
        if(cur.isInteger()) {
            data.add(cur.getInteger());
        } else {
            for(NestedInteger next : cur.getList()) {
                recur(next);
            }
        }
    }

    @Override
    public Integer next() {
        if(hasNext())
            return data.get(ptr++);
        else return null;
    }


    @Override
    public boolean hasNext() {
        return ptr < data.size();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */