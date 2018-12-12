import java.util.LinkedHashMap;

class Solution {
    public int characterReplacement(String s, int k) {
        //first idea 26n with two ptrs for each char
        int max = k;
        if(s.length() < k) return s.length();

        for(int i=0; i<26; i++) {
            char cur = (char)(i + 'A');
            // find left and right
            int left = 0, right = 0, ct = s.charAt(0) == cur ? 1 : 0;
            int tempRes = 0;
            while(right < s.length()) {
                System.out.println(left + "," + right + "," + ct);
                if(ct < k+1) {
                    right ++;
                    if(right < s.length() && s.charAt(right) != cur) ct++;
                } else if(left < right) {
                    // ct = k + 1;
                    tempRes = Math.max(tempRes, right - left);
                    if(s.charAt(left) != cur) ct--;
                    left ++;
                }
            }
            tempRes = Math.max(tempRes, right - left);
            max = Math.max(k, tempRes);
        }
        return max;
    }
}