class Solution {
    public boolean canPermutePalindrome(String s) {
        if(s == null || s.length() == 0) return true;
        int [] charNum = new int[256];
        for(int i=0; i<s.length(); i++) {
            char cur = s.charAt(i);
            charNum[cur] ++;
        }

        //check
        boolean flag = false;
        for(int i=0; i<256; i++) {
            if(charNum[i]%2 ==1 ) {
                if( !flag ) flag = true;
                else return false;
            }
        }
        return true;
    }
}