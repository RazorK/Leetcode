class Solution {
    public String reorganizeString(String S) {
        // bucket sort idea
        int [] count = new int[26];
        for(int i=0; i<S.length(); i++) { 
            char cur = S.charAt(i);
            count[cur - 'a'] ++;
        }
        
        char [] second = new char[S.length()/2];
        char [] first = new char[S.length() - S.length()/2];

        int left = 0, right = 25;
        for(int i=0; i<S.length()/2; i++) {
            while(count[left] == 0) left ++;
            while(count[right] == 0) right--;
            if(left == right) return "";

            count[left]--;
            count[right]--;
            first[i] = (char)(left + 'a');
            second[i] = (char)(right + 'a');
        }

        if(S.length() % 2 != 0) {
            while(count[left] == 0) left ++;
            first[S.length()/2] = (char)(left + 'a');
        }
        return merge(first, second);
    }

    public String merge(char [] longer, char [] shorter) {
       char [] res = new char [longer.length + shorter.length];
       int ptr = 0;
       for(int i=0; i<shorter.length; i++) {
           res[ptr ++] = longer[i];
           res[ptr ++] = shorter[i];
       }
       if(longer.length > shorter.length) {
           res[ptr] = longer[longer.length-1];
       }
       return new String(res);
    }
}