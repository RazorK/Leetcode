/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode res = new ListNode(Integer.MIN_VALUE);
        while(head!=null) {
            ListNode tmp = head.next;
            ListNode pre = res;
            while(pre.next!=null) {
                if(pre.val <= head.val && pre.next.val > head.val) {
                    break;
                }
                pre = pre.next;
            }

            // add to tail
            if(pre.next == null) {
                pre.next = head;
                head.next = null;
            } else {
                // add to middle
                ListNode tmp1 = pre.next;
                pre.next = head;
                head.next =  tmp1;
            }

            head = tmp;
        }
        return res.next;
    }
}
