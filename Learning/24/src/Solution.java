import java.util.ArrayList;
import java.util.Arrays;

/**
 * 这个不是很复杂，但是这个我做完耗时稍微久了一点
 * 看网上比较快的做法是虚构一个假的ListNode，然后开始 我的问题是判断语句比较多。。
 *
 * Created by aimin on 2017/7/25.
 */
public class Solution {
    public static void main(String [] args) {
        ListNode root = ListNode.create(Arrays.asList(1,2,3,4,5));
        System.out.println(new Solution().swapPairs(root));

    }
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next==null) return head;
        ListNode res = head.next;
        ListNode l1 = head;
        ListNode l2 = head.next;

        ListNode front = null;
        ListNode next = l2.next;
        while(true) {
            if(l2 == null)  return res;
            if(front!=null) front.next = l2;
            l2.next = l1;
            l1.next = next;

            front = l1;
            l1 = l1.next;
            if(l1!=null) l2 = l1.next;
            else return res;
            if(l2!=null) next = l2.next;
            else {
                return res;
            }
        }
    }

    public ListNode better(ListNode head) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode p = dummy;

        while(true) {
            ListNode l = p.next;
            if(l == null) return dummy.next;

            ListNode r = l.next;
            if(r == null) return dummy.next;

            ListNode n = r.next;

            r.next = l;
            l.next = n;
            p.next = r;

            p = l;
        }
    }
}
