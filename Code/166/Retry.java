import java.util.Map;

class Solution {

    /**
     * BUGs: 
     * 1. neg number
     * 2. overflow
     */
    public String fractionToDecimal(int n, int d) {
        if(n == 0) return "0";
        boolean neg = true;
        if((n > 0 && d > 0) || (n < 0 && d < 0)) neg = false;

        String res = fractionToDecimal0(Math.abs((long)n), Math.abs((long)d));
        return neg ? "-" + res : res;
    }
    public String fractionToDecimal0(long numerator, long denominator) {
        StringBuilder sb = new StringBuilder();
        if(numerator >= denominator) {
            if(numerator % denominator == 0) return Long.toString(numerator/denominator);
            sb.append(numerator/denominator).append('.');
            numerator = numerator % denominator;
        } else {
            if(numerator == 0) return "0";
            sb.append("0.");
        }
        
        // numerator -> index
        Map<Long, Integer> map = new HashMap<>();
        StringBuilder decimal = new StringBuilder();
        int i = 0;
        while(numerator != 0) {
            if(map.containsKey(numerator)) {
                int index = map.get(numerator);
                decimal.insert(index, '(');
                decimal.append(')');
                return sb.toString() + decimal.toString();
            }

            map.put(numerator, i++);
            decimal.append(numerator * 10 / denominator);
            numerator = (numerator * 10) % denominator;
        }

        return sb.toString() + decimal.toString();
    }
}