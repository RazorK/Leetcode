import java.util.*;
class Solution {
	// Given a string S and a string T, find the minimum window in S which will
	// contain all the characters in T in complexity O(n).
	//
	// For example,
	// S = "ADOBECODEBANC"
	// T = "ABC"
	// Minimum window is "BANC".
	//
	// Note:
	// If there is no such window in S that covers all characters in T, return the
	// empty string "".
	//
	// If there are multiple such windows, you are guaranteed that there will always
	// be only one unique minimum window in S.

	// can't think of a dp Solution
	// try two ptrs. still not work..
	// give up..

    // sliding windows.
    // too hard to understand...
	public String minWindow(String s, String t) {
		int[] map = new int[256];
		for (char c : t.toCharArray())
			map[c]++;
		int counter = t.length(), begin = 0, end = 0, d = Integer.MAX_VALUE, head = 0;
		while (end < s.length()) {
			if (map[s.charAt(end++)]-- > 0)
				counter--; // in t
			while (counter == 0) { // valid
				if (end - begin < d) {
					head = begin;
					d = end - head;
				}
				if (map[s.charAt(begin++)]++ == 0)
					counter++; // make it invalid
			}
		}
		return d == Integer.MAX_VALUE ? "" : s.substring(head, head + d);
	}


    // debuggable version
    // idea:
    //  first, find the first end that contains all the chars in t (from 0(begin) to end), which finds an unvaried property.
    //  then, start from 0, move the begin ptr, when first encounter the char of t,
    // start to move end ptr, until find the next char.(when moving, still try to find the valid window)
    //  in this period, remember the minimum valid window.
    public static String test(String s, String t) {
		int[] map = new int[4];
		for (char c : t.toCharArray())
			map[c-'a']++;
        System.out.println(Arrays.toString(map));
		int counter = t.length(), begin = 0, end = 0, d = Integer.MAX_VALUE, head = 0;
		while (end < s.length()) {
            System.out.println("-----Start----");
            System.out.println("end: "+end);
			if (map[s.charAt(end++)-'a']-- > 0) {
                counter--; // in t
                System.out.println("counter: "+counter);
            }
            System.out.println(Arrays.toString(map));
			while (counter == 0) { // valid
				if (end - begin < d) {
                    System.out.println("changed head");
					head = begin;
					d = end - head;
                    System.out.println("head: "+ head);
                    System.out.println("d: " + d);
				}
				if (map[s.charAt(begin++)-'a']++ == 0) {
                    counter++; // make it invalid
                }
			}
		}
		return d == Integer.MAX_VALUE ? "" : s.substring(head, head + d);
	}
}
