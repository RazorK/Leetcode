import java.util.Arrays;
import java.util.Map;

class Solution {
    public boolean isScramble(String s1, String s2) {
        if(s1.equals(s2)) return true;
        if(s1.length() != s2.length()) return false;

        return divide(s1, s2, 0, s1.length()-1, 0, s2.length()-1);
    }

    public boolean divide(String s1, String s2, int start1, int end1, int start2, int end2) {
        if(end1 - start1 != end2 - start2)  return false;
        if(end1 == start1 && s1.charAt(start1) == s2.charAt(start2))  return true;
        
        int [] s1_f = new int[256], s2_f = new int[256], s2_b = new int[256];
        for(int i=0; start1+i < end1; i++) {
            s1_f[s1.charAt(start1+i)] ++;
            s2_f[s2.charAt(start2+i)] ++;
            s2_b[s2.charAt(end2-i)] ++;

            if(Arrays.equals(s1_f, s2_f) && 
                divide(s1, s2, start1, start1 + i, start2, start2 + i) &&
                divide(s1, s2, start1 + i + 1, end1, start2 + i + 1, end2)
            ) return true;

            if(Arrays.equals(s1_f, s2_b) &&
                divide(s1, s2, start1, start1 + i, end2 - i, end2) &&
                divide(s1, s2, start1 + i + 1, end1, start2, end2 - i - 1)
            ) return true;
        }
        
        return false;
    }
}