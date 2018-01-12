import java.util.*;
class Solution {
    // Given a string containing only digits, restore it by returning all possible valid IP address combinations.
    //
    // For example:
    // Given "25525511135",
    //
    // return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)

    // try dfs
    public List<String> restoreIpAddresses(String s) {
        char [] array = s.toCharArray();
        List<String> res = new ArrayList<>();
        if(array.length <= 3) return res;
        int [] rem = new int[4];
        dfs(res, array, 0, rem, 0);
        return res;
    }

    // cur the number of current period, start the index of start of ths period
    // remember
    public void dfs(List<String> res, char [] array, int start, int [] remember, int cur) {
        if(cur == 4) {
            if(start != array.length) return;
            StringBuilder sb = new StringBuilder();
            int ptr = 0;
            for(int i=0; i<array.length; i++) {
                sb.append(array[i]);
                if(i == remember[ptr]) {
                    ptr ++;
                    if(ptr!=4)sb.append('.');
                }
            }
            res.add(sb.toString());
            return;
        }

        if(start >= array.length) return;
        remember[cur] = start;
        dfs(res, array, start + 1, remember, cur+1);

        if(start >= array.length - 1) return;
        if(array[start] != '0') {
            remember[cur] = start + 1;
            dfs(res, array, start + 2, remember, cur + 1);
        }

        if(start >= array.length -2) return;
        int code = (array[start] - '0') * 100 + (array[start+1] - '0') * 10 + (array[start + 2] - '0');
        if(code >=100 && code <=255) {
            remember[cur] = start + 2;
            dfs(res, array, start + 3, remember, cur + 1);
        }
    }
}
