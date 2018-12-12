class Solution {
    public String fractionToDecimal(int num, int den) {
        if(num == 0) return "0";
        // key : numerator, value index
        Map<Long, Integer> map = new HashMap<>();

        // Bug 1, what if numerator is negative
        boolean neg = ((long)num < 0 || (long)den < 0) && !((long)num < 0 && (long)den < 0);
        long numerator = Math.abs((long)num);
        long denominator = Math.abs((long)den);

        if(numerator%denominator == 0) return neg ? "-" + Long.toString((long)(numerator/denominator)) : Long.toString((long)(numerator/denominator));

        StringBuilder sb = new StringBuilder();

        if(numerator > denominator) {
            long first = numerator / denominator;
            numerator = numerator % denominator;
            sb.append(first).append('.');
        } else {
            sb.append(0).append('.');
        }

        while(numerator != 0) {
            long next= numerator * 10;
            if(map.containsKey(next)) {
                sb.insert(map.get(next), "(");
                sb.append(")");
                return neg ? "-" + sb.toString() : sb.toString();
            }
            map.put(next, sb.length());
            numerator = next % denominator;
            sb.append((long)next/denominator);
        }
        return neg ? "-" + sb.toString() : sb.toString();
    }
}