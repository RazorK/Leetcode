class Solution {

    static Set<String> set = getSet();
    public boolean reorderedPowerOf2(int N) {
        return set.contains(key(N));
    }

    public static Set<String> getSet() {
        int n = 1;
        Set<String> res = new HashSet<>();
        while(n < 1000000000) {
            res.add(key(n));
            n*=2;
        }
        return res;
    }

    public static String key(int n) {
        int [] count = new int [10];
        while(n>0) {
            count[n%10] ++;
            n = n/10;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<10; i++) {
            sb.append(count[i]).append(',');
        }
        return sb.toString();
    }
}