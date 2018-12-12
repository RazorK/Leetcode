import java.util.*;
class Retry {
    public boolean backspaceCompare(String S, String T) {
        // straightforward idea stack
        // new idea: scan backward
        int s = S.length() - 1, t = T.length() -1;
        while(s > -1 && t > -1) {
            int [] sr = findPrev(S, s);
            int [] tr = findPrev(T, t);
            // System.out.println(Arrays.toString(sr));
            // System.out.println(Arrays.toString(tr));
            if(sr[0] != tr[0]) return false;
            s = sr[1] - 1;
            t = tr[1] - 1;
        }

        // BUG: we have to judge whether the next is empty, rather than s and t reaches end
        return findPrev(S, s)[0] == -1 && findPrev(T,t)[0] == -1;
    }

    public int[] findPrev(String s, int ptr) {
        int count = 0;
        while(true) {
            if(ptr < 0) return new int[] {-1, -1};
            char cur = s.charAt(ptr);
            if(s.charAt(ptr) == '#') count++;
            else {
                if(count == 0)  return new int [] {cur, ptr};
                count--;
            }
            ptr--;
        }
    }

    public static void main(String [] args) {
        System.out.println(new Retry().backspaceCompare(
            "nzp#o#g",
            "b#nzp#o#g"));
    }
}