/**
 * 1.特殊情况考虑 不同长度 进位
 * 2.result.next返回的使用
 * 3.对于==null的使用 引用和赋值都可以
 * Created by aimin on 2017/5/4.
 */
public class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode tempI1 = l1;
        ListNode tempI2 = l2;
        ListNode tempResult = result;
        int flag = 0;
        while (tempI1!=null||tempI2!=null||flag!=0) {
            tempResult.next = new ListNode(0);
            tempResult = tempResult.next;
            int sum = (tempI1!=null?tempI1.val:0)+(tempI2!=null?tempI2.val:0)+flag;
            tempResult.val = sum%10;
            if(sum>=10) flag = 1;
            else flag = 0;

            tempI1 = tempI1==null?tempI1:tempI1.next;
            tempI2 = tempI2==null?tempI2:tempI2.next;
        }
        return result.next;
    }
}
