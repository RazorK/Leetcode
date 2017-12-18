import java.util.*;
class Solution {
    // Bug 1, we add numbers from the lowest bit, but what we intuitive get is
    // the hightest bit.

    // Bug 2, remember to process leading 0

    // Bug 3, add 0 corner case
    public static String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";
        int l = num1.length();
        List<Integer> n1 = getAL(num1);
        List<Integer> n2 = getAL(num2);

        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();

        for(int i = l-1;i>=0;i--) {
            ArrayList<Integer> tempn2 = mult1B(n1.get(i), (ArrayList<Integer>)n2);
            tempn2.addAll(temp);
            result = strsum_array(result, tempn2);
            temp.add(0);
        }
        delete0(result);
        return getString(result);
    }

    public static void delete0(ArrayList<Integer> num) {
        while(true) {
            if(num.get(0) == 0){
                num.remove(0);
            } else {
                return;
            }
        }
    }

    public static ArrayList<Integer> mult1B(int m, ArrayList<Integer> num) {
        List<Integer> result = new ArrayList<>();
        int carry = 0;
        int sum = 0;
        for(int i=num.size()-1; i>=0; i--) {
            sum = m * num.get(i) + carry;
            carry = sum / 10;
            result.add(sum%10);
        }
        if(carry!=0) result.add(carry);
        Collections.reverse(result);
        return (ArrayList<Integer>)result;
    }

    // arraylist version
    public static ArrayList<Integer> strsum_array(ArrayList<Integer> num1, ArrayList<Integer> num2) {
        ArrayList<Integer> n1 = (ArrayList<Integer>)num1.clone();
        ArrayList<Integer> n2 = (ArrayList<Integer>)num2.clone();
        Collections.reverse(n1);
        Collections.reverse(n2);
        ArrayList<Integer> result = new ArrayList<>();


        int l = num1.size() < num2.size()? num2.size(): num1.size();
        int carry = 0;
        int sum1b = 0;

        for(int i = 0; i<l ; i++) {
            int a = i>=num1.size()? 0: n1.get(i);
            int b = i>=num2.size()? 0: n2.get(i);
            sum1b = a + b + carry;
            carry = 0;
            if (sum1b >= 10) {
                sum1b = sum1b % 10;
                carry = 1;
            }
            result.add(sum1b);
        }
        if(carry == 1) result.add(carry);
        Collections.reverse(result);
        return result;
    }

    public static ArrayList<Integer> getAL(String num) {
        int l = num.length();
        ArrayList<Integer> result = new ArrayList();
        for(int i=0;i<l;i++) {
            result.add(str2int(num.charAt(i)));
        }
        return result;
    }

    public static String getString(List<Integer> al) {
        int l = al.size();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<l; i++) {
            sb.append(al.get(i));
        }
        return sb.toString();
    }

    public static int str2int(char s) {
        return s - '0';
    }

    // new idea reverse first
    // public static String strsum(String num1, String num2) {
    //     StringBuilder result = new StringBuilder();
    //     StringBuilder n1 = new StringBuilder(num1);
    //     StringBuilder n2 = new StringBuilder(num2);
    //     n1.reverse();
    //     n2.reverse();
    //
    //     int l = num1.length() < num2.length()? num2.length(): num1.length();
    //     int carry = 0;
    //     int sum1b = 0;
    //     for(int i = 0; i<l ; i++) {
    //         int a = i>=num1.length()? 0: str2int(n1.charAt(i));
    //         int b = i>=num2.length()? 0: str2int(n2.charAt(i));
    //         sum1b = a + b + carry;
    //         carry = 0;
    //         if (sum1b >= 10) {
    //             sum1b = sum1b % 10;
    //             carry = 1;
    //         }
    //         result.append(sum1b);
    //     }
    //     if(carry == 1) result.append(carry);
    //     return result.reverse().toString();
    // }
    //
    // public static int[] str2intarray(String num) {
    //     char [] temp = new char[num.length()];
    //     num.getChars(0, num.length()-1, temp, 0);
    //     int [] result = new int[num.length()];
    //     for(int i = 0; i< num.length(); i++) {
    //         result[i] = str2int(temp[i]);
    //     }
    //     return result;
    // }
}
