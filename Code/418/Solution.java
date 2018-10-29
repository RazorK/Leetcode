import java.util.*;
class Solution {
    //Straight forward idea
    public int wordsTyping(String[] sentence, int rows, int cols) {
        if(rows <= 0 || cols <= 0 || sentence.length == 0) return 0;

        int ptr = 0;
        int ctr = 0;
        for(int i=0; i<rows; i++) {
            int left = cols;
            while(left>0) {
                if(left > sentence[ptr].length()) {
                    left -= sentence[ptr].length() + 1;
                    ptr++;
                    if(ptr >= sentence.length) {
                        ptr = 0;
                        ctr++;
                    }
                } else {
                    break;
                }
            }
        }
        return ctr;
    }

    // idea from LC: main idea is to calculate the contribution of each row.
    public int fromLC(String[] sentence, int rows, int cols) {
        if(rows <= 0 || cols <= 0 || sentence.length == 0) return 0;

        String one = String.join(" ", sentence) + " ";

        int contr = 0;
        for(int i=0; i<rows; i++) {
            contr += cols;
            while(i>=0 && one.charAt(i%one.length()) != ' ') contr--;
            contr++;
        }

        return contr/one.length();
    }
}