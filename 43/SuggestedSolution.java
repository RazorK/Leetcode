public class SuggestedSolution {

    // Idea, find the most effective way to reuse the code
    // and the easiest way to simplify the loop number

    // Bug1 int array pass by value rather than reference
    // Bug2 wrong idea for the number of bits of result
    //      should be a + b, rather than a + b + 1
    public static String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";
        int a = num1.length();
        int b = num2.length();
        int l = a + b;
        int [] result  = new int[l];
        for(int i = a-1; i>=0; i--) {
            for(int j=b-1; j>=0; j--) {
                result[i+j+1] += (num1.charAt(i)-'0') * (num2.charAt(j)-'0');
            }
        }
        int carry = 0;
        for(int i = l-1; i>=0; i--) {
            int sum = result[i] + carry;
            carry = sum/10;
            result[i] = sum%10;
        }
        return intArray2String(result);
    }

    public static String intArray2String(int [] a) {
        StringBuilder sb = new StringBuilder();
        boolean skip = true;
        for(int i=0; i<a.length; i++) {
            if(a[i] != 0) {
                skip = false;
            }
            if(skip) continue;
            sb.append(a[i]);
        }
        return sb.toString();
    }
}
