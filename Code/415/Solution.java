class Solution {
    // Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
    //
    // Note:
    //
    // The length of both num1 and num2 is < 5100.
    // Both num1 and num2 contains only digits 0-9.
    // Both num1 and num2 does not contain any leading zero.
    // You must not use any built-in BigInteger library or convert the inputs to integer directly.
    public String addStrings(String num1, String num2) {
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        char[] n1 = num1.toCharArray();
        char[] n2 = num2.toCharArray();
        int l = n1.length>n2.length?n1.length:n2.length;
        int s = n1.length<n2.length?n1.length:n2.length;
        for(int i=0; i<l; i++) {
            int sum = (i>=n1.length? 0:n1[n1.length-1-i]-'0') + (i>=n2.length? 0:n2[n2.length-1-i]-'0') + carry;
            carry = sum/10;
            sb.append(sum%10);
        }
        if(carry == 1) sb.append(1);
        return sb.reverse().toString();
    }
}
