import java.util.List;

public class ZigzagIterator {

    int [] data;
    int ptr;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        data = new int[v1.size() + v2.size()];
        int ptr1 = 0, ptr2 = 0;
        boolean at1 = true;
        for(int i=0; i<data.length; i++) {
            // check boolean
            if(at1 && ptr1 >= v1.size()) at1 = false;
            if(!at1 && ptr2>= v2.size()) at1 = true;
            
            data[i] = at1 ? v1.get(ptr1++) : v2.get(ptr2++);
            at1 = !at1;
        }
        ptr = 0;
    }

    public int next() {
        return data[ptr++];
    }

    public boolean hasNext() {
        return ptr < data.length;
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */