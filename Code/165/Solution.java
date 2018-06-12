import java.util.*;
class Solution {
    //
    // Compare two version numbers version1 and version2.
    // If version1 > version2 return 1; if version1 < version2 return -1;otherwise return 0.
    //
    // You may assume that the version strings are non-empty and contain only digits and the . character.
    // The . character does not represent a decimal point and is used to separate number sequences.
    // For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.
    //
    // Example 1:
    //
    // Input: version1 = "0.1", version2 = "1.1"
    // Output: -1
    // Example 2:
    //
    // Input: version1 = "1.0.1", version2 = "1"
    // Output: 1
    // Example 3:
    //
    // Input: version1 = "7.5.2.4", version2 = "7.5.3"
    // Output: -1
    public int compareVersion(String version1, String version2) {
        if(version1.equals(version2)) return 0;

        // BUG: split takes an regular expression as input, so we need to escape the reserved character .
        String [] list1 = version1.split("\\.");
        String [] list2 = version2.split("\\.");
        int i=0;
        for(i=0; i< (Math.min(list1.length, list2.length)); i++) {
            int v1 = Integer.parseInt(list1[i]);
            int v2 = Integer.parseInt(list2[i]);

            if(v1 == v2) continue;
            else if(v1>v2) return 1;
            else return -1;
        }

        // BUG corner case, 0 after.
        if(list1.length == list2.length) return 0;
        String [] longer = list1.length>list2.length? list1:list2;
        while(i<=longer.length-1) {
            if(Integer.parseInt(longer[i++]) != 0) return list1.length>list2.length?1:-1;
        }
        return 0;

    }

    public static void main(String[] args) {
        System.out.println(new Solution().compareVersion("0.1", "1.1"));
    }
}
