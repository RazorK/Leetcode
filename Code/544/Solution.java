class Solution {
    public String findContestMatch(int n) {
        // straightforward combination
        String [] data = new String [n];
        //BUG: i -> i+1
        for(int i=0; i<n; i++) data[i] = Integer.toString(i+1);

        int base = n;
        while(base != 1) {
            base = base/2;
            for(int i=0; i<base; i++) {
                StringBuilder sb = new StringBuilder();
                sb.append('(').append(data[i]).append(',').append(data[2*base - 1 - i]).append(')');
                data[i] = sb.toString();
            }
        }
        return data[0];
    }
}