import java.util.*;
public class Test {
    public static long subarraySum(List<Integer> arr) {
        // Write your code here
        if(arr == null || arr.size() == 0) return 0;

        long res = 0;
        long length = arr.size();

        for(long i=0; i<length; i++) {
            long cur = arr.get(i);

            res += (i+1) * (length - i) * cur;
        }

        return res;
    }


    public static void main(String [] args) {
        List<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(3);

        System.out.println(subarraySum(input));
    }
}
