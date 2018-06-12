class Solution {
    public String convertToTitle(int n) {
        n = n-1;
        if(n<=25) return Character.toString((char)('A'+n));
        return convertToTitle(n/26) + Character.toString((char)('A'+(n%26)));
    }
}
