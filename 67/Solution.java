class Solution {
    // Given two binary strings, return their sum (also a binary string).
    //
    // For example,
    // a = "11"
    // b = "1"
    // Return "100".
    public String addBinary(String a, String b) {
        if(a.length() == 0) return b;
        if(b.length() == 0) return a;

        StringBuilder sb = new StringBuilder();
        String longer,shorter;
        if(a.length()>b.length()) {
            longer = a;
            shorter = b;
        } else {
            longer = b;
            shorter = a;
        }
        StringBuilder l = new StringBuilder(longer);
        StringBuilder s = new StringBuilder(shorter);
        l.reverse();
        s.reverse();

        int carry = 0;
        for(int i = 0; i< l.length(); i++) {
            int t_l = l.charAt(i) - '0';
            int t_s = 0;
            if(i<=s.length()-1){
                t_s = s.charAt(i) - '0';
            }
            int sum = t_l+t_s+carry;
            if(sum>=2) {
                carry = 1;
                sum = sum % 2;
            } else {
                carry = 0;
            }
            sb.append(sum);
        }
        if(carry == 1) sb.append(1);
        return sb.reverse().toString();
    }
}
