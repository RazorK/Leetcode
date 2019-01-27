import java.util.*;

class Solution {
    public String strWithout3a3b(int A, int B) {
        StringBuilder sb = new StringBuilder();
        boolean a = A >= B;
        while(A>=0 || B >= 0) {
            if(A==0 && B==0) break;
            if(a) {
                if(A >= B && A>=2) {
                    sb.append("aa");
                    A-=2;
                } else {
                    sb.append("a"); A--;
                }
            } else {
                if(B>=A && B>=2) {
                    sb.append("bb");
                    B-=2;
                } else {
                    sb.append("b"); B--;
                }
            }
            a = !a;
        }
        return sb.toString();
    }
}