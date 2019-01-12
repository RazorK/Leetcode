import java.util.Arrays;

class Solution {
    public String solveEquation(String equation) {
        String [] exps = equation.split("=");
        int [] left = parseExp(exps[0]);
        int [] right = parseExp(exps[1]);

        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));
        int coe = left[0] - right[0];
        int con = right[1] - left[1];
        if(coe == 0) return con == 0 ? "Infinite solutions" : "No solution";
        return "x=" + con/coe;
    }

    // return a int array of two number, the first one is the coefficient for x, the second one is the constant
    public int [] parseExp(String e) {
        int coe = 0, con = 0;
        int val = 0;
        boolean plus = true;
        for(int i=0; i<e.length(); i++) {
            char cur = e.charAt(i);
            if(cur == 'x') {
                // BUG1 x means 1x not 0x
                // BUG2 wtf is 0x???
                // val = val == 0? 1 : val;
                if(i==0 || e.charAt(i-1) == '-' || e.charAt(i-1) == '+') val = 1;
                coe += plus ? val : -val;
                val = 0;
                plus = true;
            } else if(cur == '+' || cur == '-') {
                con += plus? val : -val;
                val = 0;
                plus = cur == '+';
            } else {
                val = val * 10 + cur - '0';
            }
        }
        con += plus ? val : -val;
        return new int[] {coe, con};
    }
}