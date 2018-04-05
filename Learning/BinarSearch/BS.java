import java.util.*;
public class BS {
    public static boolean binarySearch(int [] a, int target) {
        return recurHelper(a, target, 0, a.length-1);
    }

    public static boolean recurHelper(int [] a, int target, int start, int end) {
        if(start>end) return false;
        int mid = (start + end) /2;
        if(target == a[mid]) return true;
        return recurHelper(a, target, start, mid -1) || recurHelper(a, target, mid + 1, end);
    }

    public static void main(String [] args) {
        
    }
}
