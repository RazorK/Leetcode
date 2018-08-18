import java.util.*;
class Solution {
    // Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
    //
    // '.' Matches any single character.
    // '*' Matches zero or more of the preceding element.
    // The matching should cover the entire input string (not partial).
    //
    // Note:
    //
    // s could be empty and contains only lowercase letters a-z.
    // p could be empty and contains only lowercase letters a-z, and characters like . or *.

    // first idea dfs & recursive
    char [] gs;
    char [] gp;
    public boolean isMatch(String s, String p) {
        gs = s.toCharArray();
        gp = p.toCharArray();
        return isMatch(0, 0);
    }

    // restriction: in this function gp[pp] can't be *;
    // deduct with p
    public boolean isMatch(int ss, int pp) {
        if(pp == gp.length && ss == gs.length) return true;
        else if(pp == gp.length) return false;
        char pCur = gp[pp];
        char sCur = ss >= gs.length ? '0' : gs[ss];

        // assume no consecutive *
        if(pp == gp.length-1 || gp[pp+1]!='*')  {
            if(match(sCur, pCur)) {
                return isMatch(ss+1, pp+1);
            }
            return false;
        } else {
            // match empty
            if(isMatch(ss, pp+2)) return true;
            if(pCur == '.') {
                for(int i=ss+1; i<=gs.length; i++) {
                    if(isMatch(i, pp+2)) return true;
                }
            } else {
                int it = ss;
                while(it<gs.length && gs[it] == pCur) {
                    it++;
                    if(isMatch(it, pp+2)) return true;
                }
            }
        }

        return false;
    }

    public boolean match(char s, char p) {
        if(p == '.') return true;
        return s == p;
    }
    //
    // public static void main(String [] args) {
    //     System.out.println(new Solution().isMatch("mississippi", "mis*is*ip*."));
    // }

    // TODO: think of DP
}
