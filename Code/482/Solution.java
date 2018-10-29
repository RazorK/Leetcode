class Solution {
    public String licenseKeyFormatting(String S, int K) {
        if(S == null || S.length() == 0) return S;
        if(K <= 0) return S;
        
        StringBuilder res = new StringBuilder();
        int count = 0;
        for(int i= S.length()-1; i>=0; i--) {
            char cur = S.charAt(i);
            if(cur == '-') continue;
            if(count == K) {
                count = 0;
                res.insert(0, '-');
            }
            cur = Character.toUpperCase(cur);

            res.insert(0, cur);
            count++;
        }
        
        return res.toString();
    }
}