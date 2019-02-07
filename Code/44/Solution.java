import java.util.*;
class Solution {
    public static boolean isMatch(String s, String p) {

        // BUG 1 corner case
        if(s.equals(p)) return true;
        if(p.isEmpty()) return false;
        if(s.isEmpty()) {
            // BUG2 char * needs to be escaped in RE, char \ need to be escaped in java string and RE.
            // so if we want to search for string "*", we should write "\\*"
            return p.replaceAll("\\*", "").isEmpty();
        }

        // try dp first
        // BUG 3, actually, we also need to decide whether empty string is matched
        int sl = s.length(), pl = p.length();
        boolean [][] board = new boolean [pl][sl+1];
        for(int i = 0; i<pl; i++) {
            if(p.charAt(i) == '?') {
                if(i == 0) board[0][0] = true;
                else {
                    if(board[i-1][sl]) board[i][0] = true;
                    for(int j=0; j<sl-1; j++) {
                        if(board[i-1][j]) board[i][j+1] = true;
                    }
                }
            } else if(p.charAt(i) == '*') {
                if(i == 0 || board[i-1][sl]) {
                    Arrays.fill(board[i], true);
                } else {
                    for(int j=0; j<sl; j++) {
                        if(board[i-1][j]) {
                            for(int k = j; k<sl; k++) board[i][k] = true;
                            break;
                        }
                    }
                }
            } else {
                if(i == 0) {
                    if(p.charAt(0) == s.charAt(0)) board[0][0] = true;
                    else return false;
                } else {
                    if(p.charAt(i) == s.charAt(0) && board[i-1][sl]) board[i][0] = true;
                    for(int j=0; j<sl-1; j++) {
                        if(board[i-1][j] && p.charAt(i) == s.charAt(j+1)) board[i][j+1] = true;
                    }
                }
            }
        }
        // System.out.println(Arrays.deepToString(board));
        return board[pl-1][sl-1];
    }

    public static void main(String [] args) {
        isMatch("adceb", "*a*b");
    }
}