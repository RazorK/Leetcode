/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    // Remove all elements from a linked list of integers that have value val.
    //
    // Example:
    //
    // Input:  1->2->6->3->4->5->6, val = 6
    // Output: 1->2->3->4->5
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return null;
        if(head.val == val) return removeElements(head.next, val);

        ListNode res = head;
        ListNode pre = head, cur = head.next;
        while(cur!=null) {
            if(cur.val == val) {
                pre.next = cur.next;
                cur = cur.next;
                continue;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return res;
    }
}
