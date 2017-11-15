import com.sun.org.apache.xalan.internal.xsltc.dom.MultiValuedNodeHeapIterator;

import java.util.List;

/**
 * Created by aimin on 2017/7/25.
 */
public class Heap extends BinaryTree {
    public Heap (int in) {
        super(in);
    }

    /**
     * To maintain the Heap property that parent value bigger than child's
     * premise that the children of A[i] are already max heap
     * Recursive
     * @param a a heap list
     * @param i the heap A[i] is not a max heap, index of the heap to be process
     */
    public static void MAX_HEAPIFY(List<Integer> a, int i) {
        int l = leftIndex(i);
        int r = rightIndex(i);
        int largestIndex = i;
        if(l<a.size()&& a.get(l) >a.get(i)) largestIndex = l;
        if(r<a.size()&& a.get(r)>a.get(largestIndex)) largestIndex = r;

        if(largestIndex!=i) {
            int temp = a.get(i);
            a.set(i,a.get(largestIndex));
            a.set(largestIndex,temp);
            MAX_HEAPIFY(a,largestIndex);
        }
    }

    public static int leftIndex(int i) {
        return i/2;
    }

    public static int rightIndex(int i) {
        return i/2+1;
    }

    public static int parentIndex(int i) {
        return 2*i;
    }
}
