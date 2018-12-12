class Solution {
    public boolean backspaceCompare(String S, String T) {
        // first idea two ptr
        int s = S.length()-1, t = T.length() - 1;
        while(s>=0 && t>=0) {
            s = findCur(S, s, 0);
            t = findCur(T, t, 0);
            System.out.println(s + "," + t);
            if(s < 0 || t < 0) break;
            if(S.charAt(s--) != T.charAt(t--)) return false;
        }
        return s==-1 && t == -1;
    }

    public int findCur(String str, int l, int count) {
        if(l < 0) return -1;
        char cur = str.charAt(l);
        if(cur == '#') return findCur(str, l-1, count + 1);
        if(count != 0) return findCur(str, l-1, count - 1);
        return l;
    }
}