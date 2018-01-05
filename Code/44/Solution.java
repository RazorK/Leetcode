class Solution {
    // Problem:
    // Implement wildcard pattern matching with support for '?' and '*'.
    // '?' Matches any single character.
    // '*' Matches any sequence of characters (including the empty sequence).
    //
    // The matching should cover the entire input string (not partial).
    //
    // The function prototype should be:
    // bool isMatch(const char *s, const char *p)
    //
    // Some examples:
    // isMatch("aa","a") 2 false
    // isMatch("aa","aa") 2 true
    // isMatch("aaa","aa") 2 false
    // isMatch("aa", "*") 2 true
    // isMatch("aa", "a*") 2 true
    // isMatch("ab", "?*") 2 true
    // isMatch("aab", "c*a*b") 2 false

    // Basically Idea DFS.
    // time exceed...
    public static boolean isMatch(String s, String p) {
        if(s.equals("") && p.equals("")) return true;
        if(p.equals("")) return false;
        if(s.equals("")){
            if(p.equals("*")) return true;
            else return false;
        }
        char [] ss = new char [s.length()];
        char [] pp = new char [p.length()];

        //BUG 1
        s.getChars(0, s.length(), ss, 0);
        p.getChars(0, p.length(), pp, 0);
        return isMatchDFS(ss, pp, 0, 0);
    }

    public static boolean isMatchDFS(char [] s, char[] p, int ss, int pp) {
        if(pp == p.length && ss == s.length) return true;
        if(pp == p.length && ss < s.length) return false;
        if(pp == p.length - 1) {
            if(p[pp] == '*') return true;
            if(p[pp] == '?') {
                return ss == s.length-1? true: false;
            }
            // p[pp] = other character
            if(ss != s.length-1 || p[pp]!=s[ss] ) return false;
            else return true;
        }

        // pp<p.length-1
        // BUG 2
        // if(ss>= s.length) return false;
        if(p[pp] == '*') {
            for(int i=ss; i<=s.length; i++) {
                if(isMatchDFS(s, p, i, pp+1)== true) return true;
            }
            return false;
        } else if(p[pp] == '?') {
            if(ss>= s.length) return false;
            return isMatchDFS(s, p, ss+1, pp+1);
        } else {
            // p[pp] = other character
            if(ss>= s.length) return false;
            if(p[pp] != s[ss]) return false;
            else return isMatchDFS(s, p, ss+1, pp+1);
        }
    }


    //Suggested Idea:
    //  same idea wth dfs, but don't use recursion

    // TODO: still not understand...
    public static boolean suggested(String s, String p) {
        int ss = 0, pp = 0, starsid = -1;
        while(ss<s.length) {
            if(pp < p.length()  && (p.charAt(pp) == '?' ||p.charAt(pp) == s.charAt(ss)) ) {
                ss++;
                pp++;
            } else if(pp < p.length && p.charAt(pp) == '*') {
                starsid = ss;
                pp++;
            } else if(starsid != -1) {

            }

        }
    }
}
