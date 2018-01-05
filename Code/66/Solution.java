class Solution {
    // Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.
    //
    // You may assume the integer do not contain any leading zero, except the number 0 itself.
    //
    // The digits are stored such that the most significant digit is at the head of the list.
    public int[] plusOne(int[] digits) {
        digits[digits.length - 1]++;
        int carry = 0;
        for(int i = digits.length - 1; i>=0; i--) {
            int sum = digits[i]+carry;
            if( sum >=10){
                digits[i] = sum % 10;
                carry = 1;
            } else {
                // BUG: forget to modify the last digit here...
                digits[i] = sum;
                carry = 0;
                break;
            }
        }
        // has to insert an digit here
        if(carry == 1) {
            int [] result = new int[digits.length+1];
            result[0] = 1;
            // BUG: this part is useless, because we only add one,
            // if the highest carry == 0, the left can only be zero

            // for(int i=0; i<digits.length; i++) {
            //     result[i+1] = digits[i];
            // }

            // This BUG makes the solution slower...
            return result;
        }
        return digits;
    }
}
