import java.util.*;

public class Solution {
    public static void main(String [] args) {
        System.out.println(stringCompression("aaabbbbccdddda"));
    }
    public static String stringCompression(String str) {
        if(str.equals("")) return str;
        StringBuilder sb = new StringBuilder();
        char temp = str.charAt(0);
        int count = 1;
        for(int i=1; i<str.length(); i++) {
            char now = str.charAt(i);
            if(now == temp) {
                count++;
                continue;
            }
            sb.append(temp);
            sb.append(count);
            temp = now;
            count = 1;
        }
        // add final
        sb.append(temp);
        sb.append(count);
        return sb.toString();
    }
}
