import java.util.*;
class Solution {
    // Given a list of non negative integers, arrange them such that they form the largest number.
    //
    // Example 1:
    //
    // Input: [10,2]
    // Output: "210"
    // Example 2:
    //
    // Input: [3,30,34,5,9]
    // Output: "9534330"
    // Note: The result may be very large, so you need to return a string instead of an integer.

    // first idea, sort them in the lexicographic order.
    public String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0) return "";

        List<Integer> x = new ArrayList<Integer>();
        for(int num : nums) {
            x.add(num);
        }
        Collections.sort(x, new Comparator<Integer>() {
            @Override
            public int compare(Integer l, Integer r) {
                return cmpHelper(l, r);
            }
        });

        if(x.get(0) == 0) return "0";
        // compose
        StringBuilder sb = new StringBuilder();
        for(Integer num : x)  {
            sb.append(num);
        }

        // problem of 00.
        return sb.toString();
    }

    public static int cmpHelper(Integer l, Integer r) {
        // BUG, can't directly use lexicographic order, consider 31, 3
        String ls = Integer.toString(l);
        String rs = Integer.toString(r);

        int i;
        for(i=0; i<ls.length() && i<rs.length(); i++) {
            if(ls.charAt(i) == rs.charAt(i)) continue;
            else return ls.charAt(i) > rs.charAt(i) ? -1 : 1;
        }

        if(ls.length() == rs.length()) return 0;
        if(ls.length() > rs.length()) {
            return cmpHelper(Integer.parseInt(ls.substring(i)), Integer.parseInt(rs));
        } else {
            return cmpHelper(Integer.parseInt(ls), Integer.parseInt(rs.substring(i)));
        }
    }

    public static void main(String[] args) {
        System.out.println(Solution.cmpHelper(10,2));
    }
}
