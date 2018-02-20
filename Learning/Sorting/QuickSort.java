public class QuickSort {
    // in place
    public static void quickSort(int [] a) {
        recur(a, 0, a.length-1);
    }

    public static void recur(int [] a, int start, int end){
        if(start >= end) return;
        int split = a[start];
        int left = start;
        int right = end;

        // left empty, right not check
        while(left<right) {
            if(a[left+1] > split) {
                swap(a, left+1, right--);
                continue;
            } else {
                a[left] = a[left+1];
                left ++;
            }
        }
        a[left] = split;
        recur(a, start, left-1);
        recur(a, left+1, end);
    }

    public static void swap(int [] a, int p, int q){
        int temp = a[p];
        a[p] = a[q];
        a[q] = temp;
    }
}
