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

        // don't need to reverse l or s, and don't need to create l, s
        // just iterate in the reverse order.
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


    // turn out slower than the first version ????
    public String improve(String a, String b) {
        if(a.length() == 0) return b;
        if(b.length() == 0) return a;

        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j =b.length() - 1;

        int carry = 0;
        while(i>=0 || j>=0) {
            int sum = carry;
            if(i>=0) sum += a.charAt(i--) - '0';
            if(j>=0) sum += b.charAt(j--) - '0';
            if(sum>=2) {
                carry =1;
                sum = sum % 2;
            } else {
                carry = 0;
            }
            sb.append(sum);
        }
        if(carry == 1) sb.append(1);
        return sb.reverse().toString();
    }


    // fastest example
    // don't understand why faster.
    // maybe use char array rather than stringbuilder??
    public String fastest(String a, String b) {
        if (a.length() > b.length()) {
           // add to arr1
           return addToA(a.toCharArray(), b);
       } else {
           // add to arr2
           return addToA(b.toCharArray(), a);
       }
    }

    // a.length >= b.length()
    private String addToA(char[] a, String b) {
       int x = a.length - 1;
       int y = b.length() - 1;
       int remain = 0;
       while (y >= 0) {
           int sum = remain + a[x] - '0' + b.charAt(y) - '0';
           a[x--] = (char)(sum % 2 + '0');
           remain = sum / 2;
           y--;
       }
       while (x >= 0 && remain > 0) {
           int sum = remain + a[x] - '0';
           a[x--] = (char)(sum % 2 + '0');
           remain = sum / 2;
       }
       if (remain == 0) {
           return String.valueOf(a);
       } else {
           return "1" + String.valueOf(a);
       }
    }
}
